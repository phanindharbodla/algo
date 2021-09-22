package com.demo;

import java.util.Random;

public class MaxDifference {
    public static void main(String[] args) {
        int a[] = new int[9];
        Random rand = new Random();
        int result = 0, rMax = 0, max = 0;
        System.out.println();
        for (int i = 0; i < 9; i++) {
            a[i] = rand.nextInt(50);
            System.out.print(a[i] + " ");
        }
        System.out.println();
        int N = 9;
        for (int i = N - 1; i >= 0; --i) {
            if (a[i] > max)
                max = a[i];
            int tmpResult = max - a[i];
            if (tmpResult > result) {
                result = tmpResult;
                rMax = max;
            }
        }
        System.out.println(result + " " + (rMax - result) + " " + rMax + " " + max);// diff,min,max, MaxInList
    }
}
