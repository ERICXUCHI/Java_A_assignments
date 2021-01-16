package ASSIGNMENT4;

public enum District {
    BAOAN ("Bao'an",25),
    FUTIAN("Futian",51),
    LONGGANG("Longgang",22),
    LONGHUA("Longhua",9),
    LUOHU("Luohu",23),
    NANSHAN("Nanshan",49);

    private String name;
    private int stationCount;

    District(String name, int stationCount){
        this.name = name;
        this.stationCount = stationCount;
    }

    public String getName(){
        return name;
    }

    public int getStationCount(){
        return stationCount;
    }
}
