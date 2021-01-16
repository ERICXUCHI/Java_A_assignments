package ASSIGNMENT5;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ConcreteParkingLot implements ParkingLot{

    private List<Car> cars = new ArrayList<>();
    public  List<Car> outCars = new ArrayList<>();
    private List<ParkingLotCondition> parkingLotConditions = new ArrayList<>();
    ParkingLotCondition smallCar = new ParkingLotCondition();
    ParkingLotCondition largeCar = new ParkingLotCondition();

    @Override
    public void addParkingSpot(int type, int count) {
        if (type == 0){
            smallCar.setTypeName("SmallCar");
            smallCar.setTotal(count);
            smallCar.setClassType(SmallCar.class);
            if (parkingLotConditions.contains(smallCar)){

            }
            else {
                parkingLotConditions.add(smallCar);
            }

        }
        if (type == 1){
            largeCar.setTypeName("LargeCar");
            largeCar.setTotal(count);
            largeCar.setClassType(LargeCar.class);
            if (parkingLotConditions.contains(largeCar)) {
            }
            else {
                parkingLotConditions.add(largeCar);
            }
        }
    }



    @Override
    public void addParkingSpot(Class<? extends Car> type, int count) {
        boolean have = false;
        for (int i = 0; i < parkingLotConditions.size(); i++) {
            if (parkingLotConditions.get(i).getClassType().equals(type)) {
                parkingLotConditions.get(i).setTotal(count);
                have = true;
            }
        }
        if (!have ) {
               parkingLotConditions.add(new ParkingLotCondition());
               parkingLotConditions.get(parkingLotConditions.size()-1).setClassType(type);
               parkingLotConditions.get(parkingLotConditions.size()-1).setTotal(count);
            parkingLotConditions.get(parkingLotConditions.size()-1).setTypeName(type.getName());
           }

    }

    @Override
    public List<String> getParkingSpotInfo() {
        List<String> s = new ArrayList<>();
        for (int i = 0; i < parkingLotConditions.size(); i++){
            s.add(parkingLotConditions.get(i).getTypeName()+": "+parkingLotConditions.get(i).getOccupied()+"/"+parkingLotConditions.get(i).getTotal());
        }
        return s;
    }

    @Override
    public String getParkingSpotInfo(int type) {
        String information = null;
        if (type == 0){
            information = "SmallCar: "+smallCar.getOccupied()+"/"+smallCar.getTotal();
        }
        if (type == 1){
            information = "LargeCar: "+largeCar.getOccupied()+"/"+largeCar.getTotal();
        }
        return information;
    }

    @Override
    public String getParkingSpotInfo(Class<? extends Car> type) {
        String states = null;
        for (int i = 0; i < parkingLotConditions.size(); i++) {
            if (parkingLotConditions.get(i).getClassType().equals(type)) {
                states = type.getName() +": "+ parkingLotConditions.get(i).getOccupied() + "/" + parkingLotConditions.get(i).getTotal();
            }
        }
            return states;
    }

    @Override
    public void driveInto(int type, String... plateNumbers) {
        if (type == 0) {
            for (int i = 0; i < Math.min(plateNumbers.length,smallCar.getTotal()-smallCar.getOccupied()); i++) {
                    cars.add(new SmallCar(plateNumbers[i], getTime()));
            }
            smallCar.setOccupied(Math.min(plateNumbers.length,smallCar.getCapacity()));
        }
        if (type == 1) {
            for (int i = 0; i < Math.min(plateNumbers.length,largeCar.getTotal()-largeCar.getOccupied()); i++) {
                cars.add(new LargeCar(plateNumbers[i], getTime()));
            }
            largeCar.setOccupied(Math.min(plateNumbers.length,largeCar.getCapacity()));
        }
    }

    @Override
    public void driveInto(Class<? extends Car> type, String... plateNumbers) {

            for (int j = 0; j < parkingLotConditions.size(); j++) {
                if (parkingLotConditions.get(j).getClassType().equals(type)) {
                    for (int i = 0; i < Math.min(plateNumbers.length,parkingLotConditions.get(j).getCapacity()); i++) {
                        try {
                            Car newCar = type.newInstance();
                            newCar.setPlateNumber(plateNumbers[i]);
                            newCar.setArriveTime(getTime());
                            cars.add(newCar);

                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        }
                    }
                    parkingLotConditions.get(j).setOccupied(Math.min(plateNumbers.length,parkingLotConditions.get(j).getCapacity()));
                }
            }
        }

    @Override
    public void driveOut(String... plateNumbers) {

        for (int i = 0; i < plateNumbers.length; i++) {
            for (int j = 0; j < cars.size(); j++) {
                if (cars.get(j).getPlateNumber().equals("\u7ca4" + "B" + plateNumbers[i])) {
                    cars.get(j).setLeaveTime(getTime());
                    outCars.add(cars.get(j));
                   if(cars.get(j) instanceof SmallCar){
                        smallCar.setOccupied( - 1);
                    }
                    if (cars.get(j) instanceof LargeCar){
                        largeCar.setOccupied( - 1);
                    }
                    cars.remove(cars.get(j));

                }
            }
        }
    }

    @Override
    public void passingMinutes(int minutes) {
        currentTime = currentTime.fewMinutesLater(minutes);
    }

    @Override
    public List<Car> findingAllCarsByNumber() {

        Collections.sort(cars);
        return cars;
    }

    @Override
    public Car getCarInfoByPlateNumber(String plateNumber) {
        Car aimCar = null;
        for (Car car : cars) {
            if (car.getPlateNumber().equals("\u7ca4" + "B" + plateNumber)) {
                aimCar = car;
            }
        }
        return aimCar;
    }

    @Override
    public int currentIncome() {
        int totalIncome = 0;
        for (int i = 0; i < outCars.size(); i++) {
            totalIncome += outCars.get(i).calculateMoney();
        }
        return totalIncome;
    }

    public  Time currentTime = new Time(0,0);

    public void setCurrentTime(Time currentTime) {
        this.currentTime = currentTime;
    }

    @Override
    public Time getTime() {
        return currentTime;
    }
}
