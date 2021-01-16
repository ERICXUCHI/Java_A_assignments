import java.util.Scanner;

public class A2Q5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String[] strMap = new String[n];
        input.nextLine();
        for (int i = 0; i < strMap.length; i++) {
            strMap[i] = input.nextLine();
        }
        int[][] IntMap = new int[n][n];
        IntMap = strMapToIntMap(strMap);

        int x = input.nextInt();
        int y = input.nextInt();
        double[][] ave = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ave[i][j]=getAverage(IntMap,i,j);
            }
        }


        int[] temp = new int[2];

        for (int counter=0; counter<5; counter++) {
            temp = changePosition(ave, x, y);
            x += temp[0];
            y += temp[1];
            System.out.printf("%d %d\n", x, y);
        }
    }

    public static int[][] strMapToIntMap(String[] strMap) {
        int[][] IntMap = new int[strMap.length][strMap.length];
        for (int i = 0; i < strMap.length; i++) {
            for (int j = 0; j < strMap.length; j++) {
                switch (strMap[i].charAt(j)) {
                    case 'S':
                        IntMap[i][j] = 1;
                        break;
                    case 'R':
                        IntMap[i][j] = 2;
                        break;
                    case 'W':
                        IntMap[i][j] = 3;
                        break;
                    case 'F':
                        IntMap[i][j] = 4;
                        break;
                    case 'H':
                        IntMap[i][j] = 5;
                        break;
                    case 'C':
                        IntMap[i][j] = 6;
                        break;
                    case 'G':
                        IntMap[i][j] = 7;
                        break;
                }
            }
        }
        return IntMap;
    }

    public static double getAverage(int[][] intMap, int x, int y) {
        int z = intMap.length;
        double average=0;
        if (x-1>=0 && y-1>=0 && x+1<z && y+1<z) {
            average = (intMap[x-1][y-1] + intMap[x-1][y] + intMap[x-1][y+1] + intMap[x][y-1] + intMap[x][y] + intMap[x][y+1] + intMap[x+1][y-1] + intMap[x+1][y] + intMap[x+1][y+1]) / 9.0;
        }
        else if (x==0 && y-1>=0 && y+1<z) {
            average = (intMap[x][y-1]+intMap[x][y]+intMap[x][y+1]+intMap[x+1][y-1]+intMap[x+1][y]+intMap[x+1][y+1])/6.0;
        }
        else if (x==0 && y==0) {
            average = (intMap[x][y] + intMap[x][y+1] + intMap[x][y] + intMap[x+1][y+1]) / 4.0;
        }
        else if (y==0 && x-1>=0 && x+1<z) {
            average = (intMap[x-1][y] + intMap[x-1][y+1] + intMap[x][y] + intMap[x][y+1] + intMap[x+1][y] + intMap[x+1][y+1]) / 6.0;
        }
        else if (x==z-1 && y==0) {
            average = (intMap[x-1][y] + intMap[x-1][y+1] + intMap[x][y] + intMap[x][y+1]) / 4.0;
        }
        else if (x==z-1 && y-1>=0 && y+1<z) {
            average = (intMap[x-1][y-1] + intMap[x-1][y] + intMap[x-1][y+1] + intMap[x][y-1] + intMap[x][y] + intMap[x][y+1]) / 6.0;
        }
        else if (x==z-1 && y==z-1){
            average = (intMap[x-1][y-1]+intMap[x-1][y]+intMap[x][y-1]+intMap[x][y]) / 6.0;
        }
        else if (y==z-1 && x-1>=0 && x+1<z){
            average = (intMap[x-1][y-1]+intMap[x-1][y]+intMap[x][y-1]+intMap[x][y]+intMap[x+1][y-1]+intMap[x+1][y]) / 6.0;
        }
        else if (x==0 && y==z-1) {
            average = (intMap[x][y - 1] + intMap[x][y] + intMap[x + 1][y - 1] + intMap[x + 1][y]) / 4.0;
        }
        return average;
    }

    public static int[] changePosition(double[][] ave,int x,int y){
        int z = ave.length;
        double[] array = new double[4];
        if (x-1>=0 && y-1>=0 && x+1<z && y+1<z){
            array[0]=ave[x-1][y];
            array[1]=ave[x][y-1];
            array[2]=ave[x+1][y];
            array[3]=ave[x][y+1];
        }
        else if (x==0 && y-1>=0&& y+1<z){
            array[0]=0;
            array[1]=ave[x][y-1];
            array[2]=ave[x+1][y];
            array[3]=ave[x][y+1];
        }
        else if (x==0 && y==0){
            array[0]=0;
            array[1]=0;
            array[2]=ave[x+1][y];
            array[3]=ave[x][y+1];
        }
        else if (y==0 && x-1>=0 && x+1<z){
            array[0]=ave[x-1][y];
            array[1]=0;
            array[2]=ave[x+1][y];
            array[3]=ave[x][y+1];
        }
        else if (x==z-1 && y==0){
            array[0]=ave[x-1][y];
            array[1]=0;
            array[2]=0;
            array[3]=ave[x][y+1];
        }
        else if (x==z-1 && y-1>=0 && y+1<z){
            array[0]=ave[x-1][y];
            array[1]=ave[x][y-1];
            array[2]=0;
            array[3]=ave[x][y+1];
        }
        else if (x==z-1 && y==z-1){
            array[0]=ave[x-1][y];
            array[1]=ave[x][y-1];
            array[2]=0;
            array[3]=0;
        }
        else if (y==z-1 && x-1>=0 && x+1<z){
            array[0]=ave[x-1][y];
            array[1]=ave[x][y-1];
            array[2]=ave[x+1][y];
            array[3]=ave[x][y+1];
        }
        else if (x==0 && y==z-1){
            array[0]=ave[x-1][y];
            array[1]=ave[x][y-1];
            array[2]=ave[x+1][y];
            array[3]=ave[x][y+1];
        }

        double max=0;
        max = array[0];
        if (array[1] > array[0]) {
            max = array[1];
        }
        if (array[2] > array[1]) {
            max = array[2];
        }
        if (array[3] > array[2]) {
            max = array[3];
        }

        int [] ans = new int[2];
        for (int counter=0; counter<5; counter++) {
            if (max == array[0]) {
                ans[0] = - 1;
            } else if (max == array[1]) {
                ans[1] = - 1;
            } else if (max == array[2]) {
                ans[0] = 1;
            } else if (max == array[3]) {
                ans[1] = 1;
            }
        }
        return ans;
    }
}


