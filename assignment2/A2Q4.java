package ASSIGNMENT2;

import java.util.Scanner;

public class A2Q4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int o = 0;
        int n = input.nextInt();
        int[][] array = new int[n][n];
        int[] value1 = new int[n];
        int[] value2 = new int[n];
        int r=0;
        int c=0;
        int sum1=0;
        int sum2=0;

        for (r = 0; r < n; r++) {
            for (c = 0; c < n; c++) {
                array[r][c] = input.nextInt();
            }
        }
        for (r = 0; r < n; r++) {
            for (c = 0; c < n; c++) {
                value1[r] = value1[r] + array[r][c];
            }
        }
        for (r = 0; r < n; r++){
            if(value1[r]==n*(1+n*n)/2){

        }
            else {
                o=o+1;
        }
        }
        for (c = 0; c < n; c++) {
            for (r = 0; r < n; r++) {
                value2[c] = value2[c] + array[r][c];
            }
        }
        for (c = 0; c < n; c++){
            if(value2[c] == n*(1+n*n)/2){

            } else {
                o=o+1;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j] < 1 || array[i][j] > n * n) {
                        o=o + 1;
                } else {

                    }
                }
            }

        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-1; j++) {
                if (array[i][j] == array[i][j + 1]) {
                    o = o + 1;
                    }
                else {

                    }
                }
        }
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-1; j++) {
                if (array[i][j] == array[i + 1][j]) {
                    o = o + 1;
                }
                else {

                }
            }
        }

            for (int i = 0; i < n; i++) {
                sum1=sum1+array[i][i];
                }
            for (int i = n-1; i >= 0; i--){
                sum2=sum2+array[i][i];
            }
            if(sum1!=n*(1+n*n)/2 || sum2!=n*(1+n*n)/2){
                o=o+1;
            }
            else {
                ;
            }
            if(o==0){
                System.out.print("true");
            }
            else {
                System.out.print("false");
            }
    }
}
