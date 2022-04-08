// import java.util.ArrayList;
import java.util.Arrays;

public class Game {


    public static void main(String[] args) {
        
        // list format [size, score]

        int[][] arr1 = {{100,50}, {50,10}, {60,45}};
        int[][] arr2 = { {45,50}, {10,85}, {15,45}, {20,100}, {25,6}, {100,100} };
        
        System.out.printf("%s: %d\n","Test Case 1",maxScore(arr1, 110));        
        System.out.printf("%s: %d\n","Test Case 2",maxScore(arr1, 109));
        System.out.printf("%s: %d\n","Test Case 3",maxScore(arr2, 150));
        System.out.printf("%s: %d\n","Test Case 4",maxScore(arr2, 0));
        System.out.printf("%s: %d\n","Test Case 5",maxScore(arr2, 1000));
        // System.out.printf("%s: %s\n","Test Case 6",arrayToString(maxScore2(arr2, 1000)));
 

    }

    public static int maxScore(int[][] arr, int size) {
        if (arr.length == 0) {
            return 0;
        }
        if (arr[0][0] > size)
            return maxScore(Arrays.copyOfRange(arr, 1, arr.length), size);
        else {
            return Math.max(arr[0][1] + maxScore(Arrays.copyOfRange(arr, 1, arr.length), size - arr[0][0]),
                            maxScore(Arrays.copyOfRange(arr, 1, arr.length), size));
        }
    }

    // public static int[] maxScore2(int[][] arr, int size) {
    //     ArrayList<Integer> list = new ArrayList<Integer>();
    //     if (arr.length == 0) {
    //         return listToArray(list);
    //     }
    //     if (arr[0][0] > size)
    //         list.add(maxScore(Arrays.copyOfRange(arr, 1, arr.length), size));
    //     else {
    //         list.add(Math.max(arr[0][1] + maxScore(Arrays.copyOfRange(arr, 1, arr.length), size - arr[0][0]),
    //                         maxScore(Arrays.copyOfRange(arr, 1, arr.length), size)));
    //     }
    //     return listToArray(list);
    // }

    // public static int[] listToArray(ArrayList<Integer> list) {
    //     int[] arr = new int[list.size()];
    //     for (int i = 0; i < list.size(); i++) {
    //         arr[i] = list.get(i);
    //     }
    //     return arr;
    // }

    // public static String arrayToString(int[] arr) {
    //     StringBuilder sb = new StringBuilder();
    //     for (int i = 0; i < arr.length; i++) {
    //         sb.append("["+arr[i]+",");
    //     }
    //     return sb.toString().substring(0, sb.toString().length() - 1) + "]";
    // }

    // public static String matrixToString(int[][] arr) {
    //     StringBuilder sb = new StringBuilder();
    //     for (int i = 0; i < arr.length; i++) {
    //         for (int j = 0; j < arr[i].length; j++) {
    //             sb.append("[" + arr[i][j] + "]");
    //         }
    //         sb.append("\n");
    //     }
    //     return sb.toString();
    // }

    

}
