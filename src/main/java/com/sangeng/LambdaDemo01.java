package com.sangeng;

import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;

public class LambdaDemo01 {
    public static void main(String[] args) {
//        new Thread(() -> {System.out.println("新线程中run方法被执行了");}).start();  //创建了线程用start()方法启动
//        int i = calculateNum((int left,int right) -> {  //重写抽象发放已经写死了 方法是谁不重要 方法名也不重要 只要传入参数和方法内容
//                return left + right;
//            });
//        System.out.println(i);
//
//        int a = calculateNum((left, right) -> left+right); //参数类型也不用定义 以为抽象方法里面已经定义好了 注意传参顺序 返回的结果就是运算的结果 所以也不用传return
//        System.out.println(i);

//        printNum((int value) -> {
//            return value%2==0;
//        });

        Integer result = typeConver((String s) -> {
            return Integer.valueOf(s);
        });
        System.out.println(result);

        String s =typeConver((String str) -> {
            return str + "三更";
        });
        System.out.println(s);
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

    public static void foreachArr(IntConsumer consumer){
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        for (int i : arr){
            consumer.accept(i);
        }
    }


}
