package lab6;

public class GeneralizeMergeSortAnalyzer extends SortAnalyzer{

    @Override
    public int compareTo(Object o) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Comparable[] sort(Comparable[] arr) {
        mergeSort(arr, 0, arr.length-1, 2);
        return arr;
    }

    private void merge(Comparable[] arr, int start, int mk, int end) {
        Comparable[] tmp = new Comparable[end-start+1];
        int i = start;
        int j = mk+1;
        int k = 0;
        while (i <= mk && j <= end) {
            if (compare(arr[i], arr[j]) < 0) {
                tmp[k] = arr[i];
                i++;
            } else {
                tmp[k] = arr[j];
                j++;
            }
            k++;
        }
        while(i <= mk) {
            tmp[k] = arr[i];
            i++;
            k++;
        }
        while(j <= end) {
            tmp[k] = arr[j];
            j++;
            k++;
        }
        for (int l = 0; l < tmp.length; l++) {
            arr[start+l] = tmp[l];
        }
    }

    private void mergeSort(Comparable[] arr, int start, int end, int k) {
        int divided = (start + end) / k;
        if (start < end) {
            mergeSort(arr, start, divided, k);
            for (int i = 0; i < k-1; i++) {
                mergeSort(arr, divided+1 + i*(divided+1), divided+(divided+1)+i*(divided+1), k);
                // mergeSort(arr, start, k, k)
                // mergeSort(arr, k+1, k+k+1,k)
                // mergeSort(arr, k+k+2, k+k+2+k, k)
                // merge(arr, start, mid, end)
                merge(arr, start, k, k+1);
            }
        }
    }

    // public static void mergeSort(int[] arr, int start, int end) {
    //     int mid = (start + end) / 2;
    //     if (start < end) {
    //         mergeSort(arr, start, mid);
    //         mergeSort(arr, mid+1, end);
    //         merge(arr, start, mid, end);
    //     }
    // }
}
