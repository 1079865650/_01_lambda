package com.thread;

public class MyThread1 extends Thread{
    public void run(){

    }
}
class ThreadTest02{
    public static void main(String[] args) {
        MyThread1 t = new MyThread1();
        t.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("主线程---->" + i);
        }
    }
}


class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("分支线程----=>" + i);
        }
    }
}
