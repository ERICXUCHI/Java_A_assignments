package ASSIGNMENT5;


public class OtherCar extends Car {
    @Override
    public int calculateMoney() {
        return 10;
    }

    @Override
    public String toString() {
        return "OtherCar "+ super.toString();
    }
}
