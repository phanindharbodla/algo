package com.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Mayor {

    public static void main(String[] args) {
        int[] k = {1, 3, 4, 5, 1};
        int[] v = {2, 2, 2, 2, 5};
        HashMap<Integer, ArrayList<Integer>> knows = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < k.length; i++) {
            if (knows.containsKey(k[i]))
                knows.get(k[i]).add(v[i]);
            else {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(v[i]);
                knows.put(k[i], temp);
            }
        }
        PossibleMayors(v.length, knows);
    }

    public static ArrayList<Integer> PossibleMayors(int N, HashMap<Integer, ArrayList<Integer>> knows) {
        boolean[] flags = new boolean[N + 1];
        int[] count = new int[N + 1];
        for (Map.Entry<Integer, ArrayList<Integer>> entry : knows.entrySet()) {
            flags[entry.getKey()] = true;
            for (Integer i : entry.getValue())
                count[i]++;
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < flags.length; i++) {
            // if (!flags[i]) res.Add(i);
            if (!flags[i] && count[i] == N - 1) res.add(i);
        }
        return res;
    }

}
