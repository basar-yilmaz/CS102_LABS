package lab6;

public class DecreasingArrayGenerator implements ArrayGenerator {

    public int[] generate(int n) {
        int[] arr = new int[n];
        for (int i = 1; i <= arr.length; i++) {
            arr[i-1] = n--;
        }   
        return arr;
    }

    public Comparable[] generateC(int n) {
        Comparable[] arr = new Comparable[n];
        for (int i = 1; i <= arr.length; i++) {
            arr[i-1] = (Integer) n--;
        }   
        return arr;
    }
}
    

