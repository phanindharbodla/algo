package com.dynamic;

public class SplitRod {
    public static void main(String args[]) {
        int[] input = {1, 5, 8, 9, 10, 17, 17, 20};
        int output = solve(input);
        System.out.println(output);
    }

    private static int solve(int[] input) {
        int dp[] = new int[input.length + 1];
        for (int i = 1; i <= input.length; i++)
            dp[i] = input[i - 1];
        for (int i = 2; i <= input.length; i++)
            for (int j = 1; j < i; j++)
                dp[i] = Math.max(dp[i], (dp[j] * (i / j) + (dp[i % j])));
        printdp(dp);
        return dp[input.length];
    }

    private static void printdp(int[] dp) {
        for (int i = 0; i < dp.length; i++)
            System.out.print(dp[i] + " ");
        System.out.println();
    }
}