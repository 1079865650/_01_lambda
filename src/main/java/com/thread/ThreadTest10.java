package com.thread;

public class ThreadTest10 {
    public static void main(String[] args) {
        MyRunnable4 r = new MyRunnable4();
        Thread t = new Thread(r);
        t.setName("t");
        t.start();
        try{
            Thread.sleep(5000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        r.run = false;
    }
}

class MyRunnable4 implements Runnable{  // 继承runnable接口 实现run方法
    boolean run = true;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (run){
                System.out.println(Thread.currentThread().getName() + "---->" + i);
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }else {
                return;
            }
        }
    }
}
