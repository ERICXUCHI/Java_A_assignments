package ASSIGNMENT3;

import java.util.Scanner;

public class A3Q1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        String[] name = new String[n];
        for (int i = 0; i < n; i++) {
            name[i] = input.nextLine();
        }
        for (int j = 0; j < n - 1; j++) {
            for (int i = 0; i < n - 1; i++) {
                int r = name[i].compareTo(name[i+1]);
                if (r<=0) {
                    String temp;
                    temp = name[i + 1];
                    name[i + 1] = name[i];
                    name[i] = temp;
                }
            }
        }
                {
                    for (int i = 0; i < n; i++) {
                        System.out.println(name[i]);
                    }
                }
            }
        }
