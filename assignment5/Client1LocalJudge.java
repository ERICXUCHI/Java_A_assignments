package ASSIGNMENT5;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.Alphanumeric;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Client1 Local Judge for Assignment 5 (CS102A).<br>
 *
 * @author Tang Jiahao
 * @version 2.0
 * @since <pre>10/24/2019</pre>
 * Junit version 5.4.2
 * with 19 tests
 */

class CSECar extends Car {

    @Override
    public int calculateMoney() {
        return 5;
    }

    @Override
    public String toString() {
        return "CSECar " + super.toString();
    }
}

class CS102ACar extends Car {

    @Override
    public int calculateMoney() {

        return 0;
    }

    @Override
    public String toString() {
        return "CS102ACar " + super.toString();
    }


}

@TestMethodOrder(Alphanumeric.class)
class Client1LocalJudge {
    private static final String ls = System.lineSeparator();
    private static StringBuilder output;
    private static Time time1, time2, time3, time4, time5;
    private static ParkingLot parkingLot;

    @BeforeAll
    static void beforeAll() {
        parkingLot = new ConcreteParkingLot();
        time1 = new Time(12, 45);
        time2 = new Time(13, 30);
        time3 = new Time(13, 55);
        time4 = new Time(6, 55);
        time5 = new Time(23, 33);
    }

    @BeforeEach
    void beforeEach() {
        output = new StringBuilder();
    }

    @Test
    void task00_1__detectTimeClassInfo() {
        String[] requiredFields = {
                "private int Time.hour",
                "private int Time.minute"
        };
        String[] requiredMethods = {
                "public Time Time.fewMinutesLater(int)",
                "public Time Time.timeDifference(Time)",
                "public java.lang.String Time.toString()"
        };
        try {
            Class time = Class.forName("Time");
            List<String> declaredFields = Arrays.stream(time.getDeclaredFields()).map(Field::toString).collect(Collectors.toList());
            for (String field : requiredFields) {
                if (!declaredFields.contains(field)) output.append(field).append(" is missing");
            }
            List<String> declaredMethods = Arrays.stream(time.getDeclaredMethods()).map(Method::toString).collect(Collectors.toList());
            for (String method : requiredMethods) {
                if (!declaredMethods.contains(method)) output.append(method).append(" is missing");
            }
        } catch (ClassNotFoundException e) {
            output.append(e.toString());
        }
        assertEquals(0, output.length(), ls + output.toString());
    }

    @Test
    void task00_2__detectCarClassInfo() {
        String[] requiredFieldsInCar = {
                "private java.lang.String Car.plateNumber",
                "private Time Car.arriveTime"
        };
        String[] requiredMethodsInLargeCar = {
                "public java.lang.String LargeCar.toString()",
                "public int LargeCar.calculateMoney()"
        };
        String requiredFieldInSmallCar = "private boolean SmallCar.deduction";
        String[] requiredMethodsInSmallCar = {
                "public java.lang.String SmallCar.toString()",
                "public int SmallCar.calculateMoney()"
        };
        try {
            Class car = Class.forName("Car");
            List<String> declaredFieldsInCar = Arrays.stream(car.getDeclaredFields()).map(Field::toString).collect(Collectors.toList());
            for (String field : requiredFieldsInCar) {
                if (!declaredFieldsInCar.contains(field)) output.append(field).append(" in Class Car is missing");
            }
            Class largeCar = Class.forName("LargeCar");
            if (!largeCar.getSuperclass().getName().equals("Car")) output.append("Invalid Super Class of LargeCar");
            List<String> declaredMethodsInLargeCar = Arrays.stream(largeCar.getDeclaredMethods()).map(Method::toString).collect(Collectors.toList());
            for (String method : requiredMethodsInLargeCar) {
                if (!declaredMethodsInLargeCar.contains(method))
                    output.append(method).append(" in Class LargeCar is missing");
            }
            Class smallCar = Class.forName("SmallCar");
            if (!smallCar.getSuperclass().getName().equals("Car")) output.append("Invalid Super Class of SmallCar");
            List<String> declaredFieldsInSmallCar = Arrays.stream(smallCar.getDeclaredFields()).map(Field::toString).collect(Collectors.toList());
            if (!declaredFieldsInSmallCar.contains(requiredFieldInSmallCar))
                output.append(requiredFieldInSmallCar).append(" in Class SmallCar is missing");
            List<String> declaredMethodsInSmallCar = Arrays.stream(smallCar.getDeclaredMethods()).map(Method::toString).collect(Collectors.toList());
            for (String method : requiredMethodsInSmallCar) {
                if (!declaredMethodsInSmallCar.contains(method))
                    output.append(method).append(" in Class SmallCar is missing");
            }
        } catch (ClassNotFoundException e) {
            output.append(e.toString());
        }
        assertEquals(0, output.length(), ls + output.toString());
    }

    @Test
    void task00_3__detectConcreteParkingLotClassInfo() {
        String requiredField = "private java.util.List ConcreteParkingLot.cars";
        try {
            Class concreteParkingLot = Class.forName("ConcreteParkingLot");
            List<String> declaredFields = Arrays.stream(concreteParkingLot.getDeclaredFields()).map(Field::toString).collect(Collectors.toList());
            if (!declaredFields.contains(requiredField)) output.append(requiredField).append(" is missing");
        } catch (ClassNotFoundException e) {
            output.append(e.toString());
        }
        assertEquals(0, output.length(), ls + output.toString());
    }

    @Test
    void task01__addBasicParkingSpot() {
        parkingLot.addParkingSpot(1, 1);
        parkingLot.addParkingSpot(0, 3);
        parkingLot.addParkingSpot(1, 6);
        parkingLot.addParkingSpot(0, 2);
        parkingLot.addParkingSpot(0, 4);
        parkingLot.addParkingSpot(1, 3);
        parkingLot.getParkingSpotInfo().stream().sorted().forEach(e -> output.append(e).append(ls));
        assertEquals("LargeCar: 0/10" + ls +
                "SmallCar: 0/9" + ls, output.toString());
    }

    @Test
    void task02__getParkingSpotInfo() {
        output.append(parkingLot.getParkingSpotInfo(0)).append(ls);
        output.append(parkingLot.getParkingSpotInfo(1)).append(ls);
        assertEquals("SmallCar: 0/9" + ls +
                "LargeCar: 0/10" + ls, output.toString());
    }

    @Test
    void task03__testTime() {
        output.append(time3.timeDifference(time1)).append(ls);
        output.append(time1.timeDifference(time4)).append(ls);
        output.append(time2.timeDifference(time5)).append(ls);
        output.append(time4.timeDifference(time2)).append(ls);
        output.append(time5.timeDifference(time3)).append(ls);
        output.append(time1.fewMinutesLater(1)).append(ls);
        output.append(time2.fewMinutesLater(45)).append(ls);
        output.append(time3.fewMinutesLater(27)).append(ls);
        output.append(time4.fewMinutesLater(88)).append(ls);
        output.append(time5.fewMinutesLater(12)).append(ls);
        assertEquals("01:10" + ls +
                "05:50" + ls +
                "10:03" + ls +
                "06:35" + ls +
                "09:38" + ls +
                "12:46" + ls +
                "14:15" + ls +
                "14:22" + ls +
                "08:23" + ls +
                "23:45" + ls, output.toString());
    }

    @Test
    void task04__testTimeInParkingLot() {
        output.append(parkingLot.getTime()).append(ls);
        parkingLot.passingMinutes(3);
        output.append(parkingLot.getTime()).append(ls);
        parkingLot.passingMinutes(37);
        output.append(parkingLot.getTime()).append(ls);
        parkingLot.passingMinutes(73);
        output.append(parkingLot.getTime()).append(ls);
        parkingLot.passingMinutes(13);
        output.append(parkingLot.getTime()).append(ls);
        parkingLot.passingMinutes(51);
        output.append(parkingLot.getTime()).append(ls);
        assertEquals("00:00" + ls +
                "00:03" + ls +
                "00:40" + ls +
                "01:53" + ls +
                "02:06" + ls +
                "02:57" + ls, output.toString());
    }

    @Test
    void task05__testCar() {
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
        cars.forEach(e -> output.append(e).append(ls));
        assertEquals("LargeCar 粤B10000 13:55" + ls +
                "LargeCar 粤B10101 13:30" + ls +
                "LargeCar 粤B40213 06:55" + ls +
                "LargeCar 粤B50789 23:33" + ls +
                "LargeCar 粤B10111 12:45" + ls +
                "SmallCar 粤B40372 06:55 deducted" + ls +
                "SmallCar 粤B00000 13:30 deducted" + ls +
                "SmallCar 粤B13579 12:45" + ls +
                "SmallCar 粤B20010 13:55 deducted" + ls +
                "SmallCar 粤B91021 23:33" + ls, output.toString());
    }

    @Test
    void task06__testDriveInto() {
        parkingLot.driveInto(0, "11117", "11213", "41514");
        parkingLot.driveInto(1, "00213");
        parkingLot.passingMinutes(55);
        parkingLot.driveInto(0, "10200", "99999", "98512");
        parkingLot.passingMinutes(10);
        parkingLot.driveInto(1, "41869", "88342", "46272", "71727", "13844");
        parkingLot.findingAllCarsByNumber().forEach(e -> output.append(e).append(ls));
        assertEquals("LargeCar 粤B00213 02:57" + ls +
                "SmallCar 粤B10200 03:52 deducted" + ls +
                "SmallCar 粤B11117 02:57" + ls +
                "SmallCar 粤B11213 02:57" + ls +
                "LargeCar 粤B13844 04:02" + ls +
                "SmallCar 粤B41514 02:57 deducted" + ls +
                "LargeCar 粤B41869 04:02" + ls +
                "LargeCar 粤B46272 04:02" + ls +
                "LargeCar 粤B71727 04:02" + ls +
                "LargeCar 粤B88342 04:02" + ls +
                "SmallCar 粤B98512 03:52 deducted" + ls +
                "SmallCar 粤B99999 03:52" + ls, output.toString());
    }

    @Test
    void task07__testGetInfoByPN() {
        output.append(parkingLot.getCarInfoByPlateNumber("11117")).append(ls);
        output.append(parkingLot.getCarInfoByPlateNumber("88342")).append(ls);
        output.append(parkingLot.getCarInfoByPlateNumber("98512")).append(ls);
        output.append(parkingLot.getCarInfoByPlateNumber("46272")).append(ls);
        output.append(parkingLot.getCarInfoByPlateNumber("99999")).append(ls);
        assertEquals("SmallCar 粤B11117 02:57" + ls +
                "LargeCar 粤B88342 04:02" + ls +
                "SmallCar 粤B98512 03:52 deducted" + ls +
                "LargeCar 粤B46272 04:02" + ls +
                "SmallCar 粤B99999 03:52" + ls, output.toString());
    }

    @Test
    void task08__testOverFlowDriveInto() {
        parkingLot.getParkingSpotInfo().stream().sorted().forEach(e -> output.append(e).append(ls));
        parkingLot.passingMinutes(4);
        parkingLot.driveInto(0, "11118", "11115", "11111", "11110", "12345", "54321", "09342", "12321", "38592", "43982", "18493");
        parkingLot.driveInto(1, "00001", "12340", "95461");
        parkingLot.findingAllCarsByNumber().forEach(e -> output.append(e).append(ls));
        parkingLot.getParkingSpotInfo().stream().sorted().forEach(e -> output.append(e).append(ls));
        assertEquals("LargeCar: 6/10" + ls +
                "SmallCar: 6/9" + ls +
                "LargeCar 粤B00001 04:06" + ls +
                "LargeCar 粤B00213 02:57" + ls +
                "SmallCar 粤B10200 03:52 deducted" + ls +
                "SmallCar 粤B11111 04:06" + ls +
                "SmallCar 粤B11115 04:06" + ls +
                "SmallCar 粤B11117 02:57" + ls +
                "SmallCar 粤B11118 04:06 deducted" + ls +
                "SmallCar 粤B11213 02:57" + ls +
                "LargeCar 粤B12340 04:06" + ls +
                "LargeCar 粤B13844 04:02" + ls +
                "SmallCar 粤B41514 02:57 deducted" + ls +
                "LargeCar 粤B41869 04:02" + ls +
                "LargeCar 粤B46272 04:02" + ls +
                "LargeCar 粤B71727 04:02" + ls +
                "LargeCar 粤B88342 04:02" + ls +
                "LargeCar 粤B95461 04:06" + ls +
                "SmallCar 粤B98512 03:52 deducted" + ls +
                "SmallCar 粤B99999 03:52" + ls +
                "LargeCar: 9/10" + ls +
                "SmallCar: 9/9" + ls, output.toString());
    }

    @Test
    void task09_1__testDriveOutAndIncome0to30() {
        parkingLot.driveOut("99999");
        output.append(parkingLot.currentIncome()).append(ls);
        parkingLot.driveOut("41869");
        output.append(parkingLot.currentIncome()).append(ls);
        parkingLot.driveOut("11118");
        output.append(parkingLot.currentIncome()).append(ls);
        parkingLot.findingAllCarsByNumber().forEach(e -> output.append(e).append(ls));
        assertEquals("0" + ls +
                "0" + ls +
                "0" + ls +
                "LargeCar 粤B00001 04:06" + ls +
                "LargeCar 粤B00213 02:57" + ls +
                "SmallCar 粤B10200 03:52 deducted" + ls +
                "SmallCar 粤B11111 04:06" + ls +
                "SmallCar 粤B11115 04:06" + ls +
                "SmallCar 粤B11117 02:57" + ls +
                "SmallCar 粤B11213 02:57" + ls +
                "LargeCar 粤B12340 04:06" + ls +
                "LargeCar 粤B13844 04:02" + ls +
                "SmallCar 粤B41514 02:57 deducted" + ls +
                "LargeCar 粤B46272 04:02" + ls +
                "LargeCar 粤B71727 04:02" + ls +
                "LargeCar 粤B88342 04:02" + ls +
                "LargeCar 粤B95461 04:06" + ls +
                "SmallCar 粤B98512 03:52 deducted" + ls, output.toString());
    }

    @Test
    void task09_2__testDriveOutAndIncome30to60() {
        parkingLot.passingMinutes(30);
        parkingLot.driveOut("10200");
        output.append(parkingLot.currentIncome()).append(ls);
        parkingLot.driveOut("71727");
        output.append(parkingLot.currentIncome()).append(ls);
        parkingLot.driveOut("11115");
        output.append(parkingLot.currentIncome()).append(ls);
        assertEquals("0" + ls +
                "15" + ls +
                "30" + ls, output.toString());
    }

    @Test
    void task09_3__testDriveOutAndIncome60to120() {
        parkingLot.passingMinutes(34);
        parkingLot.driveOut("00001");
        output.append(parkingLot.currentIncome()).append(ls);
        parkingLot.driveOut("98512");
        output.append(parkingLot.currentIncome()).append(ls);
        parkingLot.driveOut("11111");
        output.append(parkingLot.currentIncome()).append(ls);
        assertEquals("60" + ls +
                "60" + ls +
                "80" + ls, output.toString());
    }

    @Test
    void task09_4__testDriveOutAndIncome120greater() {
        parkingLot.passingMinutes(20);
        parkingLot.driveOut("11117");
        output.append(parkingLot.currentIncome()).append(ls);
        parkingLot.driveOut("00213");
        output.append(parkingLot.currentIncome()).append(ls);
        parkingLot.driveOut("41514");
        output.append(parkingLot.currentIncome()).append(ls);
        parkingLot.findingAllCarsByNumber().forEach(e -> output.append(e).append(ls));
        assertEquals("105" + ls +
                "150" + ls +
                "155" + ls +
                "SmallCar 粤B11213 02:57" + ls +
                "LargeCar 粤B12340 04:06" + ls +
                "LargeCar 粤B13844 04:02" + ls +
                "LargeCar 粤B46272 04:02" + ls +
                "LargeCar 粤B88342 04:02" + ls +
                "LargeCar 粤B95461 04:06" + ls, output.toString());
    }

    @Test
    void task10__DriveInAndOut() {
        output.append(parkingLot.getTime()).append(ls);
        parkingLot.passingMinutes(390);
        parkingLot.driveInto(1, "21112", "32229");
        parkingLot.driveInto(0, "11120", "11131");
        parkingLot.passingMinutes(233);
        output.append(parkingLot.getTime()).append(ls);
        parkingLot.driveOut("11120");
        output.append(parkingLot.currentIncome()).append(ls);
        parkingLot.passingMinutes(107);
        output.append(parkingLot.getTime()).append(ls);
        parkingLot.driveOut("95461");
        output.append(parkingLot.currentIncome()).append(ls);
        parkingLot.driveOut("11131");
        output.append(parkingLot.currentIncome()).append(ls);
        assertEquals("05:30" + ls +
                "15:53" + ls +
                "165" + ls +
                "17:40" + ls +
                "265" + ls +
                "305" + ls, output.toString());
    }

    @Test
    void task11__wildcard_addGenericsParkingSpot() {
        parkingLot.addParkingSpot(OtherCar.class, 10);
        parkingLot.addParkingSpot(CS102ACar.class, 5);
        parkingLot.addParkingSpot(CSECar.class, 5);
        parkingLot.getParkingSpotInfo().stream().sorted().forEach(e -> output.append(e).append(ls));
        assertEquals("CS102ACar: 0/5" + ls +
                "CSECar: 0/5" + ls + "LargeCar: 6/10" + ls +
                "OtherCar: 0/10" + ls +
                "SmallCar: 1/9" + ls, output.toString());
    }


    @Test
    void task12__wildcard_testDriveInto() {
        parkingLot.driveInto(OtherCar.class, "30001", "30002");
        parkingLot.driveInto(CS102ACar.class, "98766");
        parkingLot.driveInto(CSECar.class, "48888", "48887");
        output.append(parkingLot.getParkingSpotInfo(OtherCar.class)).append(ls);
        parkingLot.passingMinutes(13);
        parkingLot.driveInto(OtherCar.class, "00100", "11011", "23333", "33333", "44444", "55555");
        parkingLot.driveInto(OtherCar.class, "43533", "13032", "41000", "12421", "30303", "08571");
        parkingLot.findingAllCarsByNumber().forEach(e -> output.append(e).append(ls));
        assertEquals("OtherCar: 2/10" + ls +
                "OtherCar 粤B00100 17:53" + ls +
                "OtherCar 粤B11011 17:53" + ls +
                "SmallCar 粤B11213 02:57" + ls +
                "LargeCar 粤B12340 04:06" + ls +
                "OtherCar 粤B13032 17:53" + ls +
                "LargeCar 粤B13844 04:02" + ls +
                "LargeCar 粤B21112 12:00" + ls +
                "OtherCar 粤B23333 17:53" + ls +
                "OtherCar 粤B30001 17:40" + ls +
                "OtherCar 粤B30002 17:40" + ls +
                "LargeCar 粤B32229 12:00" + ls +
                "OtherCar 粤B33333 17:53" + ls +
                "OtherCar 粤B43533 17:53" + ls +
                "OtherCar 粤B44444 17:53" + ls +
                "LargeCar 粤B46272 04:02" + ls +
                "CSECar 粤B48887 17:40" + ls +
                "CSECar 粤B48888 17:40" + ls +
                "OtherCar 粤B55555 17:53" + ls +
                "LargeCar 粤B88342 04:02" + ls +
                "CS102ACar 粤B98766 17:40" + ls, output.toString());
    }

    @Test
    void task13__wildcard_testDriveOutAndIncome() {
        parkingLot.passingMinutes(20);
        parkingLot.driveOut("11011", "13032", "30002", "48888", "98766");
        output.append(parkingLot.currentIncome()).append(ls);
        parkingLot.passingMinutes(120);
        parkingLot.driveOut("12340", "88342", "33333", "55555", "30001");
        output.append(parkingLot.currentIncome()).append(ls);
        parkingLot.findingAllCarsByNumber().forEach(e -> output.append(e).append(ls));
        assertEquals("340" + ls +
                "570" + ls +
                "OtherCar 粤B00100 17:53" + ls +
                "SmallCar 粤B11213 02:57" + ls +
                "LargeCar 粤B13844 04:02" + ls +
                "LargeCar 粤B21112 12:00" + ls +
                "OtherCar 粤B23333 17:53" + ls +
                "LargeCar 粤B32229 12:00" + ls +
                "OtherCar 粤B43533 17:53" + ls +
                "OtherCar 粤B44444 17:53" + ls +
                "LargeCar 粤B46272 04:02" + ls +
                "CSECar 粤B48887 17:40" + ls, output.toString());

    }

}
