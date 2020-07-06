package oop_object_property.bai_tap;

import java.util.Date;

public class StopWatch {
    public long startTime;
    public long endTime;

    public StopWatch() {
    }

    public void start() {
        Date date = new Date();
        this.startTime = date.getTime();
        // this.startTime=System.currentTimeMillis();
    }

    public void stop() {
        Date date = new Date();
        this.endTime = date.getTime();
        //this.endTime = System.currentTimeMillis();
        //lấy ngày và giờ hiện tại.
    }

    public double getElapsedTime() {
        return this.endTime - this.startTime;
    }

    public static void main(String[] args) {
        StopWatch date = new StopWatch();
        date.start();
        int size = 1000000;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * size + 1);
        }
        date.stop();
        System.out.print("Time elapsed:" + date.getElapsedTime() + " miliseconds.");
    }
}