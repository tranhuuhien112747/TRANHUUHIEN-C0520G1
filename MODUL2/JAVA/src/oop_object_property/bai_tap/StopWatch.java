package oop_object_property.bai_tap;

import java.util.Date;
import java.util.Scanner;

public class StopWatch {
    public Date startTime;
    public Date endTime;

    public StopWatch() {
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void start() {
        Date date = new Date();
        this.startTime = date;
    }

    public void stop() {
        Date date = new Date();
        this.endTime = date;
    }

    public long getElapsedTime() {
        return endTime.getSeconds() - startTime.getSeconds();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StopWatch date = new StopWatch();
        date.start();
        for (int i = 0; i < 2; i++) {
            System.out.println("tung nui");
            int khanhdeptrai = scanner.nextInt();
            System.out.println("1" + khanhdeptrai);
        }
        date.stop();
        System.out.println(date.getElapsedTime() + " giay");
    }
}