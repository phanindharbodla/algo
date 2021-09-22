package com;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class DSU {


    int Arr[];

    public static void main(String[] args) {

        String input2 = "abcdc";
        extracted(input2);

    }

    private static String extracted(String input2) {

        List<Integer> test = new ArrayList<>();
        test.add(1);
        TreeSet<Integer> treeSet = new TreeSet<>(test);


        String input1 = "abccc";

        int[] cnt = new int[26];

        for (char c : input2.toCharArray()) {
            cnt[c - 'a']++;
        }

        int s = 0;

        for (int n : cnt) {
            if (n != 0)
                s++;
        }

        DSU dsu = new DSU();
        dsu.initialize(s);

        dsu.union(1, 0);
        dsu.union(1, 2);


        return (dsu.countSets() == 1) ? "Yes" : "No";
    }

    int countSets() {
        HashSet<Integer> set = new HashSet();
        for (int n : Arr)
            set.add(n);
        return set.size();
    }

    void initialize(int N) {
        Arr = new int[N];
        for (int i = 0; i < N; i++)
            Arr[i] = i;
    }

    boolean find(int a, int b) {

        return Arr[a] == Arr[b];

    }


    void union(int a, int b) {
        int TEMP = Arr[a];
        //Collections.sort(new L);
        for (int i = 0; i < Arr.length; i++) {
            if (Arr[i] == TEMP)
                Arr[i] = Arr[b];
        }
    }
}
