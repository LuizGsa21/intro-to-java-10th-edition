package ToolKit;

/**
 * Created by luizsa on 9/30/14.
 */
public class MyCalendarGUI extends MyCalendar {

    public MyCalendarGUI(int year, int month, int dayOfMonth) {
        super(year, month, dayOfMonth);
    }

    public void nextDay() {

        // if day is at the end of month, change month and reset day
        if (get(DATE) == daysInMonth()) {
            nextMonth();
        }else {
            set(DATE, get(DATE) + 1);
        }
    }

    public void nextMonth() {
        set(DATE, 1);
        set(MONTH, (get(MONTH) + 1) % 12);

        if (get(MONTH) == 0) {
            set(YEAR, get(YEAR) + 1);
        }
    }

    public void previousMonth(){
        set(DATE, 1);

        int month = get(MONTH) - 1;
        if (month < 0) {
            set(MONTH, 11);
            set(YEAR, get(YEAR) - 1);
        } else {
            set(MONTH, month);
        }

    }

    @Override
    public String toString() {
        return getMonthName() + " " + get(DATE) + ", " + get(YEAR);
    }
}
