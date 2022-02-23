package lab1;
import java.util.Scanner;

    //-----------------------------------------------------------------
   //  Author: Başar YILMAZ
   //-----------------------------------------------------------------

public class EquationTester {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        /*
        String[] eq1_strArr = new String[3];
        int[] eq1_intArr = new int[3];
        String[] eq2_strArr = new String[3];
        int[] eq2_intArr = new int[3];

        System.out.print("Enter a, b, and c for equation1: ");
        String in_eq1 = in.nextLine();
        eq1_strArr = in_eq1.split(" ");
        for (int i = 0; i < eq1_intArr.length; i++){
            eq1_intArr[i] = Integer.parseInt(eq1_strArr[i]);
        }

        System.out.print("Enter a, b, and c for equation2: ");
        String in_eq2 = in.nextLine();
        eq2_strArr = in_eq2.split(" ");
        for (int i = 0; i < eq2_intArr.length; i++){
            eq2_intArr[i] = Integer.parseInt(eq2_strArr[i]);
        }
        */

        System.out.print("Enter a, b, and c for equation1: ");
        Equation test1 = new Equation(in.nextInt(), in.nextInt(), in.nextInt());

        System.out.print("Enter a, b, and c for equation2: ");
        Equation test2 = new Equation(in.nextInt(), in.nextInt(), in.nextInt());

        System.out.println("-".repeat(30));
        System.out.println("Equations: ");

        System.out.println("Equation 1: "+ test1);
        System.out.println("Equation 2: "+ test2);

        System.out.println("-".repeat(30));

        //System.out.println("Reduced equations: ");
        ////test1.reduceEquation();
        ////test2.reduceEquation();
        //System.out.println("Equation 1: " + test1);
        //System.out.println("Equation 2: " + test2);

        System.out.println("-".repeat(30));

        System.out.println("Is equal: "+ test1.equals(test2));
        System.out.println("-".repeat(30));

        System.out.println("Sum of equations: "+test1.add(test2));
        System.out.println("-".repeat(30));

        System.out.println("Subtraction of equations: "+ test1.subtract(test2));
        System.out.println("-".repeat(30));

        


        
        /*
        //System.out.println("Greatest common divisor of " + a +", "+ b + " and "+ c +" is "+test1.gcd()+".");

        System.out.println("Not reduced eq1 => "+test1);
        System.out.println("Not reduced eq2 => "+test2);

        test1.reduceEquation();
        System.out.println("    reduced eq1 => "+test1);
        System.out.println("    reduced eq2 => "+test2);
        System.out.println("      eq1 + eq2 => "+test1.add(test2));
        System.out.println("      eq1 - eq2 => "+test1.subtract(test2));

        */

        in.close();
    }
    
}
