package com.yuhaowin.messageformat;

import java.text.MessageFormat;

public class TestMessageFormat {

    public static void test() {
        String data[] = {
                "erere",
                "hthth",
                "充值送翼支付红包",
                "已确认",
                "test"
        };
        String format = "'{'\"accNbr\":\"{2}\"'}'";
        String result = MessageFormat.format(format, data);
        System.out.println(result);
    }


    public static void mytest(){
        String[] data = {"yuhao","eric","jack","mark"};

        data[0] = "余浩";

        for (int i=0;i<data.length;i++){
            System.out.println(data[i]);
        }
   }

    public static void main(String[] args) {
        TestMessageFormat.mytest();
    }
}
