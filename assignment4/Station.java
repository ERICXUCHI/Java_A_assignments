package ASSIGNMENT4;

public class Station {
    private String name;
    private District district;
    private double latitude;
    private double longitude;
    private Station next;

    public Station() {
    }

    public Station(String name, District district, double latitude, double longitude) {
        this.name = name;
        this.district = district;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setNext(Station next) {
        this.next = next;
    }

    public String getName() {
        return name;
    }

    public District getDistrict() {
        return district;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public Station getNext() {
        return next;
    }

    public boolean equals(Station s) {
        if (s != null){
        if (getName() == s.getName() && getDistrict() == s.getDistrict() && getLatitude() == s.getLatitude() && getLongitude() == s.getLongitude()) {
            return true;
        }
        else {
            return false;
        }
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "ASSIGNMENT4.Station{" +
                "name='" + name + '\'' +
                ", district=" + district.getName() +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", next=" + next +
                '}';
    }
}
