package com.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class stream_test02 {
    public static void main(String[] args) {
//        List<String> list = Arrays.asList("m,k,l,a", "1,3,5,7");
//        List<String> collect = list.stream().flatMap(s -> {
//            // 将每个元素转化长一个stream
//            String[] split = s.split(","); // string10 split arrays
//            Stream<String> s2 = Arrays.stream(split); //Stream<String> stream  what to turn into flow
//            return s2;
//        }).collect(Collectors.toList());
//        System.out.println(list);
//        System.out.println(list.size()); //list.size()=2
//        System.out.println(collect);
        List<String> stringList = Arrays.asList("mu", "CSDN", "hello",
                "world", "quickly");  // String::length string's method
        stringList.stream().mapToInt(String::length).forEach(System.out::println);
        System.out.println(stringList);
        // 将int集合的每个元素增加1000
        List<Integer> integerList = Arrays.asList(4, 5, 2, 1, 6, 3);
        integerList.stream().mapToInt(x -> x + 1000).forEach(System.out::println);  //怎么改变后又放回呢
        System.out.println(integerList);

        List<Double> doubleList = Arrays.asList(1.0, 2.0, 3.0, 4.0, 2.0);
        //maotoDouble 就可以求和了
        double asDouble = doubleList.stream().mapToDouble(Number::doubleValue).average().getAsDouble();
        double sum = doubleList.stream().mapToDouble(Number::doubleValue).sum();
        double max = doubleList.stream().mapToDouble(Number::doubleValue).max().getAsDouble();
        System.out.println(asDouble);
        System.out.println(sum);
        System.out.println(max);

    }
}
