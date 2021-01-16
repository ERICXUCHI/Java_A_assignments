
package ASSIGNMENT5;
import java.util.*;
import static java.lang.System.out;

public class Client1 {
    public static void main(String[] args) {
        task00_1__detectTimeClassInfo();
        out.println();
        task00_2__detectCarClassInfo();
        out.println();
        task00_3__detectConcreteParkingLotClassInfo();
        out.println();
        task01__addBasicParkingSpot();
        out.println();
        task02__getParkingSpotInfo();
        out.println();
        task03__testTime();
        out.println();
        task04__testTimeInParkingLot();
        out.println();
        task05__testCar();
        out.println();
        task06__testDriveInto();
        out.println();
        task07__testGetInfoByPN();
        out.println();
        task08__testOverFlowDriveInto();
        out.println();
        task09_1__testDriveOutAndIncome0to30();
        out.println();
        task09_2__testDriveOutAndIncome30to60();
        out.println();
        task09_3__testDriveOutAndIncome60to120();
        out.println();
        task09_4__testDriveOutAndIncome120greater();
        out.println();
        task10__DriveInAndOut();
        out.println();
        task11__wildcard_addGenericsParkingSpot();
        out.println();
        task12__wildcard_testDriveInto();
        out.println();
        task13__wildcard_testDriveOutAndIncome();
        out.println();
    }

    private static Time time1 = new Time(12, 45),
            time2 = new Time(13, 30),
            time3 = new Time(13, 55),
            time4 = new Time(6, 55),
            time5 = new Time(23, 33);
    private static ParkingLot parkingLot = new ConcreteParkingLot();
    
    private static void task00_1__detectTimeClassInfo() {}

    
    private static void task00_2__detectCarClassInfo() {}

    
    private static void task00_3__detectConcreteParkingLotClassInfo(){}

    
    private static void task01__addBasicParkingSpot() {
        parkingLot.addParkingSpot(1, 1);
        parkingLot.addParkingSpot(0, 3);
        parkingLot.addParkingSpot(1, 6);
        parkingLot.addParkingSpot(0, 2);
        parkingLot.addParkingSpot(0, 4);
        parkingLot.addParkingSpot(1, 3);
        Object[] tmp = parkingLot.getParkingSpotInfo().toArray();
        Arrays.sort(tmp);
        for(Object str : tmp) out.println(str);
    }

    
    private static void task02__getParkingSpotInfo() {
        out.println(parkingLot.getParkingSpotInfo(0));
        out.println(parkingLot.getParkingSpotInfo(1));
    }

    
    private static void task03__testTime() {
        out.println(time3.timeDifference(time1));
        out.println(time1.timeDifference(time4));
        out.println(time2.timeDifference(time5));
        out.println(time4.timeDifference(time2));
        out.println(time5.timeDifference(time3));
        out.println(time1.fewMinutesLater(1));
        out.println(time2.fewMinutesLater(45));
        out.println(time3.fewMinutesLater(27));
        out.println(time4.fewMinutesLater(88));
        out.println(time5.fewMinutesLater(12));
    }

    
    private static void task04__testTimeInParkingLot() {
        out.println(parkingLot.getTime());
        parkingLot.passingMinutes(3);
        out.println(parkingLot.getTime());
        parkingLot.passingMinutes(37);
        out.println(parkingLot.getTime());
        parkingLot.passingMinutes(73);
        out.println(parkingLot.getTime());
        parkingLot.passingMinutes(13);
        out.println(parkingLot.getTime());
        parkingLot.passingMinutes(51);
        out.println(parkingLot.getTime());
    }

    
    private static void task05__testCar() {
        List<Car> cars = new LinkedList<>();
        cars.add(new LargeCar("10000", time3));
        cars.add(new LargeCar("10101", time2));
        cars.add(new LargeCar("40213", time4));
        cars.add(new LargeCar("50789", time5));
        cars.add(new LargeCar("10111", time1));
        cars.add(new SmallCar("40372", time4));
        cars.add(new SmallCar("00000", time2));
        cars.add(new SmallCar("13579", time1));
        cars.add(new SmallCar("20010", time3));
        cars.add(new SmallCar("91021", time5));
        for(Car car : cars) out.println(car);
    }

    
    private static void task06__testDriveInto() {
        parkingLot.driveInto(0, "11117", "11213", "41514");
        parkingLot.driveInto(1, "00213");
        parkingLot.passingMinutes(55);
        parkingLot.driveInto(0, "10200", "99999", "98512");
        parkingLot.passingMinutes(10);
        parkingLot.driveInto(1, "41869", "88342", "46272", "71727", "13844");
        for(Car car : parkingLot.findingAllCarsByNumber()) out.println(car);
    }

    
    private static void task07__testGetInfoByPN() {
        out.println(parkingLot.getCarInfoByPlateNumber("11117"));
        out.println(parkingLot.getCarInfoByPlateNumber("88342"));
        out.println(parkingLot.getCarInfoByPlateNumber("98512"));
        out.println(parkingLot.getCarInfoByPlateNumber("46272"));
        out.println(parkingLot.getCarInfoByPlateNumber("99999"));
    }

    
    private static void task08__testOverFlowDriveInto() {
        parkingLot.getParkingSpotInfo().stream().sorted().forEach(out::println);
        parkingLot.passingMinutes(4);
        parkingLot.driveInto(0,"11118","11115","11111","11110","12345","54321","09342","12321","38592","43982","18493");
        parkingLot.driveInto(1, "00001", "12340", "95461");
        for(Car car : parkingLot.findingAllCarsByNumber()) out.println(car);
        Object[] tmp = parkingLot.getParkingSpotInfo().toArray();
        Arrays.sort(tmp);
        for(Object str : tmp) out.println(str);
    }

    
    private static void task09_1__testDriveOutAndIncome0to30() {
        parkingLot.driveOut("99999");
        out.println(parkingLot.currentIncome());
        parkingLot.driveOut("41869");
        out.println(parkingLot.currentIncome());
        parkingLot.driveOut("11118");
        out.println(parkingLot.currentIncome());
        for(Car car : parkingLot.findingAllCarsByNumber()) out.println(car);
    }

    
    private static void task09_2__testDriveOutAndIncome30to60() {
        parkingLot.passingMinutes(30);
        parkingLot.driveOut("10200");
        out.println(parkingLot.currentIncome());
        parkingLot.driveOut("71727");
        out.println(parkingLot.currentIncome());
        parkingLot.driveOut("11115");
        out.println(parkingLot.currentIncome());
    }

    
    private static void task09_3__testDriveOutAndIncome60to120() {
        parkingLot.passingMinutes(34);
        parkingLot.driveOut("00001");
        out.println(parkingLot.currentIncome());
        parkingLot.driveOut("98512");
        out.println(parkingLot.currentIncome());
        parkingLot.driveOut("11111");
        out.println(parkingLot.currentIncome());
    }

    
    private static void task09_4__testDriveOutAndIncome120greater() {
        parkingLot.passingMinutes(20);
        parkingLot.driveOut("11117");
        out.println(parkingLot.currentIncome());
        parkingLot.driveOut("00213");
        out.println(parkingLot.currentIncome());
        parkingLot.driveOut("41514");
        out.println(parkingLot.currentIncome());
        for(Car car : parkingLot.findingAllCarsByNumber()) out.println(car);
    }

    
    private static void task10__DriveInAndOut() {
        out.println(parkingLot.getTime());
        parkingLot.passingMinutes(390);
        parkingLot.driveInto(1,"21112","32229");
        parkingLot.driveInto(0,"11120","11131");
        parkingLot.passingMinutes(233);
        out.println(parkingLot.getTime());
        parkingLot.driveOut("11120");
        out.println(parkingLot.currentIncome());
        parkingLot.passingMinutes(107);
        out.println(parkingLot.getTime());
        parkingLot.driveOut("95461");
        out.println(parkingLot.currentIncome());
        parkingLot.driveOut("11131");
        out.println(parkingLot.currentIncome());
    }

    
    private static void task11__wildcard_addGenericsParkingSpot() {
        parkingLot.addParkingSpot(OtherCar.class,10);
        Object[] tmp = parkingLot.getParkingSpotInfo().toArray();
        Arrays.sort(tmp);
        for(Object str : tmp) out.println(str);
    }

    
    private static void task12__wildcard_testDriveInto() {
        parkingLot.driveInto(OtherCar.class,"30001","30002");
        out.println(parkingLot.getParkingSpotInfo(OtherCar.class));
        parkingLot.passingMinutes(13);
        parkingLot.driveInto(OtherCar.class,"00100","11011", "23333", "33333", "44444", "55555");
        parkingLot.driveInto(OtherCar.class,"43533","13032", "41000", "12421", "30303", "08571");
        for(Car car : parkingLot.findingAllCarsByNumber()) out.println(car);
    }

    
    private static void task13__wildcard_testDriveOutAndIncome() {
        parkingLot.passingMinutes(20);
        parkingLot.driveOut("11011", "13032", "30002");
        out.println(parkingLot.currentIncome());
        parkingLot.passingMinutes(120);
        parkingLot.driveOut("12340", "88342", "33333", "55555", "30001");
        out.println(parkingLot.currentIncome());
        for(Car car : parkingLot.findingAllCarsByNumber()) out.println(car);
    }
}
