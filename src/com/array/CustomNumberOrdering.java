package com.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CustomNumberOrdering {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, -4};

        print(input);
        int length = input.length;
        int start = 0;
        int end = length - 1;
        int i = 0;
        while (i < length) {
            if (input[start] % 2 == 1) {
                start++;
                i++;
            }
            if (input[end] % 2 == 0) {
                end--;
                i++;
            }
            if (input[start] % 2 == 0 && input[end] % 2 == 1) {
                int temp = input[start];
                input[start] = input[end];
                input[end] = temp;
                start++;
                end--;
                i = i + 2;
            }
        }
        Arrays.sort(input, start, length);

        for (int x = 0; x < start; x++) {
            for (int y = x; y < start; y++) {
                if (input[x] < input[y]) {
                    int temp = input[x];
                    input[x] = input[y];
                    input[y] = temp;
                }
            }
        }
        System.out.println(input);

        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(3);
        l.add(2);
        Comparator<Integer> c = (o1, o2) -> o1.compareTo(o2);
        l.sort(c);

        System.out.println();
    }

    private static void print(int[] input) {
        Arrays.stream(input).filter(a -> a % 2 == 1).sorted().toArray();
        Arrays.stream(input).filter(a -> a % 2 == 0).sorted().toArray();
    }
}
