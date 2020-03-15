package com.yuhaowin.tuniu;

public class Test5 {

    public void functionA(){
        String[] p1 = {"a","b"};
        StringBuffer p2 = new StringBuffer("c");
        String p3 = "d";
        functionB(p1,p2,p3);
        System.out.println(p1[0]);
        System.out.println(p2.toString());
        System.out.println(p3);

    }

    public void functionB(String[] p1,StringBuffer p2,String p3){
        p1[0] = "aa";
        p2.append("c");
        System.out.println(p2);
        p2 = new StringBuffer("cccc");
        System.out.println(p2);
        p3 = "dd";
    }

    public static void main(String[] args) {

        new Test5().functionA();

    }

}
