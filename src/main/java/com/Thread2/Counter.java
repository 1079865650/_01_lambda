package com.Thread2;

public class Counter {  // 一个包下的类名只能有一个
    private int count = 0;
    public void add(int n){
        synchronized (this){
            count += n;
        }
    }
    public void dec(int n){
        synchronized(this){ //锁住的是当前的this
            count -= n;
        }
    }
    public int get(){
        return count;
    }
}
