package com.arrays;

public class RotatedSortedArray {
    public static void main(String[] args) {
        //Find the Rotation Count in Rotated Sorted array
        int arr[] = {15, 18, 23, 32, 1, 2, 3, 6, 12};

        System.out.println(solve(arr));
    }

    private static int solve(int[] arr) {
        int start = 0, end = arr.length - 1, mid = 0;

        mid = (start + end) / 2;

        do {
            if (arr[start] > arr[mid]) {
                end = mid;
                mid = (start + end) / 2;
            } else if (arr[mid] > arr[end]) {
                start = mid;
                mid = (start + end) / 2;
            }
        } while (start + 1 < end && arr[start] > arr[end]);

        return start + 1;
    }
}
