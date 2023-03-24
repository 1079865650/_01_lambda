package com.thread;

public class test01 {
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable());
        t.start();
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }
}
