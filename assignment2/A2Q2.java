package ASSIGNMENT2;

import java.util.Scanner;

public class A2Q2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] id0 = new int[n];
        int[] amount0 = new int[n];
        int[] id = new int[n];
        int[] amount = new int[n];

        for (int i = 0; i < n; i++) {
            id0[i] = input.nextInt();
            amount0[i] = input.nextInt();
        }
        for(int e=0; e<n; e++) {
            id[e] = id0[e];
            amount[e] = amount0[e];
        }
        for(int j=0; j<n; j++){
            for(int i=n-1; i>=1; i--){
                if(amount[i]>amount[i-1]){
                    int temp1=amount[i];
                    amount[i]=amount[i-1];
                    amount[i-1]=temp1;
                    int temp2=id[i];
                    id[i]=id[i-1];
                    id[i-1]=temp2;
                }
            }
        }

        int[] id1 = new int[n];
        int[] amount1 = new int[n];

        for(int i=0; i<5; i++){
            id1[i]=id[i];
            amount1[i]=amount[i];
        }

        for(int i=0; i<5; i++){
            for(int j=0; j<n; j++){
                if(id1[i]==id0[j] && amount1[i]==amount0[j]){
                    id0[j]=-1;
                }
            }
        }
            int r=5;
            for (int i = 0; i < n; i++) {
                if (id0[i] != -1) {
                    id1[r] = id0[i];
                    amount1[r] = amount0[i];
                    r=r+1;
                }
            }

        for(int k=0; k<n; k++){
            System.out.printf("%d %d",id1[k],amount1[k]);
            System.out.println();
        }
    }
}



