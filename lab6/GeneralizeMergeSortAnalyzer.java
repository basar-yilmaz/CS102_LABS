package lab6;
import java.util.Arrays;

public class GeneralizeMergeSortAnalyzer extends SortAnalyzer{

    @Override
    public int compareTo(Object o) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Comparable[] sort(Comparable[] arr) {
        System.out.println("Generalize MergeSort");
        mergeSort(arr, 5, 0, arr.length);
        return arr;
    }


    // low is left bound (included)
    // q is start of right slice
    // high is end of right slice (excluded)
    public Comparable[] merge(Comparable[] a, int low, int q, int high) {
        int n1 = q - low;  // length of first array
        Comparable[] lt = new Comparable[n1];
        for (int i = 0; i < n1; i++) {
            lt[i] = a[low + i];
        }
        int i = 0;  // index into lt
        int j = q;  // index into a for right slice
        int k = low;  // index into a for merged list

        while (i < n1 && j < high) { //comparing the values of the arrays and merging
            if (compare(lt[i], a[j]) <= 0) {
                a[k] = lt[i];
                i++;
                k++;
            } else {
                a[k] = a[j];
                j++;
                k++;
            }
        }
        while (i < n1) { // copy remaining elements from right slice
            a[k] = lt[i];
            i++;
            k++;
        }
        // remaining elements from right slice are already in place
        return a;
    }

    public Comparable[] mergeSort(Comparable[] arr, int k, int low, int high) {
        // k amount of steps; low is first index of slice; r is last index of slice (excluded);
        if (high - low >= 2) {
            if (k > high - low) {
                k = high - low;
            }    
            Comparable[] pos = new Comparable[k + 1]; //array for saving the indices of the "splits"
            for (int i = 0; i <= k; i++) {
                pos[i] = (Comparable) (low + (high - low) * i / k); //saving the array indices
            }
            for (int i = 0; i < k; i++) {
                mergeSort(arr, k, (int) pos[i], (int) pos[i + 1]); //sorting the arrays
            }
            while (k > 1) {
                int i = 1;
                int n = 1;
                for (i = 0; i < k - 1; i += 2) {
                    // merge slices 2 at a time: this will produce the expected output
                    // but is not a direct k-way merge.
                    merge(arr, (int) pos[i], (int) pos[i + 1], (int) pos[i + 2]);
                    System.out.println(Arrays.toString(arr));
                    pos[n++] = pos[i + 2];
                }
                if (i < k) {
                    pos[n++] = pos[i + 1];
                }    
                k = n - 1;
            }
        }
        return arr;
    }


    

    // private void merge(Comparable[] arr, int start, int divide, int end) {
    //     int l1 = divide - start + 1;
    //     int l2 = end - divide;
    //     Comparable[] tmp = new Comparable[l1];
    //     Comparable[] tmp2 = new Comparable[l2];
    //     for (int i = 0; i < l1; i++) {
    //         tmp[i] = arr[start + i];
    //     }
    //     for (int i = 0; i < l2; i++) {
    //         tmp2[i] = arr[divide + 1 + i];
    //     }
    //     int i, j, k;
    //     i = 0;
    //     j = 0;
    //     k = start;
    //     while (i < l1 && j < l2) {
    //         if (compare(tmp[i], tmp2[j]) < 0) {
    //             arr[k] = tmp[i];
    //             i++;
    //         } else {
    //             arr[k] = tmp2[j];
    //             j++;
    //         }
    //         k++;
    //     }
    //     while(i < l1) {
    //         arr[k] = tmp[i];
    //         i++;
    //         k++;
    //     }
    //     while(j < l2) {
    //         arr[k] = tmp2[j];
    //         j++;
    //         k++;
    //     }
    // }

    // private void mergeSort(Comparable[] arr, int start, int end, int k) {
    //     // if ((end-start+1) <= k) {
    //     //     for (int i = 0; i < (end-start+1); i++) {
    //     //         mergeSort(arr, i, i, k);
    //     //     }
    //     // }
    //     if (start < end) {
    //         int divide = (end-start+1) / k;
    //         mergeSort(arr, start, divide, k);
    //         for (int i = 0; i < k-1; i++) {
    //             mergeSort(arr, i*divide, (i+1)*divide, k);
    //         }
    //         // merge(arr, start, divide-1, 2*divide-1);
    //         // System.out.println(display(arr));
    //         // merge(arr, 2*divide+1, 3*divide, 4*divide);
    //         // merge(arr, 4*divided+1, 5*divide, 6*divide );
    //         for (int i = 0; i < k-1; i++) {
    //             merge(arr, (2*i)*divide, (2*i+1)*divide, (2*i+2)*divide);
    //             System.out.println(display(arr));
    //         }
    //     }
    // }

    // public static void indexCalcMS(int start, int end, int k) {
    //     String result = "";
    //     if (k == 1) {
    //         result += start + " " + end;
    //         System.out.println(result);
    //         return; 
    //     }
    //     if ((end-start+1) <= k) {
    //         for (int i = 0; i < (end-start+1); i++) {
    //             result += i +", "+ i + " ";
    //         }
    //         System.out.println(result);
    //         return;
    //     }
    //     int x = (end-start+1) / k;
    //     result += "["+ start + ", "+ (x-1)  + "]";
    //     int t = x;
    //     for (int i = 1; i < k-1; i++) {
    //         result += " [" +(i*x) + ", " + ((i+1)*x-1) + "]";
    //         t = (i+1)*x;
    //     }                
    //     result+= " [" + t + ", " + end + "]";   
    //     System.out.println(result);
    // }

    // public static void indexCalcM(int start, int end, int k) {
    //     String result = "";
    //     if (k == 1) {
    //         result += start + ", "+ (start+end)/2 + ", "+ end;
    //         System.out.println(result);
    //         return; 
    //     }
    //     int subL = (end-start+1) / k;
    //     result += "[" + start + ", " + (subL-1) + ", "+ (2*subL-1) + "]";
    //     for (int i = 1; i < k-1; i++) {
    //         result += " [" + ((i+1)*subL) + ", "+ ((i+2)*subL-1) + ", "+ ((i+3)*subL-1) +"] "; 
    //     }
    //     System.out.println(result);



    // }

    // public static void main(String[] args) {
    //     int[] arr = {9,8,7,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5};
    //     indexCalcMS(0, arr.length-1, 3);
    //     indexCalcM(0, arr.length-1, 3);
    // }


}
