package com.graph;

import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SnakeAndLadder {

    static int[] cell = new int[30];

    public static void main(String[] args) {

        Arrays.fill(cell, -1);
        // Ladders
        cell[2] = 21;
        cell[4] = 7;
        cell[10] = 25;
        cell[19] = 28;
        // Snakes
        cell[26] = 0;
        cell[20] = 8;
        cell[16] = 3;
        cell[18] = 6;

        System.out.println("Minimum no of dice throws to finish game is " + bfs(0, 29));
    }

    private static int bfs(int start, int end) {
        Queue<SimpleEntry<Integer, Integer>> queue = new LinkedList<SimpleEntry<Integer, Integer>>();
        boolean[] visited = new boolean[cell.length];
        queue.add(new SimpleEntry<Integer, Integer>(start, 0));// start , steps
        visited[start] = true;
        while (!queue.isEmpty()) {
            SimpleEntry<Integer, Integer> head = queue.poll();
            int currentCell = head.getKey();
            int limit = Math.min(currentCell + 6, end);
            int currentMin = head.getValue();
            for (int i = currentCell + 1; i <= limit; i++) {
                if (!visited[i]) {
                    int newCell = (cell[i] == -1) ? i : cell[i];
                    queue.add(new SimpleEntry<Integer, Integer>(newCell, currentMin + 1));
                    visited[i] = true;
                    if (i == end)
                        return currentMin + 1;
                }
            }
        }
        return -1;
    }

    private static int shortestPath(int start, int end) {
        Queue<SimpleEntry<Integer, Integer>> queue = new LinkedList<>();
        boolean[] visited = new boolean[cell.length];
        queue.add(new SimpleEntry<>(start, 0));// starting cell position steps required to reach it
        visited[0] = true;
        int currentCell, i, endCell, minSteps = 0;
        SimpleEntry<Integer, Integer> currentEntry;
        while (!queue.isEmpty()) {
            currentEntry = queue.poll();
            System.out.println(currentEntry.getKey() + " : " + currentEntry.getValue());
            currentCell = currentEntry.getKey();
            minSteps = currentEntry.getValue();
            endCell = Math.min(end, currentCell + 6);
            for (i = currentCell + 1; i <= endCell; i++) {
                if (!visited[i]) {
                    queue.add(new SimpleEntry<>(cell[i] == -1 ? i : cell[i], minSteps + 1));
                    visited[i] = true;
                    if (i == end)
                        return minSteps + 1;

                }
            }
        }

        return -1;
    }


}