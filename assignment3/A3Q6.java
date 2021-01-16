import java.util.Scanner;

public class A3Q6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String letters = input.next();
        input.nextLine();
        int n = input.nextInt();
        int p = letters.length()/ (2 * n - 2) * (n - 1) ;
        char[][] words = new char[0][0];
        if (letters.length() % (2 * n - 2) == 0) {
            words = new char[n][p];
            for (int i = 0; i < p; i++) {
                if (i%(n-1)==0){
                    for (int j = 0; j < n; j++) {
                        if (i / (n - 1) * (2 * n - 2) + j<=letters.length()-1) {
                            words[n - 1 - j][p - 1 - i] = letters.charAt(i / (n - 1) * (2 * n - 2) + j);
                        }
                    }
                }
                for (int k = 1; k < n-1; k++) {
                    if (i %(n-1)==k){
                        if (i / (n - 1) * (2 * n - 2) + n + k - 1<=letters.length()-1) {
                            words[k][p - 1 - i] = letters.charAt(i / (n - 1) * (2 * n - 2) + n + k - 1);
                        }
                    }
                }
            }
        }
        if (letters.length() % (2 * n - 2) <= n) {
            words = new char[n][p + 1];
            for (int i = 0; i < p+1; i++) {
                if (i%(n-1)==0){
                    for (int j = 0; j < n; j++) {
                        if (i/(n-1)*(2*n-2)+j<=letters.length()-1){
                        words[n-1-j][p+1-1-i] = letters.charAt(i/(n-1)*(2*n-2)+j);
                        }
                    }
                }
                for (int k = 1; k < n-1; k++) {
                    if (i %(n-1)==k){
                        if (i / (n - 1) * (2 * n - 2) + n + k - 1<=letters.length()-1) {
                            words[k][p + 1 - 1 - i] = letters.charAt(i / (n - 1) * (2 * n - 2) + n + k - 1);
                        }
                    }
                }
            }
        }
        if (letters.length() % (2 * n - 2) > n) {
            int q = p+1 + letters.length() - (letters.length() / (2 * n - 2)) * (2 * n - 2) - n;
            words = new char[n][q];
            for (int i = 0; i < q; i++) {
                if (i%(n-1)==0){
                    for (int j = 0; j < n; j++) {
                        if (i/(n-1)*(2*n-2)+j<=letters.length()-1) {
                            words[n - 1 - j][q - 1 - i] = letters.charAt(i / (n - 1) * (2 * n - 2) + j);
                        }
                    }
                }
                for (int k = 1; k < n-1; k++) {
                    if (i %(n-1)==k){
                        if (i / (n - 1) * (2 * n - 2) + n + k - 1<=letters.length()-1) {
                            words[k][q - 1 - i] = letters.charAt(i / (n - 1) * (2 * n - 2) + n + k - 1);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < words[i].length; j++) {
                System.out.printf("%s",words[i][j]);
            }
            System.out.println();
        }

    }
}
