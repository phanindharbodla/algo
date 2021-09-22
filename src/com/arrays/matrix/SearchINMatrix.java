package com.arrays.matrix;


public class SearchINMatrix {
    // Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
    // Integers in each row are sorted in ascending from left to right.
    // The first integer of each row is greater than the last integer of the previous row.
    public static void main(String[] args) {
        int[][] input = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        System.out.println(search(input, 30)); // true
        System.out.println(search(input, 51)); // false
    }

    static boolean search(int[][] input, int target) {
        int rows = input.length;
        int cols = input[0].length;
        int start = 0;
        int end = (rows * cols) - 1;
        int middle;
        int value;
        while (start <= end) {
            middle = (start + end) / 2;
            value = input[middle / cols][middle % cols];
            if (value == target)
                return true;
            if (value < target)
                start = middle + 1;
            else
                end = middle - 1;
        }

        return false;
    }
}
