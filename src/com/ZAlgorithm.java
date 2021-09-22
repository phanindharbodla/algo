package com;

public class ZAlgorithm {
    public static void main(String[] args) {
        printIndex("aaa", "aaaabaa");
    }

    private static void printIndex(String a, String b) {
        String C = a + '$' + b;
        char[] chars = C.toCharArray();
        int i;
        int l = 0, r = 0;
        int[] z = new int[chars.length];
        for (i = 1; i < chars.length; i++) {
            if (r > i) {
                z[i] = Math.min(z[i - l], r - i);
            }
            while (i + z[i] < chars.length && chars[z[i]] == chars[i + z[i]])
                z[i]++;
            if (r < i + z[i]) {
                r = i + z[i];
                l = i;
            }
        }
    }
}
