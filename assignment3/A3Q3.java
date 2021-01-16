package ASSIGNMENT3;

import java.util.Scanner;

public class A3Q3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        String[] information = new String[n];

        for (int i = 0; i < n; i++) {
            information[i] = input.nextLine();
        }
        for (int i = 0; i < n; i++) {
            String[] tokens = information[i].split(",");
            for (int j = 0; j < tokens[1].length(); j++) {
                if (Character.isDigit(tokens[1].charAt(j))) {
                } else {
                    tokens[1] = tokens[1].replace(tokens[1].charAt(j), ' ');
                }
            }
            String[] tokens1 = tokens[1].trim().split(" ");
            for (int k = 0; k < tokens1.length; k++) {
                if (tokens1[k].trim().length() == 8 && (tokens1[k].trim().startsWith("115") || tokens1[k].trim().startsWith("116") || tokens1[k].trim().startsWith("117") || tokens1[k].trim().startsWith("118") || tokens1[k].trim().startsWith("119"))) {
                    System.out.print(tokens1[k].trim() + " ");
                    System.out.print(tokens[0].trim());
                    System.out.println();
                }
            }
        }
        }
    }

