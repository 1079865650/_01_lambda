package com.stream;

import com.item.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class stream_test07 {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Sherry", 9000, 24, "female", "New York"));
        personList.add(new Person("Tom", 8900, 22, "male", "Washington"));
        personList.add(new Person("Jack", 9000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 8800, 26, "male", "New York"));
        personList.add(new Person("Alisa", 9000, 26, "female", "New York"));

        List<String> collect = personList.stream().sorted(Comparator.comparing(Person::getSalary)).map(Person::getName).collect(Collectors.toList());
        System.out.println(collect);
        List<String> collect1 = personList.stream().sorted(Comparator.comparing(Person::getSalary).reversed()).map(Person::getName).collect(Collectors.toList());
        System.out.println(collect1);
        // 先按工资再按年龄升序排序
        List<String> collect2 = personList.stream().sorted(Comparator.comparing(Person::getSalary).thenComparing(Person::getAge)).map(Person::getName).collect(Collectors.toList());
        System.out.println(collect2);
        // 先按工资再按安林自定义排序

        List<String> collect3 = personList.stream().sorted((p1, p2) -> {
            if (p1.getSalary() == p2.getSalary()) {
                return p2.getAge() - p1.getAge();
            } else {
                return p2.getSalary() - p1.getSalary();
            }
        }).map(Person::getName).collect(Collectors.toList());
        System.out.println(collect3);
    }

}
