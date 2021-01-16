package ASSIGNMENT2;

public class A2Q6 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0].trim());
        if (n % 2 == 0) {
            System.out.print("Invalid");
        }
        else {
            int i = 0;
            int r = (n - 1) / 2;
            int[][] magic_square = new int[n][n];
            magic_square[0][(n - 1) / 2] = 1;
            for (int c = 2; c <= n * n; c++) {
                //1
                if (i - 1 >= 0 && r + 1 <= n - 1) {
                    if (magic_square[i - 1][r + 1] == 0) {
                        magic_square[i - 1][r + 1] = c;
                        i = i - 1;
                        r = r + 1;
                    }
                    else {
                        magic_square[i + 1][r] = c;
                        i = i + 1;
                    }
                }
                //2
                else if (i - 1 < 0 && r + 1 <= n - 1) {
                    if (magic_square[n - 1][r + 1] == 0) {
                        magic_square[n - 1][r + 1] = c;
                        i = n - 1;
                        r = r + 1;
                    }
                    else {
                        magic_square[i + 1][r] = c;
                        i = i + 1;
                    }
                }
                //3
                else if (i - 1 < 0 && r + 1 > n - 1) {
                    magic_square[i + 1][r] = c;
                    i = i + 1;
                }
                //4
                else if (i - 1 >= 0 && r + 1 > n - 1) {
                    if (magic_square[i - 1][0] == 0) {
                        magic_square[i - 1][0] = c;
                        i = i - 1;
                        r = 0;
                    }
                    else {
                        magic_square[i + 1][r] = c;
                        i = i + 1;
                    }
                }
            }
            for (int e = 0; e < n; e++) {
                for (int f = 0; f < n; f++) {
                    System.out.printf("%d ",magic_square[e][f]);
                }
                System.out.println();
            }
        }
    }
}

