package ASSIGNMENT3;

import java.util.Scanner;

public class A3Q4 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        String[][] information = new String[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                information[i][j] = input.next();
            }
            input.nextLine();
        }
        String in = input.next();
        if (isOneNumber(in)){
            for (int i = 0; i < n; i++) {
                if (information[i][0].endsWith(in)) {
                    for (int j = 0; j < 2; j++) {
                        System.out.print(information[i][j] + " ");
                    }
                    System.out.println();
                }
                }
        }
        if (isNumeric(in)){
            for (int i = 0; i < n; i++) {
                if (information[i][0].contains(in)) {
                    for (int j = 0; j < 2; j++) {
                        System.out.print(information[i][j] + " ");
                    }
                    System.out.println();
                }
            }
        }
        if (isLetter(in)){
            for (int i = 0; i < n; i++) {
                if (information[i][1].contains(in)) {
                    for (int j = 0; j < 2; j++) {
                        System.out.print(information[i][j] + " ");
                    }
                    System.out.println();
                }
            }
        }
    }

    public static boolean isOneNumber(String str) {
        if (Character.isDigit(str.charAt(0)) && str.length() == 1) {
            return true;
        }
        else {
            return false;
        }
    }
    public static boolean isNumeric(String str){
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i)) && str.length() > 1) {
                return true;
            }
        }
        return false;
        }
    public static boolean isLetter(String str){
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                return true;
            }
        }
        return false;
        }
    }