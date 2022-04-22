package lab6;

public class IncreasingArrayGenerator implements ArrayGenerator {
    
    public int[] generate(int n) {
        int[] arr = new int[n];
        for (int i = 1; i <= n; i++) {
            arr[i-1] = i;
        }
        return arr;
    }

    public Comparable[] generateC(int n) {
        Comparable[] arr = new Comparable[n];
        for (int i = 1; i <= n; i++) {
            arr[i-1] = (Integer)  i;
        }
        return arr;
    }
}
    

