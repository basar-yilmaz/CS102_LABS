package lab6;

public abstract class SortAnalyzer implements Comparable {

    private int numberOfComparisons;
    protected int k;

    public int getNumberOfComparisons() {
        return numberOfComparisons;
    }

    protected int compare(Comparable o1, Comparable o2) {
        Integer x = (Integer) o1;
        Integer y = (Integer) o2;
        numberOfComparisons++;
        return x.compareTo(y); // (x - y) y büyükse -1, eşitse 0, x büyükse 1
    }

    public boolean isSorted(Comparable[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i].compareTo(arr[i+1]) > 0) {
                return false;
            }
        }
        return true;
    }
    
    public abstract Comparable[] sort(Comparable[] arr);
}
