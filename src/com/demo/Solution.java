package com.demo;


import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        String a = "temp";
        String b = "ptempo";
        Scanner s = new Scanner(System.in);
        permutation("", "abc");
        System.out.println(b.indexOf(a));
    }

    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
        }
    }
}