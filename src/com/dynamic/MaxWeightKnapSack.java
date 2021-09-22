package com.dynamic;

public class MaxWeightKnapSack {
    public static void main(String args[]) {
        int[] weights = {2, 3, 4};
        int[] values = {100, 120, 150};
        int capacity = 8;
        int output = solve(weights, values, capacity);
        System.out.println(output);
    }

    private static int solve(int[] weights, int[] values, int capacity) {
        int dp[][] = new int[capacity + 1][weights.length + 1];
        int lastItemWeight;
        for (int i = 1; i <= capacity; i++) {
            for (int j = 1; j <= values.length; j++) {
                dp[i][j] = dp[i][j - 1];
                lastItemWeight = weights[j - 1];
                if (lastItemWeight < i /*&& dp[i - lastItemWeight][j - 1] != 0*/) {
                    dp[i][j] = Math.max(values[j - 1] + dp[i - lastItemWeight][j - 1], dp[i][j]);
                } else if (lastItemWeight > i) {
                    // item not selected
                } else if (i == lastItemWeight) {
                    dp[i][j] = Math.max(dp[i][j], values[j - 1]);
                }
            }
        }
        printdp(dp);
        return dp[capacity][values.length];
    }

    private static void printdp(int[][] dp) {
        for (int i = 0; i < dp.length; System.out.println(), i++)
            for (int j = 0; j < dp[i].length; System.out.print(' '), j++)
                System.out.print(dp[i][j] + " ");
        System.out.println();
    }
}
