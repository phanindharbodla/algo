package com.dynamic;

public class MatrixProduct {
    public static void main(String args[]) {
        int input[] = {40, 20, 30, 10, 30};
        //int input[] = {1, 2, 3, 4, 3};
        int output = solve(input);
        System.out.println(output);
    }

    private static int solve(int[] input) {
        int totalarrays = input.length - 1, begin, end, split, gap;
        int dp[][] = new int[totalarrays][totalarrays];//d[0][1]=A0*A1 = input[0]*input[1]*input[2]
        for (gap = 1; gap < totalarrays; gap++)
            for (begin = 0, end = begin + gap; end < totalarrays; begin++, end++)
                for (split = begin, dp[begin][end] = Integer.MAX_VALUE; split < end; split++)
                    dp[begin][end] = Math.min(dp[begin][split] + dp[split + 1][end] + (input[begin] * input[split + 1] * input[end + 1]), dp[begin][end]);
        printdp(dp);
        return dp[0][totalarrays - 1];
    }

    private static void printdp(int[][] dp) {
        for (int i = 0; i < dp.length; System.out.println(), i++)
            for (int j = 0; j < dp[i].length; System.out.print(' '), j++)
                System.out.print(dp[i][j] + " ");
        System.out.println();
    }
}