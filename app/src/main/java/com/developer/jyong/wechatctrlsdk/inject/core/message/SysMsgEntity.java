package com.developer.jyong.wechatctrlsdk.inject.core.message;


import com.developer.jyong.wechatctrlsdk.inject.tool.XmlParse;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by JYong on 2019/2/18.
 */

public class SysMsgEntity {

    private static final String TAG = "xposed";


    private String templateStr = "";
    private List<Data> datas = null;


    private static class Data {
        private String name = "";
        private String value = "";

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "name='" + name + '\'' +
                    ", value='" + value + '\'' +
                    '}';
        }
    }

    public String getTemplateStr() {
        return templateStr;
    }

    public void setTemplateStr(String templateStr) {
        this.templateStr = templateStr;
    }

    public List<Data> getDatas() {
        return datas;
    }

    public void setDatas(List<Data> datas) {
        this.datas = datas;
    }


    public static SysMsgEntity toEntity(String xml) {
        return parse(xml);
    }

    private static SysMsgEntity parse(String xml) {

        SysMsgEntity entity = new SysMsgEntity();

        if (xml == null || xml.length() <= 0) {
            return null;
        }

        //去除格式化
        xml = xml.replaceAll("\t", "");
        xml = xml.replaceAll("\n", "");

        try {

            Document document = DocumentBuilderFactory
                    .newInstance()
                    .newDocumentBuilder()
                    .parse(new ByteArrayInputStream(xml.getBytes("UTF-8")));

            if (document == null) {
                return null;
            }

            //  link
            NodeList link = document.getElementsByTagName("link");
            if (link == null || link.getLength() <= 0) {
                return null;
            }

            List<Data> datas = new ArrayList<>();

            for (int t = 0; t < link.getLength(); t++) {
                Data data = new Data();

                //  attributes
                for (int n = 0; n < link.item(t).getAttributes().getLength(); n++) {
                    if (link.item(t).getAttributes().item(n).getNodeName().equals("name")) {
                        data.setName(link.item(t).getAttributes().item(n).getNodeValue());
                    }
                }

                //  child node
                NodeList memberList = XmlParse.getChildNodeList(link.item(t).getChildNodes(), "memberlist");
                if (memberList != null) {

                    List<NodeList> members = XmlParse.getChildNodeLists(memberList, "member");

                    if (members != null) {
                        StringBuilder temp = new StringBuilder();
                        for (int i = 0; i < members.size(); i++) {
                            NodeList nodeList = members.get(i);
                            String username = XmlParse.getTextContent(nodeList, "username");
                            temp.append(username);
                            temp.append(" ");
                        }
                        data.setValue(temp.toString());
                    }
                }

                //  plain
                Node plain = XmlParse.getChildNode(link.item(t).getChildNodes(), "plain");
                if (plain != null) {
                    data.setValue(plain.getTextContent());
                }
                datas.add(data);
            }

            entity.setDatas(datas);

            //  template string
            NodeList template = document.getElementsByTagName("template");
            if (template != null) {
                String temp = XmlParse.getTextContent(template, "template");
                temp = temp.replace("\"$", " ");
                temp = temp.replace("$\"", " ");
                //  群名称过滤特殊字符
                temp = temp.replace("“$", " ");
                temp = temp.replace("$”", " ");

                if (datas.size() > 0) {
                    for (int i = 0; i < datas.size(); i++) {
                        if (temp.contains(datas.get(i).getName())) {
                            temp = temp.replace(datas.get(i).getName(), datas.get(i).getValue());
                        }
                    }
                }
                entity.setTemplateStr(temp);
            }

        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
            return null;
        }
        return entity;
    }

}
