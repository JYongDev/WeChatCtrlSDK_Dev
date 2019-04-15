package com.developer.jyong.wechatctrlsdk.inject.tool;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JYong on 2019/2/18.
 */

 public class XmlParse {


    public static Node getChildNode(NodeList list, String target) {
        Node childList = null;
        if (target == null || target.length() <= 0) {
            return null;
        }

        if (list == null || list.getLength() <= 0) {
            return null;
        }


        for (int i = 0; i < list.getLength(); i++) {
            String nodeName = list.item(i).getNodeName();
            if (nodeName.equals(target)) {
                childList = list.item(i);
            }
        }
        return childList;
    }

    public static List<Node> getChildNodes(NodeList list, String target) {
        List<Node> childList ;
        if (target == null || target.length() <= 0) {
            return null;
        }

        if (list == null || list.getLength() <= 0) {
            return null;
        }

        childList = new ArrayList<>();

        for (int i = 0; i < list.getLength(); i++) {
            String nodeName = list.item(i).getNodeName();
            if (nodeName.equals(target)) {
                childList.add(list.item(i));
            }
        }
        return childList;
    }

    public static NodeList getChildNodeList(NodeList list, String target) {
        NodeList childList = null;
        if (target == null || target.length() <= 0) {
            return null;
        }

        if (list == null || list.getLength() <= 0) {
            return null;
        }

        for (int i = 0; i < list.getLength(); i++) {
            String nodeName = list.item(i).getNodeName();
            if (nodeName.equals(target)) {
                childList = list.item(i).getChildNodes();
            }
        }
        return childList;
    }

    public static List<NodeList> getChildNodeLists(NodeList list, String target) {
        List<NodeList> childList ;
        if (target == null || target.length() <= 0) {
            return null;
        }

        if (list == null || list.getLength() <= 0) {
            return null;
        }

        childList = new ArrayList<>();

        for (int i = 0; i < list.getLength(); i++) {
            String nodeName = list.item(i).getNodeName();
            if (nodeName.equals(target)) {
                childList.add(list.item(i).getChildNodes());
            }
        }
        return childList;
    }

    public  static String getTextContent(NodeList list, String target) {
        String content = "";
        if (target == null || target.length() <= 0) {
            return null;
        }

        if (list == null || list.getLength() <= 0) {
            return null;
        }

        for (int i = 0; i < list.getLength(); i++) {
            String nodeName = list.item(i).getNodeName();
            if (nodeName.equals(target)) {
                content = list.item(i).getTextContent();
            }
        }
        return content;
    }
}
