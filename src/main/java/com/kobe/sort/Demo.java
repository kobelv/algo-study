package com.kobe.sort;

import com.kobe.util.Utils;

public class Demo {
    public static void main(String[] args) {
        /**
         * test results:
         * int[] arr = Utils.generateRandomArray(900000, 1000000000);
         * InsertSort sort time costs: 73962
         * BubbleSort sort time costs: 77934
         * ChooseSort sort time costs: 78679
         */
        int[] arr = Utils.generateRandomArray(5, 10);
        String[] sortTypes = new String[]{"InsertSort",
                "BubbleSort","ChooseSort","MergeSort","QuickSort"};

        for (int i=0; i<sortTypes.length; i++){

        }
//        long start = System.currentTimeMillis();
//        InsertSort.sort(arr);
//        long end = System.currentTimeMillis();
//        System.out.println("InsertSort sort time costs: " + (end-start));
//
//        long start2 = System.currentTimeMillis();
//        BubbleSort.sort(arr);
//        long end2 = System.currentTimeMillis();
//        System.out.println("BubbleSort sort time costs: " + (end2-start2));
//
//        long start3 = System.currentTimeMillis();
//        ChooseSort.sort(arr);
//        long end3 = System.currentTimeMillis();
//        System.out.println("ChooseSort sort time costs: " + (end3-start3));

          QuickSort.sort(arr, 0, 4);

       Utils.printArray(arr);
    }
}
