package com.yuhaowin.messageformat;

import java.util.Arrays;
import java.util.List;

public class StringFormat {
    public static void main(String[] args) {

        String template = "openids:%s";

        List<String> openids = Arrays.asList(new String[]{"123","345","789"});

        //string.Concat("'", string.Join("','", openids.ToArray()), "'");

        String string = String.format(template, openids);

        System.out.println(string);
    }
}
