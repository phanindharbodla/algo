package com.dynamic;

public class SentenceWrap {
    public static void main(String args[]) {//word wrap
        int input[] = {3, 2, 2, 5};
        int target = 6;
        int output = solve(input, target);
        System.out.println(output);
    }

    private static int solve(int[] input, int target) {
        int dp[][] = new int[input.length][input.length];
        int maxcost = Integer.MAX_VALUE;
        int tempcost = 0;
        for (int i = 0; i < input.length; i++) {
            dp[i][i] = input[i];
            for (int j = i + 1; j < input.length; j++) {
                dp[i][j] += dp[i][j - 1] + 1 + input[j];
            }
        }
        for (int i = 0; i < input.length; i++) {
            for (int j = i; j < input.length; j++) {
                tempcost = target - dp[i][j];
                if (tempcost >= 0)
                    dp[i][j] = tempcost * tempcost * tempcost;
                else
                    dp[i][j] = maxcost;
            }
        }
        for (int i = 1; i < input.length; i++)
            for (int j = i; j < input.length && dp[i][j] != maxcost; j++)
                dp[i][j] = Math.min(dp[i][j] + dp[i - 1][i - 1], dp[i - 1][j]);
        printdp(dp);
        return dp[input.length - 1][input.length - 1];
    }

    private static void printdp(int[][] dp) {
        for (int i = 0; i < dp.length; System.out.println(), i++)
            for (int j = 0; j < dp[i].length; System.out.print(' '), j++)
                System.out.print(dp[i][j] + " ");
        System.out.println();
    }
}