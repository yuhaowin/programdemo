package com.yuhaowin.annotation;


import com.yuhaowin.annotation.excelannotation.ExcelMappingAction;

public class Test {

    public static void main(String[] args) {

        String[] excelTitles = ExcelMappingAction.handle(User.class).getExcelTitle();
        String[] pojoAttributes = ExcelMappingAction.handle(User.class).getPojoAttribute();

        for (int i = 0; i < excelTitles.length; i++) {
            System.out.println("Excel标题: " + excelTitles[i] + "  类属性: " + pojoAttributes[i]);
        }
    }
}
