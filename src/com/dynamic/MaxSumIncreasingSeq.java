package com.dynamic;

public class MaxSumIncreasingSeq {
    public static void main(String args[]) {
        // find the max sum elements from elements in array [0..n] such that ai1<ai2<ai3..<aik => ai1...+aik should be max
        int[] input = {1, 101, 2, 3, 100, 4, 5};
        int output = solve(input);
        System.out.println(output);
    }

    private static int solve(int[] input) {
        int dp[] = new int[input.length];
        int max = 0;
        for (int i = 0; i < input.length; i++) dp[i] = input[i];
        for (int i = 1; i < input.length; i++) {
            for (int j = 0; j < i; j++) {
                if (input[j] < input[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + input[i]);
                    max = Math.max(dp[i], max);
                }
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
