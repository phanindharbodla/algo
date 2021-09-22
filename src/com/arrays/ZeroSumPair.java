package com.arrays;

import java.util.Arrays;

public class ZeroSumPair {
    public static void main(String[] args) {
        int[] input = {15, 5, -20, 30, -45};
        System.out.println(solve(input));
    }

    private static int solve(int[] input) {
        Arrays.sort(input);
        printarr(input);
        int a = 0, b = input.length - 1, besta = a, bestb = b, sum;
        int bestSum = Math.abs(input[a] + input[b]);
        while (a < b) {
            sum = input[a] + input[b];
            if (bestSum > Math.abs(sum)) {
                bestSum = Math.abs(sum);
                besta = a;
                bestb = b;
            }
            if (sum < 0) a++;
            else b--;
        }
        System.out.println(input[besta] + " " + input[bestb]);
        //printarr(input);
        return 0;
    }

    private static void printarr(int[] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
        System.out.println();
    }
}
