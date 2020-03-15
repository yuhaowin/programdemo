package com.yuhaowin.lock;

public class SyncWaitNotify {

    static Thread t1 = null, t2 = null;

    public static void main(String[] args) {
        Object o = new Object();
        char[] chars1 = "1234567".toCharArray();
        char[] chars2 = "ABCDEFG".toCharArray();

        t1 = new Thread(() -> {
            synchronized (o) {
                for (char c : chars1) {
                    System.out.print(c);
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
            synchronized (o) {
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
