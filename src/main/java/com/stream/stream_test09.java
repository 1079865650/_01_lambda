package com.stream;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class stream_test09 {
    public static void main(String[] args) {
        List<User> userList = getUserList();
        List<User> collect = userList.stream().filter(user -> user.getId() > 6).collect(Collectors.toList());
        System.out.println(collect);
        collect.forEach(System.out::println);
        List<String> collect1 = userList.stream().map(user -> user.getName() + "用户").collect(Collectors.toList());
        collect1.forEach(System.out::println);
        List<String> collect2 = userList.stream().map(User::getAddress).distinct().collect(Collectors.toList());
        collect2.forEach(System.out::println);
        userList.stream().sorted(Comparator.comparing(User::getName).reversed()).collect(Collectors.toList()).forEach(System.out::println);
        userList.stream().limit(5).collect(Collectors.toList()).forEach(System.out::println);
        userList.stream().skip(7).collect(Collectors.toList()).forEach(System.out::println);
        userList.stream().peek(user -> user.setId(user.getId()+100)).forEach(System.out::println);
        List<String> collect3 = Stream.of("1", "2", "3", "4").filter(e -> e.length() > 3).peek(e -> System.out.println("Filtered value:" + e))
                .map(String::toUpperCase).peek(e -> System.out.println("Mapped value:" + e)).collect(Collectors.toList());
        System.out.println(collect3);

    }
    private static List<User> getUserList() {
        List<User> userList = new ArrayList<>();

        userList.add(new User(1,"张三",18,"上海"));
        userList.add(new User(2,"王五",16,"上海"));
        userList.add(new User(3,"李四",20,"上海"));
        userList.add(new User(4,"张雷",22,"北京"));
        userList.add(new User(5,"张超",15,"深圳"));
        userList.add(new User(6,"李雷",24,"北京"));
        userList.add(new User(7,"王爷",21,"上海"));
        userList.add(new User(8,"张三丰",18,"广州"));
        userList.add(new User(9,"赵六",16,"广州"));
        userList.add(new User(10,"赵无极",26,"深圳"));

        return userList;
    }
}
