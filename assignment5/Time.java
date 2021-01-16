package ASSIGNMENT5;

public class Time {
    private int hour;
    private int minute;

    public Time(){
    }

    public Time(int hour, int minute){
        this.hour = hour;
        this.minute = minute;
    }

    public int getHour(){
        return hour;
    }
    public void setHour(int hour){
        this.hour = hour;
    }

    public int getMinute(){
        return minute;
    }
    public void setMinute(int minute){
        this.minute = minute;
    }

    public Time timeDifference(Time time){
        Time time0 = new Time();
        if (getHour() - time.hour >=0) {
            if (getMinute() - time.minute >= 0) {
                time0.minute = getMinute() - time.minute;
                time0.hour = getHour() - time.hour;
            } else {
                time0.minute = 60 + getMinute() - time.minute;
                time0.hour = getHour() - 1 - time.hour;
            }
        }
        else {
            if (time.minute - getMinute() >= 0) {
                time0.minute = time.minute - getMinute();
                time0.hour =time.hour - getHour();
            } else {
                time0.minute = 60 + time.minute - getMinute();
                time0.hour = time.hour - 1 - getHour();
            }
        }
        return time0;
    }

    public Time fewMinutesLater(int minute){
        Time time1 = new Time();
        if ((getMinute() + minute) / 60 >= 1){
            time1.hour = getHour() + (getMinute() + minute) / 60;
            time1.minute = (getMinute() + minute) % 60;
        }
        else if((getMinute() + minute) / 60 < 1){
            time1.hour = getHour();
            time1.minute = getMinute() + minute;
        }
        return time1;
    }

    public String toString(){
        return String.format("%02d:%02d",hour,minute);
    }
}
