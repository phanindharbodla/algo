package com.dynamic;

public class StringPalindrome {

    public static void main(String[] args) {
        //String str = "prapullareddy";
        String str = "prapullareddy";
        System.out.println(minimumOperations(str));
        // Another way to find is find the longest common sequence of given
        // string and its reverse of it and the string length - length of common
        // sequence is the answer
        int i = str.length() - longestCommonSequence(str, (new StringBuilder(str)).reverse().toString());
        System.out.println(i);
    }

    private static int minimumOperations(String str) {
        // Create a table of size n*n. table[i][j] will store
        // minumum number of insertions needed to convert str[i..j]
        // to a palindrome.
        int[][] ans = new int[str.length()][str.length()];
        for (int gap = 1; gap < str.length(); gap++) {
            for (int l = 0, r = gap; r < str.length(); l++, r++)
                ans[l][r] = (str.charAt(l) == str.charAt(r)) ? ans[l + 1][r - 1] : (Math.min(ans[l + 1][r], ans[l][r - 1]) + 1);
        }
        return ans[0][str.length() - 1];
    }

    private static int longestCommonSequence(String a, String b) {
        // Following steps build dp [m+1][n+1] in bottom up fashion. Note that dp[i][j] contains length of LCS of a[0..i-1] and b[0..j-1]
        int dp[][] = new int[a.length() + 1][b.length() + 1];
        for (int i = 1; i <= a.length(); i++)
            for (int j = 1; j <= b.length(); j++)
                dp[i][j] = (a.charAt(i - 1) == b.charAt(j - 1)) ? (dp[i - 1][j - 1] + 1) : Math.max(dp[i - 1][j], dp[i][j - 1]);
        return dp[a.length()][b.length()];
    }

}
