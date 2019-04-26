package com.developer.jyong.wechatctrlsdk.inject.core.main;

public class Configurator {

    private final static String WX_VERSION_663 = "6.6.3";
    private final static String WX_VERSION_665 = "6.6.5";
    private final static String WX_VERSION_666 = "6.6.6";
    private final static String WX_VERSION_667 = "6.6.7";
    private final static String WX_VERSION_672 = "6.7.2";
    private final static String WX_VERSION_673 = "6.7.3";
    private final static String WX_VERSION_700 = "7.0.0";
    private final static String WX_VERSION_703 = "7.0.3";
    private final static String WX_VERSION_704 = "7.0.4";

    public final static int CODE_CHANGED_VERSION_667 = 667;
    public final static int CODE_CHANGED_VERSION_672 = 672;

    // api version
    private int version;

    // download chatting img
    private String imgDownloadBootClz;
    private String imgDownloadBootFunc;
    private String loadClz;
    private String loadFunc;
    private String downImgEntityClz;
    private String downImgEntityParamClz;
    private String downloadFunc;

    // database
 /*   private String dbClz;
    private String dbFunc;
    private String dbInstance;
    private String dbInsertFunc;
    private String dbUpdateFunc;
    private String dbDeleteFunc;*/

    private String dbClz;
    private String dbOpenFunc;
    private String dbCipherClz;
    private String dbCursorFactoryClz;
    private String dbErrorHandlerClz;
    private String dbInsertFunc;
    private String dbUpdateFunc;
    private String dbDeleteFunc;

    // launcher
    private String launcherClz;
    private String launcherFunc;

    // download chatting video
    private String videoDownloadBootClz;
    private String videoDownloadFunc;

    // send text
    private String textMsgEntityClz;
    private String textMsgBootClz;
    private String textMsgBootFunc;
    private String textMsgSendFunc;

    // send image
    private String imgMsgEntityClz;
    private String imgMsgEntityParamClz;
    private String imgMsgBootClz;
    private String imgMsgBootFunc;
    private String imgMsgSendFunc;

    // send video
    private String videoMsgEntityClz;
    private String videoMsgEntityParamClz;
    private String videoMsgBootClz;
    private String videoMsgBootFunc;

    // send voice
    private String voiceMsgDBEntityClz;
    private String voiceMsgDBEntityFunc;
    private String voiceMsgPathClz;
    private String voiceMsgPathFunc;
    private String voiceMsgNotifyFunc;
    private String voiceMsgBootClz;
    private String voiceMsgBootFunc;
    private String voiceMsgEntityClz;
    private String voiceMsgSendFunc;

    // transmit link
    private String linkMsgParam1WrapClz;
    private String linkMsgParam1WrapFunc;
    private String linkMsgParam1InvokeClz;
    private String linkMsgParam1InvokeFunc;
    private String linkMsgParam2WrapClz;
    private String linkMsgParam2WrapFunc;
    private String linkMsgParam2InvokeFunc;
    private String linkMsgParam2ConvertClz;
    private String linkMsgParam2ConvertFunc;
    private String linkMsgParam1ConvertClz;
    private String linkMsgParam1ConvertFunc;
    private String linkMsgSendClz;
    private String linkMsgSendFunc;

    //  send moment text
    private int snsTextEntityInstanceParam;
    private String snsEntityClz;
    private String snsEntityDescConfigFunc;
    private String snsEntityVal0ConfigFunc1;
    private String snsEntityVal0ConfigFunc2;
    private String snsEntityVal0ConfigFunc3;
    private String snsEntityVal0ConfigFunc4;
    private String snsEntityCommitFunc;
    private String snsEntityCarrierClz;
    private String snsEntityCarryFunc;
    private String snsMsgHandleQueueClz;
    private String snsMsgHandleQueueVar;
    private String snsMsgHandlePutFunc;
    private String snsToolsOfGetRefreshClz;
    private String snsToolsOfGetRefreshFunc;
    private String snsRefreshFunc;

    //  send moment image
    private int snsImgEntityInstanceParam;
    private String snsImgInfoClz;
    private String snsImgInfoVarType;
    private String snsImgInfoVal0Var1;
    private String snsImgInfoVal0Var2;
    private String snsImgInfoVal0Var3;
    private String snsImgInfoVal0Var4;
    private String snsImgInfoVarDesc;
    private String snsImgInfoValFalseVar5;
    private String snsEntityOneOfVar;
    private String snsImgOptListVar;
    private String snsImgOptClz;
    private String snsImgOptVal00fVar;
    private String snsImgOptVal0Var;
    private String snsImgOptVal1000fVar1;
    private String snsImgOptVal1000fVar2;
    private String snsImgOptVal1000fVar3;
    private String snsImgOptVal1000fVar4;
    private String snsImgOptVal2Var;
    private String snsImgOptTimestamp1;
    private String snsImgOptTimestamp2;
    private String snsImgOptAddFunc;
    private String snsEntityImgConfigFunc;

    //  send moment video
    private int snsVideoEntityInstanceParam;
    private String getSnsVideoTmpPathClz;
    private String getSnsVideoTmpPathFunc;
    private String snsEntityVideoConfigFunc;
    private String snsVideoFileOperationClz;
    private String snsVideoCopyFileFunc;
    private String snsVideoGetOneOfVarFunc;
    private String snsVideoExtraVar1Param1;
    private String snsVideoEntityOneOfVar1;
    private String snsVideoEntityVarInnerVar1;
    private String snsVideoEntityVar1InnerVar1;
    private String snsVideoExtraVar1AddFunc;
    private String snsVideoExtraVar2Clz;
    private String snsVideoExtraVar1Param2;
    private String snsVideoExtraVar2Param1;
    private String snsVideoEntityOneOfVar2;
    private String snsVideoEntityVar2InnerVar;
    private String snsVideoExtraVar2AddFunc;

    // create room < Wechat672
    private String roomEntityClz;
    private String roomEntityVar;
    private String roomEntityStrParam;
    private String roomEntityListParam;
    private String roomEntitySubmitClz;
    private String roomEntitySubmitInstance;
    private String roomEntitySubmitFunc;

    // create room > Wechat672
    private String createRoomEntityClz;
    private String createRoomEntityParentClz;
    private String createRoomGetParentEntityFunc;
    private String createRoomVarInParent;
    private String createRoomBootClz;
    private String createRoomBootFunc;
    private String createRoomBootInstance;
    private String createRoomCallbackVar;
    private String createRoomSendFunc;
    private String createRoomRefreshUIClz;
    private String createRoomRefreshUIFunc;
    private String createRoomVarGetTypeFunc;

    // add room member
    private String addRoomMemberEntityClz;
    private String addRoomMemberBootClz;
    private String addRoomMemberBootFunc;
    private String addRoomMemberSendFunc;

    // remove room member
    private String removeRoomMemberEntityClz;
    private String removeRoomMemberBootClz;
    private String removeRoomMemberBootFunc;
    private String removeRoomMemberSendFunc;

    // notify all
    private String notifyAllMemberEntityClz;
    private String notifyAllRoomMemberBootClz;
    private String notifyAllRoomMemberBootFunc;
    private String notifyAllRoomMemberSendFunc;

    // send card
    private String cardMsgPackagerClz;
    private String cardMsgPackageFunc;
    private String cardMsgEntityClz;
    private String cardMsgBootClz;
    private String cardMsgBootFunc;
    private String cardMsgSendFunc;

    // agree friend
    private String agreeFriendEntityClz;
    private String agreeFriendBootClz;
    private String agreeFriendBootFunc;
    private String agreeFriendSendFunc;

    // get context
    private String contextClz;
    private String contextFunc;

    // modify chatroom name
    private String getRoomNameEntityClz;
    private String getRoomNameEntityFunc;
    private String roomNameAmendFunc;
    private String roonNameShowDialogFunc;
    private String roomNameDialogInstance;
    private String roomNameDismissFunc;

    //  send subscription card (发送公众号名片)
    private String subscriptionBootClz;
    private String subscriptionBootFunc;
    private String subscriptionSendFunc;

    //  modify contact remark
    private String getRemarkInfoBootClz;
    private String getRemarkInfoBootFunc;
    private String getRemarkInfoFunc;
    private String amendRemarkClz;
    private String amendRemarkFunc;

    //  delete contact
    private String delContactEntityClz;
    private String delContactBootClz;
    private String delContactBootFunc;
    private String delContactFunc;
    private String delContactRefreshBootFunc;
    private String delContactRefreshFunc;

    // accept remittance
    private String remittanceEntityClz;
    private String remittanceEntityParams;
    private String remittanceBootClz;
    private String remittanceBootFunc;
    private String remittanceAcceptInstance;
    private String remittanceAcceptFunc;

    //  exit room
    private String exitRoomInvokeParamsClz;   //  形参
    private String exitRoomInvokeClz;      //  类
    private String exitRoomInvokeFunc;     //  方法
    private String exitRoomGetInvokeFunc;
    private String exitRoomRefreshUIEntityClz;
    private String exitRoomRefreshUIFunc;
    private String exitRoomBootClz;
    private String exitRoomBootFunc1;
    private String exitRoomBootFunc2;
    private String exitRoomFunc;


    //  at one
    private String atoneEntityClz;
    private String atoneBootClz;
    private String atoneBootFunc;
    private String atoneSendFunc;

    private Configurator() {
    }

    public static Configurator instance(String version) {

        if (version == null || version.length() <= 0) {
            return null;
        }

        Configurator configurator = null;

        switch (version) {
            case WX_VERSION_704:
                configurator = new Builder()
                        .setVersion(704)
                        .setImgDownloadBootClz("com.tencent.mm.model.aw")
                        .setImgDownloadBootFunc("Rg")
                        .setLoadClz("com.tencent.mm.at.o")
                        .setLoadFunc("ahm")
                        .setDownImgEntityClz("com.tencent.mm.at.k")
                        .setDownImgEntityParamClz("com.tencent.mm.ai.g")
                        .setDownloadFunc("a")
                        .setDbClz("com.tencent.wcdb.database.SQLiteDatabase")
                        .setDbOpenFunc("openDatabase")
                        .setDbCipherClz("com.tencent.wcdb.database.SQLiteCipherSpec")
                        .setDbCursorFactoryClz("com.tencent.wcdb.database.SQLiteDatabase.CursorFactory")
                        .setDbErrorHandlerClz("com.tencent.wcdb.DatabaseErrorHandler")
                        .setDbInsertFunc("insertWithOnConflict")
                        .setDbUpdateFunc("updateWithOnConflict")
                        .setDbDeleteFunc("delete")
                        .setLauncherClz("com.tencent.mm.ui.LauncherUI")
                        .setLauncherFunc("onCreateOptionsMenu")
                        .setVideoDownloadBootClz("com.tencent.mm.modelvideo.u")
                        .setVideoDownloadFunc("up")
                        .setTextMsgEntityClz("com.tencent.mm.modelmulti.h")
                        .setTextMsgBootClz("com.tencent.mm.model.aw")
                        .setTextMsgBootFunc("Rg")
                        .setTextMsgSendFunc("a")
                        .setImgMsgEntityClz("com.tencent.mm.at.l")
                        .setImgMsgEntityParamClz("com.tencent.mm.ai.g")
                        .setImgMsgBootClz("com.tencent.mm.model.aw")
                        .setImgMsgBootFunc("Rg")
                        .setImgMsgSendFunc("a")
                        .setVideoMsgEntityClz("com.tencent.mm.pluginsdk.model.j")
                        .setVideoMsgEntityParamClz("com.tencent.mm.pluginsdk.model.j$a")
                        .setVideoMsgBootClz("com.tencent.mm.sdk.g.d")
                        .setVideoMsgBootFunc("post")
                        .setVoiceMsgDBEntityClz("com.tencent.mm.modelvoice.q")
                        .setVoiceMsgDBEntityFunc("uP")
                        .setVoiceMsgPathClz("com.tencent.mm.modelvoice.q")
                        .setVoiceMsgPathFunc("U")
                        .setVoiceMsgNotifyFunc("o")
                        .setVoiceMsgBootClz("com.tencent.mm.model.aw")
                        .setVoiceMsgBootFunc("Rg")
                        .setVoiceMsgEntityClz("com.tencent.mm.modelvoice.f")
                        .setVoiceMsgSendFunc("a")
                        .setLinkMsgParam1WrapClz("com.tencent.mm.sdk.platformtools.bo")
                        .setLinkMsgParam1WrapFunc("anj")
                        .setLinkMsgParam1InvokeClz("com.tencent.mm.af.j$b")
                        .setLinkMsgParam1InvokeFunc("me")
                        .setLinkMsgParam1ConvertClz("com.tencent.mm.af.j$b")
                        .setLinkMsgParam1ConvertFunc("a")
                        .setLinkMsgParam2WrapClz("com.tencent.mm.at.o")
                        .setLinkMsgParam2WrapFunc("ahl")
                        .setLinkMsgParam2InvokeFunc("I")
                        .setLinkMsgParam2ConvertClz("com.tencent.mm.modelsfs.FileOp")
                        .setLinkMsgParam2ConvertFunc("te")
                        .setLinkMsgSendClz("com.tencent.mm.pluginsdk.model.app.l")
                        .setLinkMsgSendFunc("a")
                        .setSnsEntityClz("com.tencent.mm.plugin.sns.model.ax")
                        .setSnsEntityDescConfigFunc("Ym")
                        .setSnsEntityVal0ConfigFunc1("Di")
                        .setSnsEntityVal0ConfigFunc2("Dh")
                        .setSnsEntityVal0ConfigFunc3("Df")
                        .setSnsEntityVal0ConfigFunc4("Dg")
                        .setSnsEntityCommitFunc("commit")
                        .setSnsEntityCarrierClz("com.tencent.mm.modelsns.b")
                        .setSnsEntityCarryFunc("ma")
                        .setSnsMsgHandleQueueClz("com.tencent.mm.plugin.sns.i.g")
                        .setSnsMsgHandleQueueVar("qTp")
                        .setSnsMsgHandlePutFunc("c")
                        .setSnsToolsOfGetRefreshClz("com.tencent.mm.plugin.sns.model.af")
                        .setSnsToolsOfGetRefreshFunc("cnB")
                        .setSnsRefreshFunc("cmp")
                        .setSnsImgInfoClz("com.tencent.mm.plugin.sns.data.h")
                        .setSnsImgInfoVarType("type")
                        .setSnsImgInfoVal0Var1("filterId")
                        .setSnsImgInfoVal0Var2("qFX")
                        .setSnsImgInfoVal0Var3("qFY")
                        .setSnsImgInfoVal0Var4("cNE")
                        .setSnsImgInfoVarDesc("desc")
                        .setSnsImgInfoValFalseVar5("qGc")
                        .setSnsEntityOneOfVar("qNL")
                        .setSnsImgOptListVar("wFr")
                        .setSnsImgOptClz("com.tencent.mm.protocal.protobuf.cbv")
                        .setSnsImgOptVal00fVar("bEJ")
                        .setSnsImgOptVal0Var("rkk")
                        .setSnsImgOptVal1000fVar1("xbk")
                        .setSnsImgOptVal1000fVar2("xbl")
                        .setSnsImgOptVal1000fVar3("xbm")
                        .setSnsImgOptVal1000fVar4("xbn")
                        .setSnsImgOptVal2Var("xbo")
                        .setSnsImgOptTimestamp1("xbp")
                        .setSnsImgOptTimestamp2("xbq")
                        .setSnsImgOptAddFunc("add")
                        .setSnsEntityImgConfigFunc("dh")
                        .setGetSnsVideoTmpPathClz("com.tencent.mm.plugin.sns.model.af")
                        .setGetSnsVideoTmpPathFunc("getAccSnsTmpPath")
                        .setSnsEntityVideoConfigFunc("Yw")
                        .setSnsVideoFileOperationClz("com.tencent.mm.vfs.e")
                        .setSnsVideoCopyFileFunc("y")
                        .setSnsVideoGetOneOfVarFunc("c")
                        .setSnsVideoExtraVar1Param1("Desc")
                        .setSnsVideoEntityOneOfVar1("qNK")
                        .setSnsVideoEntityVarInnerVar1("xfI")
                        .setSnsVideoEntityVar1InnerVar1("wbK")
                        .setSnsVideoExtraVar1AddFunc("add")
                        .setSnsVideoExtraVar2Clz("com.tencent.mm.protocal.protobuf.ayq")
                        .setSnsVideoExtraVar1Param2("cNE")
                        .setSnsVideoExtraVar2Param1("wCt")
                        .setSnsVideoEntityOneOfVar2("qNL")
                        .setSnsVideoEntityVar2InnerVar("wFf")
                        .setSnsVideoExtraVar2AddFunc("add")
                        .setSnsTextEntityInstanceParam(2)
                        .setSnsImgEntityInstanceParam(1)
                        .setSnsVideoEntityInstanceParam(15)
                        .setCreateRoomEntityClz("com.tencent.mm.chatroom.c.g")
                        .setCreateRoomEntityParentClz("com.tencent.mm.roomsdk.a.c.a")
                        .setCreateRoomGetParentEntityFunc("pa")
                        .setCreateRoomVarInParent("tRR")
                        .setCreateRoomBootClz("com.tencent.mm.kernel.g")
                        .setCreateRoomBootFunc("RO")
                        .setCreateRoomBootInstance("eJo")
                        .setCreateRoomCallbackVar("fur")
                        .setCreateRoomSendFunc("a")
                        .setCreateRoomRefreshUIClz("com.tencent.mm.model.m")
                        .setCreateRoomRefreshUIFunc("a")
                        .setCreateRoomVarGetTypeFunc("getType")
                        .setAddRoomMemberEntityClz("com.tencent.mm.chatroom.c.e")
                        .setAddRoomMemberBootClz("com.tencent.mm.model.aw")
                        .setAddRoomMemberBootFunc("Rg")
                        .setAddRoomMemberSendFunc("a")
                        .setRemoveRoomMemberEntityClz("com.tencent.mm.chatroom.c.h")
                        .setRemoveRoomMemberBootClz("com.tencent.mm.model.aw")
                        .setRemoveRoomMemberBootFunc("Rg")
                        .setRemoveRoomMemberSendFunc("a")
                        .setNotifyAllMemberEntityClz("com.tencent.mm.chatroom.c.o")
                        .setNotifyAllRoomMemberBootClz("com.tencent.mm.model.aw")
                        .setNotifyAllRoomMemberBootFunc("Rg")
                        .setNotifyAllRoomMemberSendFunc("a")
                        .setCardMsgPackagerClz("com.tencent.mm.ui.contact.z")
                        .setCardMsgPackageFunc("arT")
                        .setCardMsgEntityClz("com.tencent.mm.modelmulti.h")
                        .setCardMsgBootClz("com.tencent.mm.model.aw")
                        .setCardMsgBootFunc("Rg")
                        .setCardMsgSendFunc("a")
                        .setAgreeFriendEntityClz("com.tencent.mm.pluginsdk.model.m")
                        .setAgreeFriendBootClz("com.tencent.mm.model.aw")
                        .setAgreeFriendBootFunc("Rg")
                        .setAgreeFriendSendFunc("a")
                        .setContextClz("com.tencent.mm.sdk.platformtools.ah")
                        .setContextFunc("getContext")
                        .setGetRoomNameEntityClz("com.tencent.mm.roomsdk.a.b")
                        .setGetRoomNameEntityFunc("alY")
                        .setRoomNameAmendFunc("M")
                        .setRoonNameShowDialogFunc("a")
                        .setRoomNameDialogInstance("tipDialog")
                        .setRoomNameDismissFunc("dismiss")
                        .setSubscriptionBootClz("com.tencent.mm.plugin.messenger.a.g")
                        .setSubscriptionBootFunc("bOk")
                        .setSubscriptionSendFunc("q")
                        .setGetRemarkInfoBootClz("com.tencent.mm.model.c")
                        .setGetRemarkInfoBootFunc("XM")
                        .setGetRemarkInfoFunc("aoO")
                        .setAmendRemarkClz("com.tencent.mm.model.t")
                        .setAmendRemarkFunc("b")
                        .setDelContactEntityClz("com.tencent.mm.az.c")
                        .setDelContactBootClz("com.tencent.mm.model.c")
                        .setDelContactBootFunc("XL")
                        .setDelContactFunc("c")
                        .setDelContactRefreshBootFunc("XR")
                        .setDelContactRefreshFunc("apq")
                        .setRemittanceEntityClz("com.tencent.mm.plugin.remittance.model.u")
                        .setRemittanceEntityParams("eHT")
                        .setRemittanceBootClz("com.tencent.mm.kernel.g")
                        .setRemittanceBootFunc("RO")
                        .setRemittanceAcceptInstance("eJo")
                        .setRemittanceAcceptFunc("a")
                        .setExitRoomInvokeParamsClz("com.tencent.mm.plugin.messenger.foundation.a.j")
                        .setExitRoomInvokeClz("com.tencent.mm.kernel.g")
                        .setExitRoomInvokeFunc("K")
                        .setExitRoomGetInvokeFunc("XL")
                        .setExitRoomRefreshUIEntityClz("com.tencent.mm.chatroom.e.a")
                        .setExitRoomRefreshUIFunc("c")
                        .setExitRoomBootClz("com.tencent.mm.roomsdk.a.b")
                        .setExitRoomBootFunc1("alY")
                        .setExitRoomBootFunc2("ke")
                        .setExitRoomFunc("dmX")
                        .setAtoneEntityClz("com.tencent.mm.modelmulti.h")
                        .setAtoneBootClz("com.tencent.mm.model.aw")
                        .setAtoneBootFunc("Rg")
                        .setAtoneSendFunc("a")
                        .create();
                break;
            case WX_VERSION_703:
                configurator = new Builder()
                        .setVersion(703)
                        .setImgDownloadBootClz("com.tencent.mm.model.av")
                        .setImgDownloadBootFunc("Pw")
                        .setLoadClz("com.tencent.mm.as.o")
                        .setLoadFunc("afj")
                        .setDownImgEntityClz("com.tencent.mm.as.k")
                        .setDownImgEntityParamClz("com.tencent.mm.ah.g")
                        .setDownloadFunc("a")
                        .setDbClz("com.tencent.wcdb.database.SQLiteDatabase")
                        .setDbOpenFunc("openDatabase")
                        .setDbCipherClz("com.tencent.wcdb.database.SQLiteCipherSpec")
                        .setDbCursorFactoryClz("com.tencent.wcdb.database.SQLiteDatabase.CursorFactory")
                        .setDbErrorHandlerClz("com.tencent.wcdb.DatabaseErrorHandler")
                        .setDbInsertFunc("insertWithOnConflict")
                        .setDbUpdateFunc("updateWithOnConflict")
                        .setDbDeleteFunc("delete")
                        .setLauncherClz("com.tencent.mm.ui.LauncherUI")
                        .setLauncherFunc("onCreateOptionsMenu")
                        .setVideoDownloadBootClz("com.tencent.mm.modelvideo.u")
                        .setVideoDownloadFunc("tN")
                        .setTextMsgEntityClz("com.tencent.mm.modelmulti.h")
                        .setTextMsgBootClz("com.tencent.mm.model.av")
                        .setTextMsgBootFunc("Pw")
                        .setTextMsgSendFunc("a")
                        .setImgMsgEntityClz("com.tencent.mm.as.l")
                        .setImgMsgEntityParamClz("com.tencent.mm.ah.g")
                        .setImgMsgBootClz("com.tencent.mm.model.av")
                        .setImgMsgBootFunc("Pw")
                        .setImgMsgSendFunc("a")
                        .setVideoMsgEntityClz("com.tencent.mm.pluginsdk.model.j")
                        .setVideoMsgEntityParamClz("com.tencent.mm.pluginsdk.model.j$a")
                        .setVideoMsgBootClz("com.tencent.mm.sdk.g.d")
                        .setVideoMsgBootFunc("post")
                        .setVoiceMsgDBEntityClz("com.tencent.mm.modelvoice.q")
                        .setVoiceMsgDBEntityFunc("uo")
                        .setVoiceMsgPathClz("com.tencent.mm.modelvoice.q")
                        .setVoiceMsgPathFunc("T")
                        .setVoiceMsgNotifyFunc("o")
                        .setVoiceMsgBootClz("com.tencent.mm.model.av")
                        .setVoiceMsgBootFunc("Pw")
                        .setVoiceMsgEntityClz("com.tencent.mm.modelvoice.f")
                        .setVoiceMsgSendFunc("a")
                        .setLinkMsgParam1WrapClz("com.tencent.mm.sdk.platformtools.bp")
                        .setLinkMsgParam1WrapFunc("alI")
                        .setLinkMsgParam1InvokeClz("com.tencent.mm.ae.j$b")
                        .setLinkMsgParam1InvokeFunc("lE")
                        .setLinkMsgParam1ConvertClz("com.tencent.mm.ae.j$b")
                        .setLinkMsgParam1ConvertFunc("a")
                        .setLinkMsgParam2WrapClz("com.tencent.mm.as.o")
                        .setLinkMsgParam2WrapFunc("afi")
                        .setLinkMsgParam2InvokeFunc("H")
                        .setLinkMsgParam2ConvertClz("com.tencent.mm.modelsfs.FileOp")
                        .setLinkMsgParam2ConvertFunc("sE")
                        .setLinkMsgSendClz("com.tencent.mm.pluginsdk.model.app.l")
                        .setLinkMsgSendFunc("a")
                        .setSnsEntityClz("com.tencent.mm.plugin.sns.model.ax")
                        .setSnsEntityDescConfigFunc("WU")
                        .setSnsEntityVal0ConfigFunc1("Cr")
                        .setSnsEntityVal0ConfigFunc2("Cq")
                        .setSnsEntityVal0ConfigFunc3("Co")
                        .setSnsEntityVal0ConfigFunc4("Cp")
                        .setSnsEntityCommitFunc("commit")
                        .setSnsEntityCarrierClz("com.tencent.mm.modelsns.b")
                        .setSnsEntityCarryFunc("lm")
                        .setSnsMsgHandleQueueClz("com.tencent.mm.plugin.sns.i.g")
                        .setSnsMsgHandleQueueVar("qom")
                        .setSnsMsgHandlePutFunc("c")
                        .setSnsToolsOfGetRefreshClz("com.tencent.mm.plugin.sns.model.af")
                        .setSnsToolsOfGetRefreshFunc("cjq")
                        .setSnsRefreshFunc("cih")
                        .setSnsImgInfoClz("com.tencent.mm.plugin.sns.data.h")
                        .setSnsImgInfoVarType("type")
                        .setSnsImgInfoVal0Var1("filterId")
                        .setSnsImgInfoVal0Var2("qbd")
                        .setSnsImgInfoVal0Var3("qbe")
                        .setSnsImgInfoVal0Var4("cCt")
                        .setSnsImgInfoVarDesc("desc")
                        .setSnsImgInfoValFalseVar5("qbi")
                        .setSnsEntityOneOfVar("qiK")
                        .setSnsImgOptListVar("vTI")
                        .setSnsImgOptClz("com.tencent.mm.protocal.protobuf.bzi")
                        .setSnsImgOptVal00fVar("bsZ")
                        .setSnsImgOptVal0Var("qFg")
                        .setSnsImgOptVal1000fVar1("wog")
                        .setSnsImgOptVal1000fVar2("woh")
                        .setSnsImgOptVal1000fVar3("woi")
                        .setSnsImgOptVal1000fVar4("woj")
                        .setSnsImgOptVal2Var("wok")
                        .setSnsImgOptTimestamp1("wol")
                        .setSnsImgOptTimestamp2("wom")
                        .setSnsImgOptAddFunc("add")
                        .setSnsEntityImgConfigFunc("df")
                        .setGetSnsVideoTmpPathClz("com.tencent.mm.plugin.sns.model.af")
                        .setGetSnsVideoTmpPathFunc("getAccSnsTmpPath")
                        .setSnsEntityVideoConfigFunc("Xe")
                        .setSnsVideoFileOperationClz("com.tencent.mm.vfs.e")
                        .setSnsVideoCopyFileFunc("y")
                        .setSnsVideoGetOneOfVarFunc("c")
                        .setSnsVideoExtraVar1Param1("Desc")
                        .setSnsVideoEntityOneOfVar1("qiJ")
                        .setSnsVideoEntityVarInnerVar1("wsx")
                        .setSnsVideoEntityVar1InnerVar1("vqu")
                        .setSnsVideoExtraVar1AddFunc("add")
                        .setSnsVideoExtraVar2Clz("com.tencent.mm.protocal.protobuf.awz")
                        .setSnsVideoExtraVar1Param2("cCt")
                        .setSnsVideoExtraVar2Param1("vQL")
                        .setSnsVideoEntityOneOfVar2("qiK")
                        .setSnsVideoEntityVar2InnerVar("vTw")
                        .setSnsVideoExtraVar2AddFunc("add")
                        .setSnsTextEntityInstanceParam(2)
                        .setSnsImgEntityInstanceParam(1)
                        .setSnsVideoEntityInstanceParam(15)
                        .setCreateRoomEntityClz("com.tencent.mm.chatroom.c.g")
                        .setCreateRoomEntityParentClz("com.tencent.mm.roomsdk.a.c.a")
                        .setCreateRoomGetParentEntityFunc("oz")
                        .setCreateRoomVarInParent("wHN")
                        .setCreateRoomBootClz("com.tencent.mm.kernel.g")
                        .setCreateRoomBootFunc("Qd")
                        .setCreateRoomBootInstance("evj")
                        .setCreateRoomCallbackVar("ffa")
                        .setCreateRoomSendFunc("a")
                        .setCreateRoomRefreshUIClz("com.tencent.mm.model.l")
                        .setCreateRoomRefreshUIFunc("a")
                        .setCreateRoomVarGetTypeFunc("getType")
                        .setAddRoomMemberEntityClz("com.tencent.mm.chatroom.c.e")
                        .setAddRoomMemberBootClz("com.tencent.mm.model.av")
                        .setAddRoomMemberBootFunc("Pw")
                        .setAddRoomMemberSendFunc("a")
                        .setRemoveRoomMemberEntityClz("com.tencent.mm.chatroom.c.h")
                        .setRemoveRoomMemberBootClz("com.tencent.mm.model.av")
                        .setRemoveRoomMemberBootFunc("Pw")
                        .setRemoveRoomMemberSendFunc("a")
                        .setNotifyAllMemberEntityClz("com.tencent.mm.chatroom.c.o")
                        .setNotifyAllRoomMemberBootClz("com.tencent.mm.model.av")
                        .setNotifyAllRoomMemberBootFunc("Pw")
                        .setNotifyAllRoomMemberSendFunc("a")
                        .setCardMsgPackagerClz("com.tencent.mm.ui.contact.z")
                        .setCardMsgPackageFunc("aqn")
                        .setCardMsgEntityClz("com.tencent.mm.modelmulti.h")
                        .setCardMsgBootClz("com.tencent.mm.model.av")
                        .setCardMsgBootFunc("Pw")
                        .setCardMsgSendFunc("a")
                        .setAgreeFriendEntityClz("com.tencent.mm.pluginsdk.model.m")
                        .setAgreeFriendBootClz("com.tencent.mm.model.av")
                        .setAgreeFriendBootFunc("Pw")
                        .setAgreeFriendSendFunc("a")
                        .setContextClz("com.tencent.mm.sdk.platformtools.ah")
                        .setContextFunc("getContext")
                        .setGetRoomNameEntityClz("com.tencent.mm.roomsdk.a.b")
                        .setGetRoomNameEntityFunc("akv")
                        .setRoomNameAmendFunc("M")
                        .setRoonNameShowDialogFunc("a")
                        .setRoomNameDialogInstance("tipDialog")
                        .setRoomNameDismissFunc("dismiss")
                        .setSubscriptionBootClz("com.tencent.mm.plugin.messenger.a.g")
                        .setSubscriptionBootFunc("bKf")
                        .setSubscriptionSendFunc("q")
                        .setGetRemarkInfoBootClz("com.tencent.mm.model.c")
                        .setGetRemarkInfoBootFunc("VI")
                        .setGetRemarkInfoFunc("anm")
                        .setAmendRemarkClz("com.tencent.mm.model.s")
                        .setAmendRemarkFunc("b")
                        .setDelContactEntityClz("com.tencent.mm.ay.c")
                        .setDelContactBootClz("com.tencent.mm.model.c")
                        .setDelContactBootFunc("VH")
                        .setDelContactFunc("c")
                        .setDelContactRefreshBootFunc("VN")
                        .setDelContactRefreshFunc("anN")
                        .setRemittanceEntityClz("com.tencent.mm.plugin.remittance.model.u")
                        .setRemittanceEntityParams("etQ")
                        .setRemittanceBootClz("com.tencent.mm.kernel.g")
                        .setRemittanceBootFunc("Qd")
                        .setRemittanceAcceptInstance("evj")
                        .setRemittanceAcceptFunc("a")
                        .setExitRoomInvokeParamsClz("com.tencent.mm.plugin.messenger.foundation.a.j")
                        .setExitRoomInvokeClz("com.tencent.mm.kernel.g")
                        .setExitRoomInvokeFunc("L")
                        .setExitRoomGetInvokeFunc("VH")
                        .setExitRoomRefreshUIEntityClz("com.tencent.mm.chatroom.e.a")
                        .setExitRoomRefreshUIFunc("c")
                        .setExitRoomBootClz("com.tencent.mm.roomsdk.a.b")
                        .setExitRoomBootFunc1("akv")
                        .setExitRoomBootFunc2("jG")
                        .setExitRoomFunc("dhu")
                        .setAtoneEntityClz("com.tencent.mm.modelmulti.h")
                        .setAtoneBootClz("com.tencent.mm.model.av")
                        .setAtoneBootFunc("Pw")
                        .setAtoneSendFunc("a")
                        .create();
                break;
            case WX_VERSION_700:
                configurator = new Builder()
                        .setVersion(700)
                        .setImgDownloadBootClz("com.tencent.mm.model.av")
                        .setImgDownloadBootFunc("LZ")
                        .setLoadClz("com.tencent.mm.as.o")
                        .setLoadFunc("abF")
                        .setDownImgEntityClz("com.tencent.mm.as.k")
                        .setDownImgEntityParamClz("com.tencent.mm.ah.g")
                        .setDownloadFunc("a")
                        .setDbClz("com.tencent.wcdb.database.SQLiteDatabase")
                        .setDbOpenFunc("openDatabase")
                        .setDbCipherClz("com.tencent.wcdb.database.SQLiteCipherSpec")
                        .setDbCursorFactoryClz("com.tencent.wcdb.database.SQLiteDatabase.CursorFactory")
                        .setDbErrorHandlerClz("com.tencent.wcdb.DatabaseErrorHandler")
                        .setDbInsertFunc("insertWithOnConflict")
                        .setDbUpdateFunc("updateWithOnConflict")
                        .setDbDeleteFunc("delete")
                        .setLauncherClz("com.tencent.mm.ui.LauncherUI")
                        .setLauncherFunc("onCreateOptionsMenu")
                        .setVideoDownloadBootClz("com.tencent.mm.modelvideo.u")
                        .setVideoDownloadFunc("pF")
                        .setTextMsgEntityClz("com.tencent.mm.modelmulti.h")
                        .setTextMsgBootClz("com.tencent.mm.model.av")
                        .setTextMsgBootFunc("LZ")
                        .setTextMsgSendFunc("a")
                        .setImgMsgEntityClz("com.tencent.mm.as.l")
                        .setImgMsgEntityParamClz("com.tencent.mm.ah.g")
                        .setImgMsgBootClz("com.tencent.mm.model.av")
                        .setImgMsgBootFunc("LZ")
                        .setImgMsgSendFunc("a")
                        .setVideoMsgEntityClz("com.tencent.mm.pluginsdk.model.j")
                        .setVideoMsgEntityParamClz("com.tencent.mm.pluginsdk.model.j$a")
                        .setVideoMsgBootClz("com.tencent.mm.sdk.g.d")
                        .setVideoMsgBootFunc("post")
                        .setVoiceMsgDBEntityClz("com.tencent.mm.modelvoice.q")
                        .setVoiceMsgDBEntityFunc("qg")
                        .setVoiceMsgPathClz("com.tencent.mm.modelvoice.q")
                        .setVoiceMsgPathFunc("S")
                        .setVoiceMsgNotifyFunc("o")
                        .setVoiceMsgBootClz("com.tencent.mm.model.av")
                        .setVoiceMsgBootFunc("LZ")
                        .setVoiceMsgEntityClz("com.tencent.mm.modelvoice.f")
                        .setVoiceMsgSendFunc("a")
                        .setLinkMsgParam1WrapClz("com.tencent.mm.sdk.platformtools.bo")
                        .setLinkMsgParam1WrapFunc("agN")
                        .setLinkMsgParam1InvokeClz("com.tencent.mm.ae.i$b")
                        .setLinkMsgParam1InvokeFunc("hA")
                        .setLinkMsgParam1ConvertClz("com.tencent.mm.ae.i$b")
                        .setLinkMsgParam1ConvertFunc("a")
                        .setLinkMsgParam2WrapClz("com.tencent.mm.as.o")
                        .setLinkMsgParam2WrapFunc("abE")
                        .setLinkMsgParam2InvokeFunc("G")
                        .setLinkMsgParam2ConvertClz("com.tencent.mm.modelsfs.FileOp")
                        .setLinkMsgParam2ConvertFunc("ou")
                        .setLinkMsgSendClz("com.tencent.mm.pluginsdk.model.app.l")
                        .setLinkMsgSendFunc("a")
                        .setSnsEntityClz("com.tencent.mm.plugin.sns.model.ax")
                        .setSnsEntityDescConfigFunc("Sq")
                        .setSnsEntityVal0ConfigFunc1("Bq")
                        .setSnsEntityVal0ConfigFunc2("Bp")
                        .setSnsEntityVal0ConfigFunc3("Bn")
                        .setSnsEntityVal0ConfigFunc4("Bo")
                        .setSnsEntityCommitFunc("commit")
                        .setSnsEntityCarrierClz("com.tencent.mm.modelsns.b")
                        .setSnsEntityCarryFunc("lb")
                        .setSnsMsgHandleQueueClz("com.tencent.mm.plugin.sns.i.g")
                        .setSnsMsgHandleQueueVar("pVa")
                        .setSnsMsgHandlePutFunc("c")
                        .setSnsToolsOfGetRefreshClz("com.tencent.mm.plugin.sns.model.af")
                        .setSnsToolsOfGetRefreshFunc("cdo")
                        .setSnsRefreshFunc("cce")
                        .setSnsImgInfoClz("com.tencent.mm.plugin.sns.data.h")
                        .setSnsImgInfoVarType("type")
                        .setSnsImgInfoVal0Var1("filterId")
                        .setSnsImgInfoVal0Var2("pHT")
                        .setSnsImgInfoVal0Var3("pHU")
                        .setSnsImgInfoVal0Var4("cxF")
                        .setSnsImgInfoVarDesc("desc")
                        .setSnsImgInfoValFalseVar5("pHY")
                        .setSnsEntityOneOfVar("pPy")
                        .setSnsImgOptListVar("vuH")
                        .setSnsImgOptClz("com.tencent.mm.protocal.protobuf.byx")
                        .setSnsImgOptVal00fVar("bsl")
                        .setSnsImgOptVal0Var("qlI")
                        .setSnsImgOptVal1000fVar1("vOV")
                        .setSnsImgOptVal1000fVar2("vOW")
                        .setSnsImgOptVal1000fVar3("vOX")
                        .setSnsImgOptVal1000fVar4("vOY")
                        .setSnsImgOptVal2Var("vOZ")
                        .setSnsImgOptTimestamp1("vPa")
                        .setSnsImgOptTimestamp2("vPb")
                        .setSnsImgOptAddFunc("add")
                        .setSnsEntityImgConfigFunc("db")
                        .setGetSnsVideoTmpPathClz("com.tencent.mm.plugin.sns.model.af")
                        .setGetSnsVideoTmpPathFunc("getAccSnsTmpPath")
                        .setSnsEntityVideoConfigFunc("SA")
                        .setSnsVideoFileOperationClz("com.tencent.mm.vfs.e")
                        .setSnsVideoCopyFileFunc("x")
                        .setSnsVideoGetOneOfVarFunc("c")
                        .setSnsVideoExtraVar1Param1("Desc")
                        .setSnsVideoEntityOneOfVar1("pPx")
                        .setSnsVideoEntityVarInnerVar1("vTj")
                        .setSnsVideoEntityVar1InnerVar1("uRK")
                        .setSnsVideoExtraVar1AddFunc("add")
                        .setSnsVideoExtraVar2Clz("com.tencent.mm.protocal.protobuf.aws")
                        .setSnsVideoExtraVar1Param2("cxF")
                        .setSnsVideoExtraVar2Param1("vrK")
                        .setSnsVideoEntityOneOfVar2("pPy")
                        .setSnsVideoEntityVar2InnerVar("vuv")
                        .setSnsVideoExtraVar2AddFunc("add")
                        .setSnsTextEntityInstanceParam(2)
                        .setSnsImgEntityInstanceParam(1)
                        .setSnsVideoEntityInstanceParam(15)
                        .setCreateRoomEntityClz("com.tencent.mm.chatroom.c.g")
                        .setCreateRoomEntityParentClz("com.tencent.mm.roomsdk.a.c.a")
                        .setCreateRoomGetParentEntityFunc("nW")
                        .setCreateRoomVarInParent("wiq")
                        .setCreateRoomBootClz("com.tencent.mm.kernel.g")
                        .setCreateRoomBootFunc("MG")
                        .setCreateRoomBootInstance("epW")
                        .setCreateRoomCallbackVar("eZy")
                        .setCreateRoomSendFunc("a")
                        .setCreateRoomRefreshUIClz("com.tencent.mm.model.l")
                        .setCreateRoomRefreshUIFunc("a")
                        .setCreateRoomVarGetTypeFunc("getType")
                        .setAddRoomMemberEntityClz("com.tencent.mm.chatroom.c.e")
                        .setAddRoomMemberBootClz("com.tencent.mm.model.av")
                        .setAddRoomMemberBootFunc("LZ")
                        .setAddRoomMemberSendFunc("a")
                        .setRemoveRoomMemberEntityClz("com.tencent.mm.chatroom.c.h")
                        .setRemoveRoomMemberBootClz("com.tencent.mm.model.av")
                        .setRemoveRoomMemberBootFunc("LZ")
                        .setRemoveRoomMemberSendFunc("a")
                        .setNotifyAllMemberEntityClz("com.tencent.mm.chatroom.c.o")
                        .setNotifyAllRoomMemberBootClz("com.tencent.mm.model.av")
                        .setNotifyAllRoomMemberBootFunc("LZ")
                        .setNotifyAllRoomMemberSendFunc("a")
                        .setCardMsgPackagerClz("com.tencent.mm.ui.contact.z")
                        .setCardMsgPackageFunc("alq")
                        .setCardMsgEntityClz("com.tencent.mm.modelmulti.h")
                        .setCardMsgBootClz("com.tencent.mm.model.av")
                        .setCardMsgBootFunc("LZ")
                        .setCardMsgSendFunc("a")
                        .setAgreeFriendEntityClz("com.tencent.mm.pluginsdk.model.m")
                        .setAgreeFriendBootClz("com.tencent.mm.model.av")
                        .setAgreeFriendBootFunc("LZ")
                        .setAgreeFriendSendFunc("a")
                        .setContextClz("com.tencent.mm.sdk.platformtools.ah")
                        .setContextFunc("getContext")
                        .setGetRoomNameEntityClz("com.tencent.mm.roomsdk.a.b")
                        .setGetRoomNameEntityFunc("afD")
                        .setRoomNameAmendFunc("K")
                        .setRoonNameShowDialogFunc("a")
                        .setRoomNameDialogInstance("tipDialog")
                        .setRoomNameDismissFunc("dismiss")
                        .setSubscriptionBootClz("com.tencent.mm.plugin.messenger.a.g")
                        .setSubscriptionBootFunc("bEq")
                        .setSubscriptionSendFunc("q")
                        .setGetRemarkInfoBootClz("com.tencent.mm.model.c")
                        .setGetRemarkInfoBootFunc("Sd")
                        .setGetRemarkInfoFunc("air")
                        .setAmendRemarkClz("com.tencent.mm.model.s")
                        .setAmendRemarkFunc("b")
                        .setDelContactEntityClz("com.tencent.mm.ay.c")
                        .setDelContactBootClz("com.tencent.mm.model.c")
                        .setDelContactBootFunc("Sc")
                        .setDelContactFunc("c")
                        .setDelContactRefreshBootFunc("Si")
                        .setDelContactRefreshFunc("aiA")
                        .setRemittanceEntityClz("com.tencent.mm.plugin.remittance.model.u")
                        .setRemittanceEntityParams("eoD")
                        .setRemittanceBootClz("com.tencent.mm.kernel.g")
                        .setRemittanceBootFunc("MG")
                        .setRemittanceAcceptInstance("epW")
                        .setRemittanceAcceptFunc("a")
                        .setExitRoomInvokeParamsClz("com.tencent.mm.plugin.messenger.foundation.a.j")
                        .setExitRoomInvokeClz("com.tencent.mm.kernel.g")
                        .setExitRoomInvokeFunc("L")
                        .setExitRoomGetInvokeFunc("Sc")
                        .setExitRoomRefreshUIEntityClz("com.tencent.mm.chatroom.e.a")
                        .setExitRoomRefreshUIFunc("c")
                        .setExitRoomBootClz("com.tencent.mm.roomsdk.a.b")
                        .setExitRoomBootFunc1("afD")
                        .setExitRoomBootFunc2("fE")
                        .setExitRoomFunc("cZV")
                        .setAtoneEntityClz("com.tencent.mm.modelmulti.h")
                        .setAtoneBootClz("com.tencent.mm.model.av")
                        .setAtoneBootFunc("LZ")
                        .setAtoneSendFunc("a")
                        .create();
                break;
            case WX_VERSION_673:
                configurator = new Builder()
                        .setVersion(673)
                        .setImgDownloadBootClz("com.tencent.mm.model.au")
                        .setImgDownloadBootFunc("Dk")
                        .setLoadClz("com.tencent.mm.as.o")
                        .setLoadFunc("OK")
                        .setDownImgEntityClz("com.tencent.mm.as.k")
                        .setDownImgEntityParamClz("com.tencent.mm.ah.g")
                        .setDownloadFunc("a")
                        .setDbClz("com.tencent.wcdb.database.SQLiteDatabase")
                        .setDbOpenFunc("openDatabase")
                        .setDbCipherClz("com.tencent.wcdb.database.SQLiteCipherSpec")
                        .setDbCursorFactoryClz("com.tencent.wcdb.database.SQLiteDatabase.CursorFactory")
                        .setDbErrorHandlerClz("com.tencent.wcdb.DatabaseErrorHandler")
                        .setDbInsertFunc("insertWithOnConflict")
                        .setDbUpdateFunc("updateWithOnConflict")
                        .setDbDeleteFunc("delete")
                        .setLauncherClz("com.tencent.mm.ui.LauncherUI")
                        .setLauncherFunc("onCreateOptionsMenu")
                        .setVideoDownloadBootClz("com.tencent.mm.modelvideo.u")
                        .setVideoDownloadFunc("oa")
                        .setTextMsgEntityClz("com.tencent.mm.modelmulti.h")
                        .setTextMsgBootClz("com.tencent.mm.model.au")
                        .setTextMsgBootFunc("Dk")
                        .setTextMsgSendFunc("a")
                        .setImgMsgEntityClz("com.tencent.mm.as.l")
                        .setImgMsgEntityParamClz("com.tencent.mm.ah.g")
                        .setImgMsgBootClz("com.tencent.mm.model.au")
                        .setImgMsgBootFunc("Dk")
                        .setImgMsgSendFunc("a")
                        .setVideoMsgEntityClz("com.tencent.mm.pluginsdk.model.j")
                        .setVideoMsgEntityParamClz("com.tencent.mm.pluginsdk.model.j$a")
                        .setVideoMsgBootClz("com.tencent.mm.sdk.f.e")
                        .setVideoMsgBootFunc("a")
                        .setVoiceMsgDBEntityClz("com.tencent.mm.modelvoice.q")
                        .setVoiceMsgDBEntityFunc("oz")
                        .setVoiceMsgPathClz("com.tencent.mm.modelvoice.q")
                        .setVoiceMsgPathFunc("R")
                        .setVoiceMsgNotifyFunc("m")
                        .setVoiceMsgBootClz("com.tencent.mm.model.au")
                        .setVoiceMsgBootFunc("Dk")
                        .setVoiceMsgEntityClz("com.tencent.mm.modelvoice.f")
                        .setVoiceMsgSendFunc("a")
                        .setLinkMsgParam1WrapClz("com.tencent.mm.sdk.platformtools.bk")
                        .setLinkMsgParam1WrapFunc("ZQ")
                        .setLinkMsgParam1InvokeClz("com.tencent.mm.ae.g$a")
                        .setLinkMsgParam1InvokeFunc("gp")
                        .setLinkMsgParam1ConvertClz("com.tencent.mm.ae.g$a")
                        .setLinkMsgParam1ConvertFunc("a")
                        .setLinkMsgParam2WrapClz("com.tencent.mm.as.o")
                        .setLinkMsgParam2WrapFunc("OJ")
                        .setLinkMsgParam2InvokeFunc("F")
                        .setLinkMsgParam2ConvertClz("com.tencent.mm.modelsfs.FileOp")
                        .setLinkMsgParam2ConvertFunc("mS")
                        .setLinkMsgSendClz("com.tencent.mm.pluginsdk.model.app.l")
                        .setLinkMsgSendFunc("a")
                        .setSnsEntityClz("com.tencent.mm.plugin.sns.model.ax")
                        .setSnsEntityDescConfigFunc("NR")
                        .setSnsEntityVal0ConfigFunc1("xX")
                        .setSnsEntityVal0ConfigFunc2("xW")
                        .setSnsEntityVal0ConfigFunc3("xU")
                        .setSnsEntityVal0ConfigFunc4("xV")
                        .setSnsEntityCommitFunc("commit")
                        .setSnsEntityCarrierClz("com.tencent.mm.modelsns.b")
                        .setSnsEntityCarryFunc("jf")
                        .setSnsMsgHandleQueueClz("com.tencent.mm.plugin.sns.h.f")
                        .setSnsMsgHandleQueueVar("ozP")
                        .setSnsMsgHandlePutFunc("c")
                        .setSnsToolsOfGetRefreshClz("com.tencent.mm.plugin.sns.model.af")
                        .setSnsToolsOfGetRefreshFunc("bDB")
                        .setSnsRefreshFunc("bCp")
                        .setSnsImgInfoClz("com.tencent.mm.plugin.sns.data.h")
                        .setSnsImgInfoVarType("type")
                        .setSnsImgInfoVal0Var1("filterId")
                        .setSnsImgInfoVal0Var2("ona")
                        .setSnsImgInfoVal0Var3("onb")
                        .setSnsImgInfoVal0Var4("onc")
                        .setSnsImgInfoVarDesc("desc")
                        .setSnsImgInfoValFalseVar5("ong")
                        .setSnsEntityOneOfVar("ouz")
                        .setSnsImgOptListVar("tsz")
                        .setSnsImgOptClz(" com.tencent.mm.protocal.c.bue")
                        .setSnsImgOptVal00fVar("aXH")
                        .setSnsImgOptVal0Var("oQw")
                        .setSnsImgOptVal1000fVar1("tKS")
                        .setSnsImgOptVal1000fVar2("tKT")
                        .setSnsImgOptVal1000fVar3("tKU")
                        .setSnsImgOptVal1000fVar4("tKV")
                        .setSnsImgOptVal2Var("tKW")
                        .setSnsImgOptTimestamp1("tKX")
                        .setSnsImgOptTimestamp2("tKY")
                        .setSnsImgOptAddFunc("add")
                        .setSnsEntityImgConfigFunc("cy")
                        .setGetSnsVideoTmpPathClz("com.tencent.mm.plugin.sns.model.af")
                        .setGetSnsVideoTmpPathFunc("getAccSnsTmpPath")
                        .setSnsEntityVideoConfigFunc("Ob")
                        .setSnsVideoFileOperationClz("com.tencent.mm.vfs.e")
                        .setSnsVideoCopyFileFunc("r")
                        .setSnsVideoGetOneOfVarFunc("c")
                        .setSnsVideoExtraVar1Param1("kRN")
                        .setSnsVideoEntityOneOfVar1("ouy")
                        .setSnsVideoEntityVarInnerVar1("tNr")
                        .setSnsVideoEntityVar1InnerVar1("sPJ")
                        .setSnsVideoExtraVar1AddFunc("add")
                        .setSnsVideoExtraVar2Clz("com.tencent.mm.protocal.c.auf")
                        .setSnsVideoExtraVar1Param2("onc")
                        .setSnsVideoExtraVar2Param1("tpH")
                        .setSnsVideoEntityOneOfVar2("ouz")
                        .setSnsVideoEntityVar2InnerVar("tsn")
                        .setSnsVideoExtraVar2AddFunc("add")
                        .setSnsTextEntityInstanceParam(2)
                        .setSnsImgEntityInstanceParam(1)
                        .setSnsVideoEntityInstanceParam(15)
                        .setCreateRoomEntityClz("com.tencent.mm.chatroom.c.g")
                        .setCreateRoomEntityParentClz("com.tencent.mm.roomsdk.a.c.a")
                        .setCreateRoomGetParentEntityFunc("mm")
                        .setCreateRoomVarInParent("ubv")
                        .setCreateRoomBootClz("com.tencent.mm.kernel.g")
                        .setCreateRoomBootFunc("DO")
                        .setCreateRoomBootInstance("dJT")
                        .setCreateRoomCallbackVar("eeo")
                        .setCreateRoomSendFunc("a")
                        .setCreateRoomRefreshUIClz("com.tencent.mm.model.l")
                        .setCreateRoomRefreshUIFunc("a")
                        .setCreateRoomVarGetTypeFunc("getType")
                        .setAddRoomMemberEntityClz("com.tencent.mm.chatroom.c.e")
                        .setAddRoomMemberBootClz("com.tencent.mm.model.au")
                        .setAddRoomMemberBootFunc("Dk")
                        .setAddRoomMemberSendFunc("a")
                        .setRemoveRoomMemberEntityClz("com.tencent.mm.chatroom.c.h")
                        .setRemoveRoomMemberBootClz("com.tencent.mm.model.au")
                        .setRemoveRoomMemberBootFunc("Dk")
                        .setRemoveRoomMemberSendFunc("a")
                        .setNotifyAllMemberEntityClz("com.tencent.mm.chatroom.c.o")
                        .setNotifyAllRoomMemberBootClz("com.tencent.mm.model.au")
                        .setNotifyAllRoomMemberBootFunc("Dk")
                        .setNotifyAllRoomMemberSendFunc("a")
                        .setCardMsgPackagerClz("com.tencent.mm.ui.contact.z")
                        .setCardMsgPackageFunc("adW")
                        .setCardMsgEntityClz("com.tencent.mm.modelmulti.h")
                        .setCardMsgBootClz("com.tencent.mm.model.au")
                        .setCardMsgBootFunc("Dk")
                        .setCardMsgSendFunc("a")
                        .setAgreeFriendEntityClz("com.tencent.mm.pluginsdk.model.m")
                        .setAgreeFriendBootClz("com.tencent.mm.model.au")
                        .setAgreeFriendBootFunc("Dk")
                        .setAgreeFriendSendFunc("a")
                        .setContextClz("com.tencent.mm.sdk.platformtools.ae")
                        .setContextFunc("getContext")
                        .setGetRoomNameEntityClz("com.tencent.mm.roomsdk.a.b")
                        .setGetRoomNameEntityFunc("YK")
                        .setRoomNameAmendFunc("F")
                        .setRoonNameShowDialogFunc("a")
                        .setRoomNameDialogInstance("tipDialog")
                        .setRoomNameDismissFunc("dismiss")
                        .setSubscriptionBootClz("com.tencent.mm.plugin.messenger.a.g")
                        .setSubscriptionBootFunc("bhI")
                        .setSubscriptionSendFunc("o")
                        .setGetRemarkInfoBootClz("com.tencent.mm.model.c")
                        .setGetRemarkInfoBootFunc("Fw")
                        .setGetRemarkInfoFunc("abl")
                        .setAmendRemarkClz("com.tencent.mm.model.s")
                        .setAmendRemarkFunc("b")
                        .setDelContactEntityClz("com.tencent.mm.ay.b")
                        .setDelContactBootClz("com.tencent.mm.model.c")
                        .setDelContactBootFunc("Fv")
                        .setDelContactFunc("b")
                        .setDelContactRefreshBootFunc("FB")
                        .setDelContactRefreshFunc("abu")
                        .setRemittanceEntityClz("com.tencent.mm.plugin.remittance.model.u")
                        .setRemittanceEntityParams("dIA")
                        .setRemittanceBootClz("com.tencent.mm.kernel.g")
                        .setRemittanceBootFunc("DO")
                        .setRemittanceAcceptInstance("dJT")
                        .setRemittanceAcceptFunc("a")
                        .setExitRoomInvokeParamsClz("com.tencent.mm.plugin.messenger.foundation.a.j")
                        .setExitRoomInvokeClz("com.tencent.mm.kernel.g")
                        .setExitRoomInvokeFunc("r")
                        .setExitRoomGetInvokeFunc("Fv")
                        .setExitRoomRefreshUIEntityClz("com.tencent.mm.chatroom.e.a")
                        .setExitRoomRefreshUIFunc("b")
                        .setExitRoomBootClz("com.tencent.mm.roomsdk.a.b")
                        .setExitRoomBootFunc1("YK")
                        .setExitRoomBootFunc2("eN")
                        .setExitRoomFunc("cpz")
                        .create();
                break;
            case WX_VERSION_672:
                configurator = new Builder()
                        .setVersion(672)
                        .setImgDownloadBootClz("com.tencent.mm.model.av")
                        .setImgDownloadBootFunc("CB")
                        .setLoadClz("com.tencent.mm.ap.o")
                        .setLoadFunc("Ob")
                        .setDownImgEntityClz("com.tencent.mm.ap.k")
                        .setDownImgEntityParamClz("com.tencent.mm.af.g")
                        .setDownloadFunc("a")
                        .setDbClz("com.tencent.wcdb.database.SQLiteDatabase")
                        .setDbOpenFunc("openDatabase")
                        .setDbCipherClz("com.tencent.wcdb.database.SQLiteCipherSpec")
                        .setDbCursorFactoryClz("com.tencent.wcdb.database.SQLiteDatabase.CursorFactory")
                        .setDbErrorHandlerClz("com.tencent.wcdb.DatabaseErrorHandler")
                        .setDbInsertFunc("insertWithOnConflict")
                        .setDbUpdateFunc("updateWithOnConflict")
                        .setDbDeleteFunc("delete")
                        .setLauncherClz("com.tencent.mm.ui.LauncherUI")
                        .setLauncherFunc("onCreateOptionsMenu")
                        .setVideoDownloadBootClz("com.tencent.mm.modelvideo.u")
                        .setVideoDownloadFunc("nR")
                        .setTextMsgEntityClz("com.tencent.mm.modelmulti.h")
                        .setTextMsgBootClz("com.tencent.mm.model.av")
                        .setTextMsgBootFunc("CB")
                        .setTextMsgSendFunc("a")
                        .setImgMsgEntityClz("com.tencent.mm.ap.l")
                        .setImgMsgEntityParamClz("com.tencent.mm.af.g")
                        .setImgMsgBootClz("com.tencent.mm.model.av")
                        .setImgMsgBootFunc("CB")
                        .setImgMsgSendFunc("a")
                        .setVideoMsgEntityClz("com.tencent.mm.pluginsdk.model.j")
                        .setVideoMsgEntityParamClz("com.tencent.mm.pluginsdk.model.j$a")
                        .setVideoMsgBootClz("com.tencent.mm.sdk.f.e")
                        .setVideoMsgBootFunc("a")
                        .setVoiceMsgDBEntityClz("com.tencent.mm.modelvoice.q")
                        .setVoiceMsgDBEntityFunc("oq")
                        .setVoiceMsgPathClz("com.tencent.mm.modelvoice.q")
                        .setVoiceMsgPathFunc("P")
                        .setVoiceMsgNotifyFunc("l")
                        .setVoiceMsgBootClz("com.tencent.mm.model.av")
                        .setVoiceMsgBootFunc("CB")
                        .setVoiceMsgEntityClz("com.tencent.mm.modelvoice.f")
                        .setVoiceMsgSendFunc("a")
                        .setLinkMsgParam1WrapClz("com.tencent.mm.sdk.platformtools.bj")
                        .setLinkMsgParam1WrapFunc("Yw")
                        .setLinkMsgParam1InvokeClz("com.tencent.mm.ac.g$a")
                        .setLinkMsgParam1InvokeFunc("gk")
                        .setLinkMsgParam1ConvertClz("com.tencent.mm.ac.g$a")
                        .setLinkMsgParam1ConvertFunc("a")
                        .setLinkMsgParam2WrapClz("com.tencent.mm.ap.o")
                        .setLinkMsgParam2WrapFunc("Oa")
                        .setLinkMsgParam2InvokeFunc("D")
                        .setLinkMsgParam2ConvertClz("com.tencent.mm.modelsfs.FileOp")
                        .setLinkMsgParam2ConvertFunc("mH")
                        .setLinkMsgSendClz("com.tencent.mm.pluginsdk.model.app.l")
                        .setLinkMsgSendFunc("a")
                        .setSnsEntityClz("com.tencent.mm.plugin.sns.model.ax")
                        .setSnsEntityDescConfigFunc("MI")
                        .setSnsEntityVal0ConfigFunc1("xk")
                        .setSnsEntityVal0ConfigFunc2("xj")
                        .setSnsEntityVal0ConfigFunc3("xh")
                        .setSnsEntityVal0ConfigFunc4("xi")
                        .setSnsEntityCommitFunc("commit")
                        .setSnsEntityCarrierClz("com.tencent.mm.modelsns.b")
                        .setSnsEntityCarryFunc("iO")
                        .setSnsMsgHandleQueueClz("com.tencent.mm.plugin.sns.h.e")
                        .setSnsMsgHandleQueueVar("nUd")
                        .setSnsMsgHandlePutFunc("c")
                        .setSnsToolsOfGetRefreshClz("com.tencent.mm.plugin.sns.model.af")
                        .setSnsToolsOfGetRefreshFunc("bzz")
                        .setSnsRefreshFunc("byo")
                        .setSnsImgInfoClz("com.tencent.mm.plugin.sns.data.h")
                        .setSnsImgInfoVarType("type")
                        .setSnsImgInfoVal0Var1("nHl")
                        .setSnsImgInfoVal0Var2("nHm")
                        .setSnsImgInfoVal0Var3("nHn")
                        .setSnsImgInfoVal0Var4("nHo")
                        .setSnsImgInfoVarDesc("desc")
                        .setSnsImgInfoValFalseVar5("nHs")
                        .setSnsEntityOneOfVar("nOO")
                        .setSnsImgOptListVar("sIi")
                        .setSnsImgOptClz("com.tencent.mm.protocal.c.bsl")
                        .setSnsImgOptVal00fVar("aWM")
                        .setSnsImgOptVal0Var("okN")
                        .setSnsImgOptVal1000fVar1("tac")
                        .setSnsImgOptVal1000fVar2("tad")
                        .setSnsImgOptVal1000fVar3("tae")
                        .setSnsImgOptVal1000fVar4("taf")
                        .setSnsImgOptVal2Var("tah")
                        .setSnsImgOptTimestamp1("tai")
                        .setSnsImgOptTimestamp2("taj")
                        .setSnsImgOptAddFunc("add")
                        .setSnsEntityImgConfigFunc("cu")
                        .setGetSnsVideoTmpPathClz("com.tencent.mm.plugin.sns.model.af")
                        .setGetSnsVideoTmpPathFunc("getAccSnsTmpPath")
                        .setSnsEntityVideoConfigFunc("MS")
                        .setSnsVideoFileOperationClz("com.tencent.mm.vfs.d")
                        .setSnsVideoCopyFileFunc("q")
                        .setSnsVideoGetOneOfVarFunc("c")
                        .setSnsVideoExtraVar1Param1("kmm")
                        .setSnsVideoEntityOneOfVar1("nON")
                        .setSnsVideoEntityVarInnerVar1("tcE")
                        .setSnsVideoEntityVar1InnerVar1("sfN")
                        .setSnsVideoExtraVar1AddFunc("add")
                        .setSnsVideoExtraVar2Clz("com.tencent.mm.protocal.c.atc")
                        .setSnsVideoExtraVar1Param2("nHo")
                        .setSnsVideoExtraVar2Param1("sFy")
                        .setSnsVideoEntityOneOfVar2("nOO")
                        .setSnsVideoEntityVar2InnerVar("sHW")
                        .setSnsVideoExtraVar2AddFunc("add")
                        .setSnsTextEntityInstanceParam(2)
                        .setSnsImgEntityInstanceParam(1)
                        .setSnsVideoEntityInstanceParam(15)
                        .setCreateRoomEntityClz("com.tencent.mm.chatroom.c.g")
                        .setCreateRoomEntityParentClz("com.tencent.mm.roomsdk.a.c.a")
                        .setCreateRoomGetParentEntityFunc("lJ")
                        .setCreateRoomVarInParent("tqa")
                        .setCreateRoomBootClz("com.tencent.mm.kernel.g")
                        .setCreateRoomBootFunc("Df")
                        .setCreateRoomBootInstance("dAN")
                        .setCreateRoomCallbackVar("dVK")
                        .setCreateRoomSendFunc("a")
                        .setCreateRoomRefreshUIClz("com.tencent.mm.model.l")
                        .setCreateRoomRefreshUIFunc("a")
                        .setCreateRoomVarGetTypeFunc("getType")
                        .setAddRoomMemberEntityClz("com.tencent.mm.chatroom.c.e")
                        .setAddRoomMemberBootClz("com.tencent.mm.model.av")
                        .setAddRoomMemberBootFunc("CB")
                        .setAddRoomMemberSendFunc("a")
                        .setRemoveRoomMemberEntityClz("com.tencent.mm.chatroom.c.h")
                        .setRemoveRoomMemberBootClz("com.tencent.mm.model.av")
                        .setRemoveRoomMemberBootFunc("CB")
                        .setRemoveRoomMemberSendFunc("a")
                        .setNotifyAllMemberEntityClz("com.tencent.mm.chatroom.c.o")
                        .setNotifyAllRoomMemberBootClz("com.tencent.mm.model.av")
                        .setNotifyAllRoomMemberBootFunc("CB")
                        .setNotifyAllRoomMemberSendFunc("a")
                        .setCardMsgPackagerClz("com.tencent.mm.ui.contact.z")
                        .setCardMsgPackageFunc("acD")
                        .setCardMsgEntityClz("com.tencent.mm.modelmulti.h")
                        .setCardMsgBootClz("com.tencent.mm.model.av")
                        .setCardMsgBootFunc("CB")
                        .setCardMsgSendFunc("a")
                        .setAgreeFriendEntityClz("com.tencent.mm.pluginsdk.model.m")
                        .setAgreeFriendBootClz("com.tencent.mm.model.av")
                        .setAgreeFriendBootFunc("CB")
                        .setAgreeFriendSendFunc("a")
                        .setContextClz("com.tencent.mm.sdk.platformtools.ae")
                        .setContextFunc("getContext")
                        .setGetRoomNameEntityClz("com.tencent.mm.roomsdk.a.c.a")
                        .setGetRoomNameEntityFunc("Xr")
                        .setRoomNameAmendFunc("C")
                        .setRoonNameShowDialogFunc("a")
                        .setRoomNameDialogInstance("tipDialog")
                        .setRoomNameDismissFunc("dismiss")
                        .setSubscriptionBootClz("com.tencent.mm.plugin.messenger.a.g")
                        .setSubscriptionBootFunc("bdH")
                        .setSubscriptionSendFunc("o")
                        .setGetRemarkInfoBootClz("com.tencent.mm.model.c")
                        .setGetRemarkInfoBootFunc("EO")
                        .setGetRemarkInfoFunc("ZQ")
                        .setAmendRemarkClz("com.tencent.mm.model.s")
                        .setAmendRemarkFunc("b")
                        .setDelContactEntityClz("com.tencent.mm.av.b")
                        .setDelContactBootClz("com.tencent.mm.model.c")
                        .setDelContactBootFunc("EN")
                        .setDelContactFunc("b")
                        .setDelContactRefreshBootFunc("ET")
                        .setDelContactRefreshFunc("ZZ")
                        .setRemittanceEntityClz("com.tencent.mm.plugin.remittance.model.u")
                        .setRemittanceEntityParams("dzu")
                        .setRemittanceBootClz("com.tencent.mm.kernel.g")
                        .setRemittanceBootFunc("Df")
                        .setRemittanceAcceptInstance("dAN")
                        .setRemittanceAcceptFunc("a")
                        .setExitRoomInvokeParamsClz("com.tencent.mm.plugin.messenger.foundation.a.j")
                        .setExitRoomInvokeClz("com.tencent.mm.kernel.g")
                        .setExitRoomInvokeFunc("q")
                        .setExitRoomGetInvokeFunc("EN")
                        .setExitRoomRefreshUIEntityClz("com.tencent.mm.chatroom.e.a")
                        .setExitRoomRefreshUIFunc("b")
                        .setExitRoomBootClz("com.tencent.mm.roomsdk.a.b")
                        .setExitRoomBootFunc1("Xr")
                        .setExitRoomBootFunc2("eK")
                        .setExitRoomFunc("cjP")
                        .create();
                break;
            case WX_VERSION_667:
                configurator = new Builder()
                        .setVersion(667)
                        .setImgDownloadBootClz("com.tencent.mm.model.au")
                        .setImgDownloadBootFunc("DF")
                        .setLoadClz("com.tencent.mm.ak.o")
                        .setLoadFunc("Pg")
                        .setDownImgEntityClz("com.tencent.mm.ak.k")
                        .setDownImgEntityParamClz("com.tencent.mm.ab.f")
                        .setDownloadFunc("a")
                        .setDbClz("com.tencent.wcdb.database.SQLiteDatabase")
                        .setDbOpenFunc("openDatabase")
                        .setDbCipherClz("com.tencent.wcdb.database.SQLiteCipherSpec")
                        .setDbCursorFactoryClz("com.tencent.wcdb.database.SQLiteDatabase.CursorFactory")
                        .setDbErrorHandlerClz("com.tencent.wcdb.DatabaseErrorHandler")
                        .setDbInsertFunc("insertWithOnConflict")
                        .setDbUpdateFunc("updateWithOnConflict")
                        .setDbDeleteFunc("delete")
                        .setLauncherClz("com.tencent.mm.ui.LauncherUI")
                        .setLauncherFunc("onCreateOptionsMenu")
                        .setVideoDownloadBootClz("com.tencent.mm.modelvideo.t")
                        .setVideoDownloadFunc("nS")
                        .setTextMsgEntityClz("com.tencent.mm.modelmulti.i")
                        .setTextMsgBootClz("com.tencent.mm.model.au")
                        .setTextMsgBootFunc("DF")
                        .setTextMsgSendFunc("a")
                        .setImgMsgEntityClz("com.tencent.mm.ak.l")
                        .setImgMsgEntityParamClz("com.tencent.mm.ab.f")
                        .setImgMsgBootClz("com.tencent.mm.model.au")
                        .setImgMsgBootFunc("DF")
                        .setImgMsgSendFunc("a")
                        .setVideoMsgEntityClz("com.tencent.mm.pluginsdk.model.j")
                        .setVideoMsgEntityParamClz("com.tencent.mm.pluginsdk.model.j$a")
                        .setVideoMsgBootClz("com.tencent.mm.sdk.f.e")
                        .setVideoMsgBootFunc("a")
                        .setVoiceMsgDBEntityClz("com.tencent.mm.modelvoice.q")
                        .setVoiceMsgDBEntityFunc("om")
                        .setVoiceMsgPathClz("com.tencent.mm.modelvoice.q")
                        .setVoiceMsgPathFunc("O")
                        .setVoiceMsgNotifyFunc("m")
                        .setVoiceMsgBootClz("com.tencent.mm.model.au")
                        .setVoiceMsgBootFunc("DF")
                        .setVoiceMsgEntityClz("com.tencent.mm.modelvoice.f")
                        .setVoiceMsgSendFunc("a")
                        .setLinkMsgParam1WrapClz("com.tencent.mm.sdk.platformtools.bi")
                        .setLinkMsgParam1WrapFunc("WT")
                        .setLinkMsgParam1InvokeClz("com.tencent.mm.y.g$a")
                        .setLinkMsgParam1InvokeFunc("gp")
                        .setLinkMsgParam1ConvertClz("com.tencent.mm.y.g$a")
                        .setLinkMsgParam1ConvertFunc("a")
                        .setLinkMsgParam2WrapClz("com.tencent.mm.ak.o")
                        .setLinkMsgParam2WrapFunc("Pf")
                        .setLinkMsgParam2InvokeFunc("E")
                        .setLinkMsgParam2ConvertClz("com.tencent.mm.modelsfs.FileOp")
                        .setLinkMsgParam2ConvertFunc("e")
                        .setLinkMsgSendClz("com.tencent.mm.pluginsdk.model.app.l")
                        .setLinkMsgSendFunc("a")
                        .setSnsEntityClz("com.tencent.mm.plugin.sns.model.ax")
                        .setSnsEntityDescConfigFunc("My")
                        .setSnsEntityVal0ConfigFunc1("wH")
                        .setSnsEntityVal0ConfigFunc2("wG")
                        .setSnsEntityVal0ConfigFunc3("wE")
                        .setSnsEntityVal0ConfigFunc4("wF")
                        .setSnsEntityCommitFunc("commit")
                        .setSnsEntityCarrierClz("com.tencent.mm.modelsns.b")
                        .setSnsEntityCarryFunc("iq")
                        .setSnsMsgHandleQueueClz("com.tencent.mm.plugin.sns.h.e")
                        .setSnsMsgHandleQueueVar("nxO")
                        .setSnsMsgHandlePutFunc("c")
                        .setSnsToolsOfGetRefreshClz("com.tencent.mm.plugin.sns.model.af")
                        .setSnsToolsOfGetRefreshFunc("byk")
                        .setSnsRefreshFunc("bwX")
                        .setSnsImgInfoClz("com.tencent.mm.plugin.sns.data.h")
                        .setSnsImgInfoVarType("type")
                        .setSnsImgInfoVal0Var1("nkW")
                        .setSnsImgInfoVal0Var2("nkX")
                        .setSnsImgInfoVal0Var3("nkY")
                        .setSnsImgInfoVal0Var4("nkZ")
                        .setSnsImgInfoVarDesc("desc")
                        .setSnsImgInfoValFalseVar5("nld")
                        .setSnsEntityOneOfVar("nsy")
                        .setSnsImgOptListVar("rWo")
                        .setSnsImgOptClz("com.tencent.mm.protocal.c.bpo")
                        .setSnsImgOptVal00fVar("biF")
                        .setSnsImgOptVal0Var("nOD")
                        .setSnsImgOptVal1000fVar1("snF")
                        .setSnsImgOptVal1000fVar2("snG")
                        .setSnsImgOptVal1000fVar3("snH")
                        .setSnsImgOptVal1000fVar4("snI")
                        .setSnsImgOptVal2Var("snJ")
                        .setSnsImgOptTimestamp1("snK")
                        .setSnsImgOptTimestamp2("snL")
                        .setSnsImgOptAddFunc("add")
                        .setSnsEntityImgConfigFunc("cj")
                        .setGetSnsVideoTmpPathClz("com.tencent.mm.plugin.sns.model.af")
                        .setGetSnsVideoTmpPathFunc("getAccSnsTmpPath")
                        .setSnsEntityVideoConfigFunc("MI")
                        .setSnsVideoFileOperationClz("com.tencent.mm.modelsfs.FileOp")
                        .setSnsVideoCopyFileFunc("y")
                        .setSnsVideoGetOneOfVarFunc("c")
                        .setSnsVideoExtraVar1Param1("jOS")
                        .setSnsVideoEntityOneOfVar1("nsx")
                        .setSnsVideoEntityVarInnerVar1("sqc")
                        .setSnsVideoEntityVar1InnerVar1("ruA")
                        .setSnsVideoExtraVar1AddFunc("add")
                        .setSnsVideoExtraVar2Clz("com.tencent.mm.protocal.c.ari")
                        .setSnsVideoExtraVar1Param2("nkZ")
                        .setSnsVideoExtraVar2Param1("rTF")
                        .setSnsVideoEntityOneOfVar2("nsy")
                        .setSnsVideoEntityVar2InnerVar("rWc")
                        .setSnsVideoExtraVar2AddFunc("add")
                        .setSnsTextEntityInstanceParam(2)
                        .setSnsImgEntityInstanceParam(1)
                        .setSnsVideoEntityInstanceParam(15)
                        .setRoomEntityClz("com.tencent.mm.g.a.jw")
                        .setRoomEntityVar("bTO")
                        .setRoomEntityStrParam("bTQ")
                        .setRoomEntityListParam("bTR")
                        .setRoomEntitySubmitClz("com.tencent.mm.sdk.b.a")
                        .setRoomEntitySubmitInstance("sFg")
                        .setRoomEntitySubmitFunc("m")
                        .setAddRoomMemberEntityClz("com.tencent.mm.plugin.chatroom.d.d")
                        .setAddRoomMemberBootClz("com.tencent.mm.model.au")
                        .setAddRoomMemberBootFunc("DF")
                        .setAddRoomMemberSendFunc("a")
                        .setRemoveRoomMemberEntityClz("com.tencent.mm.plugin.chatroom.d.g")
                        .setRemoveRoomMemberBootClz("com.tencent.mm.model.au")
                        .setRemoveRoomMemberBootFunc("DF")
                        .setRemoveRoomMemberSendFunc("a")
                        .setNotifyAllMemberEntityClz("com.tencent.mm.plugin.chatroom.d.m")
                        .setNotifyAllRoomMemberBootClz("com.tencent.mm.model.au")
                        .setNotifyAllRoomMemberBootFunc("DF")
                        .setNotifyAllRoomMemberSendFunc("a")
                        .setCardMsgPackagerClz("com.tencent.mm.ui.contact.y")
                        .setCardMsgPackageFunc("aaP")
                        .setCardMsgEntityClz("com.tencent.mm.modelmulti.i")
                        .setCardMsgBootClz("com.tencent.mm.model.au")
                        .setCardMsgBootFunc("DF")
                        .setCardMsgSendFunc("a")
                        .setAgreeFriendEntityClz("com.tencent.mm.pluginsdk.model.m")
                        .setAgreeFriendBootClz("com.tencent.mm.model.au")
                        .setAgreeFriendBootFunc("DF")
                        .setAgreeFriendSendFunc("a")
                        .setContextClz("com.tencent.mm.sdk.platformtools.ad")
                        .setContextFunc("getContext")
                        .create();
                break;
            case WX_VERSION_666:
                configurator = new Builder()
                        .setVersion(666)
                        .setImgDownloadBootClz("com.tencent.mm.z.au")
                        .setImgDownloadBootFunc("Dv")
                        .setLoadClz("com.tencent.mm.am.o")
                        .setLoadFunc("Pa")
                        .setDownImgEntityClz("com.tencent.mm.am.k")
                        .setDownImgEntityParamClz("com.tencent.mm.ac.f")
                        .setDownloadFunc("a")
                        .setDbClz("com.tencent.wcdb.database.SQLiteDatabase")
                        .setDbOpenFunc("openDatabase")
                        .setDbCipherClz("com.tencent.wcdb.database.SQLiteCipherSpec")
                        .setDbCursorFactoryClz("com.tencent.wcdb.database.SQLiteDatabase.CursorFactory")
                        .setDbErrorHandlerClz("com.tencent.wcdb.DatabaseErrorHandler")
                        .setDbInsertFunc("insertWithOnConflict")
                        .setDbUpdateFunc("updateWithOnConflict")
                        .setDbDeleteFunc("delete")
                        .setLauncherClz("com.tencent.mm.ui.LauncherUI")
                        .setLauncherFunc("onCreateOptionsMenu")
                        .setVideoDownloadBootClz("com.tencent.mm.modelvideo.t")
                        .setVideoDownloadFunc("nx")
                        .setTextMsgEntityClz("com.tencent.mm.modelmulti.i")
                        .setTextMsgBootClz("com.tencent.mm.z.au")
                        .setTextMsgBootFunc("Dv")
                        .setTextMsgSendFunc("a")
                        .setImgMsgEntityClz("com.tencent.mm.am.l")
                        .setImgMsgEntityParamClz("com.tencent.mm.ac.f")
                        .setImgMsgBootClz("com.tencent.mm.z.au")
                        .setImgMsgBootFunc("Dv")
                        .setImgMsgSendFunc("a")
                        .setVideoMsgEntityClz("com.tencent.mm.pluginsdk.model.j")
                        .setVideoMsgEntityParamClz("com.tencent.mm.pluginsdk.model.j$a")
                        .setVideoMsgBootClz("com.tencent.mm.sdk.f.e")
                        .setVideoMsgBootFunc("a")
                        .setVoiceMsgDBEntityClz("com.tencent.mm.modelvoice.q")
                        .setVoiceMsgDBEntityFunc("nR")
                        .setVoiceMsgPathClz("com.tencent.mm.modelvoice.q")
                        .setVoiceMsgPathFunc("O")
                        .setVoiceMsgNotifyFunc("m")
                        .setVoiceMsgBootClz("com.tencent.mm.z.au")
                        .setVoiceMsgBootFunc("Dv")
                        .setVoiceMsgEntityClz("com.tencent.mm.modelvoice.f")
                        .setVoiceMsgSendFunc("a")
                        .setLinkMsgParam1WrapClz("com.tencent.mm.sdk.platformtools.bh")
                        .setLinkMsgParam1WrapFunc("WP")
                        .setLinkMsgParam1InvokeClz("com.tencent.mm.y.g$a")
                        .setLinkMsgParam1InvokeFunc("gf")
                        .setLinkMsgParam1ConvertClz("com.tencent.mm.y.g$a")
                        .setLinkMsgParam1ConvertFunc("a")
                        .setLinkMsgParam2WrapClz("com.tencent.mm.am.o")
                        .setLinkMsgParam2WrapFunc("OZ")
                        .setLinkMsgParam2InvokeFunc("E")
                        .setLinkMsgParam2ConvertClz("com.tencent.mm.modelsfs.FileOp")
                        .setLinkMsgParam2ConvertFunc("e")
                        .setLinkMsgSendClz("com.tencent.mm.pluginsdk.model.app.l")
                        .setLinkMsgSendFunc("a")
                        .setSnsEntityClz("com.tencent.mm.plugin.sns.model.aw")
                        .setSnsEntityDescConfigFunc("Mn")
                        .setSnsEntityVal0ConfigFunc1("xm")
                        .setSnsEntityVal0ConfigFunc2("xl")
                        .setSnsEntityVal0ConfigFunc3("xj")
                        .setSnsEntityVal0ConfigFunc4("xk")
                        .setSnsEntityCommitFunc("commit")
                        .setSnsEntityCarrierClz("com.tencent.mm.modelsns.b")
                        .setSnsEntityCarryFunc("ir")
                        .setSnsMsgHandleQueueClz("com.tencent.mm.plugin.sns.h.e")
                        .setSnsMsgHandleQueueVar("rGv")
                        .setSnsMsgHandlePutFunc("c")
                        .setSnsToolsOfGetRefreshClz("com.tencent.mm.plugin.sns.model.ae")
                        .setSnsToolsOfGetRefreshFunc("byJ")
                        .setSnsRefreshFunc("bxy")
                        .setSnsImgInfoClz("com.tencent.mm.plugin.sns.data.h")
                        .setSnsImgInfoVarType("type")
                        .setSnsImgInfoVal0Var1("rtD")
                        .setSnsImgInfoVal0Var2("rtE")
                        .setSnsImgInfoVal0Var3("rtF")
                        .setSnsImgInfoVal0Var4("rtG")
                        .setSnsImgInfoVarDesc("desc")
                        .setSnsImgInfoValFalseVar5("rtK")
                        .setSnsEntityOneOfVar("rBg")
                        .setSnsImgOptListVar("xbL")
                        .setSnsImgOptClz("com.tencent.mm.protocal.c.bmo")
                        .setSnsImgOptVal00fVar("biR")
                        .setSnsImgOptVal0Var("rXl")
                        .setSnsImgOptVal1000fVar1("xsz")
                        .setSnsImgOptVal1000fVar2("xsA")
                        .setSnsImgOptVal1000fVar3("xsB")
                        .setSnsImgOptVal1000fVar4("xsC")
                        .setSnsImgOptVal2Var("xsD")
                        .setSnsImgOptTimestamp1("xsE")
                        .setSnsImgOptTimestamp2("xsF")
                        .setSnsImgOptAddFunc("add")
                        .setSnsEntityImgConfigFunc("bU")
                        .setGetSnsVideoTmpPathClz("com.tencent.mm.plugin.sns.model.ae")
                        .setGetSnsVideoTmpPathFunc("getAccSnsTmpPath")
                        .setSnsEntityVideoConfigFunc("Mx")
                        .setSnsVideoFileOperationClz("com.tencent.mm.modelsfs.FileOp")
                        .setSnsVideoCopyFileFunc("y")
                        .setSnsVideoGetOneOfVarFunc("a")
                        .setSnsVideoExtraVar1Param1("nyz")
                        .setSnsVideoEntityOneOfVar1("rBf")
                        .setSnsVideoEntityVarInnerVar1("xuX")
                        .setSnsVideoEntityVar1InnerVar1("wBf")
                        .setSnsVideoExtraVar1AddFunc("add")
                        .setSnsVideoExtraVar2Clz("com.tencent.mm.protocal.c.aps")
                        .setSnsVideoExtraVar1Param2("rtG")
                        .setSnsVideoExtraVar2Param1("wZc")
                        .setSnsVideoEntityOneOfVar2("rBg")
                        .setSnsVideoEntityVar2InnerVar("xbz")
                        .setSnsVideoExtraVar2AddFunc("add")
                        .setSnsTextEntityInstanceParam(2)
                        .setSnsImgEntityInstanceParam(1)
                        .setSnsVideoEntityInstanceParam(15)
                        .setRoomEntityClz("com.tencent.mm.g.a.js")
                        .setRoomEntityVar("eCD")
                        .setRoomEntityStrParam("eCF")
                        .setRoomEntityListParam("eCG")
                        .setRoomEntitySubmitClz("com.tencent.mm.sdk.b.a")
                        .setRoomEntitySubmitInstance("xJM")
                        .setRoomEntitySubmitFunc("m")
                        .setAddRoomMemberEntityClz("com.tencent.mm.plugin.chatroom.d.d")
                        .setAddRoomMemberBootClz("com.tencent.mm.z.au")
                        .setAddRoomMemberBootFunc("Dv")
                        .setAddRoomMemberSendFunc("a")
                        .setRemoveRoomMemberEntityClz("com.tencent.mm.plugin.chatroom.d.g")
                        .setRemoveRoomMemberBootClz("com.tencent.mm.z.au")
                        .setRemoveRoomMemberBootFunc("Dv")
                        .setRemoveRoomMemberSendFunc("a")
                        .setNotifyAllMemberEntityClz("com.tencent.mm.plugin.chatroom.d.m")
                        .setNotifyAllRoomMemberBootClz("com.tencent.mm.z.au")
                        .setNotifyAllRoomMemberBootFunc("Dv")
                        .setNotifyAllRoomMemberSendFunc("a")
                        .setCardMsgPackagerClz("com.tencent.mm.ui.contact.y")
                        .setCardMsgPackageFunc("aaU")
                        .setCardMsgEntityClz("com.tencent.mm.modelmulti.i")
                        .setCardMsgBootClz("com.tencent.mm.z.au")
                        .setCardMsgBootFunc("Dv")
                        .setCardMsgSendFunc("a")
                        .setAgreeFriendEntityClz("com.tencent.mm.pluginsdk.model.m")
                        .setAgreeFriendBootClz("com.tencent.mm.z.au")
                        .setAgreeFriendBootFunc("Dv")
                        .setAgreeFriendSendFunc("a")
                        .setContextClz("com.tencent.mm.sdk.platformtools.ac")
                        .setContextFunc("getContext")
                        .create();
                break;
            case WX_VERSION_665:
                configurator = new Builder()
                        .setVersion(665)
                        .setImgDownloadBootClz("com.tencent.mm.y.as")
                        .setImgDownloadBootFunc("CN")
                        .setLoadClz("com.tencent.mm.ap.o")
                        .setLoadFunc("PD")
                        .setDownImgEntityClz("com.tencent.mm.ap.k")
                        .setDownImgEntityParamClz("com.tencent.mm.ad.f")
                        .setDownloadFunc("a")
                        .setDbClz("com.tencent.wcdb.database.SQLiteDatabase")
                        .setDbOpenFunc("openDatabase")
                        .setDbCipherClz("com.tencent.wcdb.database.SQLiteCipherSpec")
                        .setDbCursorFactoryClz("com.tencent.wcdb.database.SQLiteDatabase.CursorFactory")
                        .setDbErrorHandlerClz("com.tencent.wcdb.DatabaseErrorHandler")
                        .setDbInsertFunc("insertWithOnConflict")
                        .setDbUpdateFunc("updateWithOnConflict")
                        .setDbDeleteFunc("delete")
                        .setLauncherClz("com.tencent.mm.ui.LauncherUI")
                        .setLauncherFunc("onCreateOptionsMenu")
                        .setVideoDownloadBootClz("com.tencent.mm.modelvideo.t")
                        .setVideoDownloadFunc("nF")
                        .setTextMsgEntityClz("com.tencent.mm.modelmulti.j")
                        .setTextMsgBootClz("com.tencent.mm.y.as")
                        .setTextMsgBootFunc("CN")
                        .setTextMsgSendFunc("a")
                        .setImgMsgEntityClz("com.tencent.mm.ap.l")
                        .setImgMsgEntityParamClz("com.tencent.mm.ad.f")
                        .setImgMsgBootClz("com.tencent.mm.y.as")
                        .setImgMsgBootFunc("CN")
                        .setImgMsgSendFunc("a")
                        .setVideoMsgEntityClz("com.tencent.mm.pluginsdk.model.k")
                        .setVideoMsgEntityParamClz("com.tencent.mm.pluginsdk.model.k$a")
                        .setVideoMsgBootClz("com.tencent.mm.sdk.f.e")
                        .setVideoMsgBootFunc("a")
                        .setVoiceMsgDBEntityClz("com.tencent.mm.modelvoice.q")
                        .setVoiceMsgDBEntityFunc("nZ")
                        .setVoiceMsgPathClz("com.tencent.mm.modelvoice.q")
                        .setVoiceMsgPathFunc("M")
                        .setVoiceMsgNotifyFunc("k")
                        .setVoiceMsgBootClz("com.tencent.mm.y.as")
                        .setVoiceMsgBootFunc("CN")
                        .setVoiceMsgEntityClz("com.tencent.mm.modelvoice.f")
                        .setVoiceMsgSendFunc("a")
                        .setLinkMsgParam1WrapClz("com.tencent.mm.sdk.platformtools.bi")
                        .setLinkMsgParam1WrapFunc("Wn")
                        .setLinkMsgParam1InvokeClz("com.tencent.mm.x.g$a")
                        .setLinkMsgParam1InvokeFunc("fV")
                        .setLinkMsgParam1ConvertClz("com.tencent.mm.x.g$a")
                        .setLinkMsgParam1ConvertFunc("a")
                        .setLinkMsgParam2WrapClz("com.tencent.mm.ap.o")
                        .setLinkMsgParam2WrapFunc("PC")
                        .setLinkMsgParam2InvokeFunc("B")
                        .setLinkMsgParam2ConvertClz("com.tencent.mm.modelsfs.FileOp")
                        .setLinkMsgParam2ConvertFunc("d")
                        .setLinkMsgSendClz("com.tencent.mm.pluginsdk.model.app.l")
                        .setLinkMsgSendFunc("a")
                        .setSnsEntityClz("com.tencent.mm.plugin.sns.model.aw")
                        .setSnsEntityDescConfigFunc("Le")
                        .setSnsEntityVal0ConfigFunc1("xj")
                        .setSnsEntityVal0ConfigFunc2("xi")
                        .setSnsEntityVal0ConfigFunc3("xg")
                        .setSnsEntityVal0ConfigFunc4("xh")
                        .setSnsEntityCommitFunc("commit")
                        .setSnsEntityCarrierClz("com.tencent.mm.modelsns.b")
                        .setSnsEntityCarryFunc("iz")
                        .setSnsMsgHandleQueueClz("com.tencent.mm.plugin.sns.h.e")
                        .setSnsMsgHandleQueueVar("rjJ")
                        .setSnsMsgHandlePutFunc("c")
                        .setSnsToolsOfGetRefreshClz("com.tencent.mm.plugin.sns.model.ae")
                        .setSnsToolsOfGetRefreshFunc("bwb")
                        .setSnsRefreshFunc("buT")
                        .setSnsImgInfoClz("com.tencent.mm.plugin.sns.data.h")
                        .setSnsImgInfoVarType("type")
                        .setSnsImgInfoVal0Var1("qWY")
                        .setSnsImgInfoVal0Var2("qWZ")
                        .setSnsImgInfoVal0Var3("qXa")
                        .setSnsImgInfoVal0Var4("qXb")
                        .setSnsImgInfoVarDesc("desc")
                        .setSnsImgInfoValFalseVar5("qXf")
                        .setSnsEntityOneOfVar("rev")
                        .setSnsImgOptListVar("wFz")
                        .setSnsImgOptClz("com.tencent.mm.protocal.c.blv")
                        .setSnsImgOptVal00fVar("biF")
                        .setSnsImgOptVal0Var("rAl")
                        .setSnsImgOptVal1000fVar1("wVL")
                        .setSnsImgOptVal1000fVar2("wVM")
                        .setSnsImgOptVal1000fVar3("wVN")
                        .setSnsImgOptVal1000fVar4("wVO")
                        .setSnsImgOptVal2Var("wVP")
                        .setSnsImgOptTimestamp1("wVQ")
                        .setSnsImgOptTimestamp2("wVR")
                        .setSnsImgOptAddFunc("add")
                        .setSnsEntityImgConfigFunc("bP")
                        .setGetSnsVideoTmpPathClz("com.tencent.mm.plugin.sns.model.ae")
                        .setGetSnsVideoTmpPathFunc("getAccSnsTmpPath")
                        .setSnsEntityVideoConfigFunc("Lo")
                        .setSnsVideoFileOperationClz("com.tencent.mm.modelsfs.FileOp")
                        .setSnsVideoCopyFileFunc("x")
                        .setSnsVideoGetOneOfVarFunc("a")
                        .setSnsVideoExtraVar1Param1("nkL")
                        .setSnsVideoEntityOneOfVar1("reu")
                        .setSnsVideoEntityVarInnerVar1("wYj")
                        .setSnsVideoEntityVar1InnerVar1("wfh")
                        .setSnsVideoExtraVar1AddFunc("add")
                        .setSnsVideoExtraVar2Clz("com.tencent.mm.protocal.c.apk")
                        .setSnsVideoExtraVar1Param2("qXb")
                        .setSnsVideoExtraVar2Param1("wCR")
                        .setSnsVideoEntityOneOfVar2("rev")
                        .setSnsVideoEntityVar2InnerVar("wFn")
                        .setSnsVideoExtraVar2AddFunc("add")
                        .setSnsTextEntityInstanceParam(2)
                        .setSnsImgEntityInstanceParam(1)
                        .setSnsVideoEntityInstanceParam(15)
                        .setContextClz("com.tencent.mm.sdk.platformtools.ad")
                        .setContextFunc("getContext")
                        .create();
                break;
            case WX_VERSION_663:
                configurator = new Builder()
                        .setVersion(663)
                        .setImgDownloadBootClz("com.tencent.mm.z.ar")
                        .setImgDownloadBootFunc("CG")
                        .setLoadClz("com.tencent.mm.aq.o")
                        .setLoadFunc("Px")
                        .setDownImgEntityClz("com.tencent.mm.ap.k")
                        .setDownImgEntityParamClz("com.tencent.mm.ae.f")
                        .setDownloadFunc("a")
                        .setDbClz("com.tencent.wcdb.database.SQLiteDatabase")
                        .setDbOpenFunc("openDatabase")
                        .setDbCipherClz("com.tencent.wcdb.database.SQLiteCipherSpec")
                        .setDbCursorFactoryClz("com.tencent.wcdb.database.SQLiteDatabase.CursorFactory")
                        .setDbErrorHandlerClz("com.tencent.wcdb.DatabaseErrorHandler")
                        .setDbInsertFunc("insertWithOnConflict")
                        .setDbUpdateFunc("updateWithOnConflict")
                        .setDbDeleteFunc("delete")
                        .setLauncherClz("com.tencent.mm.ui.LauncherUI")
                        .setLauncherFunc("onCreateOptionsMenu")
                        .setVideoDownloadBootClz("com.tencent.mm.modelvideo.t")
                        .setVideoDownloadFunc("nB")
                        .setTextMsgEntityClz("com.tencent.mm.modelmulti.j")
                        .setTextMsgBootClz("com.tencent.mm.z.ar")
                        .setTextMsgBootFunc("CG")
                        .setTextMsgSendFunc("a")
                        .setImgMsgEntityClz("com.tencent.mm.aq.l")
                        .setImgMsgEntityParamClz("com.tencent.mm.ae.f")
                        .setImgMsgBootClz("com.tencent.mm.z.ar")
                        .setImgMsgBootFunc("CG")
                        .setImgMsgSendFunc("a")
                        .setVideoMsgEntityClz("com.tencent.mm.pluginsdk.model.k")
                        .setVideoMsgEntityParamClz("com.tencent.mm.pluginsdk.model.k$a")
                        .setVideoMsgBootClz("com.tencent.mm.sdk.f.e")
                        .setVideoMsgBootFunc("a")
                        .setVoiceMsgDBEntityClz("com.tencent.mm.modelvoice.q")
                        .setVoiceMsgDBEntityFunc("nV")
                        .setVoiceMsgPathClz("com.tencent.mm.modelvoice.q")
                        .setVoiceMsgPathFunc("M")
                        .setVoiceMsgNotifyFunc("k")
                        .setVoiceMsgBootClz("com.tencent.mm.z.ar")
                        .setVoiceMsgBootFunc("CG")
                        .setVoiceMsgEntityClz("com.tencent.mm.modelvoice.f")
                        .setVoiceMsgSendFunc("a")
                        .setLinkMsgParam1WrapClz("com.tencent.mm.sdk.platformtools.bh")
                        .setLinkMsgParam1WrapFunc("VH")
                        .setLinkMsgParam1InvokeClz("com.tencent.mm.y.g$a")
                        .setLinkMsgParam1InvokeFunc("fT")
                        .setLinkMsgParam1ConvertClz("com.tencent.mm.y.g&a")
                        .setLinkMsgParam1ConvertFunc("a")
                        .setLinkMsgParam2WrapClz("com.tencent.mm.aq.o")
                        .setLinkMsgParam2WrapFunc("Pw")
                        .setLinkMsgParam2InvokeFunc("B")
                        .setLinkMsgParam2ConvertClz("com.tencent.mm.modelsfs.FileOp")
                        .setLinkMsgParam2ConvertFunc("d")
                        .setLinkMsgSendClz("com.tencent.mm.pluginsdk.model.app.l")
                        .setLinkMsgSendFunc("a")
                        .setSnsEntityClz("com.tencent.mm.plugin.sns.model.aw")
                        .setSnsEntityDescConfigFunc("Kz")
                        .setSnsEntityVal0ConfigFunc1("wO")
                        .setSnsEntityVal0ConfigFunc2("wP")
                        .setSnsEntityVal0ConfigFunc3("wR")
                        .setSnsEntityVal0ConfigFunc4("wQ")
                        .setSnsEntityCommitFunc("commit")
                        .setSnsEntityCarrierClz("com.tencent.mm.modelsns.b")
                        .setSnsEntityCarryFunc("iw")
                        .setSnsMsgHandleQueueClz("com.tencent.mm.plugin.sns.h.e")
                        .setSnsMsgHandleQueueVar("rdF")
                        .setSnsMsgHandlePutFunc("c")
                        .setSnsToolsOfGetRefreshClz("com.tencent.mm.plugin.sns.model.ae")
                        .setSnsToolsOfGetRefreshFunc("bvr")
                        .setSnsRefreshFunc("buj")
                        .setSnsImgInfoClz("com.tencent.mm.plugin.sns.data.h")
                        .setSnsImgInfoVarType("type")
                        .setSnsImgInfoVal0Var1("qQV")
                        .setSnsImgInfoVal0Var2("qQW")
                        .setSnsImgInfoVal0Var3("qQX")
                        .setSnsImgInfoVal0Var4("qQY")
                        .setSnsImgInfoVarDesc("desc")
                        .setSnsImgInfoValFalseVar5("qRc")
                        .setSnsEntityOneOfVar("qYr")
                        .setSnsImgOptListVar("wyo")
                        .setSnsImgOptClz("com.tencent.mm.protocal.c.bkl")
                        .setSnsImgOptVal00fVar("biF")
                        .setSnsImgOptVal0Var("rui")
                        .setSnsImgOptVal1000fVar1("wNU")
                        .setSnsImgOptVal1000fVar2("wNV")
                        .setSnsImgOptVal1000fVar3("wNW")
                        .setSnsImgOptVal1000fVar4("wNX")
                        .setSnsImgOptVal2Var("wNY")
                        .setSnsImgOptTimestamp1("wNZ")
                        .setSnsImgOptTimestamp2("wOa")
                        .setSnsImgOptAddFunc("add")
                        .setSnsEntityImgConfigFunc("bN")
                        .setGetSnsVideoTmpPathClz("com.tencent.mm.plugin.sns.model.ae")
                        .setGetSnsVideoTmpPathFunc("getAccSnsTmpPath")
                        .setSnsEntityVideoConfigFunc("KJ")
                        .setSnsVideoFileOperationClz("com.tencent.mm.modelsfs.FileOp")
                        .setSnsVideoCopyFileFunc("x")
                        .setSnsVideoGetOneOfVarFunc("a")
                        .setSnsVideoExtraVar1Param1("nfe")
                        .setSnsVideoEntityOneOfVar1("qYq")
                        .setSnsVideoEntityVarInnerVar1("wQo")
                        .setSnsVideoEntityVar1InnerVar1("vYd")
                        .setSnsVideoExtraVar1AddFunc("add")
                        .setSnsVideoExtraVar2Clz("com.tencent.mm.protocal.c.aox")
                        .setSnsVideoExtraVar1Param2("qQY")
                        .setSnsVideoExtraVar2Param1("wvG")
                        .setSnsVideoEntityOneOfVar2("qYr")
                        .setSnsVideoEntityVar2InnerVar("wyc")
                        .setSnsVideoExtraVar2AddFunc("add")
                        .setSnsTextEntityInstanceParam(2)
                        .setSnsImgEntityInstanceParam(1)
                        .setSnsVideoEntityInstanceParam(15)
                        .setContextClz("com.tencent.mm.sdk.platformtools.ac")
                        .setContextFunc("getContext")
                        .create();
                break;
            default:
                break;
        }
        return configurator;
    }

    public String getAtoneEntityClz() {
        return atoneEntityClz;
    }

    public String getAtoneBootClz() {
        return atoneBootClz;
    }

    public String getAtoneBootFunc() {
        return atoneBootFunc;
    }

    public String getAtoneSendFunc() {
        return atoneSendFunc;
    }

    public String getDbClz() {
        return dbClz;
    }

    public String getDbOpenFunc() {
        return dbOpenFunc;
    }

    public String getDbCipherClz() {
        return dbCipherClz;
    }

    public String getDbCursorFactoryClz() {
        return dbCursorFactoryClz;
    }

    public String getDbErrorHandlerClz() {
        return dbErrorHandlerClz;
    }

    public String getDbInsertFunc() {
        return dbInsertFunc;
    }

    public String getDbUpdateFunc() {
        return dbUpdateFunc;
    }

    public String getDbDeleteFunc() {
        return dbDeleteFunc;
    }

    public String getExitRoomInvokeParamsClz() {
        return exitRoomInvokeParamsClz;
    }

    public String getExitRoomInvokeClz() {
        return exitRoomInvokeClz;
    }

    public String getExitRoomInvokeFunc() {
        return exitRoomInvokeFunc;
    }

    public String getExitRoomGetInvokeFunc() {
        return exitRoomGetInvokeFunc;
    }

    public String getExitRoomRefreshUIEntityClz() {
        return exitRoomRefreshUIEntityClz;
    }

    public String getExitRoomRefreshUIFunc() {
        return exitRoomRefreshUIFunc;
    }

    public String getExitRoomBootClz() {
        return exitRoomBootClz;
    }

    public String getExitRoomBootFunc1() {
        return exitRoomBootFunc1;
    }

    public String getExitRoomBootFunc2() {
        return exitRoomBootFunc2;
    }

    public String getExitRoomFunc() {
        return exitRoomFunc;
    }

    public String getRemittanceEntityClz() {
        return remittanceEntityClz;
    }

    public String getRemittanceEntityParams() {
        return remittanceEntityParams;
    }

    public String getRemittanceBootClz() {
        return remittanceBootClz;
    }

    public String getRemittanceBootFunc() {
        return remittanceBootFunc;
    }

    public String getRemittanceAcceptInstance() {
        return remittanceAcceptInstance;
    }

    public String getRemittanceAcceptFunc() {
        return remittanceAcceptFunc;
    }

    public String getDelContactEntityClz() {
        return delContactEntityClz;
    }

    public String getDelContactBootClz() {
        return delContactBootClz;
    }

    public String getDelContactBootFunc() {
        return delContactBootFunc;
    }

    public String getDelContactFunc() {
        return delContactFunc;
    }

    public String getDelContactRefreshBootFunc() {
        return delContactRefreshBootFunc;
    }

    public String getDelContactRefreshFunc() {
        return delContactRefreshFunc;
    }

    public String getGetRemarkInfoBootClz() {
        return getRemarkInfoBootClz;
    }

    public String getGetRemarkInfoBootFunc() {
        return getRemarkInfoBootFunc;
    }

    public String getGetRemarkInfoFunc() {
        return getRemarkInfoFunc;
    }

    public String getAmendRemarkClz() {
        return amendRemarkClz;
    }

    public String getAmendRemarkFunc() {
        return amendRemarkFunc;
    }

    public String getSubscriptionBootClz() {
        return subscriptionBootClz;
    }

    public String getSubscriptionBootFunc() {
        return subscriptionBootFunc;
    }

    public String getSubscriptionSendFunc() {
        return subscriptionSendFunc;
    }

    public String getGetRoomNameEntityClz() {
        return getRoomNameEntityClz;
    }

    public String getGetRoomNameEntityFunc() {
        return getRoomNameEntityFunc;
    }

    public String getRoomNameAmendFunc() {
        return roomNameAmendFunc;
    }

    public String getRoonNameShowDialogFunc() {
        return roonNameShowDialogFunc;
    }

    public String getRoomNameDialogInstance() {
        return roomNameDialogInstance;
    }

    public String getRoomNameDismissFunc() {
        return roomNameDismissFunc;
    }

    public String getContextClz() {
        return contextClz;
    }

    public String getContextFunc() {
        return contextFunc;
    }

    public int getVersion() {
        return version;
    }

    public String getAgreeFriendEntityClz() {
        return agreeFriendEntityClz;
    }

    public String getAgreeFriendBootClz() {
        return agreeFriendBootClz;
    }

    public String getAgreeFriendBootFunc() {
        return agreeFriendBootFunc;
    }

    public String getAgreeFriendSendFunc() {
        return agreeFriendSendFunc;
    }

    public String getImgMsgBootClz() {
        return imgMsgBootClz;
    }

    public String getImgMsgBootFunc() {
        return imgMsgBootFunc;
    }

    public String getImgMsgSendFunc() {
        return imgMsgSendFunc;
    }

    public String getCardMsgPackagerClz() {
        return cardMsgPackagerClz;
    }

    public String getCardMsgPackageFunc() {
        return cardMsgPackageFunc;
    }

    public String getCardMsgEntityClz() {
        return cardMsgEntityClz;
    }

    public String getCardMsgBootClz() {
        return cardMsgBootClz;
    }

    public String getCardMsgBootFunc() {
        return cardMsgBootFunc;
    }

    public String getCardMsgSendFunc() {
        return cardMsgSendFunc;
    }

    public String getNotifyAllMemberEntityClz() {
        return notifyAllMemberEntityClz;
    }

    public String getNotifyAllRoomMemberBootClz() {
        return notifyAllRoomMemberBootClz;
    }

    public String getNotifyAllRoomMemberBootFunc() {
        return notifyAllRoomMemberBootFunc;
    }

    public String getNotifyAllRoomMemberSendFunc() {
        return notifyAllRoomMemberSendFunc;
    }

    public String getRemoveRoomMemberEntityClz() {
        return removeRoomMemberEntityClz;
    }

    public String getRemoveRoomMemberBootClz() {
        return removeRoomMemberBootClz;
    }

    public String getRemoveRoomMemberBootFunc() {
        return removeRoomMemberBootFunc;
    }

    public String getRemoveRoomMemberSendFunc() {
        return removeRoomMemberSendFunc;
    }

    public String getAddRoomMemberEntityClz() {
        return addRoomMemberEntityClz;
    }

    public String getAddRoomMemberBootClz() {
        return addRoomMemberBootClz;
    }

    public String getAddRoomMemberBootFunc() {
        return addRoomMemberBootFunc;
    }

    public String getAddRoomMemberSendFunc() {
        return addRoomMemberSendFunc;
    }

    public String getRoomEntityClz() {
        return roomEntityClz;
    }

    public String getRoomEntityVar() {
        return roomEntityVar;
    }

    public String getRoomEntityStrParam() {
        return roomEntityStrParam;
    }

    public String getRoomEntityListParam() {
        return roomEntityListParam;
    }

    public String getRoomEntitySubmitClz() {
        return roomEntitySubmitClz;
    }

    public String getRoomEntitySubmitInstance() {
        return roomEntitySubmitInstance;
    }

    public String getRoomEntitySubmitFunc() {
        return roomEntitySubmitFunc;
    }

    public int getSnsTextEntityInstanceParam() {
        return snsTextEntityInstanceParam;
    }

    public int getSnsImgEntityInstanceParam() {
        return snsImgEntityInstanceParam;
    }

    public int getSnsVideoEntityInstanceParam() {
        return snsVideoEntityInstanceParam;
    }

    public String getSnsVideoExtraVar1Param2() {
        return snsVideoExtraVar1Param2;
    }

    public String getSnsVideoEntityOneOfVar2() {
        return snsVideoEntityOneOfVar2;
    }

    public String getSnsVideoEntityVar2InnerVar() {
        return snsVideoEntityVar2InnerVar;
    }

    public String getGetSnsVideoTmpPathClz() {
        return getSnsVideoTmpPathClz;
    }

    public String getGetSnsVideoTmpPathFunc() {
        return getSnsVideoTmpPathFunc;
    }

    public String getSnsEntityVideoConfigFunc() {
        return snsEntityVideoConfigFunc;
    }

    public String getSnsVideoFileOperationClz() {
        return snsVideoFileOperationClz;
    }

    public String getSnsVideoCopyFileFunc() {
        return snsVideoCopyFileFunc;
    }

    public String getSnsVideoGetOneOfVarFunc() {
        return snsVideoGetOneOfVarFunc;
    }

    public String getSnsVideoExtraVar1Param1() {
        return snsVideoExtraVar1Param1;
    }

    public String getSnsVideoEntityOneOfVar1() {
        return snsVideoEntityOneOfVar1;
    }

    public String getSnsVideoEntityVarInnerVar1() {
        return snsVideoEntityVarInnerVar1;
    }

    public String getSnsVideoEntityVar1InnerVar1() {
        return snsVideoEntityVar1InnerVar1;
    }

    public String getSnsVideoExtraVar1AddFunc() {
        return snsVideoExtraVar1AddFunc;
    }

    public String getSnsVideoExtraVar2Clz() {
        return snsVideoExtraVar2Clz;
    }

    public String getSnsVideoExtraVar2Param1() {
        return snsVideoExtraVar2Param1;
    }

    public String getSnsVideoExtraVar2AddFunc() {
        return snsVideoExtraVar2AddFunc;
    }

    public String getSnsImgOptAddFunc() {
        return snsImgOptAddFunc;
    }

    public String getSnsEntityImgConfigFunc() {
        return snsEntityImgConfigFunc;
    }

    public String getSnsImgOptVal00fVar() {
        return snsImgOptVal00fVar;
    }

    public String getSnsImgOptVal0Var() {
        return snsImgOptVal0Var;
    }

    public String getSnsImgOptVal1000fVar1() {
        return snsImgOptVal1000fVar1;
    }

    public String getSnsImgOptVal1000fVar2() {
        return snsImgOptVal1000fVar2;
    }

    public String getSnsImgOptVal1000fVar3() {
        return snsImgOptVal1000fVar3;
    }

    public String getSnsImgOptVal1000fVar4() {
        return snsImgOptVal1000fVar4;
    }

    public String getSnsImgOptVal2Var() {
        return snsImgOptVal2Var;
    }

    public String getSnsEntityOneOfVar() {
        return snsEntityOneOfVar;
    }

    public String getSnsImgOptListVar() {
        return snsImgOptListVar;
    }

    public String getSnsImgOptClz() {
        return snsImgOptClz;
    }

    public String getSnsImgOptTimestamp1() {
        return snsImgOptTimestamp1;
    }

    public String getSnsImgOptTimestamp2() {
        return snsImgOptTimestamp2;
    }

    public String getSnsImgInfoClz() {
        return snsImgInfoClz;
    }

    public String getSnsImgInfoVarType() {
        return snsImgInfoVarType;
    }

    public String getSnsImgInfoVal0Var1() {
        return snsImgInfoVal0Var1;
    }

    public String getSnsImgInfoVal0Var2() {
        return snsImgInfoVal0Var2;
    }

    public String getSnsImgInfoVal0Var3() {
        return snsImgInfoVal0Var3;
    }

    public String getSnsImgInfoVal0Var4() {
        return snsImgInfoVal0Var4;
    }

    public String getSnsImgInfoVarDesc() {
        return snsImgInfoVarDesc;
    }

    public String getSnsImgInfoValFalseVar5() {
        return snsImgInfoValFalseVar5;
    }

    public String getSnsToolsOfGetRefreshClz() {
        return snsToolsOfGetRefreshClz;
    }

    public String getSnsToolsOfGetRefreshFunc() {
        return snsToolsOfGetRefreshFunc;
    }

    public String getSnsRefreshFunc() {
        return snsRefreshFunc;
    }

    public String getSnsEntityCommitFunc() {
        return snsEntityCommitFunc;
    }

    public String getSnsEntityCarrierClz() {
        return snsEntityCarrierClz;
    }

    public String getSnsEntityCarryFunc() {
        return snsEntityCarryFunc;
    }

    public String getSnsMsgHandleQueueClz() {
        return snsMsgHandleQueueClz;
    }

    public String getSnsMsgHandleQueueVar() {
        return snsMsgHandleQueueVar;
    }

    public String getSnsMsgHandlePutFunc() {
        return snsMsgHandlePutFunc;
    }

    public String getSnsEntityClz() {
        return snsEntityClz;
    }

    public String getSnsEntityDescConfigFunc() {
        return snsEntityDescConfigFunc;
    }

    public String getSnsEntityVal0ConfigFunc1() {
        return snsEntityVal0ConfigFunc1;
    }

    public String getSnsEntityVal0ConfigFunc2() {
        return snsEntityVal0ConfigFunc2;
    }

    public String getSnsEntityVal0ConfigFunc3() {
        return snsEntityVal0ConfigFunc3;
    }

    public String getSnsEntityVal0ConfigFunc4() {
        return snsEntityVal0ConfigFunc4;
    }

    public String getLinkMsgParam1ConvertClz() {
        return linkMsgParam1ConvertClz;
    }

    public String getLinkMsgParam1ConvertFunc() {
        return linkMsgParam1ConvertFunc;
    }

    public String getLinkMsgParam1WrapClz() {
        return linkMsgParam1WrapClz;
    }

    public String getLinkMsgParam1WrapFunc() {
        return linkMsgParam1WrapFunc;
    }

    public String getLinkMsgParam1InvokeClz() {
        return linkMsgParam1InvokeClz;
    }

    public String getLinkMsgParam1InvokeFunc() {
        return linkMsgParam1InvokeFunc;
    }

    public String getLinkMsgParam2WrapClz() {
        return linkMsgParam2WrapClz;
    }

    public String getLinkMsgParam2WrapFunc() {
        return linkMsgParam2WrapFunc;
    }

    public String getLinkMsgParam2InvokeFunc() {
        return linkMsgParam2InvokeFunc;
    }

    public String getLinkMsgParam2ConvertClz() {
        return linkMsgParam2ConvertClz;
    }

    public String getLinkMsgParam2ConvertFunc() {
        return linkMsgParam2ConvertFunc;
    }

    public String getLinkMsgSendClz() {
        return linkMsgSendClz;
    }

    public String getLinkMsgSendFunc() {
        return linkMsgSendFunc;
    }

    public String getVoiceMsgDBEntityClz() {
        return voiceMsgDBEntityClz;
    }

    public String getVoiceMsgDBEntityFunc() {
        return voiceMsgDBEntityFunc;
    }

    public String getVoiceMsgPathClz() {
        return voiceMsgPathClz;
    }

    public String getVoiceMsgPathFunc() {
        return voiceMsgPathFunc;
    }

    public String getVoiceMsgNotifyFunc() {
        return voiceMsgNotifyFunc;
    }

    public String getVoiceMsgBootClz() {
        return voiceMsgBootClz;
    }

    public String getVoiceMsgBootFunc() {
        return voiceMsgBootFunc;
    }

    public String getVoiceMsgEntityClz() {
        return voiceMsgEntityClz;
    }

    public String getVoiceMsgSendFunc() {
        return voiceMsgSendFunc;
    }

    public String getVideoMsgEntityClz() {
        return videoMsgEntityClz;
    }

    public String getVideoMsgEntityParamClz() {
        return videoMsgEntityParamClz;
    }

    public String getVideoMsgBootClz() {
        return videoMsgBootClz;
    }

    public String getVideoMsgBootFunc() {
        return videoMsgBootFunc;
    }

    public String getImgMsgEntityClz() {
        return imgMsgEntityClz;
    }

    public String getImgMsgEntityParamClz() {
        return imgMsgEntityParamClz;
    }

    public String getLauncherClz() {
        return launcherClz;
    }

    public String getLauncherFunc() {
        return launcherFunc;
    }

    public String getImgDownloadBootClz() {
        return imgDownloadBootClz;
    }

    public String getImgDownloadBootFunc() {
        return imgDownloadBootFunc;
    }

    public String getVideoDownloadBootClz() {
        return videoDownloadBootClz;
    }

    public String getVideoDownloadFunc() {
        return videoDownloadFunc;
    }

    public String getLoadClz() {
        return loadClz;
    }

    public String getLoadFunc() {
        return loadFunc;
    }

    public String getDownImgEntityClz() {
        return downImgEntityClz;
    }

    public String getDownImgEntityParamClz() {
        return downImgEntityParamClz;
    }

    public String getDownloadFunc() {
        return downloadFunc;
    }

    public String getTextMsgEntityClz() {
        return textMsgEntityClz;
    }

    public String getTextMsgBootClz() {
        return textMsgBootClz;
    }

    public String getTextMsgBootFunc() {
        return textMsgBootFunc;
    }

    public String getTextMsgSendFunc() {
        return textMsgSendFunc;
    }

    public String getCreateRoomEntityClz() {
        return createRoomEntityClz;
    }

    public String getCreateRoomEntityParentClz() {
        return createRoomEntityParentClz;
    }

    public String getCreateRoomGetParentEntityFunc() {
        return createRoomGetParentEntityFunc;
    }

    public String getCreateRoomVarInParent() {
        return createRoomVarInParent;
    }

    public String getCreateRoomBootClz() {
        return createRoomBootClz;
    }

    public String getCreateRoomBootFunc() {
        return createRoomBootFunc;
    }

    public String getCreateRoomBootInstance() {
        return createRoomBootInstance;
    }

    public String getCreateRoomCallbackVar() {
        return createRoomCallbackVar;
    }

    public String getCreateRoomSendFunc() {
        return createRoomSendFunc;
    }

    public String getCreateRoomRefreshUIClz() {
        return createRoomRefreshUIClz;
    }

    public String getCreateRoomRefreshUIFunc() {
        return createRoomRefreshUIFunc;
    }

    public String getCreateRoomVarGetTypeFunc() {
        return createRoomVarGetTypeFunc;
    }


    public static class Builder {

        private Configurator configurator = null;

        public Builder() {
            this.configurator = new Configurator();
        }

        private Builder setDownloadFunc(String downloadFunc) {
            configurator.downloadFunc = downloadFunc;
            return this;
        }

        private Builder setLoadClz(String loadClz) {
            configurator.loadClz = loadClz;
            return this;
        }

        private Builder setLoadFunc(String loadFunc) {
            configurator.loadFunc = loadFunc;
            return this;
        }

        private Builder setDownImgEntityClz(String downImgEntityClz) {
            configurator.downImgEntityClz = downImgEntityClz;
            return this;
        }

        private Builder setDownImgEntityParamClz(String downImgEntityParamClz) {
            configurator.downImgEntityParamClz = downImgEntityParamClz;
            return this;
        }

        private Builder setLauncherClz(String launcherClz) {
            configurator.launcherClz = launcherClz;
            return this;
        }

        private Builder setLauncherFunc(String launcherFunc) {
            configurator.launcherFunc = launcherFunc;
            return this;
        }

        private Builder setImgDownloadBootClz(String imgDownloadBootClz) {
            configurator.imgDownloadBootClz = imgDownloadBootClz;
            return this;
        }

        private Builder setImgDownloadBootFunc(String imgDownloadBootFunc) {
            configurator.imgDownloadBootFunc = imgDownloadBootFunc;
            return this;
        }

        private Builder setVideoDownloadBootClz(String videoDownloadBootClz) {
            configurator.videoDownloadBootClz = videoDownloadBootClz;
            return this;
        }

        private Builder setVideoDownloadFunc(String videoDownloadFunc) {
            configurator.videoDownloadFunc = videoDownloadFunc;
            return this;
        }

        private Builder setTextMsgEntityClz(String textMsgEntityClz) {
            configurator.textMsgEntityClz = textMsgEntityClz;
            return this;
        }

        private Builder setTextMsgBootClz(String textMsgBootClz) {
            configurator.textMsgBootClz = textMsgBootClz;
            return this;
        }

        private Builder setTextMsgBootFunc(String textMsgBootFunc) {
            configurator.textMsgBootFunc = textMsgBootFunc;
            return this;
        }

        private Builder setTextMsgSendFunc(String textMsgSendFunc) {
            configurator.textMsgSendFunc = textMsgSendFunc;
            return this;
        }

        private Builder setImgMsgEntityClz(String imgMsgEntityClz) {
            configurator.imgMsgEntityClz = imgMsgEntityClz;
            return this;
        }

        private Builder setImgMsgEntityParamClz(String imgMsgEntityParamClz) {
            configurator.imgMsgEntityParamClz = imgMsgEntityParamClz;
            return this;
        }

        private Builder setVideoMsgEntityClz(String videoMsgEntityClz) {
            configurator.videoMsgEntityClz = videoMsgEntityClz;
            return this;
        }

        private Builder setVideoMsgEntityParamClz(String videoMsgEntityParamClz) {
            configurator.videoMsgEntityParamClz = videoMsgEntityParamClz;
            return this;
        }

        private Builder setVideoMsgBootClz(String videoMsgBootClz) {
            configurator.videoMsgBootClz = videoMsgBootClz;
            return this;
        }

        private Builder setVideoMsgBootFunc(String videoMsgBootFunc) {
            configurator.videoMsgBootFunc = videoMsgBootFunc;
            return this;
        }

        private Builder setVoiceMsgDBEntityClz(String voiceMsgDBEntityClz) {
            configurator.voiceMsgDBEntityClz = voiceMsgDBEntityClz;
            return this;
        }

        private Builder setVoiceMsgDBEntityFunc(String voiceMsgDBEntityFunc) {
            configurator.voiceMsgDBEntityFunc = voiceMsgDBEntityFunc;
            return this;
        }

        private Builder setVoiceMsgPathClz(String voiceMsgPathClz) {
            configurator.voiceMsgPathClz = voiceMsgPathClz;
            return this;
        }

        private Builder setVoiceMsgPathFunc(String voiceMsgPathFunc) {
            configurator.voiceMsgPathFunc = voiceMsgPathFunc;
            return this;
        }

        private Builder setVoiceMsgNotifyFunc(String voiceMsgNotifyFunc) {
            configurator.voiceMsgNotifyFunc = voiceMsgNotifyFunc;
            return this;
        }

        private Builder setVoiceMsgBootClz(String voiceMsgBootClz) {
            configurator.voiceMsgBootClz = voiceMsgBootClz;
            return this;
        }

        private Builder setVoiceMsgBootFunc(String voiceMsgBootFunc) {
            configurator.voiceMsgBootFunc = voiceMsgBootFunc;
            return this;
        }

        private Builder setVoiceMsgEntityClz(String voiceMsgEntityClz) {
            configurator.voiceMsgEntityClz = voiceMsgEntityClz;
            return this;
        }

        private Builder setVoiceMsgSendFunc(String voiceMsgSendFunc) {
            configurator.voiceMsgSendFunc = voiceMsgSendFunc;
            return this;
        }

        private Builder setLinkMsgParam1WrapClz(String linkMsgParam1WrapClz) {
            configurator.linkMsgParam1WrapClz = linkMsgParam1WrapClz;
            return this;
        }

        private Builder setLinkMsgParam1WrapFunc(String linkMsgParam1WrapFunc) {
            configurator.linkMsgParam1WrapFunc = linkMsgParam1WrapFunc;
            return this;
        }

        private Builder setLinkMsgParam1InvokeClz(String linkMsgParam1InvokeClz) {
            configurator.linkMsgParam1InvokeClz = linkMsgParam1InvokeClz;
            return this;
        }

        private Builder setLinkMsgParam1InvokeFunc(String linkMsgParam1InvokeFunc) {
            configurator.linkMsgParam1InvokeFunc = linkMsgParam1InvokeFunc;
            return this;
        }

        private Builder setLinkMsgParam2WrapClz(String linkMsgParam2WrapClz) {
            configurator.linkMsgParam2WrapClz = linkMsgParam2WrapClz;
            return this;
        }

        private Builder setLinkMsgParam2WrapFunc(String linkMsgParam2WrapFunc) {
            configurator.linkMsgParam2WrapFunc = linkMsgParam2WrapFunc;
            return this;
        }

        private Builder setLinkMsgParam2InvokeFunc(String linkMsgParam2InvokeFunc) {
            configurator.linkMsgParam2InvokeFunc = linkMsgParam2InvokeFunc;
            return this;
        }

        private Builder setLinkMsgParam2ConvertClz(String linkMsgParam2ConvertClz) {
            configurator.linkMsgParam2ConvertClz = linkMsgParam2ConvertClz;
            return this;
        }

        private Builder setLinkMsgParam2ConvertFunc(String linkMsgParam2ConvertFunc) {
            configurator.linkMsgParam2ConvertFunc = linkMsgParam2ConvertFunc;
            return this;
        }

        private Builder setLinkMsgSendClz(String linkMsgSendClz) {
            configurator.linkMsgSendClz = linkMsgSendClz;
            return this;
        }

        private Builder setLinkMsgSendFunc(String linkMsgSendFunc) {
            configurator.linkMsgSendFunc = linkMsgSendFunc;
            return this;
        }

        private Builder setLinkMsgParam1ConvertClz(String linkMsgParam1ConvertClz) {
            configurator.linkMsgParam1ConvertClz = linkMsgParam1ConvertClz;
            return this;
        }

        private Builder setLinkMsgParam1ConvertFunc(String linkMsgParam1ConvertFunc) {
            configurator.linkMsgParam1ConvertFunc = linkMsgParam1ConvertFunc;
            return this;
        }

        private Builder setSnsEntityClz(String snsEntityClz) {
            configurator.snsEntityClz = snsEntityClz;
            return this;
        }

        private Builder setSnsEntityDescConfigFunc(String snsEntityDescConfigFunc) {
            configurator.snsEntityDescConfigFunc = snsEntityDescConfigFunc;
            return this;
        }

        private Builder setSnsEntityVal0ConfigFunc1(String snsEntityVal0ConfigFunc1) {
            configurator.snsEntityVal0ConfigFunc1 = snsEntityVal0ConfigFunc1;
            return this;
        }

        private Builder setSnsEntityVal0ConfigFunc2(String snsEntityVal0ConfigFunc2) {
            configurator.snsEntityVal0ConfigFunc2 = snsEntityVal0ConfigFunc2;
            return this;
        }

        private Builder setSnsEntityVal0ConfigFunc3(String snsEntityVal0ConfigFunc3) {
            configurator.snsEntityVal0ConfigFunc3 = snsEntityVal0ConfigFunc3;
            return this;
        }

        private Builder setSnsEntityVal0ConfigFunc4(String snsEntityVal0ConfigFunc4) {
            configurator.snsEntityVal0ConfigFunc4 = snsEntityVal0ConfigFunc4;
            return this;
        }

        private Builder setSnsEntityCommitFunc(String snsEntityCommitFunc) {
            configurator.snsEntityCommitFunc = snsEntityCommitFunc;
            return this;
        }

        private Builder setSnsEntityCarrierClz(String snsEntityCarrierClz) {
            configurator.snsEntityCarrierClz = snsEntityCarrierClz;
            return this;
        }

        private Builder setSnsEntityCarryFunc(String snsEntityCarryFunc) {
            configurator.snsEntityCarryFunc = snsEntityCarryFunc;
            return this;
        }

        private Builder setSnsMsgHandleQueueClz(String snsMsgHandleQueueClz) {
            configurator.snsMsgHandleQueueClz = snsMsgHandleQueueClz;
            return this;
        }

        private Builder setSnsMsgHandleQueueVar(String snsMsgHandleQueueVar) {
            configurator.snsMsgHandleQueueVar = snsMsgHandleQueueVar;
            return this;
        }

        private Builder setSnsMsgHandlePutFunc(String snsMsgHandlePutFunc) {
            configurator.snsMsgHandlePutFunc = snsMsgHandlePutFunc;
            return this;
        }

        private Builder setSnsToolsOfGetRefreshClz(String snsToolsOfGetRefreshClz) {
            configurator.snsToolsOfGetRefreshClz = snsToolsOfGetRefreshClz;
            return this;
        }

        private Builder setSnsToolsOfGetRefreshFunc(String snsToolsOfGetRefreshFunc) {
            configurator.snsToolsOfGetRefreshFunc = snsToolsOfGetRefreshFunc;
            return this;
        }

        private Builder setSnsRefreshFunc(String snsRefreshFunc) {
            configurator.snsRefreshFunc = snsRefreshFunc;
            return this;
        }

        private Builder setSnsImgInfoClz(String snsImgInfoClz) {
            configurator.snsImgInfoClz = snsImgInfoClz;
            return this;
        }

        private Builder setSnsImgInfoVarType(String snsImgInfoVarType) {
            configurator.snsImgInfoVarType = snsImgInfoVarType;
            return this;
        }

        private Builder setSnsImgInfoVal0Var1(String snsImgInfoVal0Var1) {
            configurator.snsImgInfoVal0Var1 = snsImgInfoVal0Var1;
            return this;
        }

        private Builder setSnsImgInfoVal0Var2(String snsImgInfoVal0Var2) {
            configurator.snsImgInfoVal0Var2 = snsImgInfoVal0Var2;
            return this;
        }

        private Builder setSnsImgInfoVal0Var3(String snsImgInfoVal0Var3) {
            configurator.snsImgInfoVal0Var3 = snsImgInfoVal0Var3;
            return this;
        }

        private Builder setSnsImgInfoVal0Var4(String snsImgInfoVal0Var4) {
            configurator.snsImgInfoVal0Var4 = snsImgInfoVal0Var4;
            return this;
        }

        private Builder setSnsImgInfoVarDesc(String snsImgInfoVarDesc) {
            configurator.snsImgInfoVarDesc = snsImgInfoVarDesc;
            return this;
        }

        private Builder setSnsImgInfoValFalseVar5(String snsImgInfoValFalseVar5) {
            configurator.snsImgInfoValFalseVar5 = snsImgInfoValFalseVar5;
            return this;
        }

        private Builder setSnsEntityOneOfVar(String snsEntityOneOfVar) {
            configurator.snsEntityOneOfVar = snsEntityOneOfVar;
            return this;
        }

        private Builder setSnsImgOptListVar(String snsImgOptListVar) {
            configurator.snsImgOptListVar = snsImgOptListVar;
            return this;
        }

        private Builder setSnsImgOptClz(String snsImgOptClz) {
            configurator.snsImgOptClz = snsImgOptClz;
            return this;
        }

        private Builder setSnsImgOptTimestamp1(String snsImgOptTimestamp1) {
            configurator.snsImgOptTimestamp1 = snsImgOptTimestamp1;
            return this;
        }

        private Builder setSnsImgOptTimestamp2(String snsImgOptTimestamp2) {
            configurator.snsImgOptTimestamp2 = snsImgOptTimestamp2;
            return this;
        }

        private Builder setSnsImgOptVal00fVar(String snsImgOptVal00fVar) {
            configurator.snsImgOptVal00fVar = snsImgOptVal00fVar;
            return this;
        }

        private Builder setSnsImgOptVal0Var(String snsImgOptVal0Var) {
            configurator.snsImgOptVal0Var = snsImgOptVal0Var;
            return this;
        }

        private Builder setSnsImgOptVal1000fVar1(String snsImgOptVal1000fVar1) {
            configurator.snsImgOptVal1000fVar1 = snsImgOptVal1000fVar1;
            return this;
        }

        private Builder setSnsImgOptVal1000fVar2(String snsImgOptVal1000fVar2) {
            configurator.snsImgOptVal1000fVar2 = snsImgOptVal1000fVar2;
            return this;
        }

        private Builder setSnsImgOptVal1000fVar3(String snsImgOptVal1000fVar3) {
            configurator.snsImgOptVal1000fVar3 = snsImgOptVal1000fVar3;
            return this;
        }

        private Builder setSnsImgOptVal1000fVar4(String snsImgOptVal1000fVar4) {
            configurator.snsImgOptVal1000fVar4 = snsImgOptVal1000fVar4;
            return this;
        }

        private Builder setSnsImgOptVal2Var(String snsImgOptVal2Var) {
            configurator.snsImgOptVal2Var = snsImgOptVal2Var;
            return this;
        }

        private Builder setSnsImgOptAddFunc(String snsImgOptAddFunc) {
            configurator.snsImgOptAddFunc = snsImgOptAddFunc;
            return this;
        }

        private Builder setSnsEntityImgConfigFunc(String snsEntityImgConfigFunc) {
            configurator.snsEntityImgConfigFunc = snsEntityImgConfigFunc;
            return this;
        }

        private Builder setGetSnsVideoTmpPathClz(String getSnsVideoTmpPathClz) {
            configurator.getSnsVideoTmpPathClz = getSnsVideoTmpPathClz;
            return this;
        }

        private Builder setGetSnsVideoTmpPathFunc(String getSnsVideoTmpPathFunc) {
            configurator.getSnsVideoTmpPathFunc = getSnsVideoTmpPathFunc;
            return this;
        }

        private Builder setSnsEntityVideoConfigFunc(String snsEntityVideoConfigFunc) {
            configurator.snsEntityVideoConfigFunc = snsEntityVideoConfigFunc;
            return this;
        }

        private Builder setSnsVideoFileOperationClz(String snsVideoFileOperationClz) {
            configurator.snsVideoFileOperationClz = snsVideoFileOperationClz;
            return this;
        }

        private Builder setSnsVideoCopyFileFunc(String snsVideoCopyFileFunc) {
            configurator.snsVideoCopyFileFunc = snsVideoCopyFileFunc;
            return this;
        }

        private Builder setSnsVideoGetOneOfVarFunc(String snsVideoGetOneOfVarFunc) {
            configurator.snsVideoGetOneOfVarFunc = snsVideoGetOneOfVarFunc;
            return this;
        }

        private Builder setSnsVideoExtraVar1Param1(String snsVideoExtraVar1Param1) {
            configurator.snsVideoExtraVar1Param1 = snsVideoExtraVar1Param1;
            return this;
        }

        private Builder setSnsVideoExtraVar1AddFunc(String snsVideoExtraVar1AddFunc) {
            configurator.snsVideoExtraVar1AddFunc = snsVideoExtraVar1AddFunc;
            return this;
        }

        private Builder setSnsVideoExtraVar2Clz(String snsVideoExtraVar2Clz) {
            configurator.snsVideoExtraVar2Clz = snsVideoExtraVar2Clz;
            return this;
        }

        private Builder setSnsVideoExtraVar2Param1(String snsVideoExtraVar2Param1) {
            configurator.snsVideoExtraVar2Param1 = snsVideoExtraVar2Param1;
            return this;
        }

        private Builder setSnsVideoExtraVar2AddFunc(String snsVideoExtraVar2AddFunc) {
            configurator.snsVideoExtraVar2AddFunc = snsVideoExtraVar2AddFunc;
            return this;
        }

        private Builder setSnsVideoEntityOneOfVar1(String snsVideoEntityOneOfVar1) {
            configurator.snsVideoEntityOneOfVar1 = snsVideoEntityOneOfVar1;
            return this;
        }

        private Builder setSnsVideoEntityVarInnerVar1(String snsVideoEntityVarInnerVar1) {
            configurator.snsVideoEntityVarInnerVar1 = snsVideoEntityVarInnerVar1;
            return this;
        }

        private Builder setSnsVideoEntityVar1InnerVar1(String snsVideoEntityVar1InnerVar1) {
            configurator.snsVideoEntityVar1InnerVar1 = snsVideoEntityVar1InnerVar1;
            return this;
        }

        private Builder setSnsVideoExtraVar1Param2(String snsVideoExtraVar1Param2) {
            configurator.snsVideoExtraVar1Param2 = snsVideoExtraVar1Param2;
            return this;
        }

        private Builder setSnsVideoEntityOneOfVar2(String snsVideoEntityOneOfVar2) {
            configurator.snsVideoEntityOneOfVar2 = snsVideoEntityOneOfVar2;
            return this;
        }

        private Builder setSnsVideoEntityVar2InnerVar(String snsVideoEntityVar2InnerVar) {
            configurator.snsVideoEntityVar2InnerVar = snsVideoEntityVar2InnerVar;
            return this;
        }

        private Builder setSnsTextEntityInstanceParam(int snsTextEntityInstanceParam) {
            configurator.snsTextEntityInstanceParam = snsTextEntityInstanceParam;
            return this;
        }

        private Builder setSnsImgEntityInstanceParam(int snsImgEntityInstanceParam) {
            configurator.snsImgEntityInstanceParam = snsImgEntityInstanceParam;
            return this;
        }

        private Builder setSnsVideoEntityInstanceParam(int snsVideoEntityInstanceParam) {
            configurator.snsVideoEntityInstanceParam = snsVideoEntityInstanceParam;
            return this;
        }

        private Builder setRoomEntityClz(String roomEntityClz) {
            configurator.roomEntityClz = roomEntityClz;
            return this;
        }

        private Builder setRoomEntityVar(String roomEntityVar) {
            configurator.roomEntityVar = roomEntityVar;
            return this;
        }

        private Builder setRoomEntityStrParam(String roomEntityStrParam) {
            configurator.roomEntityStrParam = roomEntityStrParam;
            return this;
        }

        private Builder setRoomEntityListParam(String roomEntityListParam) {
            configurator.roomEntityListParam = roomEntityListParam;
            return this;
        }

        private Builder setRoomEntitySubmitClz(String roomEntitySubmitClz) {
            configurator.roomEntitySubmitClz = roomEntitySubmitClz;
            return this;
        }

        private Builder setRoomEntitySubmitInstance(String roomEntitySubmitInstance) {
            configurator.roomEntitySubmitInstance = roomEntitySubmitInstance;
            return this;
        }

        private Builder setRoomEntitySubmitFunc(String roomEntitySubmitFunc) {
            configurator.roomEntitySubmitFunc = roomEntitySubmitFunc;
            return this;
        }

        private Builder setAddRoomMemberEntityClz(String addRoomMemberEntityClz) {
            configurator.addRoomMemberEntityClz = addRoomMemberEntityClz;
            return this;
        }

        private Builder setAddRoomMemberBootClz(String addRoomMemberBootClz) {
            configurator.addRoomMemberBootClz = addRoomMemberBootClz;
            return this;
        }

        private Builder setAddRoomMemberBootFunc(String addRoomMemberBootFunc) {
            configurator.addRoomMemberBootFunc = addRoomMemberBootFunc;
            return this;
        }

        private Builder setAddRoomMemberSendFunc(String addRoomMemberSendFunc) {
            configurator.addRoomMemberSendFunc = addRoomMemberSendFunc;
            return this;
        }

        private Builder setRemoveRoomMemberEntityClz(String removeRoomMemberEntityClz) {
            configurator.removeRoomMemberEntityClz = removeRoomMemberEntityClz;
            return this;
        }

        private Builder setRemoveRoomMemberBootClz(String removeRoomMemberBootClz) {
            configurator.removeRoomMemberBootClz = removeRoomMemberBootClz;
            return this;
        }

        private Builder setRemoveRoomMemberBootFunc(String removeRoomMemberBootFunc) {
            configurator.removeRoomMemberBootFunc = removeRoomMemberBootFunc;
            return this;
        }

        private Builder setRemoveRoomMemberSendFunc(String removeRoomMemberSendFunc) {
            configurator.removeRoomMemberSendFunc = removeRoomMemberSendFunc;
            return this;
        }

        private Builder setNotifyAllMemberEntityClz(String notifyAllMemberEntityClz) {
            configurator.notifyAllMemberEntityClz = notifyAllMemberEntityClz;
            return this;
        }

        private Builder setNotifyAllRoomMemberBootClz(String notifyAllRoomMemberBootClz) {
            configurator.notifyAllRoomMemberBootClz = notifyAllRoomMemberBootClz;
            return this;
        }

        private Builder setNotifyAllRoomMemberBootFunc(String notifyAllRoomMemberBootFunc) {
            configurator.notifyAllRoomMemberBootFunc = notifyAllRoomMemberBootFunc;
            return this;
        }

        private Builder setNotifyAllRoomMemberSendFunc(String notifyAllRoomMemberSendFunc) {
            configurator.notifyAllRoomMemberSendFunc = notifyAllRoomMemberSendFunc;
            return this;
        }

        private Builder setCardMsgPackagerClz(String cardMsgPackagerClz) {
            configurator.cardMsgPackagerClz = cardMsgPackagerClz;
            return this;
        }

        private Builder setCardMsgPackageFunc(String cardMsgPackageFunc) {
            configurator.cardMsgPackageFunc = cardMsgPackageFunc;
            return this;
        }

        private Builder setCardMsgEntityClz(String cardMsgEntityClz) {
            configurator.cardMsgEntityClz = cardMsgEntityClz;
            return this;
        }

        private Builder setCardMsgBootClz(String cardMsgBootClz) {
            configurator.cardMsgBootClz = cardMsgBootClz;
            return this;
        }

        private Builder setCardMsgBootFunc(String cardMsgBootFunc) {
            configurator.cardMsgBootFunc = cardMsgBootFunc;
            return this;
        }

        private Builder setCardMsgSendFunc(String cardMsgSendFunc) {
            configurator.cardMsgSendFunc = cardMsgSendFunc;
            return this;
        }

        private Builder setImgMsgBootClz(String imgMsgBootClz) {
            configurator.imgMsgBootClz = imgMsgBootClz;
            return this;
        }

        private Builder setImgMsgBootFunc(String imgMsgBootFunc) {
            configurator.imgMsgBootFunc = imgMsgBootFunc;
            return this;
        }

        private Builder setImgMsgSendFunc(String imgMsgSendFunc) {
            configurator.imgMsgSendFunc = imgMsgSendFunc;
            return this;
        }

        private Builder setAgreeFriendEntityClz(String agreeFriendEntityClz) {
            configurator.agreeFriendEntityClz = agreeFriendEntityClz;
            return this;
        }

        private Builder setAgreeFriendBootClz(String agreeFriendBootClz) {
            configurator.agreeFriendBootClz = agreeFriendBootClz;
            return this;
        }

        private Builder setAgreeFriendBootFunc(String agreeFreindBootFunc) {
            configurator.agreeFriendBootFunc = agreeFreindBootFunc;
            return this;
        }

        private Builder setAgreeFriendSendFunc(String agreeFriendSendFunc) {
            configurator.agreeFriendSendFunc = agreeFriendSendFunc;
            return this;
        }

        private Builder setVersion(int version) {
            configurator.version = version;
            return this;
        }

        private Builder setContextClz(String contextClz) {
            configurator.contextClz = contextClz;
            return this;
        }

        private Builder setContextFunc(String contextFunc) {
            configurator.contextFunc = contextFunc;
            return this;
        }


        private Builder setCreateRoomEntityClz(String createRoomEntityClz) {
            configurator.createRoomEntityClz = createRoomEntityClz;
            return this;
        }

        private Builder setCreateRoomEntityParentClz(String createRoomEntityParentClz) {
            configurator.createRoomEntityParentClz = createRoomEntityParentClz;
            return this;
        }

        private Builder setCreateRoomGetParentEntityFunc(String createRoomGetParentEntityFunc) {
            configurator.createRoomGetParentEntityFunc = createRoomGetParentEntityFunc;
            return this;
        }

        private Builder setCreateRoomVarInParent(String createRoomVarInParent) {
            configurator.createRoomVarInParent = createRoomVarInParent;
            return this;
        }

        private Builder setCreateRoomBootClz(String createRoomBootClz) {
            configurator.createRoomBootClz = createRoomBootClz;
            return this;
        }

        private Builder setCreateRoomBootFunc(String createRoomBootFunc) {
            configurator.createRoomBootFunc = createRoomBootFunc;
            return this;
        }

        private Builder setCreateRoomBootInstance(String createRoomBootInstance) {
            configurator.createRoomBootInstance = createRoomBootInstance;
            return this;
        }

        private Builder setCreateRoomCallbackVar(String createRoomCallbackVar) {
            configurator.createRoomCallbackVar = createRoomCallbackVar;
            return this;
        }

        private Builder setCreateRoomSendFunc(String createRoomSendFunc) {
            configurator.createRoomSendFunc = createRoomSendFunc;
            return this;
        }

        private Builder setCreateRoomRefreshUIClz(String createRoomRefreshUIClz) {
            configurator.createRoomRefreshUIClz = createRoomRefreshUIClz;
            return this;
        }

        private Builder setCreateRoomRefreshUIFunc(String createRoomRefreshUIFunc) {
            configurator.createRoomRefreshUIFunc = createRoomRefreshUIFunc;
            return this;
        }

        private Builder setCreateRoomVarGetTypeFunc(String createRoomVarGetTypeFunc) {
            configurator.createRoomVarGetTypeFunc = createRoomVarGetTypeFunc;
            return this;
        }

        private Builder setGetRoomNameEntityClz(String getRoomNameEntityClz) {
            configurator.getRoomNameEntityClz = getRoomNameEntityClz;
            return this;
        }

        private Builder setGetRoomNameEntityFunc(String getRoomNameEntityFunc) {
            configurator.getRoomNameEntityFunc = getRoomNameEntityFunc;
            return this;
        }

        private Builder setRoomNameAmendFunc(String roomNameAmendFunc) {
            configurator.roomNameAmendFunc = roomNameAmendFunc;
            return this;
        }

        private Builder setRoonNameShowDialogFunc(String roonNameShowDialogFunc) {
            configurator.roonNameShowDialogFunc = roonNameShowDialogFunc;
            return this;
        }

        private Builder setRoomNameDialogInstance(String roomNameDialogInstance) {
            configurator.roomNameDialogInstance = roomNameDialogInstance;
            return this;
        }

        private Builder setRoomNameDismissFunc(String roomNameDismissFunc) {
            configurator.roomNameDismissFunc = roomNameDismissFunc;
            return this;
        }

        private Builder setSubscriptionBootClz(String subscriptionBootClz) {
            configurator.subscriptionBootClz = subscriptionBootClz;
            return this;
        }

        private Builder setSubscriptionBootFunc(String subscriptionBootFunc) {
            configurator.subscriptionBootFunc = subscriptionBootFunc;
            return this;
        }

        private Builder setSubscriptionSendFunc(String subscriptionSendFunc) {
            configurator.subscriptionSendFunc = subscriptionSendFunc;
            return this;
        }

        private Builder setGetRemarkInfoBootClz(String getRemarkInfoBootClz) {
            configurator.getRemarkInfoBootClz = getRemarkInfoBootClz;
            return this;
        }

        private Builder setGetRemarkInfoBootFunc(String getRemarkInfoBootFunc) {
            configurator.getRemarkInfoBootFunc = getRemarkInfoBootFunc;
            return this;
        }

        private Builder setGetRemarkInfoFunc(String getRemarkInfoFunc) {
            configurator.getRemarkInfoFunc = getRemarkInfoFunc;
            return this;
        }

        private Builder setAmendRemarkClz(String amendRemarkClz) {
            configurator.amendRemarkClz = amendRemarkClz;
            return this;
        }

        private Builder setAmendRemarkFunc(String amendRemarkFunc) {
            configurator.amendRemarkFunc = amendRemarkFunc;
            return this;
        }

        private Builder setDelContactEntityClz(String delContactEntityClz) {
            configurator.delContactEntityClz = delContactEntityClz;
            return this;
        }

        private Builder setDelContactBootClz(String delContactBootClz) {
            configurator.delContactBootClz = delContactBootClz;
            return this;
        }

        private Builder setDelContactBootFunc(String delContactBootFunc) {
            configurator.delContactBootFunc = delContactBootFunc;
            return this;
        }

        private Builder setDelContactFunc(String delContactFunc) {
            configurator.delContactFunc = delContactFunc;
            return this;
        }

        private Builder setDelContactRefreshBootFunc(String delContactRefreshBootFunc) {
            configurator.delContactRefreshBootFunc = delContactRefreshBootFunc;
            return this;
        }

        private Builder setDelContactRefreshFunc(String delContactRefreshFunc) {
            configurator.delContactRefreshFunc = delContactRefreshFunc;
            return this;
        }

        private Builder setRemittanceEntityClz(String remittanceEntityClz) {
            configurator.remittanceEntityClz = remittanceEntityClz;
            return this;
        }

        private Builder setRemittanceEntityParams(String remittanceEntityParams) {
            configurator.remittanceEntityParams = remittanceEntityParams;
            return this;
        }

        private Builder setRemittanceBootClz(String remittanceBootClz) {
            configurator.remittanceBootClz = remittanceBootClz;
            return this;
        }

        private Builder setRemittanceBootFunc(String remittanceBootFunc) {
            configurator.remittanceBootFunc = remittanceBootFunc;
            return this;
        }

        private Builder setRemittanceAcceptInstance(String remittanceAcceptInstance) {
            configurator.remittanceAcceptInstance = remittanceAcceptInstance;
            return this;
        }

        private Builder setRemittanceAcceptFunc(String remittanceAcceptFunc) {
            configurator.remittanceAcceptFunc = remittanceAcceptFunc;
            return this;
        }

        private Builder setExitRoomInvokeParamsClz(String exitRoomInvokeParamsClz) {
            configurator.exitRoomInvokeParamsClz = exitRoomInvokeParamsClz;
            return this;
        }

        private Builder setExitRoomInvokeClz(String exitRoomInvokeClz) {
            configurator.exitRoomInvokeClz = exitRoomInvokeClz;
            return this;
        }

        private Builder setExitRoomInvokeFunc(String exitRoomInvokeFunc) {
            configurator.exitRoomInvokeFunc = exitRoomInvokeFunc;
            return this;
        }

        private Builder setExitRoomGetInvokeFunc(String exitRoomGetInvokeFunc) {
            configurator.exitRoomGetInvokeFunc = exitRoomGetInvokeFunc;
            return this;
        }

        private Builder setExitRoomRefreshUIEntityClz(String exitRoomRefreshUIEntity) {
            configurator.exitRoomRefreshUIEntityClz = exitRoomRefreshUIEntity;
            return this;
        }

        private Builder setExitRoomRefreshUIFunc(String exitRoomRefreshUIFunc) {
            configurator.exitRoomRefreshUIFunc = exitRoomRefreshUIFunc;
            return this;
        }

        private Builder setExitRoomBootClz(String exitRoomBootClz) {
            configurator.exitRoomBootClz = exitRoomBootClz;
            return this;
        }

        private Builder setExitRoomBootFunc1(String exitRoomBootFunc1) {
            configurator.exitRoomBootFunc1 = exitRoomBootFunc1;
            return this;
        }

        private Builder setExitRoomBootFunc2(String exitRoomBootFunc2) {
            configurator.exitRoomBootFunc2 = exitRoomBootFunc2;
            return this;
        }

        private Builder setExitRoomFunc(String exitRoomFunc) {
            configurator.exitRoomFunc = exitRoomFunc;
            return this;
        }

        private Builder setDbClz(String dbClz) {
            configurator.dbClz = dbClz;
            return this;
        }

        private Builder setDbOpenFunc(String dbOpenFunc) {
            configurator.dbOpenFunc = dbOpenFunc;
            return this;
        }

        private Builder setDbCipherClz(String dbCipherClz) {
            configurator.dbCipherClz = dbCipherClz;
            return this;
        }

        private Builder setDbCursorFactoryClz(String dbCursorFactoryClz) {
            configurator.dbCursorFactoryClz = dbCursorFactoryClz;
            return this;
        }

        private Builder setDbErrorHandlerClz(String dbErrorHandlerClz) {
            configurator.dbErrorHandlerClz = dbErrorHandlerClz;
            return this;
        }

        private Builder setDbInsertFunc(String dbInsertFunc) {
            configurator.dbInsertFunc = dbInsertFunc;
            return this;
        }

        private Builder setDbUpdateFunc(String dbUpdateFunc) {
            configurator.dbUpdateFunc = dbUpdateFunc;
            return this;
        }

        private Builder setDbDeleteFunc(String dbDeleteFunc) {
            configurator.dbDeleteFunc = dbDeleteFunc;
            return this;
        }

        private Builder setAtoneEntityClz(String atoneEntityClz) {
            configurator.atoneEntityClz = atoneEntityClz;
            return this;
        }

        private Builder setAtoneBootClz(String atoneBootClz) {
            configurator.atoneBootClz = atoneBootClz;
            return this;
        }

        private Builder setAtoneBootFunc(String atoneBootFunc) {
            configurator.atoneBootFunc = atoneBootFunc;
            return this;
        }

        private Builder setAtoneSendFunc(String atoneSendFunc) {
            configurator.atoneSendFunc = atoneSendFunc;
            return this;
        }


        private Configurator create() {
            return configurator;
        }

    }

}
