package com.kobe.search;

import java.util.HashMap;

public class SearchPid {
    int id;
    int pid;
    public SearchPid(int id, int pid){
        id = id;
        pid = pid;
    }

    public static void main(String[] args) {
        SearchPid s1 = new SearchPid(1, 2);
        SearchPid s2 = new SearchPid(2, 3);
        SearchPid s3 = new SearchPid(4, 3);
        HashMap<Integer, Integer> map = new HashMap<>();

    }
}
