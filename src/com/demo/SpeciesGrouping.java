package com.demo;

import java.util.HashMap;

public class SpeciesGrouping {
    public static void main(String[] args) {
        int[] species = {-1, 0, 1, 2, 3, 4, 5, 6};
        int out = solve(species);
        System.out.println(out);
    }

    private static int solve(int[] species) {
        int max = 0, temp = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] dp = new int[species.length];
        for (int i = 0; i < species.length; i++) {
            if (species[i] >= 0) map.put(species[i], i);
        }
        for (int i = 0; i < species.length; i++) {
            if (species[i] == -1) {
                dp[i] = 1;
                temp = i;
                while (map.containsKey(temp)) {
                    dp[map.get(temp)] = 1 + dp[temp];
                    temp = map.get(temp);
                }
                max = Math.max(max, dp[temp]);
            }
        }
        printdp(dp);
        return max;
    }

    private static void printdp(int[] dp) {
        for (int i = 0; i < dp.length; System.out.println(), i++)
            System.out.print(dp[i] + " ");
        System.out.println();
    }

}
