package ASSIGNMENT5;

public class LargeCar extends Car{
    public LargeCar() {
    }

    public LargeCar(String plateNumber, Time time) {
        this.setPlateNumber(plateNumber);
        this.setArriveTime(time);
    }

    @Override
    public String toString(){
        return String.format("LargeCar %s %s",getPlateNumber(),getArriveTime());
    }

    public int calculateMoney(){
        int money =0;
        int minutes = getLeaveTime().getHour()*60 + getLeaveTime().getMinute() - getArriveTime().getHour()*60 - getArriveTime().getMinute();
            if (minutes < 30){
                money = 0;
            }
            if (minutes >= 30 && minutes < 60){
                money = 15;
            }
            if (minutes >=60 && minutes < 120){
                money = 15*(minutes/60 + 1);
            }
            if (minutes >= 120){
                money = Math.min(100 ,15*(minutes/60 + 1));
            }
        return money;
    }
}
