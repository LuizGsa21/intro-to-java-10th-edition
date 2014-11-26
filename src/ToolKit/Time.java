package ToolKit;

/**
 * Chapter 10 Exercise :
 *
 *      My class for Chapter 10 Exercise 1.
 *
 * Created by Luiz Arantes Sa on 9/2/14.
 */
public class Time {

    public long hour;
    public long minute;
    public long second;

    public Time() {
        long totalSeconds = System.currentTimeMillis() / 1000;
        long totalMinutes = totalSeconds / 60;
        long totalHours = totalMinutes / 60;
        this.hour = totalHours % 24;
        this.minute = totalMinutes % 60;
        this.second = totalSeconds % 60;

    }

    public Time(long hour, long minute, long second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public Time(long elapseTime) {
        long totalSeconds = elapseTime / 1000;
        long totalMinutes = totalSeconds / 60;
        long totalHours = totalMinutes / 60;
        this.hour = totalHours % 24;
        this.minute = totalMinutes % 60;
        this.second = totalSeconds % 60;

    }

    public long getHour() {
        return hour;
    }


    public long getMinute() {
        return minute;
    }


    public long getSecond() {
        return second;
    }



}
