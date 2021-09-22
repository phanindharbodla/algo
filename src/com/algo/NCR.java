package com.algo;

public class NCR {

    public static void main(String[] args) {
        long i = ncr(10, 3);
        System.out.println(i);
    }

    private static long ncr(int n, int k) {
        if (n == 0) return 1;
        if (k < n - k) k = n - k;
        long ans = 1;

        for (int i = 1; i <= k; i++) {
            ans *= (n - i + 1);
            ans /= i;
        }
        return ans;
    }

}
