package com.kobe.array;

import java.util.ArrayList;
import java.util.Random;

public class ArrayUtils {

    public static void printResults(ArrayList<String> finalResult) {
        if (finalResult == null) {
            System.out.println("nothing to print.");
        }
        System.out.println("总共有 " + finalResult.size() + " 种：");
        for (int i = 0; i < finalResult.size(); i++) {
            System.out.println(finalResult.get(i));
        }
    }

    public static void printArray(int[] arr) {
        if (arr == null) {
            System.out.println("nothing to print.");
        }
        System.out.println("顺序为：");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static int[] generateRandomArray(int size, int seed) {
        int[] result = new int[size];
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            result[i] = r.nextInt(seed);
        }
        return result;
    }

}
