package com.yuhaowin.annotation;

import com.yuhaowin.annotation.excelannotation.ExcelMapping;

public class User {

    @ExcelMapping("姓名")
    private String name;

    @ExcelMapping("年龄")
    private Integer age;

    @ExcelMapping("生日")
    private String birthday;
}
