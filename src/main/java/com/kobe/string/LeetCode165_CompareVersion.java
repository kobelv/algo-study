package com.kobe.string;

public class LeetCode165_CompareVersion {

    public static void main(String[] args) {
        String s1 = "1.01";
        String s2 = "1.001";
        System.out.println(new LeetCode165_CompareVersion().compareVersion(s1, s2));
    }
    
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int i1 = 0, i2 = 0;
        int x, y;
        while (i1 < v1.length || i2 < v2.length){
            x = 0;
            y = 0;
            if (i1 < v1.length){
                x = Integer.parseInt(v1[i1]);
                i1 ++;
            }

            if (i2 < v2.length){
                y = Integer.parseInt(v2[i2]);
                i2 ++;
            }

            if (x > y){
                return 1;
            }

            if (x < y){
                return -1;
            }
        }

        return 0;
    }

}
