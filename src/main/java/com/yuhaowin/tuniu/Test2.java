package com.yuhaowin.tuniu;

import java.util.Random;

public class Test2 {

    public static synchronized void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                hello();
            }
        };
        t.start();
        try {
            Thread.sleep(new Random().nextInt(500));
        } catch (InterruptedException e) {

        }
        System.out.print("Three");
    }

    static synchronized void hello() {
        try {
            Thread.sleep(new Random().nextInt(500));
        } catch (InterruptedException e) {
        }
        System.out.print("Hello");
    }
}
