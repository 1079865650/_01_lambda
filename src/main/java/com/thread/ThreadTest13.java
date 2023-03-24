package com.thread;

public class ThreadTest13 {
    public static void main(String[] args) {
        System.out.println("main begin");
        Thread t = new Thread(new MyRunnable7());
        t.setName("t");
        t.start();
        try{
            t.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("main over");
    }
}

class MyRunnable7 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println(Thread.currentThread().getName() + "--->" + i);
        }
    }
}
