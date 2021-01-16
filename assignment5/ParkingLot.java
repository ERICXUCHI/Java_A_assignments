package ASSIGNMENT5;

import java.util.List;

public interface ParkingLot {

    /**
     * The method is used to add parking spots with {@code type} and {@code count}.<br>
     * If the type of the parking lots haven't been created, you need to create it first and then add the count, otherwise, you can add the count directly to corresponding parking lot<br>
     * --There are two parameters need to be passed.<br>
     * --There is no value need to be returned.<br>
     * @param type an integer which represents the type of parking spot. It only has two values: 0 and 1.<br>
     *             --type==0 represent the SmallCar<br>
     *             --type==1 represent the LargeCar<br>
     * @param count an integer which means how many spots need to be added.<br>
     */
    public void addParkingSpot(int type, int count);

    /**
     * The method is used to add parking spots with {@code type} and {@code count}.<br>
     * If the type of the parking lots haven't been created, you need to create it first and then add the count, otherwise, you can add the count directly to corresponding parking lot<br>
     * --There are two parameters need to be passed.<br>
     * --There is no value need to be returned.<br>
     * @param type an object which extends Car represents a type of car. It will be like "SmallCar.class", or other arbitrary subclasses of Car (It is your bonus)<br>
     * @param count an integer which means how many spots need to be added.<br>
     */
    public void addParkingSpot(Class<? extends Car> type, int count);

    /**
     * The method is used to get a List&lt;String&gt; of String include the information about parking spot.<br>
     * The string of the information must be "(type of car spot): (the vacant spots)/(all spots)". <br>
     * --There are no parameters needed to be passed.<br>
     * --There is a value need to be returned.<br>
     * @return a List&lt;String&gt; of String which has a list of information. Each information must be like "SmallCar: 5/12", which means the parking spot of SmallCar has 5 of 12 vacant spots.<br>
     * --If you can return the information of more types (those are arbitrary subclass of Car) of spot like "OtherCar", "SUSTechCar", "TransformerCar" etc, it will be your bonus! <br>
     */
    public List<String> getParkingSpotInfo();

    /**
     * The method is used to get a {@code String} include the information of one type of car about parking spot.<br>
     * The string of the information must be "(type of car spot): (the vacant spots)/(all spots)". <br>
     * --There is one parameter need to be passed.<br>
     * --There is a value need to be returned.<br>
     * @param type an integer which represents the type of parking spot. It only has two values: 0 and 1.<br>
     *             --type==0 represent the SmallCar<br>
     *             --type==1 represent the LargeCar<br>
     * @return a {@code String} has a information. It must be like "LargeCar: 0/3", which means the parking spot of LargeCar has 0 of 3 vacant spots.<br>
     */
    public String getParkingSpotInfo(int type);

    /**
     * The method is used to get a {@code String} include the information of one type of car about parking spot.<br>
     * The string of the information must be "(type of car spot): (the vacant spots)/(all spots)". <br>
     * --There is one parameter need to be passed.<br>
     * --There is a value need to be returned.<br>
     * @param type an object which extends Car represents a type of car. It will be like "SmallCar.class".<br>
     *             --If you can return the information of more types of spot like "OtherCar.class", "SUSTechCar.class", "TransformerCar.class" etc, or other arbitrary subclasses of Car (It will be your bonus)<br>
     * @return a {@code String} has a information. It must be like "LargeCar: 0/3", which means the parking spot of LargeCar has 0 of 3 vacant spots.<br>
     */
    public String getParkingSpotInfo(Class<? extends Car> type);

    /**
     * The method is used to record the information of a series of new cars, which prepare to park.<br>
     * You need to create each corresponding {@code Car}:<br>
     * 1. For SmallCar, the original value of deduction is determined by whether its plate number is an even number. If it is an even number, deduction is true, otherwise, deduction is false.<br>
     * 2. set its {@code arriveTime} and {@code plateNumber}.<br>
     * 3. add them to cars list and add count number to corresponding parking Spot.<br>
     * 4. if the count of current Car equivalent to the capacity of the type of current car, the cars cannot be driven into the parking pots.
     * For example, if the capacity of "SmallCar" is 5, and the current count of "SmallCar" in parking lot is 4,
     * now there are 3 "SmallCar" (22222,33333,44444) want to drive into the parking lot, in this case, only 22222 can be driven but other two cannot.
     * --There are one parameter and a series of parameters need to be passed.<br>
     * --There is no value need to be returned.<br>
     * @param type an integer which represents the type of car. It only has two values: 0 and 1.<br>
     *             --type==0 represent the SmallCar<br>
     *             --type==1 represent the LargeCar<br>
     * @param plateNumbers an array with a series of new cars with their plates, it will be like ("30001", "10088"), ("30001", "10088", "11111") or ("30001", "10088", "11111", "10086"). We can make sure that our test cases are all five-digital Integers<br>
     */
    public void driveInto(int type, String... plateNumbers);

    /**
     * The method is used to record the information of a series of new cars, which prepare to park.<br>
     * You need to create each corresponding {@code Car}:<br>
     * 1. For SmallCar, the original value of deduction is determined by whether its plate number is an even number. If it is an even number, deduction is true, otherwise, deduction is false.<br>
     * 2. set its {@code arriveTime} and {@code plateNumber}.<br>
     * 3. add them to cars list and add count number to corresponding parking Spot.<br>
     * 4. if the count of current Car equivalent to the capacity of the current car type, the cars cannot be driven into the parking pots.
     * For example, if the capacity of "SmallCar" is 5, and the current count of "SmallCar" in parking lot is 4,
     * now there are 3 "SmallCar" (22222,33333,44444) want to drive into the parking lot, in this case, only 22222 can be driven but other two cannot.
     * --There are one parameter and a series of parameters need to be passed.<br>
     * --There are one parameter and a series of parameters need to be passed.<br>
     * --There is no value need to be returned.<br>
     * @param type an arbitrary type of subclass of Car. It will be like "SmallCar.class".<br>
     *               --If you can return the information of more types (those are arbitrary subclass of Car) of spot like "OtherCar", "SUSTechCar", "TransformerCar" etc, it will be your bonus! <br>
     * @param plateNumbers an array with a series of new cars with their plates, it will be like ("30001", "10088"), ("30001", "10088", "11111") or ("30001", "10088", "11111", "10086"). We can make sure that our test cases are all five-digital Integers<br>
     */
    public void driveInto(Class<? extends Car> type, String... plateNumbers);

    /**
     * The method is used to remove the objects of a series of cars.<br>
     * You need to find all removed cars:<br>
     * 1. minus corresponding count number in corresponding parking spot<br>
     * 2. calculate the money that the car need to pay. Then add all to your {@code Income} and update it<br>
     * We can make sure that our test cases of plateNumbers are all cars in the parking lots.
     * --There are a series of parameters need to be passed.<br>
     * --There is no value need to be returned.<br>
     * @param plateNumbers an array with a series of new cars with their plates, it will be like ("30001", "10088"), ("30001", "10088", "11111") or ("30001", "10088", "11111", "10086"). We can make sure that our test cases are all five-digital Integers<br>
     */
    public void driveOut(String... plateNumbers);

    /**
     * The method is used to record the passing minutes.<br>
     * You need to add the passing minutes to current {@code Time} and then update it.<br>
     * --There is a parameter need to be passed.<br>
     * --There is no value need to be returned.<br>
     * @param minutes an integer which means how much minutes is passed. It will be like "55", "300", "600" etc.<br>
     */
    public void passingMinutes(int minutes);

    /**
     * The method is used to return a List&lt;Car&gt; of {@code Cars}. Each car is sorted by {@code plateNumber} in ascending order.<br>
     * You need to sort all cars by their {@code plateNumber} in ascending order. Then return a List&lt;Car&gt; of cars with their information.<br>
     * --There is no parameter need to be passed.<br>
     * --There is a value need to be returned.<br>
     * @return a List&lt;Car&gt; of {@code Cars}.<br>
     */
    public List<Car> findingAllCarsByNumber();

    /**
     * The method is used to find and return a {@code Car} by its {@code plateNumber}.<br>
     * You need to find the car by its {@code plateNumber} and then return the {@code Car}.<br>
     * --There is a parameter need to be passed.<br>
     * --There is a value need to be returned.<br>
     * @param plateNumber a String represents the plateNumber of a car. It will be like "11117", "11118", "08932" etc.<br>
     * @return a {@code Car} which has been find by its {@code plateNumber}.<br>
     */
    public Car getCarInfoByPlateNumber(String plateNumber);

    /**
     * The method is used to return current {@code Income}.<br>
     * You need to return current {@code Income} when it be used.<br>
     * --There is no parameter need to be passed.<br>
     * --There is a value need to be returned.<br>
     * @return an integer which means the total {@code Income} till now today.<br>
     */
    public int currentIncome();

    /**
     * The method is used to return current {@code Time}.<br>
     * You need to return current {@code Time} when it be used.<br>
     * --There is no parameter need to be passed.<br>
     * --There is a value need to be returned.<br>
     * @return a {@code Time} which means the current {@code Time}.<br>
     */
    public Time getTime();
}
