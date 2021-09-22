package com.dynamic;

public class SubsetSum {
    public static void main(String args[]) {
        int[] input = {13, 26, 4, 71, 89, 23, 54, 76, 24, 53};
        int target = 124;
        boolean output = solve(input, target);
        System.out.println((output) ? "YES" : "NO");
    }

    private static boolean solve(int[] input, int target) {
        boolean dp[][] = new boolean[input.length + 1][target + 1];
        int curnum = 0;
        for (int i = 0; i <= input.length; i++)        //dp[0][i]=0,dp[i][0]=0 base cases
            dp[i][0] = true;
        for (int i = 1; i <= input.length; i++) {
            for (int sum = 1; sum <= target; sum++) {
                curnum = input[i - 1];
                dp[i][sum] = dp[i - 1][sum];
                if (curnum == sum) {
                    dp[i][sum] = true;// fits sum selected
                } else if (curnum > sum) {
                    // does'nt fit so choose the previous best
                } else //if(curnum<sum)
                {
                    if (dp[i - 1][sum - curnum])
                        dp[i][sum] = true;
                }
            }
        }
        printdp(dp);
        return dp[input.length][target];
    }

    private static void printdp(boolean[][] dp) {
        for (int i = 0; i < dp.length; System.out.println(), i++)
            for (int j = 0; j < dp[i].length; System.out.print(' '), j++)
                System.out.print((dp[i][j]) ? 1 : 0);
        System.out.println();
    }
}