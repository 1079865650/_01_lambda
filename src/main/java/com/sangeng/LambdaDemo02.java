package com.sangeng;

import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;

public class LambdaDemo02 {
    public static void main(String[] args) {
//        foreachArr(value -> System.out.println(value)); // 参数和方法体  参数和方法体 参数和方法体
//        Integer result = typeConver(s -> Integer.valueOf(s));
//        System.out.println(result);
//        printNum(value -> value%2==0);  // 实现里面的抽象方法

        // 使用这个方法 目的就是调用抽象方法 ，传参加返回即可
        int i = calculateNum((left, right) -> left + right);
        System.out.println(i);
        new Thread(() -> {  // 不需要传参就用 （）
            System.out.println("dasd");
        }).start();
    }

    public static void foreachArr(IntConsumer consumer){
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        for (int i : arr){
            consumer.accept(i);
        }
    }

    public static <R> R typeConver(Function<String,R> function){
        String str = "12345";
        R result = function.apply(str);
        return result;
    }

    public static void printNum(IntPredicate predicate){
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        for(int i : arr){
            if(predicate.test(i)){
                System.out.println(i);
            }
        }
    }
    public static int calculateNum(IntBinaryOperator operator){
        // 调用这个抽象类里面的方法 方法已经被重写了 参数也写定了
        int a = 10;
        int b = 20;
        return operator.applyAsInt(a,b);
    }


}
