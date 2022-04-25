package lab6;

public class mergefsort {

    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};

        System.out.printf("%s: %s\n","Unsorted List",display(arr));
        mergeSort(arr, 0, arr.length-1);
        System.out.printf("%s: %s\n","Sorted List",display(arr));
    }

    public static void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start+end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);
            merge(arr, start, mid, end);
            System.out.println(display(arr));
        }
    }

    private static void merge(int[] arr, int start, int divide, int end) {
        int l1 = divide - start + 1;
        int l2 = end - divide;
        int[] tmp = new int[l1];
        int[] tmp2 = new int[l2];
        for (int i = 0; i < l1; i++) {
            tmp[i] = arr[start + i];
        }
        for (int j = 0; j < l2; j++) {
            tmp2[j] = arr[divide + 1 + j];
        }
        int i, j, k;
        i = 0;
        j = 0;
        k = start;
        while (i < l1 && j < l2) {
            if (tmp[i] <= tmp2[j]) {
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

    public static String display(int arr[])
    { 
        String result = "[";
        for (int i=0; i<arr.length; i++) 
        {
            result += arr[i] + ", ";
        }  
        result = result.substring(0, result.length()-2) + "]";
        return result;
    } 
    
}