package ASSIGNMENT4;

import javafx.scene.Scene;

public class BusLine {
    private Station head =new Station();// the head station of busline, and usually it doesn't store any data except the next Node.
    private Station tail;// the last station in the busline.
    private String number;// the number of current busline, such as 81 or 74
    private int size;// the size of current busline, and the initial value of which is 0, when adding a station, the value of size would increase by 1.


    public BusLine(){
    }
    public BusLine(String number){
        this.number = number;
    }


    public void setHead(Station head) {
        this.head = head;
    }

    public void setTail(Station tail) {
        this.tail = tail;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Station getHead() {
        return head;
    }

    public Station getTail() {
        return tail;
    }

    public String getNumber() {
        return number;
    }

    public int getSize() {
        return size;
    }

    public void addStation(Station station){
        if (size>0) {
            getTail().setNext(station);
            setTail(station);
        }
        else {

            head.setNext(station);
            setTail(station);
        }
        size++;
    }

    public void addStation(Station station, int index){

        Station cur = head;
        if (index == 0) {
            station.setNext(head.getNext());
            head.setNext(station);
        }
        else if (index > 0){
            for (int i = 0; i < index; i++) {
                cur = cur.getNext();
            }
            station.setNext(cur.getNext());
            cur.setNext(station);
        }
            size++;
    }



    public boolean isEmpty(){
        if (size==0){
            return true;
        }
        else {
            return false;
        }
    }

    public int size(){
        return size;
    }

    public void printStation(){
        Station now = head.getNext();
        if (size != 0){
        for (int i = 0; i < size; i++) {
            System.out.printf("%s ", now.getName());
            now = now.getNext();
        }
        }
    }

    public Station nearestStation(Station station){

        Station nearStation = station;
        double[] Distance = new double[size];
        double min;
        Station pre = head;
        for (int i = 0; i < size; i++) {
            pre = pre.getNext();
            Distance[i] = Math.sqrt((pre.getLatitude() - station.getLatitude())*(pre.getLatitude() - station.getLatitude())+(pre.getLongitude() - station.getLongitude())*(pre.getLongitude() - station.getLongitude()));
        }
        if (Distance[0] != 0) {
            min = Distance[0];
        }
        else {
            min = Distance[1];
        }

        pre = head;
        for (int i = 0; i < size; i++) {
            if (Distance[i] < min && Distance[i] != 0) {
                min = Distance[i];
            }
        }
        for (int i = 0; i < size; i++) {
            if (Distance[i] == min){
                if (i == 0){
                    nearStation = pre.getNext();
                }
                else {
                    for (int j = 0; j < i; j++) {
                        pre = pre.getNext();
                    }
                    nearStation = pre.getNext();
                }
            }
        }
        return nearStation;
    }

    public double ratioOfDistrict(District district){
        double num = 0;
        Station pos = head;
        for (int i = 0; i < size; i++) {
            pos = pos.getNext();
            if (pos.getDistrict() == district){
                num++;
            }
        }
        return num/district.getStationCount();
    }

    }


