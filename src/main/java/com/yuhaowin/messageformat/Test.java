package com.yuhaowin.messageformat;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Test {

    public static void main(String[] args) {

        List<String> str1 = Arrays.asList(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"});
        List<String> str2 = Arrays.asList(new String[]{"1", "2", "3"});

//        for (String item : str1){
//            if (!str2.contains(item)){
//                System.out.println("删除:" + item);
//            }
//        }

        List<String> intersection = str1.stream().filter(item -> str2.contains(item)).collect(toList());
        System.out.println("---得到交集 intersection---");
        intersection.parallelStream().forEach(System.out :: println);

    }
}
