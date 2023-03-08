package com.stream;

import com.item.Person;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class stream_test01 {


    public static void main(String[] args) {
//        List<String> list = Arrays.asList("a", "b", "c");
//        //创建一个顺序流  使用集合创建流
//        Stream<String> stream = list.stream();
//        //创建一个并行流
//        Stream<String> parallelStream = list.parallelStream();
//        int[] array = {1,3,5,6,8};
//        //使用数组创建流
//        IntStream stream1 = Arrays.stream(array);
//        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);
//        Stream<Integer> stream2 = Stream.iterate(0, (x) -> x + 3).limit(4);
//        stream2.forEach(System.out::println);
//        Stream<Double> stream3 = Stream.generate(Math::random).limit(3);
//        stream3.forEach(System.out::println);
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, "male", "New York"));
        personList.add(new Person("Jack", 7000, "male", "Washington"));
        personList.add(new Person("Lily", 7800, "female", "Washington"));
        personList.add(new Person("Anni", 8200, "female", "New York"));
        personList.add(new Person("Owen", 9500, "male", "New York"));
        personList.add(new Person("Alisa", 7900, "female", "New York"));
//        List<String> filterList = personList.parallelStream().filter(x -> x.getSalary() > 8000).map(Person::getName).collect(Collectors.toList());
//        System.out.println("薪资高于8000美元的员工:" + filterList);

//        List<String> list = Arrays.asList("adnm", "admmt", "pot", "xbangd", "weoujgsd");
//        Optional<String> max = list.stream().max(Comparator.comparing(String::length));
//        System.out.println("最长的字符串:" + max.get());

//        Optional<Person> max = personList.stream().max(Comparator.comparingInt(Person::getSalary));
//        System.out.println("员工薪资最大值：" + max.get().getSalary());
        //计算Integer集合中大于6的元素的个数。
//        List<Integer> list = Arrays.asList(7, 6, 4, 8, 2, 11, 9);
//        long count = list.stream().filter(x -> x > 6).count();
//        System.out.println("list中大于6的元素个数:" + count);
        /*映射，可以将一个流的元素按照一定的映射规则映射到另一个流中。分为map和flatMap：
        map：接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
        flatMap：接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流。*/
        //英文字符串数组的元素全部改为大写。整数数组每个元素+3
//        String[] strArr = { "abcd", "bcdd", "defde", "fTr" };
//        List<String> strList = Arrays.stream(strArr).map(String::toUpperCase).collect(Collectors.toList());
//        List<Integer> intList = Arrays.asList(1, 3, 5, 7, 9, 11);
//        List<Integer> intListNew = intList.stream().map(x -> x + 3).collect(Collectors.toList());
//        System.out.println("每个元素大写:" + strList);
//        System.out.println("每个元素+3" + intListNew);

        //不改变原来员工集合的方式
//        List<Person> personListNew = personList.stream().map(person -> {
//            Person personNew = new Person(person.getName(), 0, 0, null, null);
//            personNew.setSalary(person.getSalary() + 10000);
//            return personNew;
//        }).collect(Collectors.toList());
//        System.out.println("一次改动前：" + personList.get(0).getName() + "-->" + personList.get(0).getSalary());
//        System.out.println("一次改动后：" + personListNew.get(0).getName() + "-->" + personListNew.get(0).getSalary());


    }

}
