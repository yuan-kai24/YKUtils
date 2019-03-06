package yk;

import yk.date.DateUtils;

import java.util.TimerTask;

public class Main {
    public static void main(String [] args){
        DateUtils.setTimingSask(22, 23, 1000, new TimerTask() {
            @Override
            public void run() {
                System.out.println("测试成功");
            }
        });
    }
}
