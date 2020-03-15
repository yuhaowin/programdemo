package com.yuhaowin.tuniu;

import java.util.ArrayList;

public class Test6 {
    public static void main(String[] args) {
//        ArrayList list = new ArrayList();
//        list.add("余浩22");
//        for (int i = 0; i < 10; i++) {
//            list.add(i+"");
//        }
//        list.add("余浩");
//        System.out.println(list.size());


        int oldCapacity = Integer.MAX_VALUE - 16;
        System.out.println(oldCapacity);
        int minCapacity =  - 15;
        int maxSize = Integer.MAX_VALUE - 8;
        int newCapacity = oldCapacity + (oldCapacity >> 1);

        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        if (newCapacity - maxSize > 0)
            newCapacity = hugeCapacity(minCapacity);
        // minCapacity is usually close to size, so this is a win:
        System.out.println(newCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > Integer.MAX_VALUE - 8) ?
                Integer.MAX_VALUE :
                Integer.MAX_VALUE - 8;
    }
}
