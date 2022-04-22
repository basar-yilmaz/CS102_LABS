package lab6;
public class MergeSort {
    
    public static void main(String[] args) {
        int[] arr = {2, 1, 0, 7, 9, 4, 3, 1, 1, 0, 0};

        System.out.printf("%s: %s\n","Unsorted List",display(arr));
        mergeSort(arr, 0, arr.length-1);
        System.out.printf("%s: %s\n","Sorted List",display(arr));
    }


    // public static void merge(int[] arr, int start, int mid, int end) {
    //     int[] temp = new int[end-start+1];
    //     int i = start;
    //     int j = mid+1;
    //     int k = 0;
    //     while (i <= mid && j <= end) {
    //         if (arr[i] < arr[j]) {
    //             temp[k] = arr[i];
    //             i++;
    //         } else {
    //             temp[k] = arr[j];
    //             j++;
    //         }
    //         k++;
    //     }
    //     while (i <= mid) {
    //         temp[k] = arr[i];
    //         i++;
    //         k++;
    //     }
    //     while (j <= end) {
    //         temp[k] = arr[j];
    //         j++;
    //         k++;
    //     }
    //     for (int l = 0; l < temp.length; l++) {
    //         arr[start+l] = temp[l];
    //     }
    // }

    // public static void mergeSort(int[] arr, int start, int end) {
    //     int mid = (start + end) / 2;
    //     if (start < end) {
    //         mergeSort(arr, start, mid);
    //         mergeSort(arr, mid+1, end);
    //         merge(arr, start, mid, end);
    //     }
    // }

    public static void mergeSort(int[] arr, int start, int end) {
        int mid = (start + end) / 2;
        if (start < end) {
            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);
            merge(arr, start, mid, end);
        }
    }

    public static void merge(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end-start+1]; 
        int i = start;
        int j = mid + 1;
        int k = 0; // position in temp array
        while (i <= mid && j <= end) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            }
            else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            temp[k] = arr[i];
            i++;
            k++;
        }
        while (j <= end) {
            temp[k] = arr[j];
            j++;
            k++;
        }
        for (int l = 0; l < temp.length; l++) {
            arr[start + l] = temp[l];
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
