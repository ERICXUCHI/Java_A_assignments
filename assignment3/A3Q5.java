package ASSIGNMENT3;

import java.util.ArrayList;
import java.util.Scanner;

public class A3Q5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        input.nextLine();
        int[] staffID = new int[n];
        String[] name = new String[n];
        int[] level = new int[n];
        double[][] information = new double[n][2];
        for (int i = 0; i < n; i++) {
            staffID[i] = input.nextInt();
            name[i] = input.next();
            level[i] = input.nextInt();
              for (int j = 0; j < 2; j++) {
                  information[i][j] = input.nextDouble();
            }
        }
        int p = input.nextInt();
        input.nextLine();
        int[][] modification = new int[p][2];
        double[] modifyContent = new double[p];
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < 2; j++) {
                modification[i][j] = input.nextInt();
            }
            modifyContent[i] = input.nextDouble();
        }
        for (int i = 0; i < p; i++) {
            switch (modification[i][0]){
                case 1:for (int j = 0; j < n; j++){
                    if (staffID[j]==modification[i][1]){
                        level[j]=(int)modifyContent[i];
                    }
                }break;
                case 2:for (int j = 0; j < n; j++){
                    if (staffID[j]==modification[i][1]){
                        information[j][0]=modifyContent[i];
                    }
                }break;
                case 3:for (int j = 0; j < n; j++){
                    if (staffID[j]==modification[i][1]){
                        information[j][1]=modifyContent[i];
                    }
                }break;
            }
        }
        ArrayList<Staff> staffList=new ArrayList<Staff>();
        for (int i = 0; i < n; i++) {
            staffList.add(new Staff());
            staffList.get(i).setStaffID(staffID[i]);
            staffList.get(i).setName(name[i]);
            staffList.get(i).setLevel(level[i]);
            staffList.get(i).setBasicSalary(information[i][0]);
            staffList.get(i).setSaleAmount(information[i][1]);
            staffList.get(i).updateCurSalary(level[i],information[i][0],information[i][1]);
            System.out.printf("%.2f\n", staffList.get(i).getCurSalary());
        }
    }
}
