package com.dynamic;

public class Template {
    public static void main(String args[]) {
        int output = solve();
        System.out.println(output);
    }

    private static int solve() {
        return 0;
    }

    private static void printdp(int[][] dp) {
        for (int i = 0; i < dp.length; System.out.println(), i++)
            for (int j = 0; j < dp[i].length; System.out.print(' '), j++)
                System.out.print(dp[i][j] + " ");
        System.out.println();
    }
}
