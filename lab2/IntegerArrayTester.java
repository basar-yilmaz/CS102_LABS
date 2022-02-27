package lab2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class IntegerArrayTester {

    public static void main (String[] args) {
        Scanner in = new Scanner(System.in); 

        // System.out.print("Enter the String for arr1: ");
        // IntegerArray arr1 = new IntegerArray(in.next());
        // System.out.print("Enter the String for arr2: ");
        // IntegerArray arr2 = new IntegerArray(in.next());
        // System.out.print("Enter the String for arr3: ");
        // IntegerArray arr3 = new IntegerArray(in.next());
        // System.out.print("Enter the String for arr4: ");
        // IntegerArray arr4 = new IntegerArray(in.next());

        

        IntegerArray arr1 = new IntegerArray("3232");
        IntegerArray arr2 = new IntegerArray("2343");
        IntegerArray arr3 = new IntegerArray("12312");
        IntegerArray arr4 = new IntegerArray("0123213");
        IntegerArray arr5 = new IntegerArray("0123213");
        System.out.println("~".repeat(35));

        System.out.println("Integer Arr 1: "+arrayDisplay(arr1));
        System.out.println("Integer Arr 2: "+arrayDisplay(arr2));
        System.out.println("Integer Arr 3: "+arrayDisplay(arr3));
        System.out.println("Integer Arr 4: "+arrayDisplay(arr4));
        System.out.println("~".repeat(35));

        System.out.println("Arr1 + Arr2: "+ arrayDisplay( (arr1.add(arr2) )));
        System.out.println("Arr2 + Arr3: "+ arrayDisplay( (arr2.add(arr3) )));
        System.out.println("Arr1 + Arr3: "+ arrayDisplay( (arr1.add(arr3) )));
        System.out.println("~".repeat(35));
        
        System.out.println("Arr1 - Arr2: " + arrayDisplay( (arr1.substract(arr2) )));
        System.out.println("Arr3 - Arr1: " + arrayDisplay( (arr3.substract(arr1) )));
        System.out.println("Arr2 - Arr4: " + arrayDisplay( (arr2.substract(arr4) )));
        System.out.println("~".repeat(35));


        System.out.println("Is Arr1 equal to Arr2? : " + arr1.equals(arr2));
        System.out.println("Is Arr3 equal to Arr4? : " + arr3.equals(arr4));
        System.out.println("Is Arr4 equal to Arr5? : " + arr5.equals(arr4));
        System.out.println("~".repeat(35));


        // Test1.txt
        System.out.print("Please enter the filename: ");
        String file_name = in.nextLine();

        IntegerArrayList int_arr = readIntegerArraysFromFile(file_name);

        int start = 0;
        int midIndex = int_arr.getSize() / 2;
        int endIndex = int_arr.getSize();


        System.out.println("Output:");
        System.out.println();
        System.out.println("start index = "+ start);
        System.out.println("middle index = "+ midIndex);
        System.out.println("end index = "+ endIndex);
        System.out.println();
        System.out.println("Minimum of all the numbers:");
        System.out.println(arrToStr(int_arr.min(start, endIndex)));

        System.out.println("Minimum of the first half:");
        System.out.println(arrToStr(int_arr.min(start, midIndex)));

        System.out.println("Minimum of the second half:");
        System.out.println(arrToStr(int_arr.min(midIndex, endIndex)));
        System.out.println();
        System.out.println("~".repeat(75));

        // Test2.txt
        System.out.print("Please enter the filename: ");
        String file_name2 = in.nextLine();
        IntegerArrayList int_arr2 = readIntegerArraysFromFile(file_name2);

        int midIndex2 = int_arr2.getSize() / 2;
        int endIndex2 = int_arr2.getSize();


        System.out.println("Output:");
        System.out.println();
        System.out.println("start index = "+ start);
        System.out.println("middle index = "+ midIndex2);
        System.out.println("end index = "+ endIndex2);
        System.out.println();
        System.out.println("Minimum of all the numbers:");
        System.out.println(arrToStr(int_arr2.min(start, endIndex2)));

        System.out.println("Minimum of the first half:");
        System.out.println(arrToStr(int_arr2.min(start, midIndex2)));

        System.out.println("Minimum of the second half:");
        System.out.println(arrToStr(int_arr2.min(midIndex2, endIndex2)));
        System.out.println();
        System.out.println("~".repeat(75));

        // Test3.txt
        System.out.print("Please enter the filename: ");
        String file_name3 = in.nextLine();
        IntegerArrayList int_arr3 = readIntegerArraysFromFile(file_name3);

        int midIndex3 = int_arr3.getSize() / 2;
        int endIndex3 = int_arr3.getSize();


        System.out.println("Output:");
        System.out.println();
        System.out.println("start index = "+ start);
        System.out.println("middle index = "+ midIndex3);
        System.out.println("end index = "+ endIndex3);
        System.out.println();
        System.out.println("Minimum of all the numbers:");
        System.out.println(arrToStr(int_arr3.min(start, endIndex3)));

        System.out.println("Minimum of the first half:");
        System.out.println(arrToStr(int_arr3.min(start, midIndex3)));

        System.out.println("Minimum of the second half:");
        System.out.println(arrToStr(int_arr3.min(midIndex3, endIndex3)));


        in.close();

    }

    public static IntegerArrayList readIntegerArraysFromFile(String fileName) {
        IntegerArrayList numbers = new IntegerArrayList();
        String path = "C:/Drive/21-22 Spring/CS 102 - 3/labs/lab2/" + fileName;
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              if (data.length() == 0) 
                continue;
              numbers.addIntegerArray(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return numbers;
    }
    

    public static String arrayDisplay(IntegerArray array) {
        String result = "[";

        for (int i = 0; i < array.numberOfDigits(); i++) {
            result += array.digits[i] + ", ";
        }
        result = result.substring(0, result.length()-2) +"]";
        if (array.getNegative()) {
            result += " (Negative(-))";
            return result;
        }
        return result;
    }

    public static String arrToStr(IntegerArray array) {
        String result = "";

        for (int i = 0; i < array.numberOfDigits(); i++) {
            result += array.digits[i];
        }
        return result;
    }



}
