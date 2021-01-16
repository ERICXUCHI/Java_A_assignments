package ASSIGNMENT1;

import java.util.Scanner;

public class A1Q2 {

    public static void main(String[]args){
        Scanner input=new Scanner(System.in);

        int a,b,c,d,e,f,g,h,i,j,k;
        a=input.nextInt();
        b=input.nextInt();
        c=input.nextInt();
        d=a*3600+b*60+c;

        e=input.nextInt();
        f=input.nextInt();
        g=input.nextInt();
        h=e*3600+f*60+g;

        i=h-d;
        j = i % 60;
        k = i / 60;

        if(k==0){
            System.out.println(j+"s");
        }
        else if (j==0){
            System.out.println(k+"m");
        }
        else {
            System.out.println(k+"m"+j+"s");
        }


    }
}
