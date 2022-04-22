package lab6;

public class MergeSortAnalyzer extends SortAnalyzer{

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public Comparable[] sort(Comparable[] arr) {
        mergeSort(arr, 0, arr.length-1);
        return arr;
    }

    private void merge(Comparable[] arr, int start, int mid, int end) {
        Comparable[] tmp = new Comparable[end-start+1];
        int i = start;
        int j = mid+1;
        int k = 0;
        while (i <= mid && j <= end) {
            if (compare(arr[i], arr[j]) < 0) {
                tmp[k] = arr[i];
                i++;
            } 
            else {
                tmp[k] = arr[j];
                j++;
            }
            k++;
        }
        while(i <= mid) {
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

    private void mergeSort(Comparable[] arr, int start, int end) {
        int mid = (start + end) / 2;
        if (start < end) {
            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);
            merge(arr, start, mid, end);
        }
    }

    
}
