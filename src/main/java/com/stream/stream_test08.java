package com.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class stream_test08 {
    public static void main(String[] args) {
        String[] arr1 = { "a", "b", "c", "d" };
        String[] arr2 = { "d", "e", "f", "g" };
        Stream<String> arr11 = Stream.of(arr1);
        Stream<String> arr21 = Stream.of(arr2);
        List<String> collect = Stream.concat(arr11, arr21).distinct().collect(Collectors.toList());
        System.out.println(collect);
        List<Integer> collect1 = Stream.iterate(1, x -> x + 2).limit(10).collect(Collectors.toList());
        System.out.println(collect1);

        List<Integer> collect2 = Stream.iterate(1, x -> x + 2).skip(1).limit(5).collect(Collectors.toList());
        System.out.println(collect2);
    }
}
