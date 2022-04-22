package lab6;

public class Tester {

    public static void main(String[] args) {
        ArrayGenerator[] generators = {
            new RandomArrayGenerator(),
            new DecreasingArrayGenerator(),
            new IncreasingArrayGenerator()
        };
        // for (ArrayGenerator generator : generators) {
        //     int[] arr = generator.generate(8);
        //     System.out.println(arrayToString(arr));
        // }
        // System.out.println("-".repeat(31));

        // for (ArrayGenerator generator : generators) {
        //     Comparable[] arr = generator.generateC(8);
        //     System.out.println(arrayToString2(arr));
        // }

        System.out.println("-".repeat(31));

        SortAnalyzer analyzer = new MergeSortAnalyzer();

        System.out.println("Normal MergeSort");

        for (ArrayGenerator generator : generators) {
            Comparable[] arr = generator.generateC(85);
            System.out.printf("%s: %s\n","Unsorted List",arrayToString2(arr));
            analyzer.sort(arr);
            if (analyzer.isSorted(arr)) {
                System.out.printf("%s \n%s: %s\n","Process: Successfull!","Sorted List",arrayToString2(arr));
                System.out.println(analyzer.getNumberOfComparisons()); 
            } else {
                System.out.printf("%s: %s\n","Sorted failed!",arrayToString2(arr));
            }
            System.out.println("-".repeat(31));
        }

        System.out.println("-".repeat(31));

        SortAnalyzer quick1 = new QuickSortAnalyzer();

        System.out.println("Normal QuickSort");

        for (ArrayGenerator generator : generators) {
            Comparable[] arr = generator.generateC(8);
            System.out.printf("%s: %s\n","Unsorted List",arrayToString2(arr));
            quick1.sort(arr);
            if (quick1.isSorted(arr)) {
                System.out.printf("%s \n%s: %s\n","Process: Successfull!","Sorted List",arrayToString2(arr));
                System.out.println(quick1.getNumberOfComparisons()); 
            } else {
                System.out.printf("%s: %s\n","Sorted failed!",arrayToString2(arr));
            }
            System.out.println("-".repeat(31));
        }

        System.out.println("-".repeat(31));

        // SortAnalyzer genMerge = new GeneralizeMergeSortAnalyzer();

        // for (ArrayGenerator generator : generators) {
        //     Comparable[] arr = generator.generateC(50);
        //     System.out.printf("%s: %s\n","Unsorted List",arrayToString2(arr));
        //     genMerge.sort(arr);
        //     if (genMerge.isSorted(arr)) {
        //         System.out.printf("%s \n%s: %s\n","Process: Successfull!","Sorted List",arrayToString2(arr));
        //     } else {
        //         System.out.printf("%s: %s\n","Sorted failed!",arrayToString2(arr));
        //     }
        //     System.out.println("-".repeat(31));
        // }


    }

    public static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
        
    }

    public static String arrayToString2(Comparable[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
        
    }
    
}
