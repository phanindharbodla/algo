package com.demo;

public class Input {

    public static void main(String[] args) {
        /*
         * reader = new Scanner(System.in); int t =
         * Integer.parseInt(reader.nextLine());
         * System.out.println(t);
         */
        int max = 1001;
        long res[] = new long[max];

        res[0] = res[1] = 1;

        for (long i = 2; i < (long) max; i++) {
            for (long j = (i + 1) / 2; j > 0; j--) {
                if ((i % j) == (j - 1)) {
                    res[(int) i] += res[(int) (j - 1)];
                }
            }
        }
        System.out.println(1);
    }
}
