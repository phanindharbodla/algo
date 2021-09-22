package com.dynamic;

public class PlayList {
    public static void main(String args[]) {
        int[] input = {4, 19, 8, 12, 9, 15, 9, 36};
        int jtime = 25;
        /* Given array of numbers each represents the running length of a song.
        Find the maximum no of songs that that be selected such sum of their running time is (Jtime) Journey time
        Or Max subset count such that their sum is equal to jtime
        */
        int max = solve(input, jtime);
        System.out.println(max);
    }

    private static int solve(int[] input, int jtime) {
        int[][] dp = new int[jtime + 1][input.length + 1];//dp[i][j] represents count of max no of songs in till jth song whose sum is i
        int i, j, currentSong;
        //time
        for (i = 1; i <= jtime; i++)
            for (j = 1; j <= input.length; j++) {//j songs
                currentSong = input[j - 1];
                if (currentSong < i && dp[i - currentSong][j - 1] != 0) {
                    dp[i][j] = 1 + dp[i - currentSong][j - 1];
                } else if (currentSong == i) {
                    dp[i][j] = 1;// selected only this song
                }
                dp[i][j] = Math.max(dp[i][j - 1], dp[i][j]);
            }
        printdp(dp);
        System.out.println();
        return dp[jtime][input.length];
    }

    private static void printdp(int[][] dp) {
        for (int i = 0; i < dp.length; System.out.println(), i++)
            for (int j = 0; j < dp[i].length; System.out.print(' '), j++)
                System.out.print(dp[i][j] + " ");
    }
}