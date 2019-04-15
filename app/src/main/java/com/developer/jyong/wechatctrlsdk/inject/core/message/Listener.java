package com.developer.jyong.wechatctrlsdk.inject.core.message;

import android.text.TextUtils;

import com.developer.jyong.wechatctrlsdk.inject.core.main.Booter;
import com.developer.jyong.wechatctrlsdk.inject.core.main.DisposeException;
import com.developer.jyong.wechatctrlsdk.inject.info.Info;
import com.developer.jyong.wechatctrlsdk.inject.info.LinkInfo;
import com.developer.jyong.wechatctrlsdk.inject.info.MediaInfo;
import com.developer.jyong.wechatctrlsdk.inject.info.MsgInfo;
import com.developer.jyong.wechatctrlsdk.inject.info.RemittanceInfo;
import com.developer.jyong.wechatctrlsdk.inject.tool.DBTool;
import com.developer.jyong.wechatctrlsdk.inject.tool.FieldTool;
import com.developer.jyong.wechatctrlsdk.inject.tool.WeChatTool;

import org.json.JSONObject;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Listener {

    private static String TAG = "CtrlSDK";
    private static ExecutorService executor = Executors.newFixedThreadPool(10);

    public final static String TABLE_MESSAGE = "message";
    private final static String SQL_SELECT_BASE_MSG = "select talker,isSend,type,content,imgPath,createTime,msgId,msgSvrId from message where msgId = ? ";
    private final static String SQL_SELECT_IMAGE_MSG = "select m.talker,m.isSend,m.type,m.content,m.imgPath,m.createTime,m.msgId,m.msgSvrId,i.bigImgPath from message m left join ImgInfo2 i on m.imgPath = i.thumbImgPath where msgId = ? ";


    public final static int NORMAL = 1;
    public final static int DELETE = 2;
    public final static int REVOKE = 3;

    /**
     * @param tableName   table name
     * @param obj         data
     * @param taskType    message type
     * @param classLoader classloader
     */
    public static void listen(String tableName, Object obj, int taskType, ClassLoader classLoader) {

        if (TextUtils.isEmpty(tableName)) {
            return;
        }

        if (tableName.equals(TABLE_MESSAGE)) {
            listen(MsgInfo.toEntity(obj), classLoader, taskType);
        }
    }

    private static void listen(MsgInfo msg, ClassLoader classLoader, int taskType) {

        if (msg == null || classLoader == null) {
            return;
        }

        schedule(msg, taskType, classLoader);

    }

    private static void schedule(final MsgInfo msg, final int taskType, ClassLoader classLoader) {

        MsgCallback callback = new MsgCallback() {
            @Override
            public void onChanged(int type, boolean result) {
                try {

                    MsgInfo bean = null;
                    JSONObject jsonStr = null;

                    switch (type) {
                        case MsgInfo.WX_MESSAGE_TYPE_TEXT:

                            if (!result) {
                                throw new DisposeException("txt msg , can't solve this ");
                            }

                            bean = getMsgInfo(msg.getMsgId());

                            if (bean == null) {
                                throw new DisposeException("txt msg is null ");
                            }

                            jsonStr = Info.convert(bean, Info.TYPE_MESSAGE);
                            emitter(jsonStr);

                            break;
                        case MsgInfo.WX_MESSAGE_TYPE_CARD:
                            if (!result) {
                                throw new DisposeException("card msg result is false ");
                            }

                            bean = getMsgInfo(msg.getMsgId());

                            if (bean == null) {
                                throw new DisposeException("card msg bean is null");
                            }

                            bean.setContent(MsgTool.convertCardXML((String) bean.getContent()));

                            jsonStr = Info.convert(bean, Info.TYPE_MESSAGE);
                            emitter(jsonStr);
                            break;
                        case MsgInfo.WX_MESSAGE_TYPE_VOICE:
                            if (!result) {
                                throw new DisposeException("voice msg result is false ");
                            }

                            bean = getMsgInfo(msg.getMsgId());

                            if (bean == null) {
                                throw new DisposeException("voice bean is null");
                            }

                            bean.setVoicePath(MsgTool.getVoicePath(WeChatTool.getWXContext(), bean.getImgPath()));

                            jsonStr = Info.convert(bean, Info.TYPE_MESSAGE);
                            emitter(jsonStr);
                            break;
                        case MsgInfo.WX_MESSAGE_TYPE_IMAGE:
                            bean = getImageMsgInfo(msg.getMsgId());
//
                            if (bean == null) {
                                throw new DisposeException("image msg info is null");
                            }

                            if (TextUtils.isEmpty(bean.getMsgSvrId())) {
                                throw new DisposeException("image message msgSvrId is null");
                            }

                            String bigImgPath = MsgTool.getImagePath(WeChatTool.getWXContext(), bean.getBigImgPath(), true);
                            String thumbPath = MsgTool.getImagePath(WeChatTool.getWXContext(), bean.getImgPath(), false);
                            bean.setBigImgPath(bigImgPath);
                            bean.setThumbImgPath(thumbPath);
                            bean.setContent("");

                            jsonStr = Info.convert(bean, Info.TYPE_MESSAGE);
                            emitter(jsonStr);
//
                            break;
                        case MsgInfo.WX_MESSAGE_TYPE_VIDEO:
                            bean = getMsgInfo(msg.getMsgId());

                            if (bean == null) {
                                throw new DisposeException("video msg bean is null");
                            }

                            if (TextUtils.isEmpty(bean.getMsgSvrId())) {
                                throw new DisposeException("video msgSvrId is null ");
                            }

                            String videoPath = MsgTool.getVideoPath(WeChatTool.getWXContext(), bean.getImgPath());
                            bean.setVideoPath(videoPath);

                            jsonStr = Info.convert(bean, Info.TYPE_MESSAGE);
                            emitter(jsonStr);

                            break;
                        case MsgInfo.WX_MESSAGE_TYPE_LINK:
                            if (!result) {
                                throw new DisposeException(" link msg result is false  ");
                            }

                            bean = getMsgInfo(msg.getMsgId());

                            if (bean == null) {
                                throw new DisposeException("link msg bean is null");
                            }

                            String content = ((String) bean.getContent()).replace("\t", "").replace("\n", "");
                            LinkInfo link = MsgTool.getMsgLinkContent(content);
                            bean.setContent((link != null) ? LinkInfo.convert2Json(link) : "");

                            jsonStr = Info.convert(bean, Info.TYPE_MESSAGE);
                            emitter(jsonStr);
                            break;
                        case MsgInfo.WX_MESSAGE_TYPE_REMITTANCE:
                            if (!result) {
                                throw new DisposeException("transfer msg result is false");
                            }
                            bean = getMsgInfo(msg.getMsgId());

                            if (bean == null) {
                                throw new DisposeException(" transfer msg bean is null ");
                            }

                            RemittanceInfo remittance = RemittanceInfo.toEntity(bean.getTalker(), (String) bean.getContent());

                            if (remittance == null) {
                                throw new DisposeException(" remittance info is null ");
                            }

                            bean.setIsRemitter(MsgTool.isRemitter(remittance.getPaysubtype(), bean.getIsSend()));
                            bean.setMsgSvrId(remittance.getTransferID());
                            bean.setContent(MsgTool.remittanceTips(remittance.getPaysubtype(), bean.getIsSend()));
                            bean.setMoney(remittance.getFeedesc());

                            jsonStr = Info.convert(bean, Info.TYPE_MESSAGE);
                            emitter(jsonStr);
                            break;
                        case MsgInfo.WX_MESSAGE_TYPE_REDPACKAGE:
                            if (!result) {
                                throw new DisposeException("red package msg result is false ");
                            }

                            bean = getMsgInfo(msg.getMsgId());

                            if (bean == null) {
                                throw new DisposeException("red package bean is null");
                            }

                            bean.setMsgSvrId(MsgTool.getIDOfRedPacket((String) bean.getContent()));
                            bean.setContent(MsgTool.getDescFromWallet((String) bean.getContent()));

                            jsonStr = Info.convert(bean, Info.TYPE_MESSAGE);
                            emitter(jsonStr);
                            break;
                        case MsgInfo.WX_MESSAGE_TYPE_ROOM_SYSTEM:
                        case MsgInfo.WX_MESSAGE_TYPE_SYSTEM:
                            if (!result) {
                                throw new DisposeException("system msg result is false ");
                            }

                            bean = getMsgInfo(msg.getMsgId());

                            if (bean == null) {
                                throw new DisposeException("system msg bean is null");
                            }

                            if (TextUtils.isEmpty(bean.getMsgSvrId())) {
                                bean.setMsgSvrId(String.valueOf(System.currentTimeMillis()));
                            }

                            if (MsgTool.isRemoveFriends((String) bean.getContent())) {
                                bean.setContent(((String) bean.getContent()).replace("<a href=\"weixin://findfriend/verifycontact\">发送朋友验证</a>", ""));
                            } else if (MsgTool.isRoomsNameChanged((String) bean.getContent())) {
                                if (!MsgTool.isNameChangeByMe((String) bean.getContent())) {
                                    bean.setContent(MsgTool.getNameChangedTips((String) bean.getContent()));
                                }
                            } else if (MsgTool.isJoinToRoom((String) bean.getContent())) {
                                if (MsgTool.joinRoomByInvited((String) bean.getContent())) {
                                    bean.setContent(MsgTool.getJoinRoomsTips((String) bean.getContent()));
                                } else if (MsgTool.joinRoomByScan((String) bean.getContent())) {
                                    if (!MsgTool.isMeJoinRoomByScan((String) bean.getContent())) {
                                        bean.setContent(MsgTool.getJoinRoomsTips((String) bean.getContent()));
                                    }
                                }
                            } else if (MsgTool.isRemoveMember(((String) bean.getContent()))) {
                                if (MsgTool.isRemoveMemberByMe((String) bean.getContent())) {
                                    bean.setContent(MsgTool.getMemberRemoveTips((String) bean.getContent()));
                                }
                            } else if (MsgTool.isRoomdOwnerChanged((String) bean.getContent())) {
                                if (!MsgTool.roomOwnerIsMe((String) bean.getContent())) {
                                    bean.setContent(MsgTool.getOwnerChangedTips((String) bean.getContent()));
                                }
                            } else if (MsgTool.isAcceptRedPkg((String) bean.getContent())) {
                                bean.setContent("领取了红包");
                            }
                            bean.setType(MsgInfo.WX_MESSAGE_TYPE_SYSTEM);
                            jsonStr = Info.convert(bean, Info.TYPE_MESSAGE);
                            emitter(jsonStr);
                            break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    save(msg);
                }

            }
        };

        Runnable task = null;

        switch (taskType) {
            case NORMAL:
                task = new NormalExecutor(msg, classLoader, callback);
                break;
            case REVOKE:
                if (MsgTool.isRevoke((String) msg.getContent())) {
                    MsgInfo entity = getMsgInfo(msg.getMsgId());
                    if (entity != null) {
                        entity.setType(msg.getType());
                        entity.setContent(msg.getContent());
                    }
                    task = new RemoveExecutor(entity, taskType);
                }
                break;
            case DELETE:
                task = new RemoveExecutor(msg, taskType);
                break;
        }

        if (task != null) {
            Listener.executor.execute(task);
        }
    }

    private static void save(MsgInfo info) {

        /*if (info == null) {
            return;
        }
        if (TextUtils.isEmpty(info.getMsgId())) {
            return;
        }
        ContentValues values = new ContentValues();
        values.put(MsgInfo.WX_MESSAGE_COLUMNNAME_MSGID, info.getMsgId());
        values.put(MarkDao.TASK_TYPE, MarkDao.MESSAGE);

        Context context = WeChatTool.getWXContext();
        if (context != null) {
            String currentWX = WeChatTool.currentWX(context);
            if (!TextUtils.isEmpty(currentWX)) {
                MarkDao markDao = new MarkDao(context, currentWX);
                if (markDao != null) {
                    markDao.insertMessageTask(values);
                }
            }

        }*/
    }

    /**
     * emitter message to client
     *
     * @param jsonStr data
     * @throws DisposeException
     */
    private static void emitter(Object jsonStr) throws DisposeException {
        if (jsonStr == null || !Booter.put(jsonStr)) {
            throw new DisposeException("emitter message have exception");
        }
    }

    private static MsgInfo getMsgInfo(String msgId) {
        if (TextUtils.isEmpty(msgId)) {
            return null;
        }
        return MsgInfo.toEntity(DBTool.rawQuery(FieldTool.instance().getDbObject(), SQL_SELECT_BASE_MSG, new String[]{msgId}));
    }

    private static MsgInfo getImageMsgInfo(String msgId) {
        if (TextUtils.isEmpty(msgId)) {
            return null;
        }
        return MsgInfo.toEntity(DBTool.rawQuery(FieldTool.instance().getDbObject(), SQL_SELECT_IMAGE_MSG, new String[]{msgId}));
    }

    /**
     * waiting to get server id when message insert to database .
     * then , invoke the callback to upload message
     */
    private static class NormalExecutor implements Runnable {

        private MsgCallback callback = null;
        private MsgInfo msg = null;
        private Object dbObj = null;
        private ClassLoader classLoader = null;

        private final int SLEEP_TIME = 5 * 1000;
        private final int RETRY_TIME = 20;

        public NormalExecutor(MsgInfo msg, ClassLoader classLoader, MsgCallback callback) {
            this.callback = callback;
            this.msg = msg;
            this.dbObj = FieldTool.instance().getDbObject();
            this.classLoader = classLoader;
        }

        @Override
        public void run() {

            if (dbObj == null || msg == null || callback == null || classLoader == null) {
                return;
            }

            switch (msg.getType()) {
                case MsgInfo.WX_MESSAGE_TYPE_TEXT:
                case MsgInfo.WX_MESSAGE_TYPE_CARD:
                case MsgInfo.WX_MESSAGE_TYPE_VOICE:
                case MsgInfo.WX_MESSAGE_TYPE_LINK:
                    msgSend(dbObj, msg, callback);
                    break;
                case MsgInfo.WX_MESSAGE_TYPE_REMITTANCE:
                case MsgInfo.WX_MESSAGE_TYPE_REDPACKAGE:
                    doNothing(msg, callback);
                    break;
                case MsgInfo.WX_MESSAGE_TYPE_IMAGE:
                case MsgInfo.WX_MESSAGE_TYPE_VIDEO:
                    mediaMsgSend(dbObj, msg, callback);
                    break;
                case MsgInfo.WX_MESSAGE_TYPE_ROOM_SYSTEM:
                case MsgInfo.WX_MESSAGE_TYPE_SYSTEM:
                    sysMsgSend(msg, callback);
                    break;
            }

        }

        private void sysMsgSend(MsgInfo bean, MsgCallback callback) {

            try {

                if (TextUtils.isEmpty((String) bean.getContent())) {
                    callback.onChanged(bean.getType(), false);
                    // throw exception
                    return;
                }

                if (MsgTool.isAgree((String) bean.getContent()) ||
                        MsgTool.isGreet((String) bean.getContent()) ||
                        MsgTool.isRemoveFriends((String) bean.getContent()) ||
                        MsgTool.isBlacklist((String) bean.getContent()) ||
                        MsgTool.isRoomsNameChanged((String) bean.getContent()) ||
                        MsgTool.isJoinToRoom((String) bean.getContent()) ||
                        MsgTool.isRemoveMember((String) bean.getContent()) ||
                        MsgTool.isRoomdOwnerChanged((String) bean.getContent()) ||
                        MsgTool.isAcceptRedPkg((String) bean.getContent())) {
                    callback.onChanged(bean.getType(), true);
                    return;
                }

                // throw exception
                callback.onChanged(bean.getType(), false);
            } catch (Exception e) {
                e.printStackTrace();
                callback.onChanged(bean.getType(), false);
            }
        }

        private void mediaMsgSend(Object obj, MsgInfo bean, MsgCallback callback) {

            int time = 0;
            while (true) {

                try {

                    if (TextUtils.isEmpty(bean.getMsgId())) {
                        throw new DisposeException("Media message , msgId is null ");
                    }

                    Thread.sleep(SLEEP_TIME);

                    if (bean.getType() == MsgInfo.WX_MESSAGE_TYPE_IMAGE) {
                        if (isImgReady(obj, bean)) {
                            callback.onChanged(bean.getType(), true);
                            break;
                        }
                    } else if (bean.getType() == MsgInfo.WX_MESSAGE_TYPE_VIDEO) {
                        if (isVideoReady(obj, bean)) {
                            callback.onChanged(bean.getType(), true);
                            break;
                        }
                    }

                    time += 1;

                    if (time >= RETRY_TIME) {
                        throw new DisposeException("Media message , out of retry time ");
                    }

                } catch (Exception e) {
                    callback.onChanged(bean.getType(), false);
                    break;
                }

            }
        }

        private void msgSend(Object dbObj, MsgInfo bean, MsgCallback callback) {
            int time = 0;

            while (true) {
                try {
                    if (TextUtils.isEmpty(bean.getMsgId())) {
                        throw new DisposeException("Normal message , msgId is null ");
                    }

                    Thread.sleep(SLEEP_TIME);

                    if (isMsgReady(dbObj, bean)) {
                        callback.onChanged(bean.getType(), true);
                        break;
                    }

                    time += 1;

                    if (time >= RETRY_TIME) {
                        throw new DisposeException("Normal message , out of retry times ");
                    }
                } catch (Exception e) {
                    callback.onChanged(bean.getType(), false);
                    break;
                }
            }
        }

        private void doNothing(MsgInfo bean, MsgCallback callback) {
            callback.onChanged(bean.getType(), true);
        }

        private boolean isMsgReady(Object dbObj, MsgInfo bean) {

            String sql = "select msgSvrId from message where msgId = ? and msgSvrId <> '' ";
            MsgInfo msg = MsgInfo.toEntity(DBTool.rawQuery(dbObj, sql, new String[]{bean.getMsgId()}));

            if (msg != null) {
                if (!TextUtils.isEmpty(msg.getMsgSvrId())) {
                    return true;
                }
            }
            return false;
        }

        private boolean isVideoReady(Object obj, MsgInfo bean) {

            String sql = "select m.msgSvrId ,v.status from message m left join videoinfo2 v on m.msgId = v.msglocalid  where m.msgId = ? ";
            MediaInfo media = MediaInfo.convertByCursor(DBTool.rawQuery(obj, sql, new String[]{bean.getMsgId()}));

            if (media != null) {
                if (!TextUtils.isEmpty(media.getMsgSvrId())) {
                    if (media.getStatus() == MediaInfo.VIDEO_START_DOWLOAD) {
                        Downloader.downloadVideo(bean.getImgPath(), classLoader);
                    } else if (media.getStatus() == MediaInfo.VIDEO_DOWNLOAD_SUCCESS) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean isImgReady(Object obj, MsgInfo bean) {

            String sql = "select m.msgSvrId,i.bigImgPath from message m left join ImgInfo2 i on m.imgPath = i.thumbImgPath where m.msgId = ? ";
            MediaInfo media = MediaInfo.convertByCursor(DBTool.rawQuery(obj, sql, new String[]{bean.getMsgId()}));

            if (media != null) {
                if (!TextUtils.isEmpty(media.getMsgSvrId())) {
                    if (!TextUtils.isEmpty(media.getBigImgPath()) &&
                            media.getBigImgPath().startsWith(MediaInfo.IMG_NEED_DOWNLOAD_PREFIX)) {
                        // download
                        Downloader.downloadImg(Long.valueOf(bean.getMsgId()), Downloader.MID_IMAGE, classLoader);
                    } else if (!TextUtils.isEmpty(media.getBigImgPath()) &&
                            media.getBigImgPath().endsWith(MediaInfo.IMG_DOWNLOAD_SUCCESS_SUFFIX)) {
                        // download success
                        return true;
                    }
                }
            }
            return false;
        }

    }

    private static class RemoveExecutor implements Runnable {

        private Object dbObject;
        private MsgInfo msg;
        private int taskType;

        private final String SQL_GET_MSGSVRID = "select type,isSend,talker,msgSvrId,content from message where msgId = ? ";


        public RemoveExecutor(MsgInfo msg, int taskType) {
            this.dbObject = FieldTool.instance().getDbObject();
            this.msg = msg;
            this.taskType = taskType;
        }

        @Override
        public void run() {

            if (dbObject == null || msg == null || TextUtils.isEmpty(msg.getMsgId())) {
                return;
            }
            try {
                switch (taskType) {
                    case Listener.REVOKE:
                        if (msg.getType() != -1 &&
                                (msg.getType() == MsgInfo.WX_MESSAGE_TYPE_SYSTEM ||
                                        msg.getType() == MsgInfo.WX_MESSAGE_TYPE_SYSTEM2)) {
                            if (MsgTool.isRevoke((String) msg.getContent())) {

                                msg.setRevoke(1);

                                JSONObject jsonStr = Info.convert(msg, Info.TYPE_REVOKE_MESSAGE);
                                if (!Booter.put(jsonStr)) {
                                    throw new DisposeException("revoke msg transfer fail");
                                }
                            }
                        }
                        break;
                    case Listener.DELETE:

                        MsgInfo bean = MsgInfo.toEntity(DBTool.rawQuery(dbObject, SQL_GET_MSGSVRID, new String[]{msg.getMsgId()}));

                        if (bean == null) {
                            throw new DisposeException("delete msg bean is null ");
                        }

                        bean.setDel(1);

                        JSONObject jsonStr = Info.convert(bean, Info.TYPE_DELETE_MESSAGE);

                        if (!Booter.put(jsonStr)) {
                            throw new DisposeException("delete msg transfer fail ");
                        }
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
                save(msg);
            }
        }

    }

}
