package ASSIGNMENT1;

public class A1Q1 {
    public static void main(String[]args){
        String a = (args[0]);
        String b = (args[1]);
        int temp=(int)b.charAt(2);
        if(b.length()==8 && b.charAt(0)=='1' && b.charAt(1)=='1' && (temp>=(int)'5'&&temp<=(int)'9'))
        {
            System.out.println(a+", welcome to SUSTECH Hot Pot Restaurant!");
        }
        else{
            System.out.println(b);
        }
    }

}


