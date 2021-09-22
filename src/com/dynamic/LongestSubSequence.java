package com.dynamic;

public class LongestSubSequence {
    public static void main(String args[]) {
        String a = "abacus", b = "sucaba";
        int output = solve(a, b);
        System.out.println(output);
    }

    private static int solve(String a, String b) {
        int dp[][] = new int[a.length() + 1][b.length() + 1];
        char stra[] = a.toCharArray();
        char strb[] = b.toCharArray();
        for (int i = 1; i <= stra.length; i++) {
            for (int j = 1; j <= strb.length; j++) {
                dp[i][j] = (stra[i - 1] == strb[j - 1]) ? dp[i - 1][j - 1] + 1 : Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        printdp(dp);
        return dp[a.length()][b.length()];
    }

    private static void printdp(int[][] dp) {
        for (int i = 0; i < dp.length; System.out.println(), i++)
            for (int j = 0; j < dp[i].length; System.out.print(' '), j++)
                System.out.print(dp[i][j] + " ");
        System.out.println();
    }
}

