package ToolKit;

/**
 * Chapter 9 Exercise 6:
 *
 *      My class for Chapter 9 Exercise 6
 *
 * Created by Luiz Arantes Sa on 9/1/14.
 */
public class StopWatch {

    private long mStartTime;
    private long mEndTime;
    private long mElapsedPause;
    private int mLastSecond = 0;

    private boolean mIsOn;
    private boolean mIsPaused;

    private int mSeconds;
    private int mMinutes;
    private int mHours;

    public StopWatch() {
        mStartTime = System.currentTimeMillis();
    }

    public long getStartTime() {
        return mStartTime;
    }

    public long getEndTime() {
        return mEndTime;
    }

    public void start() {
        mIsOn = true;
        mStartTime = System.currentTimeMillis();
    }

    public void stop(){
        mEndTime = System.currentTimeMillis();
        mIsOn = false;
    }

    public long getElapsedTime() {
        return mEndTime - mStartTime;
    }

    public long peek() {
        return System.currentTimeMillis() - mStartTime;
    }
    public void pause() {
        mIsPaused = true;
        mElapsedPause = System.currentTimeMillis() - mStartTime;
    }

    public void resume() {
        mIsPaused = false;
        mStartTime = System.currentTimeMillis() - mElapsedPause;
    }

    public boolean isOn() {
        return mIsOn;
    }
    public boolean nextSecond() {
        updateTime();
        if (mSeconds != mLastSecond) {
            mLastSecond = mSeconds;
            return true;
        } else {
            return false;
        }
    }
    public boolean nextFiveSeconds() {
        updateTime();
        return mSeconds % 5 == 0;
    }

    public int getHour(){
        updateTime();
        return mHours;
    }

    public int getMinute(){
        updateTime();
        return mMinutes;
    }

    public int getSeconds(){
        updateTime();
        return mSeconds;
    }

    private void updateTime() {

        long currentTime = peek() / 1000;
        mSeconds = (int)(currentTime % 60);
        currentTime = currentTime / 60;

        mMinutes = (int) (currentTime % 60);
        currentTime = currentTime / 60;

        mHours = (int)(currentTime % 24);

    }

    @Override
    public String toString() {

        updateTime();
        String hours = getTimeFormat(mHours);
        String minutes = getTimeFormat(mMinutes);
        String seconds = getTimeFormat(mSeconds);

        return hours + ":" + minutes + ":" + seconds;
    }

    private String getTimeFormat(int time) {
        return (time > 9) ? time + "" : "0" + time;
    }

    public void reset(){
        stop();
        mHours = 0;
        mMinutes = 0;
        mSeconds = 0;
        mStartTime = 0;
        mEndTime = 0;
    }


    public boolean isPaused() {
        return mIsPaused;
    }
}
