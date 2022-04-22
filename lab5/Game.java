package lab5;
import java.util.ArrayList;

public class Game {

    public static void main(String[] args) {
        
        // list format [size, score]

        int[][] arr1 = {{100,50}, {50,10}, {60,45}};
        int[][] arr2 = { {45,50}, {10,85}, {15,45}, {20,100}, {25,6}, {100,100} };
        
        System.out.printf("%s: %s\n","Test Case 1",maxScore(arr1, 110, 0));        
        System.out.printf("%s: %s\n","Test Case 2",maxScore(arr1, 109, 0));
        System.out.printf("%s: %s\n","Test Case 3",maxScore(arr2, 150, 0));
        System.out.printf("%s: %s\n","Test Case 4",maxScore(arr2, 0, 0));
        System.out.printf("%s: %s\n","Test Case 5",maxScore(arr2, 1000, 0)); 

    }

    public static ArrayList<Integer> maxScore(int[][] arr, int size, int index) {

        if (arr.length <= index || size <= 0) 
            return new ArrayList<Integer>();
        

        if (arr[index][0] > size)
            return maxScore(arr, size, index+1);

        else {
            
            ArrayList<Integer> maxList = maxScore(arr, size - arr[index][0], index+1);
            ArrayList<Integer> maxList2 = maxScore(arr, size, index+1);
            int sum1 = arr[index][1] + sum(maxList); 
            int sum2= sum(maxList2);

            if (sum1 > sum2) {
                maxList.add(arr[index][1]);
                return maxList;
            }
            else {
                return maxList2;
            }
        }
    }

    public static int sum(ArrayList<Integer> arr) {
        int sum = 0;
        for (int i = 0; i < arr.size(); i++) {
            sum += arr.get(i);
        }
        return sum;
    }

    

    

}
