package com.demo;

import java.util.Random;

public class MaxSubArray {

    public static void main(String[] args) {
        int a[] = new int[9];
        Random rand = new Random();
        System.out.println();
        for (int i = 0; i < 9; i++) {
            a[i] = rand.nextInt(2);
            System.out.print(a[i] + " ");
        }
        System.out.println();
        int sum = 0, max = -1, c = 0;
        for (int i = 0; i < 9; i++) {
            sum = (a[i] == 0) ? -1 : 1;
            for (int j = i + 1; j < 9; j++) {
                sum += (a[j] == 0) ? -1 : 1;
                if (sum == 0 && c < (j - i + 1)) {
                    max = i;
                    c = j - i + 1;
                }
            }
        }
        System.out.println(c + " " + max);
    }

}
