package com.dynamic;

public class LongestIncreasingSeq {
    public static void main(String args[]) {
        int input[] = {8, 10, 9, 12, 11, 13};
        int output = solve(input);
        System.out.println(output);
        output = solveSearch(input);
        System.out.println(output);
    }

    private static int solve(int[] input) {
        int dp[] = new int[input.length];
        for (int i = 0; i < input.length; dp[i]++, i++) ;
        for (int i = 0; i < input.length; i++)
            for (int j = 0; j < i; j++)
                if (input[j] < input[i])
                    dp[i] = dp[j] + 1;
        printdp(dp);
        return dp[input.length - 1];
    }

    private static int solveSearch(int[] input) {
        int len = input.length;
        int[] c = new int[len + 1];
        int max = 1;// current max seq length
        c[max] = input[0];
        for (int i = 1; i < len; i++) {
            // place input[i] in c[x] such that in input[i] is maximum element for sequence whose length is x
            if (input[i] < c[1]) {
                c[1] = input[i];
            } else if (c[max] < input[i]) {
                c[++max] = input[i];
            } else {
                c[RangedBinarySearch(c, 1, max, input[i])] = input[i];
            }
        }
        printdp(c);
        return max;
    }

    private static int RangedBinarySearch(int[] c, int begin, int end, int key) {
        // returns index k such that c[k-1]< key < c[k]
        int mid = (begin + end) / 2;
        while (begin < end) {
            mid = (begin + end) / 2;
            if (key < c[mid]) {
                end = mid;
            } else {
                begin = mid + 1;
            }
        }
        return (key < c[mid]) ? mid : ++mid;
    }

    private static void printdp(int[] dp) {
        for (int i = 0; i < dp.length; i++)
            System.out.print(dp[i] + " ");
        System.out.println();
    }
}
