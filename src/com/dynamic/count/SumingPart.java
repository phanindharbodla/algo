package com.dynamic.count;

public class SumingPart {
    // Count number of ways to divide a number in 4 parts
    public static void main(String[] args) {
        int n = 8;
        int result = CountWaysRec(n, 4, 1);
        System.out.println(result);
        result = CountWaysRec2(n, 4);
        System.out.println(result);
        result = CountWaysDP2(n, 4);
        System.out.println(result);

    }

    private static int CountWaysRec2(int n, int k) {
        if (n == 0 && k == 0) {
            return 1;
        }
        if (k > n || (k == 0)) {// parts greater than sum or parts are 0 for a
            // sum
            return 0;
        }
        return CountWaysRec2(n - k, k) + CountWaysRec2(n - 1, k - 1);
        // (ways where every element >1) + (ways where at-least single 1 exists
        // )
    }

    private static int CountWaysDP2(int sum, int parts) {
        int[][] dp = new int[sum + 1][parts + 1];
        dp[0][0] = 1;

        try {
            for (int j = 1; j <= parts; j++) {
                for (int i = 1; i <= sum; i++) {
                    if (!((j > i) || (j == 0))) {
                        dp[i][j] += dp[i - j][j] + dp[i - 1][j - 1];
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
        }

        return dp[sum][parts];
    }

    private static int CountWaysRec(int sumLeft, int parts, int minimum) {
        if (minimum * parts > sumLeft)
            return 0;
        if (minimum * parts == sumLeft)
            return 1;
        int count = 0;
        for (; minimum <= sumLeft; minimum++) {
            count += CountWaysRec(sumLeft - minimum, parts - 1, minimum);
        }
        return count;
    }

}
