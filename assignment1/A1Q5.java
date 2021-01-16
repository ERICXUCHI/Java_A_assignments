package ASSIGNMENT1;

public class A1Q5 {
    public static void main(String[]args){
        double single []=new double[args.length];
        boolean have_bad=false;
        for(int i = 0;i < args.length;i++) {
            single[i] = Double.parseDouble(args[i]);

            if (Math.floor(single[i]) % 10 != 2 && Math.floor(single[i]) % 10 != 4) {

            }
            else {
                have_bad = true;
            }
        }
        if (have_bad){
            for(int k = 0;k < args.length;k++){
            if(Math.floor(single[k])%10==2){
                System.out.print(single[k]+4);
                System.out.print(' ');
            }
            else if(Math.floor(single[k])%10==4){
                System.out.print(single[k]+5);
                System.out.print(' ');
            }

        }

    }
}
}


