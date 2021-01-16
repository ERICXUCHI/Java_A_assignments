package ASSIGNMENT5;

public class ParkingLotCondition {

    private int type;
    private int total;
    private int occupied;
    private String typeName;
    private Class classType;

    public ParkingLotCondition(int total, int occupied, String typeName, Class classType) {
        this.total = total;
        this.occupied = occupied;
        this.typeName = typeName;
        this.classType = classType;
    }

    public ParkingLotCondition(){

    }

    public int getType(){
        return type;
    }

    public void setType(int type){
        this.type = type;
    }

    public int getTotal(){
        return total;
    }

    public void setTotal(int count){
        this.total += count;
    }

    public int getOccupied(){
        return occupied;
    }

    public void setOccupied(int occupied){
        this.occupied += occupied;
    }

    public void setCapacity(){
    }

    public int getCapacity(){
        return getTotal() - getOccupied();
    }

    public void setClassType(Class classType) {
        this.classType = classType;
    }

    public Class getClassType() {
        return classType;
    }

    public void setTypeName(String name){
        this.typeName = name;
    }

    public String getTypeName(){
        return typeName;
    }


}
