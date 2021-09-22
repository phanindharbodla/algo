package com.arrays;

public class Sol {
    public static void main(String[] args) {
        int[] input = {};
        System.out.println(solve(input));
    }

    private static int solve(int[] input) {
        printarr(input);
        return 0;
    }

    private static void printarr(int[] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
        System.out.println();
    }
}
