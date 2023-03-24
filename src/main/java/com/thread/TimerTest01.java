package com.thread;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest01 {
    public static void main(String[] args) {
        Timer timer = new Timer();
        String firstTimeStr = "1021-05-09 17:27:00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date firstTime = null;
        try {
            firstTime = sdf.parse(firstTimeStr);
            timer.schedule(new MyTimerTask(), firstTime, 1000 * 5);  //每五秒执行一次
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

class MyTimerTask extends TimerTask{
    @Override
    public void run() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(d);
        System.out.println(time + ":备份日志一次");
    }
}

class TimerTest02{
    public static void main(String[] args) {
        Timer timer = new Timer();
        String firstTimerStr = "2021-05-09 17:56:00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date firstTimer = sdf.parse(firstTimerStr);
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    Date d = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat();
                    String time = sdf.format(d);
                    System.out.println(time + ":备份日志一次!");
                }
            }, firstTimer, 1000 * 5);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}



