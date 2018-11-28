package com.yuhaowin.timer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimerTask;

/**
 * 定义一个业务任务
 */
public class MyTimerTask extends TimerTask {

    private String name;

    public MyTimerTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        //打印当前的时间
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.now();
        String date = dateTime.format(formatter);
        System.out.println("当前的时间是:" + date);
        //打印当前name的内容
        System.out.println("当前执行的name是:" + name);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
