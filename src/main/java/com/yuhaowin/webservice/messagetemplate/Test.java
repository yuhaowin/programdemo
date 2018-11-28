package com.yuhaowin.webservice.messagetemplate;

public class Test {

    public static void main(String[] args) {
        IWeChatPushService iWeChatPushService = new IWeChatPushService();
        IWeChatPushServicePortType iWeChatPushServicePort = iWeChatPushService.getIWeChatPushServicePort();
        String push = iWeChatPushServicePort.weChatMsgPush("{\n" +
                "    \"first\": \"\",\n" +
                "    \"phone\": \"13155022383\",\n" +
                "    \"accountType\": \"充值号码\",\n" +
                "    \"account\": \"13155022383\",\n" +
                "    \"amount\": \"10011元\",\n" +
                "    \"result\": \"充值成功\",\n" +
                "    \"tempStatus\": \"1\",\n" +
                "    \"source\": \"JF\",\n" +
                "    \"remark\": \"\",\n" +
                "    \"uuid\": \"11216456075\",\n" +
                "    \"tempTypeId\": \"6\",\n" +
                "    \"url\": \"\"\n" +
                "}");

        System.out.println(push);

    }
}
