package com.stream;

import com.item.Person;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class stream_test05 {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));

        Long collect = personList.stream().collect(Collectors.counting());
        System.out.println(collect);
        Double collect1 = personList.stream().collect(Collectors.averagingDouble(Person::getSalary));
        System.out.println(collect1);
        Optional<Integer> collect2 = personList.stream().map(Person::getSalary).collect(Collectors.maxBy(Integer::compare));
        System.out.println(collect2);
        DoubleSummaryStatistics collect3 = personList.stream().collect(Collectors.summarizingDouble(Person::getSalary));

    }
}
