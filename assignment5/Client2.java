package ASSIGNMENT5;

public class Client2 {
    public static void main(String[] args) {
        MyArrayList<Car> myArrayList = new MyArrayList<>();
        Time time=new Time(0,0);
        myArrayList.add(new LargeCar("22222",time));
        myArrayList.add(new LargeCar("33333",time));

        for (int i = 0; i < myArrayList.size(); i++) {
            System.out.println(myArrayList.get(i));
        }
    }
}
