package com.demo;

import java.util.AbstractMap;
import java.util.PriorityQueue;

public class SnowSpread {
    public static void main(String args[]) {
        int[] input = {0, 1, 3, 0, 1, 2, 0, 4, 2, 0, 3, 2, 1};
        System.out.println(solvewithheap(input));
        System.out.println(solve(input));
    }

    private static int solve(int[] input) {
        int sum = 0, i, j, max;
        int highLeft[] = new int[input.length];
        //int highright[] = new int[input.length];
        highLeft[0] = input[0];
        //highright[input.length - 1] = input[input.length - 1];
        for (i = 1; i < input.length; i++) {
            //j = input.length - 1 - i;
            highLeft[i] = Math.max(highLeft[i - 1], input[i]);
            //highright[j] = Math.max(highright[j + 1], input[j]);
        }
        /*for (i = 0; i < input.length; i++)
            sum += Math.min(highLeft[i], highright[i]) - input[i];*/
        max = input[input.length - 1];
        for (i = input.length - 2; i >= 0; i--) {
            max = Math.max(max, input[i]);
            sum += Math.min(highLeft[i], max) - input[i];
        }
        return sum;
    }

    private static int solvewithheap(int[] input) {
        PriorityQueue<AbstractMap.SimpleEntry<Integer, Integer>> heap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        AbstractMap.SimpleEntry<Integer, Integer> val;
        boolean[] visited = new boolean[input.length];
        int sum = 0, index, curleft = 0, curright = 0;
        for (int i = 0; i < input.length; i++) {
            heap.add(new AbstractMap.SimpleEntry<Integer, Integer>(i, input[i]));
        }
        int va11 = heap.poll().getKey();
        int va12 = heap.poll().getKey();
        int left = Math.min(va11, va12);
        int right = Math.max(va11, va12);
        int height = Math.min(input[left], input[right]);
        visited[left] = true;
        visited[right] = true;
        for (int i = left + 1; i < right; visited[i] = true, i++)
            sum += height - input[i];

        while ((val = heap.poll()) != null) {
            index = val.getKey();
            if (!visited[index]) {
                if (index > right) {
                    curleft = right;
                    curright = index;
                    right = index;
                } else if (index < left) {
                    curleft = index;
                    curright = left;
                    left = index;
                }
                visited[index] = true;
                height = Math.min(input[curleft], input[curright]);
                for (int i = curleft + 1; i < curright; visited[i] = true, i++)
                    sum += height - input[i];
            }
        }
        return sum;
    }
}
