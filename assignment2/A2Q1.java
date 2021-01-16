package ASSIGNMENT2;

import java.util.Scanner;

public class A2Q1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] id = new int[n];
        int[] amount = new int[n];
        int[] total = new int[n];
        int i, j;
        for (i = 0; i < n; i++) {

            id[i] = input.nextInt();
            amount[i] = input.nextInt();
            int money = 0;
            for (j = 1; j <= amount[i]; j++) {
                money = input.nextInt();
                total[i] = total[i] + money;
            }
        }
        for (int k = 0; k < n; k++) {
            System.out.printf("%d %d", id[k], total[k]);
            System.out.println();
        }


        }
    }

