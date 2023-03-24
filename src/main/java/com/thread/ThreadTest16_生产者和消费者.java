package com.thread;

import java.util.ArrayList;
import java.util.List;

public class ThreadTest16_生产者和消费者 {
    public static void main(String[] args) {
        // 创建1个仓库对象 共享的
        List list = new ArrayList();
        // 创建两个线程对象
        // 生产者线程
        Thread t1 = new Thread(new Producer(list));
        Thread t2 = new Thread(new Consumer(list));
        t1.setName("生产者线程");
        t2.setName("消费者线程");

        t1.start();
        t2.start();

    }
}

// 生产线程
class Producer implements Runnable{
    private List list;
    public Producer(List list){
        this.list = list;
    }

    @Override
    public void run() {
        while(true){
            synchronized (list){
                if (list.size() > 0){  // 大于0 说明仓库中已经you1个元素
                    try {
                        list.wait();  // 当前线程进入等待状态 并且让释放producer之前占有的list集合的锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            Object obj = new Object();
            list.add(obj);
            System.out.println(Thread.currentThread().getName() + "--->" + obj);
            // 唤醒消费者进行消费  为啥是list notifyAll
            list.notifyAll();
        }
    }
}

// 消费线程
class Consumer implements Runnable{
    private List list;
    public Consumer(List list){
        this.list = list;
    }

    @Override
    public void run() {
        while(true){
            synchronized (list){
                if (list.size() == 0){
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Object obj = list.remove(0);
                System.out.println(Thread.currentThread().getName() + "--->" + obj);
                // 欢迎生产者生产
                list.notifyAll();
            }
        }
    }
}
