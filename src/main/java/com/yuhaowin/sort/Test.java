package com.yuhaowin.sort;

import java.util.*;

public class Test {
    public static void main(String[] args) {

        List<Map<String,String>> list = new ArrayList<>();

        // v1
        Comparator<Map> comparator = (p1, p2) -> {
            String time1 = (String) p1.get("datatime");
            String time2 = (String) p2.get("datatime");
            return time1.compareTo(time2);
        };
        Collections.sort(list, comparator);

        // v2
        Collections.sort(list, (o1, o2) -> {
            String time1 = o1.get("datatime");
            String time2 = o2.get("datatime");
            return time2.compareTo(time1);
        });
        Comparator<Person> comparator1 = Comparator.comparing(Person::getName);
        Person p1 = new Person("John");
        Person p2 = new Person("Alice");
        comparator1.compare(p1, p2);             // > 0
        comparator1.reversed().compare(p1, p2);  // < 0

        List<Person> list1 = new ArrayList<>();
        Collections.sort(list1, Comparator.comparing(Person::getName));
    }
}
