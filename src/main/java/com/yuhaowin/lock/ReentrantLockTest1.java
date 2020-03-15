package com.yuhaowin.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest1 {

    static Thread t1 = null, t2 = null;


    public static void main(String[] args) {
        char[] chars1 = "1234567".toCharArray();
        char[] chars2 = "ABCDEFG".toCharArray();

        Lock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();

        t1 = new Thread(() -> {
            lock.lock();  //相当于是 synchronized
            try {
                for (char c : chars1) {
                    System.out.print(c);
                    condition2.signal(); //相当于是 o.notify()
                    condition1.await();  //相当于是 o.wait()
                }
                condition2.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        t2 = new Thread(() -> {
            lock.lock();
            try {
                for (char c : chars2) {
                    System.out.print(c);
                    condition1.signal();
                    condition2.await();
                }
                condition1.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        t1.start();
        t2.start();
    }
}
