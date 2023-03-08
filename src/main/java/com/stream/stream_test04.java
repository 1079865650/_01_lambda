package com.stream;

import com.item.Person;

import java.util.*;
import java.util.stream.Collectors;

public class stream_test04 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 6, 3, 4, 6, 7, 9, 6, 20);
        List<Integer> collect = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        // collect将流中的数据重新归集到新的集合里面 不会改变之前的集合
        System.out.println(collect);
        Set<Integer> listNew = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toSet());
        System.out.println(listNew);

        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 24, "female", "New York"));

        Map<String, Person> collect1 = personList.stream().filter(p -> p.getSalary() > 8000).collect(Collectors.toMap(Person::getName, p -> p));
        System.out.println(collect1);
        System.out.println(collect1.keySet());
        for (String s : collect1.keySet()) {
            System.out.println(collect1.get(s));
        }


    }
}
