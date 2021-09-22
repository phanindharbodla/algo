package com.arrays;

import java.util.HashMap;

public class BinarySubArraySum0 {
    public static void main(String args[]) {
        int[] input = {1, 0, 1, 1, 1, 0, 0, 0, 1};
        //Given an binary array containing only 0s and 1s, find the largest subarray which contain equal no of 0s and 1s.
        System.out.println(solve(input));
        int[] input1 = {1, 0, 1, 1, 1, 0, 0, 0};
        //Given an binary array containing only 0s and 1s, find the largest subarray which contain equal no of 0s and 1s.
        System.out.println(solve(input1));
    }

    private static int solve(int[] input) {
        int dp[] = new int[input.length];
        HashMap<Integer, Integer> minmap = new HashMap();
        HashMap<Integer, Integer> maxmap = new HashMap();
        int sum = 0;
        for (int i = 0; i < input.length; i++) {
            sum += (input[i] == 1) ? 1 : -1;
            dp[i] = sum;
            if (!minmap.containsKey(sum)) minmap.put(sum, i);
            maxmap.put(sum, i);
        }
        int max = 0;
        if (maxmap.containsKey(0)) max = maxmap.get(0) + 1;
        for (int i = 1; i < input.length; i++) {
            if (maxmap.containsKey(i) && minmap.containsKey(i))
                max = Math.max(max, maxmap.get(i) - minmap.get(i));
            if (maxmap.containsKey(i * -1) && minmap.containsKey(i * -1))
                max = Math.max(max, maxmap.get(i * -1) - minmap.get(i * -1));
        }
        printdp(dp);
        System.out.println(max);
        System.out.println(input.length);
        System.out.println(maxmap);
        System.out.println(minmap);
        return max;
    }

    private static void printdp(int[] dp) {
        for (int i = 0; i < dp.length; i++)
            System.out.print(dp[i] + " ");
        System.out.println();
    }
}
