package ASSIGNMENT5;

public class SmallCar extends Car{

    private boolean deduction;

    public SmallCar() {
    }

    public SmallCar(String plateNumber, Time time) {
            if ((plateNumber.charAt(plateNumber.length()-1)-'0') % 2 == 0 ){
                deduction = true;
            }
        else {
                deduction = false;
            }
        this.setPlateNumber(plateNumber);
        this.setArriveTime(time);
    }

    @Override
    public String toString(){
        if (deduction == true){
            return String.format("SmallCar %s %s " + "deducted",getPlateNumber(),getArriveTime());
        }
        return String.format("SmallCar %s %s",getPlateNumber(),getArriveTime());
    }


    public int calculateMoney(){
        int money = 0;
        int minutes = getLeaveTime().getHour()*60+getLeaveTime().getMinute() - getArriveTime().getHour()*60 - getArriveTime().getMinute();
        if (deduction){
            if (minutes <= 120){
                money = 0;
            }
            if (minutes > 120){
                money = Math.min(5*((minutes/60)-1),60);
            }
        }
        else{
            if (minutes < 30){
                money = 0;
            }
            if (minutes >= 30 && minutes < 60){
                money = 15;
            }
            if (minutes >=60 && minutes < 120){
                money = 15 + 5*(minutes/60);
            }
            if (minutes >= 120){
                money = Math.min(15 + 5*(minutes/60),60);
            }
        }
        return money;
    }





































    
}
