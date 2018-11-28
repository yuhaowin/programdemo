package com.yuhaowin.webservice.service;

import javax.xml.ws.Endpoint;

public class Publish {
    public static void main(String[] args) {
        Object implementor = new HelloWordWS();
        String address = "http://localhost:8989/HelloWorld";     //发布到的地址
        Endpoint publish = Endpoint.publish(address, implementor);
        System.out.println("发布成功");
    }
}
