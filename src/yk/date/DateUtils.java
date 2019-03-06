package yk.date;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 日期常用操作封装
 * @author YK
 */
public class DateUtils {
    //封装定时任务
    public static void setTimingSask(int day, int minute, long PERIOD_DAY, TimerTask task) {

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>定时任务监测启动<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        // 定义日历
        Calendar calendar = Calendar.getInstance();

        //定制每日dat:minute:00执行
        calendar.set(Calendar.HOUR_OF_DAY, day);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, 00);

        Date date = calendar.getTime();     //第一次执行定时任务的时间
        //如果当前时间已经过去所定时的时间点，则在第二天时间点开始执行
        if (date.before(new Date())) {
            date = addDay(date, 1);
            System.out.println("                         ---------时间段已过-------");
        }else {
            System.out.println("                         ----------等待启动--------");
        }
        Timer timer = new Timer();
        //安排指定的任务在指定的时间开始进行重复的固定延迟执行。
        timer.schedule(task, date, PERIOD_DAY);
    }

    // 增加或减少天数
    public static Date addDay(Date date, int num) {
        Calendar startDT = Calendar.getInstance();
        startDT.setTime(date);
        startDT.add(Calendar.DAY_OF_MONTH, num);
        return startDT.getTime();
    }
    // 增加或减少月份
    public static Date addMonth(Date date, int num) {
        Calendar startDT = Calendar.getInstance();
        startDT.setTime(date);
        startDT.add(Calendar.MONTH, num);
        return startDT.getTime();
    }
    // 增加或减少小时
    public static Date addHour(Date date, int num) {
        Calendar startDT = Calendar.getInstance();
        startDT.setTime(date);
        startDT.add(Calendar.HOUR, num);
        return startDT.getTime();
    }
    // 增加或减少分钟
    public static Date addMinute(Date date, int num) {
        Calendar startDT = Calendar.getInstance();
        startDT.setTime(date);
        startDT.add(Calendar.MINUTE, num);
        return startDT.getTime();
    }
}
