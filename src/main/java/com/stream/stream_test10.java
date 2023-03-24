package com.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class stream_test10 {
    static User user1 = new User("111", "18", 180);
    static User user2 = new User("222", "18", 175);
    static User user3 = new User("333", "19", 170);
    // 静态类 在类创建时就会创建 保证后面调用

    public static void main(String[] args) {
//        User user1 = new User("111", "18", 180);
//        User user2 = new User("222", "18", 175);
//        User user3 = new User("333", "19", 170);
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        ArrayList<String> userNameList = new ArrayList<>();
        for (User user : userList) {
            userNameList.add(user.getName());
        }
        List<String> collect = userList.stream().map(User::getName).collect(Collectors.toList());

        ArrayList<User> newUserList = new ArrayList<>();
        for (User user : userList) {
            if (user.getName() != null)
                newUserList.add(user);
        }
        List<User> collect1 = userList.stream().filter(user -> user.getName() != null).collect(Collectors.toList());
        System.out.println(collect1);

        
    }
}
