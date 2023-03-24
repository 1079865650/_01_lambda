package com.Thread2;

public class test1 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("hello");
        });
        System.out.println("start");
        thread.start();
        thread.join();
        System.out.println("end");
    }
}
class aa{
    public static void main(String[] args) throws InterruptedException { // 按照类启动的
        MyThread t = new MyThread();
        t.start();
        Thread.sleep(1);
        t.interrupt();
        t.join();
        System.out.println("end");
    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        int n = 0;
        while(! isInterrupted()){
            n ++;
            System.out.println(n + "hello!");
        }
    }
}
