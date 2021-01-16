package ASSIGNMENT4;

public class  Polynomial {
    int[] b;

    public Polynomial(int[] a) {
        b = a;
    }

    @Override
    public String toString() {
        String c = "";
        for (int i = 0; i < b.length; i++) {
            if (i != b.length - 1 && b[i] != 0) {
                c += i + ":" + b[i] + " ";
            }
            else if (i == b.length-1 && b[i] != 0){
                c += i + ":" + b[i];
            }
        }
            return c;
    }

    public Polynomial add(Polynomial polynomial){
        int j = Math.max(b.length,polynomial.b.length);
        int[] k =new int[j];

        for (int i = 0; i < j; i++) {
            if (i < b.length && i < polynomial.b.length){
                k[i] = b[i] + polynomial.b[i];
            }
            else if (i > b.length-1 && i <= polynomial.b.length-1){
                k[i] = polynomial.b[i];
            }
            else if (i > polynomial.b.length-1 && i<=b.length-1){
                k[i] = b[i];
            }
        }
        Polynomial combination = new Polynomial(k);
        b = k;
        return combination;
    }

    public Polynomial minus(Polynomial polynomial){
        int j = Math.max(b.length,polynomial.b.length);
        int[] k =new int[j];

        for (int i = 0; i < j; i++) {
            if (i < b.length && i < polynomial.b.length){
                k[i] = b[i] - polynomial.b[i];
            }
            else if (i > b.length-1 && i <= polynomial.b.length-1){
                k[i] = -polynomial.b[i];
            }
            else if (i > polynomial.b.length-1 && i<=b.length-1){
                k[i] = b[i];
            }
        }
        Polynomial combination = new Polynomial(k);
        b = k;
        return combination;
    }

    public Polynomial multiply(Polynomial polynomial){
        int j = Math.max(b.length,polynomial.b.length);
        int p = b.length + polynomial.b.length - 1;
        int[] k =new int[p];
        for (int i = 0; i < p; i++) {
            for (int l = 0; l < j; l++) {
                if (i-l>=0) {
                    if (b.length >= polynomial.b.length && i-l<polynomial.b.length){
                        k[i] += b[l] * polynomial.b[i-l];
                    }
                    else if(b.length < polynomial.b.length && i-l<b.length){
                        k[i] += polynomial.b[l] * b[i-l];
                    }
                }
            }
        }
        Polynomial combination = new Polynomial(k);
        b = k;
        return combination;
    }

    public static Polynomial add(Polynomial p1,Polynomial p2){
        int j = Math.max(p1.b.length,p2.b.length);
        int[] k =new int[j];

        for (int i = 0; i < j; i++) {
            if (i < p1.b.length && i < p2.b.length){
                k[i] = p1.b[i] + p2.b[i];
            }
            else if (i > p1.b.length-1 && i <= p2.b.length-1){
                k[i] = p2.b[i];
            }
            else if (i > p2.b.length-1 && i<=p1.b.length-1){
                k[i] = p1.b[i];
            }
        }
        Polynomial combination = new Polynomial(k);
        return combination;
    }

    public static Polynomial minus(Polynomial p1,Polynomial p2){
        int j = Math.max(p1.b.length,p2.b.length);
        int[] k =new int[j];

        for (int i = 0; i < j; i++) {
            if (i < p1.b.length && i < p2.b.length){
                k[i] = p1.b[i] - p2.b[i];
            }
            else if (i > p1.b.length-1 && i <= p2.b.length-1){
                k[i] = -p2.b[i];
            }
            else if (i > p2.b.length-1 && i<=p1.b.length-1){
                k[i] = p1.b[i];
            }
        }
        Polynomial combination = new Polynomial(k);
        return combination;
    }

    public static Polynomial multiply(Polynomial p1,Polynomial p2){
        int j = Math.max(p1.b.length,p2.b.length);
        int p = p1.b.length + p2.b.length - 1;
        int[] k =new int[p];
        for (int i = 0; i < p; i++) {
            for (int l = 0; l < j; l++) {
                if (i-l>=0) {
                    if (p1.b.length >= p2.b.length && i-l<p2.b.length){
                        k[i] += p1.b[l] * p2.b[i-l];
                    }
                    else if(p1.b.length < p2.b.length && i-l<p1.b.length){
                        k[i] += p2.b[l] * p1.b[i-l];
                    }
                }
            }
        }
        Polynomial combination = new Polynomial(k);
        return combination;
    }

}
