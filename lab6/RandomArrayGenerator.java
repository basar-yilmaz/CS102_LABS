package lab6;
import java.util.Random;

public class RandomArrayGenerator implements ArrayGenerator {
    
    public int[] generate(int n) {
        IncreasingArrayGenerator helper = new IncreasingArrayGenerator();
        int[] arr = helper.generate(n);
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            int j = rand.nextInt(n);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return arr;
    }

    public Comparable[] generateC(int n) {
        IncreasingArrayGenerator helper = new IncreasingArrayGenerator();
        Comparable[] arr = helper.generateC(n);
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            int j = rand.nextInt(n);
            Comparable temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return arr;
    }

}
    

