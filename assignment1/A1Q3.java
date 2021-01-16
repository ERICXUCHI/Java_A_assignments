package ASSIGNMENT1;

import java.util.Scanner;
public class A1Q3 {
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);

        double sum = 0;

        double a ;
        double b ;
        double c ;

        while(input.hasNext()){
            double price = input.nextDouble();
            double number = input.nextDouble();

            if(number==(int)number){
                sum = sum+(number*price);
            }
            else{

                a=Math.round(number*price*10)/10.0+1;

                sum = sum+a;
            }
        }
        System.out.println("END");
        System.out.printf("%.1f\n",sum);
    }
}
