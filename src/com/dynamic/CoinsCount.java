package com.dynamic;

public class CoinsCount {
    public static void main(String args[]) {
        int coins[] = {6, 2, 3, 5}, target = 11;
        /*Given a value N(10), if we want to make change for N cents, and we have infinite supply of each of
        S = { S1, S2, .. , Sm}({6, 2, 3, 5}) valued coins, how many ways can we make the change? The order of coins doesn’t matter.*/
        int output = solveSum(coins, target);
        System.out.println();
        System.out.println(output);
    }

    private static int solve(int[] coins, int target) {
        int dp[][] = new int[coins.length + 1][target + 1];
        int curcoin = 0;
        for (int i = 1; i <= coins.length; i++) {
            curcoin = coins[i - 1];
            for (int j = 1; j <= target; j++) {
                if (curcoin > j) {
                    //cant select coin
                } else if (curcoin == j) {
                    dp[i][j] = 1;//select only this coin
                } else {
                    dp[i][j] = dp[i][j - curcoin]; // selected this coin along  with
                }
                dp[i][j] += dp[i - 1][j];
            }
        }
        printdp(dp);

        return dp[coins.length][target];
    }


    private static int solveSum(int[] coins, int target) {
        int dp[][] = new int[coins.length + 1][target + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++)
                dp[i][j] = target;
        }
        int curcoin = 0;
        for (int i = 1; i <= coins.length; i++) {
            curcoin = coins[i - 1];
            for (int j = 1; j <= target; j++) {
                if (curcoin > j) {
                    //cant select coin
                } else if (curcoin == j) {
                    dp[i][j] = 1;//select only this coin
                } else {
                    dp[i][j] = Math.min(1 + dp[i][j - curcoin], dp[i][j]); // selected this coin along  with

                }
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j]);
            }
        }

        printdp(dp);
        return dp[coins.length][target];
    }

    private static void printdp(int[][] dp) {
        for (int i = 0; i < dp.length; System.out.println(), i++)
            for (int j = 0; j < dp[i].length; System.out.print(' '), j++)
                System.out.print(dp[i][j] + " ");
    }
}
