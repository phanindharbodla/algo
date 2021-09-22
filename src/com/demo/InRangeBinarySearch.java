package com.demo;

import java.util.Arrays;
import java.util.Random;

public class InRangeBinarySearch {

    public static void main(String[] args) {
        int a[] = new int[99];
        Random rand = new Random();
        int res = -1;
        System.out.println();
        for (int i = 0; i < 99; i++)
            a[i] = rand.nextInt(200);
        Arrays.sort(a);
        res = bs(a, 0, 98, 39);
        for (int i = 0; i < 99; i++)
            System.out.print(a[i] + " ");
        System.out.println();
        System.out.println(a[res] + " " + a[res + 1]);
    }

    public static int bs(int[] a, int b, int e, int k) {
        int first = b;
        int last = e;
        int middle = (first + last) / 2;
        int search = k;
        while (first <= last) {
            if (a[middle] < search) {
                first = middle + 1;
            } else if (a[middle] == search) {
                break;
            } else {
                last = middle - 1;
            }
            middle = (first + last) / 2;
        }
        return middle;
    }
}