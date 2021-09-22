package com.dynamic;

public class LongestZigZagSequence {
    public static void main(String args[]) {
        int[] input = {4, 11, 10, 9, 21, 13, 21};
        int output = solve(input);
        System.out.println(output);
        output = solve2(input);
        System.out.println(output);
    }

    private static int solve(int[] input) {
        int dp[][] = new int[input.length][2];//[i][0]=> res[0]<res[1] [i][1]=> res[0]>res[1]
        int max = 1;
        for (int i = 0; i < input.length; i++) {
            dp[i][0] = dp[i][1] = 1;
        }
        for (int i = 1; i < input.length; i++) {
            for (int j = 0; j < i; j++) {
                if (input[j] < input[i]) {
                    if (dp[j][0] % 2 == 1) {
                        dp[i][0] = 1 + dp[j][0];
                    }
                    if (dp[j][1] % 2 == 0) {
                        dp[i][1] = 1 + dp[j][1];
                    }
                } else {
                    if (dp[j][0] % 2 == 0) {
                        dp[i][0] = 1 + dp[j][0];
                    }
                    if (dp[j][1] % 2 == 1) {
                        dp[i][1] = 1 + dp[j][1];
                    }
                }
                max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
            }
        }
        printdp(dp);

        return max;
    }

    private static int solve2(int[] input) {
        int dp[][] = new int[input.length][2];
        ////dp[i][0]=> res[i-1]<res[i] dp[i][1]=> res[i-1]>res[i]
        int max = 1;
        for (int i = 0; i < input.length; i++) {
            dp[i][0] = dp[i][1] = 1;
        }
        for (int i = 1; i < input.length; i++) {
            for (int j = 0; j < i; j++) {
                if (input[j] < input[i]) {
                    dp[i][0] = Math.max(dp[i][0], dp[j][1] + 1);
                }
                if (input[j] > input[i]) {
                    dp[i][1] = Math.max(dp[i][1], dp[j][0] + 1);
                }
                max = Math.max(Math.max(dp[i][1], dp[i][0]), max);
            }
        }
        printdp(dp);
        return max;
    }

    private static void printdp(int[][] dp) {
        for (int i = 0; i < dp.length; System.out.println(), i++)
            for (int j = 0; j < dp[i].length; System.out.print(' '), j++)
                System.out.print(dp[i][j] + " ");
    }
}
