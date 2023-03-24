package com.thread;

public class Thread_DeadLock {
    public static void main(String[] args) {
        Dress dress = new Dress();
        Trousers trousers = new Trousers();
        Thread t1 = new Thread(new MyRunnable1(dress, trousers), "t1");
        Thread t2 = new Thread(new MyRunnable2(dress, trousers), "t2");  // 继承Runnable接口 接口里面重写的run方法
        t1.start();
        t2.start();
    }

}

class MyRunnable1 implements Runnable{
    Dress dress;
    Trousers trousers;

    public MyRunnable1(Dress dress, Trousers trousers) {
        this.dress = dress;
        this.trousers = trousers;
    }

    @Override
    public void run() {
        synchronized (dress){  // synchronized inside synchronized
            try{
                Thread.sleep(1000);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
            synchronized (trousers){
                System.out.println("-----------missing a pair of pants");
            }
        }
    }
}

class MyRunnable2 implements Runnable{
    Dress dress;
    Trousers trousers;
    public MyRunnable2(){

    }
    public MyRunnable2(Dress dress, Trousers trousers){
        this.dress = dress;
        this.trousers = trousers;
    }

    @Override
    public void run() {
        synchronized (trousers){
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            synchronized (dress){
                System.out.println("------------------missing a dress");
            }
        }
    }
}


class Dress{}
class Trousers{}
