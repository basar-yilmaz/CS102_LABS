package lab6;

public class QuickSortAnalyzer extends SortAnalyzer{

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public Comparable[] sort(Comparable[] arr) {
        quickSort(arr, 0, arr.length-1);
        return arr;
    }
   
    public void quickSort(Comparable[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p-1);
            quickSort(arr, p + 1, high);
        }
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
            }
        }
        // swap the pivot element with the greater element specified by i
        swap(arr, i+1, high);
        // return the position from where partition is done
        return (i + 1);
    }

    private void swap(Comparable[] arr, int i, int j) {
        Comparable tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
