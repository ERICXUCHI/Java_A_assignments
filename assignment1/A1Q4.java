package ASSIGNMENT1;

public class A1Q4 {
    public static void main(String[]args){
        int num = args.length;
        double single []=new double[args.length];
        for(int i = 0 ;i < args.length;i++){
            single[i] = Double.parseDouble(args[i]);
        }
        double sum = 0;
        for(int i = 0;i < args.length;i++){
            sum = sum + single[i];
        }
        double maxsingle = 0;
        for(int i = 0;i < args.length;i ++){
            if(single[i]>maxsingle){
                maxsingle = single[i];
            }
        }
        if((num>=10&&sum>=5000)||maxsingle>=8000 ){
            System.out.println("Diamond");
        }
        else if((num>=5&&sum>=2000)||maxsingle>=3000){
            System.out.println("Gold");
        }
        else if((num>=2&&sum>=800)||maxsingle>=1000){
            System.out.println("Silver");
        }
    }
}
