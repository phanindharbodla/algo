package com.dynamic;

public class WordWrap {

    public static void main(String[] args) {
        int[] words = {3, 2, 2, 5};
        int minCost = minCostWord(words, 6);
        System.out.println("Minimum cost is " + minCost);
    }

    private static int minCostWord(int[] words, int width) {
        int count = words.length;
        int[][] space = new int[count + 1][count + 1];// Space occupied by words i to j
        int[][] cost = new int[count + 1][count + 1];// cost of words i to j for the given width

        for (int left = 1; left <= count; left++) {
            space[left][left] = words[left - 1];
            for (int right = left + 1; right <= count; right++) {
                space[left][right] = space[left][right - 1] + (words[right - 1] + 1);
            }
        }

        int extraSpace = 0;
        int INF = cost(width);

        for (int left = 1; left <= count; left++) {
            for (int right = left; right <= count; right++) {
                extraSpace = width - (space[left][right]);
                cost[left][right] = (extraSpace > 0) ? cost(extraSpace) : INF;
            }
        }

        int[] minCost = new int[count + 1];
        int[] Split = new int[count + 1];

        for (int j = 1; j <= count; j++) {
            minCost[j] = INF;
            for (int i = 1; i <= j; i++) {
                if (minCost[i] > cost[i][j]) {
                    minCost[i] = cost[i][j];
                    Split[i] = j;
                }
            }
        }
        int min = 0;
        for (int i = 1, line = 1; i <= count; line++) {
            System.out.println("line " + line + " has " + i + "->" + Split[i] + " words");
            min += minCost[i];
            i = Split[i] + 1;
        }
        return min;
    }

    private static int cost(int i) {
        return i * i * i;
    }
}