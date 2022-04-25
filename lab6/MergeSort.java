import java.util.Arrays;

public class MergeSort {

    public static int[] mergeSort(int[] a, int p, int r) {
        // p is left bound (included)
        // r is right bound (excluded)
        if (r - p >= 2) {
            int q = p - (r - p) / 2;
            mergeSort(a, p, q);
            mergeSort(a, q, r);
            return merge(a, p, q, r);
        } else {
            return a;
        }
    }

    // p is left bound (included)
    // q is start of right slice
    // r is end of right slice (excluded)
    public static int[] merge(int[] a, int p, int q, int r) {
        int n1 = q - p;  // length of first array
        int n2 = r - q;  // length of second array
        int[] lt = new int[n1];
        for (int i = 0; i < n1; i++) {
            lt[i] = a[p + i];
        }
        int i = 0;  // index into lt
        int j = q;  // index into a for right slice
        int k = p;  // index into a for merged list

        while (i < n1 && j < r) { //comparing the values of the arrays and merging
            if (lt[i] <= a[j]) {
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

    public static int[] mergeSortK(int[] a, int k, int p, int r) {
        // k amount of steps; p is first index of slice; r is last index of slice (excluded);
        if (r - p >= 2) {
            if (k > r - p)
                k = r - p;
            int[] pos = new int[k + 1]; //array for saving the indices of the "splits"
            for (int i = 0; i <= k; i++) {
                pos[i] = p + (r - p) * i / k; //saving the array indices
            }
            for (int i = 0; i < k; i++) {
                mergeSortK(a, k, pos[i], pos[i + 1]); //sorting the arrays
            }
            while (k > 1) {
                int i, n = 1;
                for (i = 0; i < k - 1; i += 2) {
                    // merge slices 2 at a time: this will produce the expected output
                    //  but is not a direct k-way merge.
                    merge(a, pos[i], pos[i + 1], pos[i + 2]);
                    System.out.println(Arrays.toString(a));
                    pos[n++] = pos[i + 2];
                }
                if (i < k)
                    pos[n++] = pos[i + 1];
                k = n - 1;
            }
        }
        return a;
    }

    public static int[] mergeSortKw(int[] a, int k, int p, int r) {
        // k number of steps; p is first index of array; r is last index of array;
        if (p < r) {
            int[] pos = new int[k + 1]; //array for saving the indices of the "splits"
            for (int i = 0; i <= k; i++) {
                pos[i] = (int) Math.floor(p + (r - p) / k * i); //saving the array indices
            }
            for (int i = 0; i < k; i++) {
                mergeSortKw(a, k, pos[i], pos[i + 1]); //sorting the arrays
            }
            for (int i = 0; i < k - 1; i++) {
                merge(a, pos[i], pos[i + 1], pos[i + 2]); //merging the arrays pairwise
                System.out.println(Arrays.toString(a));
            }
        }
        return a;
    }

    public static void main(String[] args) {
        // Example Values:
        int[] list = { 64, 36, 46, 31 , 45, 52, 4};
            // , 45, 52,  4, 48, 74, 59,
            // 12, 16, 70, 67, 71, 26, 73, 34, 46, 84,
            // 60, 16, 26, 68, 56, 57, 97,  6, 39, 74,
            // 25, 69, 29, 69, 77, 26, 44, 53, 20,  6,
            // 77, 31, 71, 91, 28,  6, 24, 75, 26, 33,
            //  3, 20, 55, 94, 17, 81, 88, 32, 94, 32,
            //  3, 90, 76, 69,  9, 96, 76, 53, 78, 14,
            // 97, 32, 17, 15, 61, 63, 21,  0, 16, 14,
            // 61,  4, 81, 86, 29, 29, 27, 57, 85,  5,
            // 91, 54,  6, 68, 40, 88, 41,  9, 90, 51 };
        int k = 3;  // must be at least 2

        // use MergeSort
        int[] newlist = mergeSortK(list, k, 0, list.length);
        System.out.println(Arrays.toString(newlist));
    }

    // Helper function to print the elements of a list
    private static void printList(int[] list) {
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
    }
}