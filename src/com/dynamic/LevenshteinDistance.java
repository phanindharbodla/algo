package com.dynamic;

public class LevenshteinDistance {
    public static void main(String args[]) {
        /*Given two strings str1 and str2 and below operations that can performed on str1. Find minimum number of edits (operations)
        required to convert ‘str1’ into ‘str2’.valid edits are Insert, Remove, Replace on chars */
        String a = "tempro", b = "mentor";
        //String a = "bab", b = "ab";
        int output = solve(a, b);
        System.out.println(output);
    }

    private static int solve(String a, String b) {
        char stringa[] = a.toCharArray();
        char stringb[] = b.toCharArray();
        int dp[][] = new int[stringa.length + 1][stringb.length + 1];
        char chara, charb, chara1, charb1;
        for (int i = 1; i <= stringa.length; i++)
            dp[i][0] = i;
        for (int j = 1; j <= stringb.length; j++)
            dp[0][j] = j;
        for (int i = 1; i <= stringa.length; i++) {
            for (int j = 1; j <= stringb.length; j++) {
                chara = stringa[i - 1];
                charb = stringb[j - 1];
                if (chara == charb) {
                    dp[i][j] = dp[i - 1][j - 1];// no step since same char
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]);// 1 step for add char or delete char or replace char
                }
                /*if (i > 1 && j > 1) {
                    chara1 = stringa[i - 2];
                    charb1 = stringb[j - 2];
                    if (chara == charb1 && charb == chara1) {
                        dp[i][j] = Math.min(dp[i][j], 1 + dp[i - 2][j - 2]); // ab -> ba =1 step swap
                    }
                }*/
            }
        }
        printdp(dp);
        return dp[stringa.length][stringb.length];
    }

    private static void printdp(int[][] dp) {
        for (int i = 0; i < dp.length; System.out.println(), i++)
            for (int j = 0; j < dp[i].length; System.out.print(' '), j++)
                System.out.print(dp[i][j] + " ");
        System.out.println();
    }
}