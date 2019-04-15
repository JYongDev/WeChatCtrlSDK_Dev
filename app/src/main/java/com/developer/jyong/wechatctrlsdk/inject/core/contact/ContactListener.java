package com.developer.jyong.wechatctrlsdk.inject.core.contact;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;

import com.developer.jyong.wechatctrlsdk.inject.core.main.Booter;
import com.developer.jyong.wechatctrlsdk.inject.core.main.DisposeException;
import com.developer.jyong.wechatctrlsdk.inject.info.ContactInfo;
import com.developer.jyong.wechatctrlsdk.inject.info.Info;
import com.developer.jyong.wechatctrlsdk.inject.tool.DBTool;
import com.developer.jyong.wechatctrlsdk.inject.tool.EventTool;
import com.developer.jyong.wechatctrlsdk.inject.tool.FieldTool;


public class ContactListener {

    private final static String TABLE_FMESSAGE_CONVERSATION = "fmessage_conversation";
    private final static String TABLE_RCONTACT = "rcontact";

    private final static String WX_FMESSAGECONVERSATION_COLUMNNAME_FMSGCONTENT = "fmsgContent";

    public final static int NEW_CONTACT_NOTIFY = 1;
    public final static int CONTACT_STATUS = 2;

    public final static int INSERT = 1;
    public final static int UPDATE = 2;

    public static void listen(String name, ContentValues values, int type) {

        if (TextUtils.isEmpty(name) || values == null) {
            return;
        }

        if (name.equals(TABLE_FMESSAGE_CONVERSATION) && type == INSERT) {
            schedule(ContactTool.convert(values.getAsString(WX_FMESSAGECONVERSATION_COLUMNNAME_FMSGCONTENT)), NEW_CONTACT_NOTIFY);
        } else if (name.equals(TABLE_RCONTACT) && type == UPDATE) {

            if (!values.containsKey(ContactInfo.WX_RCONTACT_COLUMNNAME_TYPE) ||
                    !values.containsKey(ContactInfo.WX_RCONTACT_COLUMNNAME_USERNAME)) {
                return;
            }

            String username = values.getAsString(ContactInfo.WX_RCONTACT_COLUMNNAME_USERNAME);

            if (ContactTool.useless(username)) {
                return;
            }

            ContactInfo contact = getContact(username);

            if (contact != null) {
                contact.setNewType(values.getAsInteger(ContactInfo.WX_RCONTACT_COLUMNNAME_TYPE));
                contact.setNewRemark(!values.containsKey(ContactInfo.WX_RCONTACT_COLUMNNAME_CONREMARK) ? "" : values.getAsString(ContactInfo.WX_RCONTACT_COLUMNNAME_CONREMARK));
                contact.setNewNickname(!values.containsKey(ContactInfo.WX_RCONTACT_COLUMNNAME_NICKNAME) ? "" : values.getAsString(ContactInfo.WX_RCONTACT_COLUMNNAME_NICKNAME));
                schedule(contact, CONTACT_STATUS);
            }

        } else if (name.equals(TABLE_RCONTACT) && type == INSERT) {
            if (!values.containsKey(ContactInfo.WX_RCONTACT_COLUMNNAME_USERNAME)) {
                return;
            }
            if (TextUtils.isEmpty(values.getAsString(ContactInfo.WX_RCONTACT_COLUMNNAME_USERNAME))) {
                return;
            }

            if (ContactTool.isRoom(values.getAsString(ContactInfo.WX_RCONTACT_COLUMNNAME_USERNAME))) {
                EventTool.instance().trigger(EventTool.EVENT_ROOM, values.getAsString(ContactInfo.WX_RCONTACT_COLUMNNAME_USERNAME));
            }
        }

    }

    private static void schedule(final ContactInfo contact, int type) {

        if (contact == null) {
            return;
        }

        ContactCallback call = new ContactCallback() {
            @Override
            public void onCall(boolean result, int type) {

                switch (type) {
                    case Info.TYPE_NEW_CONTACT_NOTIFY:
                        try {
                            if (result) {
                                if (!Booter.put(Info.convert(contact, Info.TYPE_NEW_CONTACT_NOTIFY))) {
                                    throw new DisposeException("contact queue is error ");
                                }
                            } else {
                                throw new DisposeException(" contact handle false ");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            save(contact);
                        }
                        break;
                    case Info.TYPE_IN_BLACKLIST:
                        try {
                            if (result) {
                                if (!Booter.put(Info.convert(contact, Info.TYPE_IN_BLACKLIST))) {
                                    throw new DisposeException("contact queue is error ");
                                }
                            } else {
                                throw new DisposeException(" contact handle false ");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            save(contact);
                        }
                        break;
                    case Info.TYPE_REMOVE_BLACKLIST:
                        try {
                            if (result) {
                                if (!Booter.put(Info.convert(contact, Info.TYPE_REMOVE_BLACKLIST))) {
                                    throw new DisposeException("contact queue is error ");
                                }
                            } else {
                                throw new DisposeException(" contact handle false ");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            save(contact);
                        }
                        break;
                    case Info.TYPE_NEW_CONTACT:
                        try {
                            if (result) {
                                if (!Booter.put(Info.convert(contact, Info.TYPE_NEW_CONTACT))) {
                                    throw new DisposeException("contact queue is error ");
                                }
                            } else {
                                throw new DisposeException(" contact handle false ");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            save(contact);
                        }
                        break;
                    case Info.TYPE_REMOVE_CONTACT:
                        try {
                            if (result) {
                                if (!Booter.put(Info.convert(contact, Info.TYPE_REMOVE_CONTACT))) {
                                    throw new DisposeException("contact queue is error ");
                                }
                            } else {
                                throw new DisposeException(" contact handle false ");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            save(contact);
                        }
                        break;
                    case Info.TYPE_MODIFY_NICKNAME:
                        try {
                            if (result) {
                                contact.setNickname(contact.getNewNickname());
                                if (!Booter.put(Info.convert(contact, Info.TYPE_MODIFY_NICKNAME))) {
                                    throw new DisposeException("contact queue is error ");
                                }
                            } else {
                                throw new DisposeException(" contact handle false ");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            save(contact);
                        }
                        break;
                    case Info.TYPE_MODIFY_REMARK:
                        try {
                            if (result) {
                                contact.setConRemark(contact.getNewRemark());
                                if (!Booter.put(Info.convert(contact, Info.TYPE_MODIFY_REMARK))) {
                                    throw new DisposeException("contact queue is error ");
                                }
                            } else {
                                throw new DisposeException(" contact handle false ");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            save(contact);
                        }
                        break;

                }
            }
        };


        Runner runner = new Runner(contact, call, type);
        new Thread(runner).start();
    }

    private static void save(ContactInfo contact) {

       /* if (contact == null || TextUtils.isEmpty(contact.getUsername())) {
            return;
        }

        ContentValues values = new ContentValues();
        values.put(MarkDao.TASK_TYPE, MarkDao.CONTACT);
        values.put(ContactInfo.WX_RCONTACT_COLUMNNAME_USERNAME, contact.getUsername());

        MarkDao markDao = MarkDao.getDao();
        if (markDao != null) {
            markDao.insertContactTask(values);
        }*/

    }

    private static ContactInfo getContact(String username) {

        if (TextUtils.isEmpty(username)) {
            return null;
        }

        if (FieldTool.instance().getDbObject() == null) {
            return null;
        }

        String sql = "select r.type ,r.username ,r.nickname ,r.alias ,r.conRemark ,r.lvbuff ,i.reserved2 from rcontact r left join img_flag i on r.username = i.username where r.username = ? ";

        return ContactInfo.convert2Bean(DBTool.rawQuery(FieldTool.instance().getDbObject(), sql, new String[]{username}));

    }

    @Deprecated
    private static ContactInfo getContactInNotify(String username) {

        String sql = "select fmsgContent from fmessage_conversation where talker = ? ";
        Cursor cursor = DBTool.rawQuery(FieldTool.instance().getDbObject(), sql, new String[]{username});
        String content = "";
        if (cursor != null && cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                content = cursor.getColumnIndex("fmsgContent") == -1 ? "" : cursor.getString(cursor.getColumnIndex("fmsgContent"));
            }
            cursor.close();
        }
        return ContactTool.convert(content);
    }

    private static class Runner implements Runnable {

        private ContactInfo contactInfo = null;
        private ContactCallback contactCallback = null;
        private int type = 0;

        public Runner(ContactInfo contactInfo, ContactCallback contactCallback, int type) {
            this.contactInfo = contactInfo;
            this.contactCallback = contactCallback;
            this.type = type;
        }

        @Override
        public void run() {

            if (contactCallback == null || contactInfo == null) {
                return;
            }

            switch (type) {
                case ContactListener.NEW_CONTACT_NOTIFY:
                    doNothing(contactCallback);
                    break;
                case ContactListener.CONTACT_STATUS:
                    infoUpdate(contactInfo, contactCallback);
                    break;
            }

        }

        private void doNothing(ContactCallback contactCallback) {
            contactCallback.onCall(true, Info.TYPE_NEW_CONTACT_NOTIFY);
        }

        private void infoUpdate(ContactInfo contactInfo, ContactCallback contactCallback) {
            if (contactInfo.getType() != -1) {

                if (ContactTool.isFriends(contactInfo.getType()) &&
                        ContactTool.isBlacklist(contactInfo.getNewType())) {
                    contactCallback.onCall(true, Info.TYPE_IN_BLACKLIST);
                } else if (ContactTool.isBlacklist(contactInfo.getType()) &&
                        ContactTool.isFriends(contactInfo.getNewType())) {
                    contactCallback.onCall(true, Info.TYPE_REMOVE_BLACKLIST);
                } else if (!ContactTool.isFriends(contactInfo.getType()) &&
                        !ContactTool.isBlacklist(contactInfo.getType()) &&
                        ContactTool.isFriends(contactInfo.getNewType())) {
                    contactCallback.onCall(true, Info.TYPE_NEW_CONTACT);
                } else if (ContactTool.isFriends(contactInfo.getType()) &&
                        !ContactTool.isBlacklist(contactInfo.getType()) &&
                        !ContactTool.isFriends(contactInfo.getNewType())) {
                    contactCallback.onCall(true, Info.TYPE_REMOVE_CONTACT);
                } else if (!TextUtils.isEmpty(contactInfo.getNewNickname()) &&
                        !TextUtils.isEmpty(contactInfo.getNickname()) &&
                        !contactInfo.getNickname().equals(contactInfo.getNewNickname())) {
                    contactCallback.onCall(true, Info.TYPE_MODIFY_NICKNAME);
                } else if (!contactInfo.getConRemark().equals(contactInfo.getNewRemark())) {
                    contactCallback.onCall(true, Info.TYPE_MODIFY_REMARK);
                }

            }
        }
    }
}
