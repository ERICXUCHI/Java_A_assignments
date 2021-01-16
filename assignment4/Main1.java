package ASSIGNMENT4;

import ASSIGNMENT4.Polynomial;

public class Main1 {
    public static void main(String[] args) {
        int[] p1 = {3, 1, 4, 0, 3};
        int[] p2 = {0, 0, 1, 3, 3, 1};
        int[] p3 = {4, -2, 1, -4, 0, 3};
        int[] p4 = {-2, 3, 1, -1, 0, 4};
        int[] p5 = {-2};
        Polynomial polynomial1 = new Polynomial(p1);
        Polynomial polynomial2 = new Polynomial(p2);
        Polynomial polynomial3 = new Polynomial(p3);
        Polynomial polynomial4 = new Polynomial(p4);
        Polynomial polynomial5 = new Polynomial(p5);
        System.out.println(polynomial1);
        System.out.println(polynomial2);
        System.out.println(polynomial3);
        System.out.println(polynomial4);
        System.out.println(polynomial5);


        System.out.println(polynomial1.add(polynomial2));
        System.out.println(polynomial1.minus(polynomial4));
        System.out.println(polynomial3.multiply(polynomial1));

        System.out.println(Polynomial.add(polynomial1, polynomial2));
        System.out.println(Polynomial.minus(polynomial1, polynomial2));
        System.out.println(Polynomial.multiply(polynomial1, polynomial2));

    }
}
