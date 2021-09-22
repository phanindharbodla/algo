package com;

public class LivenStein {
    private static LivenStein ourInstance = new LivenStein();

    private LivenStein() {
    }

    public static LivenStein getInstance() {
        return ourInstance;
    }

    public int costOf(String str1, String str2) {
        char[] a = str1.toCharArray();
        char[] b = str2.toCharArray();


        int dp[][] = new int[a.length + 1][b.length + 1];

        for (int i = 0; i <= a.length; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= b.length; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= a.length; i++)
            for (int j = 1; j <= b.length; j++) {
                if (a[i - 1] == b[j - 1])
                    dp[i][j] = dp[i - 1][j - 1];
                else if (i > 1 && j > 1 && a[i - 1] == b[j - 2] && a[i - 2] == b[j - 1])
                    dp[i - 1][j - 1] = dp[i][j] = Math.min(dp[i - 2][j - 2] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1));
                else
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 2, Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1));
            }

        for (int i = 1; i <= a.length; System.out.println('\b'), i++)
            for (int j = 1; j <= b.length; System.out.print(" "), j++)
                System.out.print(dp[i][j]);

        System.out.println(dp[a.length][b.length]);
        return dp[a.length][b.length];
    }
}
