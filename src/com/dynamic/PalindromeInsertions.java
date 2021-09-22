package com.dynamic;

public class PalindromeInsertions {
    public static void main(String args[]) {
        String str = "loimhvnhojkjlal";
        //String str = "abacusu";
        int output = solve(str);
        System.out.println(output);
    }

    private static int solve(String str) {
        char input[] = str.toCharArray();
        int dp[][] = new int[str.length()][str.length()];
        int begin, end;
        for (int gap = 1; gap < input.length; gap++) {
            for (int i = 0; i + gap < input.length; i++) {
                begin = i;
                end = i + gap;
                dp[begin][end] = (input[begin] == input[end]) ? dp[begin + 1][end - 1] : 1 + Math.min(dp[begin + 1][end], dp[begin][end - 1]);
            }
        }
        printdp(dp);
        return dp[0][input.length - 1];
    }

    private static void printdp(int[][] dp) {
        for (int i = 0; i < dp.length; System.out.println(), i++)
            for (int j = 0; j < dp[i].length; System.out.print(' '), j++)
                System.out.print(dp[i][j] + " ");
        System.out.println();
    }
}
