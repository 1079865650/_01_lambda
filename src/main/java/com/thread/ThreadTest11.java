package com.thread;

public class ThreadTest11 {
    public static void main(String[] args) {
        System.out.println("最高优先级:" + Thread.MAX_PRIORITY);
        System.out.println("最低优先级:" + Thread.MIN_PRIORITY);
        System.out.println("默认优先级:" + Thread.NORM_PRIORITY);

        Thread t = new Thread(new MyRunnable6());
        t.setPriority(10);
        t.setName("t");
        t.start();
        // 优先级较高 只是抢到cpu时间片相对多一些  概率问题
        for (int i = 0; i < 10000; i++) {
            System.out.println(Thread.currentThread().getName() + "--->" + i);
        }
    }
}

class MyRunnable6 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println(Thread.currentThread().getName() + "---->" + i);
        }
    }
}
