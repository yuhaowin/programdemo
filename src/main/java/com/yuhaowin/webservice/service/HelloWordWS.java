package com.yuhaowin.webservice.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class HelloWordWS {

    @WebMethod
    public String sayHello(String content){
        System.out.println("你好");
        return "你也好!";
    }
}
