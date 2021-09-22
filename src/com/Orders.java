package com;

public class Orders {
    public static void main(String[] args) {

        int[] start = {0, 2, 9, 10, 11, 12};
        int[] end = {5, 9, 11, 11, 14, 17};
        int[] tip = {1, 2, 3, 2, 2, 1};
        System.out.println(solve(start, end, tip));

    }

    public static int solve(int[] start, int[] end, int[] tip) {
        int dp[] = new int[start.length];
        int earnings[] = new int[start.length];

        for (int i = 0; i < dp.length; i++) {
            earnings[i] = (end[i] - start[i]) + tip[i];
        }
        for (int i = 0; i < dp.length; i++) {
            int s = start[i];
            int best = 0;
            for (int j = 0; j < i; j++) {
                if (s >= end[j])
                    best = Math.max(best, dp[j]);
            }
            dp[i] = best + earnings[i];
        }
        return dp[tip.length - 1];
    }
}

class Order {
    int start, end, tip, money;
}