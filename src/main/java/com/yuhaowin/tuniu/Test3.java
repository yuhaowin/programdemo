package com.yuhaowin.tuniu;

import java.util.*;

public class Test3 {
    public void print(Collection<?> coll){
        System.out.println("This is collection");
    }
    public void print(ArrayList<?> coll){
        System.out.println("This is ArrayList");
    }
    public void print(Set<?> coll){
        System.out.println("This is Set");
    }
    public void print(HashSet<?> coll){
        System.out.println("This is HashSet");
    }

    public static void main(String[] args) {
        Test3 test3 = new Test3();
        Collection<?> c1 = new ArrayList<>(Arrays.asList("one","two","three"));
        test3.print(c1);
        Set<?> c2 = new HashSet<>(Arrays.asList("one","two","three"));
        test3.print(c2);

        HashSet<?> c3= new HashSet<>(Arrays.asList("one","two","three"));
        test3.print(c3);

        HashSet<?> c4;
        //test3.print(c4);
    }
}


//  https://blog.csdn.net/u012198209/article/details/80064049