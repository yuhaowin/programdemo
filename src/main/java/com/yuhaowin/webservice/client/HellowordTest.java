package com.yuhaowin.webservice.client;

public class HellowordTest {

    public static void main(String[] args) {
        HelloWordWSService helloWordWSService = new HelloWordWSService();
        HelloWordWS helloWordWSPort = helloWordWSService.getHelloWordWSPort();
        String result = helloWordWSPort.sayHello("你好啊,余浩");
        System.out.println(result);
    }
}
