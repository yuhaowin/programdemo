package com.yuhaowin.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

    static Thread t1 = null, t2 = null;


    public static void main(String[] args) {
        char[] chars1 = "1234567".toCharArray();
        char[] chars2 = "ABCDEFG".toCharArray();

        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition(); // 相当于是一个队列

        t1 = new Thread(() -> {
            lock.lock();  //相当于是 synchronized
            try {
                for (char c : chars1) {
                    System.out.print(c);
                    condition.signal(); //相当于是 o.notify()
                    condition.await();  //相当于是 o.wait()
                }
                condition.signal();
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
                    condition.signal();
                    condition.await();
                }
                condition.signal();
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
