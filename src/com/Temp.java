package com;

import java.util.BitSet;
import java.util.HashSet;

public class Temp {
    public static void main(String[] args) {
        int N = 1000, M = 1000;
        int[][] in = {{1, 1, 5, 2, 3}, {4, 5, 6, 4, 3}, {9, 4, 4, 1, 5}};//new int [N][M];
        N = in.length;
        M = in[0].length;
        BitSet prev = new BitSet(N * M + 1);
        BitSet res = new BitSet(N * M + 1);
        HashSet<Integer> set;

        for (int i = 0; i < N; i++) {
            set = new HashSet();
            for (int j = 0; j < M; j++) {
                set.add(in[i][j]);
            }
            for (Integer k : set) {
                if (prev.get(k))
                    res.set(k);
                prev.set(k);
            }
        }

        System.out.println(res.cardinality());
    }
}
