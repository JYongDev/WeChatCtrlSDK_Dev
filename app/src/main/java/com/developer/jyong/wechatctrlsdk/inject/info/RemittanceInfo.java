package com.developer.jyong.wechatctrlsdk.inject.info;


import android.text.TextUtils;

import org.w3c.dom.NodeList;

import java.io.ByteArrayInputStream;

import javax.xml.parsers.DocumentBuilderFactory;

/**
 * 转账消息实体类
 */
public class RemittanceInfo {

    private final static String WCPAY_INFO = "wcpayinfo";
    private final static String APP_MSG = "appmsg";
    private final static String TRANSCATION_ID = "transcationid";    //
    private final static String TRANSFER_ID = "transferid";       //  转账id
    private final static String INVALID_TIME = "invalidtime";      //  失效时间
    private final static String PAYSUB_TYPE = "paysubtype";       //  转账状态
    private final static String FEE_DESC = "feedesc";          //  金额
    private final static String BEGIN_TRANSFER_TIME = "begintransfertime";  // 开始转账时间

    private String transcationID = "";
    private String transferID = "";
    private String invalidTime = "0";
    private String paysubtype = "";
    private String feedesc = "";
    private String talker = "";
    private String beginTransferTime = "";

    public String getBeginTransferTime() {
        return beginTransferTime;
    }

    public void setBeginTransferTime(String beginTransferTime) {
        this.beginTransferTime = beginTransferTime;
    }

    public String getTalker() {
        return talker;
    }

    public void setTalker(String talker) {
        this.talker = talker;
    }

    public String getPaysubtype() {
        return paysubtype;
    }

    public void setPaysubtype(String paysubtype) {
        this.paysubtype = paysubtype;
    }

    public String getFeedesc() {
        return feedesc;
    }

    public void setFeedesc(String feedesc) {
        this.feedesc = feedesc;
    }

    public String getTranscationID() {
        return transcationID;
    }

    public void setTranscationID(String transcationID) {
        this.transcationID = transcationID;
    }

    public String getTransferID() {
        return transferID;
    }

    public void setTransferID(String transferID) {
        this.transferID = transferID;
    }

    public String getInvalidTime() {
        return invalidTime;
    }

    public void setInvalidTime(String invalidTime) {
        this.invalidTime = invalidTime;
    }


    /**
     * 将消息内容的 xml 转化为实体
     *
     * @param content 转账消息内容 , message content
     * @return result remittance 实体
     */
    public static RemittanceInfo toEntity(String talker, String content) {

        RemittanceInfo remittanceInfo = new RemittanceInfo();

        if (TextUtils.isEmpty(content) || TextUtils.isEmpty(talker)) {
            return null;
        }

        try {
            remittanceInfo.setTalker(talker);

            NodeList node = DocumentBuilderFactory
                    .newInstance()
                    .newDocumentBuilder()
                    .parse(new ByteArrayInputStream(content.getBytes("UTF-8")))
                    .getDocumentElement()
                    .getChildNodes();

            if (node == null) {
                return null;
            }

            NodeList nodeList = getKeyNodeList(WCPAY_INFO, getKeyNodeList(APP_MSG, node));

            if (null == nodeList) {
                return null;
            }

            for (int i = 0; i < nodeList.getLength(); i++) {
                switch (nodeList.item(i).getNodeName()) {
                    case TRANSCATION_ID:
                        remittanceInfo.setTranscationID(nodeList.item(i).getTextContent());
                        break;
                    case TRANSFER_ID:
                        remittanceInfo.setTransferID(nodeList.item(i).getTextContent());
                        break;
                    case FEE_DESC:
                        remittanceInfo.setFeedesc(nodeList.item(i).getTextContent());
                        break;
                    case INVALID_TIME:
                        remittanceInfo.setInvalidTime(nodeList.item(i).getTextContent());
                        break;
                    case PAYSUB_TYPE:
                        remittanceInfo.setPaysubtype(nodeList.item(i).getTextContent());
                        break;
                    case BEGIN_TRANSFER_TIME:
                        remittanceInfo.setBeginTransferTime(nodeList.item(i).getTextContent());
                        break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return remittanceInfo;
    }

    private static NodeList getKeyNodeList(String targetNodeName, NodeList nodeList) {
        NodeList nodes = null;
        if (TextUtils.isEmpty(targetNodeName))
            return null;
        if (null == nodeList)
            return null;

        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i).getNodeName().equals(targetNodeName)) {
                nodes = nodeList.item(i).getChildNodes();
            }
        }
        return nodes;
    }


}
