package lab6;

import java.util.Arrays;

public class Tester {

    public static void main(String[] args) {
        ArrayGenerator[] generators = {
            new RandomArrayGenerator(),
            new DecreasingArrayGenerator(),
            new IncreasingArrayGenerator()
        };
        SortAnalyzer[] analyzers = {
            new MergeSortAnalyzer(),
            new QuickSortAnalyzer(),
            new GeneralizeMergeSortAnalyzer(),
            new GeneralizeQuickSortAnalyzer()
        };

        for (SortAnalyzer analyzer : analyzers) {
            System.out.println("-".repeat(31));

            for (ArrayGenerator generator : generators) {
                Comparable[] arr = generator.generateC(100);
                System.out.printf("%s: %s\n","Unsorted List",Arrays.toString(arr));
                analyzer.sort(arr);
                if (analyzer.isSorted(arr)) {
                    System.out.printf("%s \n%s: %s\n","Process: Successfull!","Sorted List",Arrays.toString(arr));
                    System.out.println(analyzer.getNumberOfComparisons()); 
                } else {
                    System.out.printf("%s: %s\n","Sorted failed!",Arrays.toString(arr));
                }
                System.out.println("-".repeat(31));
            }
        }
        
        // for (ArrayGenerator generator : generators) {
        //     int[] arr = generator.generate(8);
        //     System.out.println(Arrays.toString(arr));
        // }
        // System.out.println("-".repeat(31));

        // for (ArrayGenerator generator : generators) {
        //     Comparable[] arr = generator.generateC(8);
        //     System.out.println(Arrays.toString(arr));
        // }

        // System.out.println("-".repeat(31));

        // SortAnalyzer analyzer = new MergeSortAnalyzer();

        // System.out.println("Normal MergeSort");

        // for (ArrayGenerator generator : generators) {
        //     Comparable[] arr = generator.generateC(8);
        //     System.out.printf("%s: %s\n","Unsorted List",Arrays.toString(arr));
        //     analyzer.sort(arr);
        //     if (analyzer.isSorted(arr)) {
        //         System.out.printf("%s \n%s: %s\n","Process: Successfull!","Sorted List",Arrays.toString(arr));
        //         System.out.println(analyzer.getNumberOfComparisons()); 
        //     } else {
        //         System.out.printf("%s: %s\n","Sorted failed!",Arrays.toString(arr));
        //     }
        //     System.out.println("-".repeat(31));
        // }

        // System.out.println("-".repeat(31));

        // SortAnalyzer quick1 = new QuickSortAnalyzer();

        // System.out.println("Normal QuickSort");

        // for (ArrayGenerator generator : generators) {
        //     Comparable[] arr = generator.generateC(8);
        //     System.out.printf("%s: %s\n","Unsorted List",Arrays.toString(arr));
        //     quick1.sort(arr);
        //     if (quick1.isSorted(arr)) {
        //         System.out.printf("%s \n%s: %s\n","Process: Successfull!","Sorted List",Arrays.toString(arr));
        //         System.out.println(quick1.getNumberOfComparisons()); 
        //     } else {
        //         System.out.printf("%s: %s\n","Sorted failed!",Arrays.toString(arr));
        //     }
        //     System.out.println("-".repeat(31));
        // }

        // System.out.println("-".repeat(31));

        // System.out.println("Generalized Mergesort");

        // SortAnalyzer genMerge = new GeneralizeMergeSortAnalyzer();

        // for (ArrayGenerator generator : generators) {
        //     Comparable[] arr = generator.generateC(12);
        //     System.out.printf("%s: %s\n","Unsorted List",Arrays.toString(arr));
        //     genMerge.sort(arr);
        //     if (genMerge.isSorted(arr)) {
        //         System.out.printf("%s \n%s: %s\n","Process: Successfull!","Sorted List",Arrays.toString(arr));
        //         System.out.println(genMerge.getNumberOfComparisons());
        //     } else {
        //         System.out.printf("%s: %s\n","Sorted failed!", Arrays.toString(arr));
        //     }
        //     System.out.println("-".repeat(31));
        // }
    }
}
