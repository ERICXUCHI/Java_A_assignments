package ASSIGNMENT4;

import ASSIGNMENT4.BusLine;
import ASSIGNMENT4.District;
import ASSIGNMENT4.Station;

public class Main2 {
    public static void main(String[] args) {
        BusLine busLine74 = new BusLine("74");
        Station s1 = new Station("Taoyuan", District.NANSHAN, 22.5325, 113.92472);
        Station s2 = new Station("NanShan", District.NANSHAN, 22.52975, 113.9304333);
        Station s3 = new Station("Changlingpi", District.NANSHAN, 22.59917, 114.0111);
        Station s4 = new Station("Xili", District.NANSHAN, 22.58056, 113.95444);
        Station s5 = new Station("UniversityTown", District.NANSHAN, 22.58194, 113.965);
        Station s6 = new Station("Chaguang", District.NANSHAN, 22.57694, 113.94944);


        busLine74.addStation(s1);
        busLine74.addStation(s2);
        busLine74.addStation(s3);
        busLine74.printStation();

        System.out.println(busLine74.getNumber());

        busLine74.addStation(s4, 2);
        busLine74.addStation(s5, 3);

        busLine74.addStation(s6);
        busLine74.printStation();
        System.out.println(busLine74.getTail());


        Station s7 = new Station("ShenzhenUniversity", District.NANSHAN, 22.53861, 113.94417);
        Station s8 = new Station("Minle", District.LONGHUA, 22.59389, 114.04889);
        System.out.println(busLine74.nearestStation(s7).getName());

        BusLine busLine81 = new BusLine();
        busLine81.addStation(s7);
        busLine81.addStation(s8);
        busLine81.addStation(s4);

        busLine81.printStation();

        System.out.printf("%%%.3f\n", busLine74.ratioOfDistrict(District.NANSHAN)*100);
    }
}
