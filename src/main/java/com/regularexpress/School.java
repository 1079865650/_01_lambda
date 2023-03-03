package com.regularexpress;

public class School {
    String name;
    String address;

    public School() {
        System.out.println("====school无参构造器====");
    }

    public School(String name, String address) {
        this.name = name;
        this.address = address;
        System.out.println("====w=School有参构造器===");
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
