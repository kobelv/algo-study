package com.kobe.recursive;

import com.kobe.array.ArrayUtils;

import java.util.ArrayList;

/**
 * 一组数据的全排列
 * 1 -- 1
 * 1，2 -- (2)1; 1(2);
 * 1，2，3 -- (3)12, 1(3)2, 12(3); (3)21, 2(3)1, 21(3);
 * 在前面每个排列的基础上，分别对每个排列再加工，从左到右各个位置插入新的数字，比如排列12可以演变
 * 成3个新的排列312，132，123
 */
public class Permutation {
    public static ArrayList calcPermutation(String[] arr, int length){
        if (arr == null){
            return null;
        }
        if (length == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(arr[0]);
            return list;
        }
        ArrayList<String> tmpResult = calcPermutation(arr, length-1);
        ArrayList<String> finalResult = new ArrayList<>();
        for (int i = 0; i< tmpResult.size(); i++){
            String tmpStr = tmpResult.get(i);
            for (int j=-1; j< tmpStr.length();j++){
                //假设原来n-1个数字原来有m个排列，现在要在每个排列上，插入新数字n。
                //则经过这层for循环后将得到n*m个新排列
                StringBuilder sb = new StringBuilder();
                buildStr(sb, tmpStr, j, true);
                sb.append(arr[length-1]);
                buildStr(sb, tmpStr, j, false);
                finalResult.add(sb.toString());
            }
        }

        return finalResult;
    }

    private static StringBuilder buildStr(StringBuilder sb, String str, int index, boolean isGetPrevious){
        if (str == null){
            return sb;
        }

        if (isGetPrevious){
            if (index<0){
                return sb;
            }
            return sb.append(str.substring(0, index+1));
        } else {
            return sb.append(str.substring(index+1, str.length()));
        }

    }

    public static void main(String[] args) {
        String[] arr = {"1","2","3","4","5","6","7","8","9"};
        //String[] arr = {"a","b","c","d","e","f"};
        ArrayList arrayList = Permutation.calcPermutation(arr, arr.length);
        ArrayUtils.printResults(arrayList);
    }
}
