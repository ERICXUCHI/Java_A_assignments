package ASSIGNMENT3;

import java.util.Scanner;

public class A3Q2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String a = input.nextLine();
        char[] letter = new char[a.length()];
        int[] counts = new int[a.length()];
        int r = 0;
        for (int i = 0; i < a.length()-1; i++) {
            if (a.charAt(i) == a.charAt(i+1)) {
                counts[r]=counts[r]+1;
                letter[r]=a.charAt(i+1);
            }
            else  if (a.charAt(i)!=a.charAt(i+1)){
                r=r+1;
                letter[r]=a.charAt(i+1);
            }
        }
        for (int i = 0; i < r+1; i++) {
            System.out.printf("%s%d",letter[i],counts[i]+1);
        }
    }
}