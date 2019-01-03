package com.yuhaowin.lambda;

import java.util.function.Consumer;
import java.util.function.DoubleSupplier;
import java.util.function.IntBinaryOperator;

/**
 * lambda表达式的语法由参数列表、箭头符号->和函数体组成。函数体既可以是一个表达式，也可以是一个语句块：
 *
 * 表达式：表达式会被执行然后返回执行结果。
 * 语句块：语句块中的语句会被依次执行，就像方法中的语句一样——
 * return语句会把控制权交给匿名方法的调用者
 * break和continue只能在循环中使用
 * 如果函数体有返回值，那么函数体内部的每一条路径都必须返回值
 */
public class Test {
    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("Hello World!");
        }).start();

        IntBinaryOperator intBinaryOperator = (int x, int y) -> {return x + y;};
        int result = intBinaryOperator.applyAsInt(7, 8);
        System.out.println(result);
        DoubleSupplier doubleSupplier = () -> 42;
        double asDouble = doubleSupplier.getAsDouble();
        System.out.println(asDouble);
        Consumer<String> greeter = (String s) -> System.out.println("Hello, " + s);
        greeter.accept("你好");
    }
}
