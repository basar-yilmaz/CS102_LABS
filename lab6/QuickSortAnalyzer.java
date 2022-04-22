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

   /**
      Adapted from Big Java
   */
   public void quickSort(Comparable[] a, int from, int to) {
      if (from >= to) { return; }
      int p = partition(a, from, to);
      quickSort(a, from, p);
      quickSort(a, p + 1, to);
   }

   /**
      Adapted from Big Java
   */
    private int partition(Comparable[] arr, int from, int to) {
        Comparable pivot = arr[from];
        int i = from - 1;
        int j = to + 1;
        while (i < j) {
            i++; 
            while (compare(arr[i], pivot) < 0) {
                i++; 
            }
            j--;
            while (compare(arr[j], pivot) > 0) {
                j--;
            }
            if (i < j) 
                swap(arr, i, j); 
            }
        return j;
   }

    private void swap(Comparable[] arr, int i, int j) {
        Comparable tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
