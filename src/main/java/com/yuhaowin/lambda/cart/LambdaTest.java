package com.yuhaowin.lambda.cart;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;

public class LambdaTest {

    @Test
    public void filterElectronicsSkus() {
        List<Sku> cartSkuList = CartService.getCartSkuList();

        // 查找购物车中数码类商品
        List<Sku> result =
                CartService.filterElectronicsSkus(cartSkuList);

        System.out.println(
                JSON.toJSONString(result, true));
    }

    @Test
    public void filterSkusByCategory() {
        List<Sku> cartSkuList = CartService.getCartSkuList();

        // 查找购物车中图书类商品集合
        List<Sku> result = CartService.filterSkusByCategory(
                cartSkuList, SkuCategoryEnum.BOOKS);

        System.out.println(JSON.toJSONString(
                result, true));
    }

    @Test
    public void filterSkus1() {
        List<Sku> cartSkuList = CartService.getCartSkuList();

        // 根据商品总价过滤超过2000元的商品列表
        List<Sku> result = CartService.filterSkus(
                cartSkuList, null,
                2000.00, false);

        System.out.println(JSON.toJSONString(
                result, true));
    }

    @Test
    public void filterSkus2() {
        List<Sku> cartSkuList = CartService.getCartSkuList();

        // 过滤商品总价大于2000的商品
        List<Sku> result = CartService.filterSkus(
                cartSkuList, new SkuTotalPricePredicate());

        System.out.println(JSON.toJSONString(
                result, true));
    }

    @Test
    public void filterSkus3() {
        List<Sku> cartSkuList = CartService.getCartSkuList();

        // 过滤商品单价大于1000的商品
        List<Sku> result = CartService.filterSkus(
                cartSkuList, new SkuPredicate() {
                    @Override
                    public boolean test(Sku sku) {
                        return sku.getSkuPrice() > 1000;
                    }
                });

        System.out.println(JSON.toJSONString(
                result, true));
    }

    @Test
    public void filterSkus4() {
        List<Sku> cartSkuList = CartService.getCartSkuList();

        SkuPredicate filter = sku1 -> sku1.getSkuPrice() > 1000;

        for (Sku sku : cartSkuList) {
            boolean test = filter.test(sku);
            System.out.println(test);
        }

//        // 过滤商品单价大于1000的商品
//        List<Sku> result = CartService.filterSkus(
//                cartSkuList,
//                (Sku sku) -> sku.getSkuPrice() > 1000);
//
//        System.out.println(JSON.toJSONString(
//                result, true));
    }

    @Test
    public void filterSkus5() {
        List<Sku> cartSkuList = CartService.getCartSkuList();

        // 过滤商品单价大于1000的商品
        List<Sku> result = CartService.filterSkus(
                cartSkuList,
                new Predicate() {
                    @Override
                    public boolean test(Object o) {
                        return ((Sku) o).getSkuPrice() > 1000;
                    }
                }
        );

        System.out.println(JSON.toJSONString(
                result, true));
    }

    @Test
    public void filterSkus6() {
        List<Sku> cartSkuList = CartService.getCartSkuList();

        // 过滤商品单价大于1000的商品
        List<Sku> result = CartService.filterSkus(
                cartSkuList,
                (Object o) -> ((Sku) o).getSkuPrice() > 1000
        );

        System.out.println(JSON.toJSONString(
                result, true));
    }

    // ------------------------------------------------------------------------------------------------------------------------------------

    @Test
    public void test1() {
        Runnable runnable = () -> System.out.println("Hello world");
        runnable.run();
    }


    @Test
    public void test2() {
        Consumer consumer = name -> System.out.println(name);
        consumer.accept("yuhao");
    }

    @Test
    public void test3() {
        Runnable runnable = () -> {
            System.out.print("Hello");
            System.out.print("world");
        };
        runnable.run();
    }

    @Test
    public void test4() {
        IntBinaryOperator operator = (x, y) -> x + y;
        int sum = operator.applyAsInt(1, 2);
        System.out.println(sum);
    }

    @Test
    public void test5() {
        Consumer<String> consumer = str -> Integer.parseInt(str);
        consumer.accept("100");
        Consumer<String> consumer1 = Integer::parseInt;
        consumer1.accept("100");
    }

    @Test
    public void test6() {
        //(args) -> args.instanceMethod();
        //ClassName::instanceMethod;
        Consumer<Integer> consumer = integer -> integer.intValue();
        consumer.accept(new Integer(100));
        Consumer<Integer>  consumer1 = Integer::intValue;
        consumer1.accept(new Integer(100));
    }

    @Test
    public void test7() {
        //(args) -> instance.instanceMethod();
        //instance::instanceMethod;
        StringBuilder builder = new StringBuilder();
        Consumer<String> consumer = str -> builder.append(str);
        consumer.accept("100");
        Consumer<String> consumer1 = builder::append;
        consumer1.accept("100");

        Thread thread = new Thread(() -> {

        });
    }
}
