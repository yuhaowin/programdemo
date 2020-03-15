package com.yuhaowin.lock;

import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {

    static Thread t1 = null, t2 = null;

    public static void main(String[] args) {
        char[] chars1 = "1234567".toCharArray();
        char[] chars2 = "ABCDEFG".toCharArray();

        t1 = new Thread(() -> {
            for (char c : chars1) {
                System.out.print(c);
                LockSupport.unpark(t2); //叫醒 t2 线程
                LockSupport.park();     //当前线程阻塞
            }
        });

        t2 = new Thread(() -> {
            for (char c : chars2) {
                LockSupport.park();     //当前线程阻塞
                System.out.print(c);
                LockSupport.unpark(t1); //叫醒 t1 线程
            }
        });

        t1.start();
        t2.start();
    }
}
