package com.yuhaowin.webservice.chudian;

import com.yuhaowin.webservice.messagetemplate.IWeChatPushService;
import com.yuhaowin.webservice.messagetemplate.IWeChatPushServicePortType;

public class Test {

    public static void main(String[] args) {
        IWeChatPushService iWeChatPushService = new IWeChatPushService();
        IWeChatPushServicePortType iWeChatPushServicePort = iWeChatPushService.getIWeChatPushServicePort();


        TouchPointExbtServiceImplService touchPointExbtServiceImplService = new TouchPointExbtServiceImplService();

        TouchPointExbtService port = touchPointExbtServiceImplService.getTouchPointExbtServiceImplPort();

//        String exchange = port.exchange("{\"serviceCode\":\"IS101\",\"channelCode\":15," +
//                "\"userPhone\":\"18120103221\"," +
//                "\"eventCode\":\"1367\"," +
//                "\"areaCode\":\"025\"," +
//                "\"extend\":\"\"" +
//                "}");

        String exchange1 = port.exchange("{\"touchId\": \"p_156\"," +
                "\"channelCode\": \"15\"," +
                "\"clickTime\": \"1523352912000\"," +
                "\"senceId\": \"100102\"," +
                "\"serviceCode\": \"IS102\"," +
                "\"userPhone\": \"18120103221\"," +
                "\"materielId\": \"1267\"" +
                "}");

        System.out.println(exchange1);

    }
}
