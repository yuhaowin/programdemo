package com.yuhaowin.lock;

import java.util.concurrent.CountDownLatch;

public class SyncWaitNotify1 {

    static Thread t1 = null, t2 = null;

    static volatile boolean T1Start = false;

    static CountDownLatch latch = new CountDownLatch(1);


    public static void main(String[] args) {
        Object o = new Object();
        char[] chars1 = "1234567".toCharArray();
        char[] chars2 = "ABCDEFG".toCharArray();

        t1 = new Thread(() -> {
            synchronized (o) {
                for (char c : chars1) {
                    System.out.print(c);
                    //T1Start = true;
                    latch.countDown();
                    try {
                        o.notify();
                        o.wait();//自己阻塞，让出锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify(); //必须有这个句话，否则程序无法结束
            }
        });

        t2 = new Thread(() -> {
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o) {
//                while (!T1Start) {
//                    try {
//                        o.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
                for (char c : chars2) {
                    System.out.print(c);
                    try {
                        o.notify();
                        o.wait(); //自己阻塞，让出锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();  //必须有这个句话，否则程序无法结束
            }
        });

        t1.start();
        t2.start();
    }
}
