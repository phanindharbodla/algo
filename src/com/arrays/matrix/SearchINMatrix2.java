package com.arrays.matrix;


public class SearchINMatrix2 {
    // Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
    // Integers in each row are sorted in ascending from left to right.
    // Integers in each column are sorted in ascending from top to bottom
    public static void main(String[] args) {
        int[][] input = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(search(input, 51)); // true
        System.out.println(search(input, 24)); // true

    }

    static boolean search(int[][] input, int target) {
        int rows = input.length;
        int cols = input[0].length;
        int row = 0, col = cols - 1;
        // start with top right index of the matrix
        while (row < rows && col >= 0) {
            if (input[row][col] == target)
                return true;
            if (input[row][col] > target)
                col--;
            else
                row++;
        }

        return false;
    }
}
