package com.yuhaowin.annotation;

import java.lang.annotation.*;

/**
 * 标识数据库表
 */

/**
 * 元注解:用于描述注解的注解
 * java中提供4个元注解
 * 1. @Target 描述注解的使用范围:可选范围在ElementType枚举中
 * 2. @Retention 描述注解的生命周期:可选范围在RetentionPolicy枚举中,有三个范围.
 * 3. @Document 用于指定javac生成API时显示该注解信息。
 * 4. @Inherited 标明该注解可以由子类继承，即子类可以继承父类的注解。
 */
@Target({ElementType.TYPE,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Table {

    String value() default "";

    String[] values() default {};

}


