package com.yuhaowin.tuniu;

public class Test1 {

    public static int ret(){
        int i =1;
        try {
            int s =1/0;
            return 1;
        }catch (Exception e){
            return 3;
        }finally {
             return i+ 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(Test1.ret());
    }
}


