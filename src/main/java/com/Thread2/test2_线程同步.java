package com.Thread2;

public class test2_线程同步 {
    public static void main(String[] args) throws InterruptedException {
        AddThread add = new AddThread();
        DecThread dec = new DecThread();
        add.start();
        add.join();
        dec.join();
        System.out.println(Counter1.count);

    }
}

class  Counter1{ // synchronized  保证了代码块再任意时刻最多只有一个线程能执行  代码块无法并发执行 加锁解锁都需要消耗一定的时间
    public static int count = 0;
}
class AddThread extends Thread{
    public void run(){
        for (int i = 0; i < 10000; i++) {
            Counter1.count += 1;
        }
    }
}

class DecThread extends Thread{
    public void run(){
        for (int i = 0; i < 10000; i++) {
            Counter1.count -= 1;
        }
    }
}