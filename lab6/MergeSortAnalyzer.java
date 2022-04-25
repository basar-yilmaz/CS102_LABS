package lab6;

import java.util.Arrays;

public class MergeSortAnalyzer extends SortAnalyzer{

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public Comparable[] sort(Comparable[] arr) {
        System.out.println("Normal MergeSort");
        mergeSort(arr, 0, arr.length-1);
        return arr;
    }

    private void merge(Comparable[] arr, int start, int divide, int end) {
        int l1 = divide - start + 1;
        int l2 = end - divide;
        Comparable[] tmp = new Comparable[l1];
        Comparable[] tmp2 = new Comparable[l2];
        for (int i = 0; i < l1; i++) {
            tmp[i] = arr[start + i];
        }
        for (int i = 0; i < l2; i++) {
            tmp2[i] = arr[divide + 1 + i];
        }
        int i, j, k;
        i = 0;
        j = 0;
        k = start;
        while (i < l1 && j < l2) {
            if (compare(tmp[i], tmp2[j]) < 0) {
                arr[k] = tmp[i];
                i++;
            } else {
                arr[k] = tmp2[j];
                j++;
            }
            k++;
        }
        while(i < l1) {
            arr[k] = tmp[i];
            i++;
            k++;
        }
        while(j < l2) {
            arr[k] = tmp2[j];
            j++;
            k++;
        }
    }

    private void mergeSort(Comparable[] arr, int start, int end) {
        int mid = (start + end) / 2;
        if (start < end) {
            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);
            merge(arr, start, mid, end);
            // System.out.println(Arrays.toString(arr));
        }
    }

    
}
