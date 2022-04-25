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

    private void mergeSort(Comparable[] arr, int start, int end, int k) {
        // if ((end-start+1) <= k) {
        //     for (int i = 0; i < (end-start+1); i++) {
        //         mergeSort(arr, i, i, k);
        //     }
        // }
        if (start < end) {
            int divide = (end-start+1) / k;
            mergeSort(arr, start, divide, k);
            for (int i = 0; i < k-1; i++) {
                mergeSort(arr, i*divide, (i+1)*divide, k);
            }
            // merge(arr, start, divide-1, 2*divide-1);
            // System.out.println(display(arr));
            // merge(arr, 2*divide+1, 3*divide, 4*divide);
            // merge(arr, 4*divided+1, 5*divide, 6*divide );
            for (int i = 0; i < k-1; i++) {
                merge(arr, (2*i)*divide, (2*i+1)*divide, (2*i+2)*divide);
                System.out.println(display(arr));
            }
        }
    }

    public static void indexCalcMS(int start, int end, int k) {
        String result = "";
        if (k == 1) {
            result += start + " " + end;
            System.out.println(result);
            return; 
        }
        if ((end-start+1) <= k) {
            for (int i = 0; i < (end-start+1); i++) {
                result += i +", "+ i + " ";
            }
            System.out.println(result);
            return;
        }
        int x = (end-start+1) / k;
        result += "["+ start + ", "+ (x-1)  + "]";
        int t = x;
        for (int i = 1; i < k-1; i++) {
            result += " [" +(i*x) + ", " + ((i+1)*x-1) + "]";
            t = (i+1)*x;
        }                
        result+= " [" + t + ", " + end + "]";   
        System.out.println(result);
    }

    public static void indexCalcM(int start, int end, int k) {
        String result = "";
        if (k == 1) {
            result += start + ", "+ (start+end)/2 + ", "+ end;
            System.out.println(result);
            return; 
        }
        int subL = (end-start+1) / k;
        result += "[" + start + ", " + (subL-1) + ", "+ (2*subL-1) + "]";
        for (int i = 1; i < k-1; i++) {
            result += " [" + ((i+1)*subL) + ", "+ ((i+2)*subL-1) + ", "+ ((i+3)*subL-1) +"] "; 
        }
        System.out.println(result);



    }

    // public static void main(String[] args) {
    //     int[] arr = {9,8,7,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5};
    //     indexCalcMS(0, arr.length-1, 3);
    //     indexCalcM(0, arr.length-1, 3);
    // }


}
