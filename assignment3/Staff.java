package ASSIGNMENT3;

public class Staff {
    private int staffID;
    private String name;
    private int level;
    private double basicSalary;
    private double saleAmount;
    private double curSalary;

    public void setStaffID(int staffID){
        this.staffID = staffID;
    }
    public int getStaffID(){
        return staffID;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setLevel(int level){
        this.level = level;
    }
    public int getLevel(){
        return level;
    }
    public void setBasicSalary(double basicSalary){
        this.basicSalary = basicSalary;
    }
    public double getBasicSalary(){
        return basicSalary;
    }
    public void setSaleAmount(double saleAmount){
        this.saleAmount = saleAmount;
    }
    public double getSaleAmount(){
        return saleAmount;
    }
    public double getCurSalary(){
        return curSalary;
    }

    public void updateCurSalary(int level,double basicSalary,double saleAmount) {
        switch (level) {
            case 1:
                curSalary = basicSalary + saleAmount * 0.06;
                this.curSalary=getCurSalary();
                break;
            case 2:
                curSalary = basicSalary + saleAmount * 0.03;
                this.curSalary=getCurSalary();
                break;
            case 3:
                curSalary = basicSalary + saleAmount * 0.02;
                this.curSalary=getCurSalary();
                break;
            case 4:
                curSalary = basicSalary + saleAmount * 0.01;
                this.curSalary=getCurSalary();
                break;
            case 5:
                curSalary = basicSalary + saleAmount * 0.005;
                this.curSalary=getCurSalary();
                break;
        }
    }

}
