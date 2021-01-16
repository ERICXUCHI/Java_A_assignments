package ASSIGNMENT5;

public abstract class Car implements Comparable<Car> {
    private String number;
    private String plateNumber;
    private Time arriveTime;
    private int Money;
    private Time leaveTime;
    private String name;

    public Car() {

    }



    public Car(String plateNumber, Time time) {
        this.setPlateNumber(plateNumber);
        this.arriveTime = time;

    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = "\u7ca4" + "B" + plateNumber;
    }


    public Time getLeaveTime(){
        return leaveTime;
    }

    public void setLeaveTime(Time leaveTime) {
        this.leaveTime = leaveTime;
    }

    public Time getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(Time arriveTime) {
        this.arriveTime = arriveTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //    private boolean deduction(){
//        return true;
//    }

    public abstract int calculateMoney();

    @Override
    public String toString() {
        return plateNumber + " " + arriveTime;
    }

    @Override
    public int compareTo(Car o) {
        return -o.getPlateNumber().compareTo(this.getPlateNumber());
    }
}
