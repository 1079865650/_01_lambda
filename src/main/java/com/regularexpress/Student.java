package com.regularexpress;

public class Student {
    String name;
    String phone;
    int age;
    School school;
    public Student(){
        System.out.println("====Student无参构造器====");
    }
    public Student(String name, String phone, int age,School school){
        this.name = name;
        this.phone = phone;
        this.age = age;
        this.school = school;
        System.out.println("====Student有参构造器====");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}
