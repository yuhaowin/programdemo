package com.yuhaowin.lock;

public class CASTest {
    enum ReadToRun {
        T1, T2
    }

    static Thread t1 = null, t2 = null;
    static volatile ReadToRun r = ReadToRun.T1;

    public static void main(String[] args) {
        char[] chars1 = "1234567".toCharArray();
        char[] chars2 = "ABCDEFG".toCharArray();

        t1 = new Thread(() -> {
            for (char c : chars1) {
                while (r != ReadToRun.T1) {
                    // 空转，自旋，无锁
                    //System.out.println("T1 等待锁");
                }
                System.out.print(c);
                r = ReadToRun.T2;
            }
        });

        t2 = new Thread(() -> {
            for (char c : chars2) {
                while (r != ReadToRun.T2) {
                    // 空转，自旋，无锁
                    //System.out.println("T2 等待锁");
                }
                System.out.print(c);
                r = ReadToRun.T1;
            }
        });

        t1.start();
        t2.start();
    }
}
