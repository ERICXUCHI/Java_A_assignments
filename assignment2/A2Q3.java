package ASSIGNMENT2;

import java.util.Scanner;

public class A2Q3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int r = input.nextInt();
        int c = input.nextInt();
        int[][] array = new int[r+2][c+2];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                array[i+1][j+1] = input.nextInt();
            }
        }
        int x = input.nextInt();
        int y = input.nextInt();
        System.out.printf("%d %d",x,y);
        System.out.println();

        while (x>=0 && y>=0 && x<=r && y<=c) {
            if (array[x+1 + 1][y+1] == 2) {
                System.out.printf("%d %d", x + 1,y);
                System.out.println();
                array[x+1][y+1]=1;
                x = x + 1;
            }
            else if (array[x+1][y+1 - 1] == 2) {
                System.out.printf("%d %d", x, y - 1);
                System.out.println();
                array[x+1][y+1]=1;
                y = y - 1;
            }
            else if (array[x+1 - 1][y+1] == 2) {
                System.out.printf("%d %d", x - 1, y);
                System.out.println();
                array[x+1][y+1]=1;
                x = x - 1;
            }
            else if (array[x+1][y+1 + 1] == 2){
                System.out.printf("%d %d", x, y + 1);
                System.out.println();
                array[x+1][y+1]=1;
                y = y + 1;
            }
            else {
                break;
            }
        }

    }
}
