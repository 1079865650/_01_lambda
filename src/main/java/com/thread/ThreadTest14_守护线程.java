package com.thread;

public class ThreadTest14_守护线程 {
    public static void main(String[] args) {
        Thread t = new BakDataThread();
        t.setName("备份数据的线程");
        t.setDaemon(true);  //Daemon 守护线程 虽然守护线程是死循环 但是当用户线程执行完毕 守护线程也停止
        t.start();
        // 主线程：主线程是用户线程
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "---->" + i);
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

class BakDataThread extends Thread{
    public void run(){
        int i = 0;
        while(true){
            System.out.println(Thread.currentThread().getName() + "---->" + (++i));
            try{
                Thread.sleep(1000);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
