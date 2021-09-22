package com.dynamic;

public class LongestPalindrome {
    public static void main(String args[]) {
        String name = "heritage";
        int output = solve(name);
        System.out.println();
        System.out.println(output);
    }

    private static int solve(String name) {
        char input[] = name.toCharArray();
        int dp[][] = new int[input.length][input.length];
        for (int i = 0; i < input.length; dp[i][i]++, i++) ;
        int begin, end, max = 1, max_i = 0, max_j = 0;
        for (int i = 0; i < input.length - 1; i++) {
            dp[i][i + 1] = (input[i] == input[i + 1]) ? 2 : 0;
            //max = Math.max(max, dp[i][i + 1]);
            if (dp[i][i + 1] > max) {
                max = dp[i][i + 1];
                max_i = i;
                max_j = i + 1;
            }
        }
        for (int gap = 2; gap < input.length - 1; gap++) {
            for (int i = 0; i < input.length - gap; i++) {
                begin = i;
                end = begin + gap;
                if (input[begin] == input[end] && dp[begin + 1][end - 1] != 0) {
                    dp[begin][end] = 2 + dp[begin + 1][end - 1];
                    //max = Math.max(max, dp[begin][end]);
                    if (dp[begin][end] > max) {
                        max = dp[begin][end];
                        max_i = begin;
                        max_j = end;
                    }
                }
            }
        }
        printdp(dp);
        for (int i = max_i; i <= max_j; i++)
            System.out.print(name.charAt(i));
        return max;
    }

    private static void printdp(int[][] dp) {
        for (int i = 0; i < dp.length; System.out.println(), i++)
            for (int j = 0; j < dp[i].length; System.out.print(' '), j++)
                System.out.print(dp[i][j] + " ");
    }
}

