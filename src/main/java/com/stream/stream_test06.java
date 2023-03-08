package com.stream;

import com.item.Person;

import java.util.*;
import java.util.stream.Collectors;

public class stream_test06 {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, "male", "New York"));
        personList.add(new Person("Jack", 7000, "male", "Washington"));
        personList.add(new Person("Lily", 7800, "female", "Washington"));
        personList.add(new Person("Anni", 8200, "female", "New York"));
        personList.add(new Person("Owen", 9500, "male", "New York"));
        personList.add(new Person("Alisa", 7900, "female", "New York"));

        Map<Boolean, List<Person>> collect = personList.stream().collect(Collectors.partitioningBy(x -> x.getSalary() > 8000));
        // partitioningBy  根据 什么 隔断 divide true and false
        Map<String, Map<String, List<Person>>> collect1 = personList.stream().collect(Collectors.groupingBy(Person::getSex, Collectors.groupingBy(Person::getArea)));

        System.out.println(collect1);  //
        String collect2 = personList.stream().map(p -> p.getName()).collect(Collectors.joining(","));
        System.out.println(collect2);
        List<String> list = Arrays.asList("a", "b", "c");
        String collect3 = list.stream().collect(Collectors.joining("-"));
        System.out.println(collect3);

        Integer collect4 = personList.stream().collect(Collectors.reducing(0, Person::getSalary, (i, j) -> (i + j - 5000)));
        System.out.println(collect4);

        Optional<Integer> reduce = personList.stream().map(Person::getSalary).reduce(Integer::sum);
        System.out.println(reduce);

    }
}
