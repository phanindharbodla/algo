package com.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

public class SumNCoins {

    public static void main(String[] args) throws IOException {
        int a[] = {1, 3, 7};
        Vector<Integer> list = new Vector<>();
        list.add(1);
        list.add(3);
        list.add(7);
        int size = a.length;
        int d = minCoins(a, size, 11);
        System.out.print("\n" + d + " ");
        d = minCoins(list, 11);
        System.out.print("\n" + d + " ");
        return;
    }

    private static int minCoins(Vector<Integer> list, int n) {
        int count = 0, a[] = new int[list.size()];
        for (int i : list) a[count++] = i;
        int size = list.size();
        int j, i, s[] = new int[n + 1];
        for (i = 0; i < n + 1; i++) {
            s[i] = n + 1;
        }
        s[0] = 0;
        for (i = 1; i <= n; i++) {
            for (j = 0; j < size; j++) {
                if (i >= a[j]) {
                    if (s[i - a[j]] + 1 < s[i])
                        s[i] = s[i - a[j]] + 1;
                }
            }
        }
        return s[n];
    }

    private static int minCoins(int[] a, int size, int n) throws IOException {
        int j, i, s[] = new int[n + 1];
        ArrayList<Integer> myList = new ArrayList<Integer>();
        for (i = 0; i < n + 1; i++) {
            s[i] = n + 1;
        }
        s[0] = 0;
        for (i = 1; i <= n; i++) {
            for (j = 0; j < size; j++) {
                if (i >= a[j]) {
                    if (s[i - a[j]] + 1 < s[i])
                        s[i] = s[i - a[j]] + 1;
                }
            }
            System.out.println(i + " " + s[i] + " ");
            myList.add(s[i]);
        }
        return s[n];
    }
}
