package com.yuhaowin.timer;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Timer;

public class MyTimer {

    public static void main(String[] args) {

        Timer timer = new Timer();

        MyTimerTask myTimerTask = new MyTimerTask("NO.1");

        //1.第一次执行是在当前时间的2秒钟后,以后每隔一秒钟执行一次;
        //timer.schedule(myTimerTask,2000,1000);

        //2.
        LocalDateTime dateTime = LocalDateTime.of(2018,11,07,00,11,00);
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = dateTime.atZone(zoneId);
        Date date = Date.from(zdt.toInstant());
        //timer.schedule(myTimerTask,date);

        //3.
        timer.schedule(myTimerTask,date,2);

        //4
        timer.schedule(myTimerTask,5000);

        //5
        timer.schedule(myTimerTask,5000,5000);

    }
}
