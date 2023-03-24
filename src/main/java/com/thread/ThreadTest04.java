package com.thread;

public class ThreadTest04 {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() { //实现了接口还能继承其他类
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("t线程---->" + i);
                }
            }
        });
        t.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("main线程--->" + i);
        }
    }
}
