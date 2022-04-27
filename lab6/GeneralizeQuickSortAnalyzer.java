package lab6;

import java.util.Arrays;

public class GeneralizeQuickSortAnalyzer extends SortAnalyzer{
    
    public int compareTo(Object o) {
        return 0;
    }

    public Comparable[] sort(Comparable[] arr) {
        System.out.println("Generalize QuickSort");
        quickSort(arr, 0, arr.length-1, 2);
        return arr;
    }

    private int partition(Comparable[] arr, int low, int high) {
        Comparable pivot = arr[high];
        // pointer for greater element
        int i = (low - 1);
        // traverse through all elements
        // compare each element with pivot
        for (int j = low; j < high; j++) {
            if (compare(arr[j], pivot) < 0) {
                // if element smaller than pivot is found
                // swap it with the greatr element pointed by i
                i++;
                // swapping element at i with element at j
                swap(arr, i, j);
                // System.out.println(Arrays.toString(arr));
            }
        }
        // swap the pivot element with the greater element specified by i
        swap(arr, i+1, high);
        // System.out.println(Arrays.toString(arr));
        // return the position from where partition is done
        return (i + 1);
    }

    private void quickSort(Comparable[] arr, int low, int high, int k) {
        if (low < high) {
            int[] pos = new int[k-1];
            for (int i = 0; i < k-1; i++) {
                pos[i] = partition(arr, low, high);
            }
            
            quickSort(arr, low, pos[0]-1, k);
            for (int i = 0; i < k-2; i++) {
                quickSort(arr, pos[i]+1, pos[i+1]-1, k);
            }
            quickSort(arr, pos[k-2]+1, high, k);
        }
    }

    private void swap(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
