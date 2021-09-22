package com.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class CanvasPieces {

    public static void main(String[] args) {
        String[] input = {"48 192 351 207", "48 392 351 407", "120 52 135 547", "260 52 275 547"};
        int x1, x2, y1, y2;
        boolean[][] canvas = new boolean[400][600];
        for (int i = 0; i < input.length; i++) {
            StringTokenizer temp = new StringTokenizer(input[i], " ");
            x1 = Integer.parseInt(temp.nextToken());
            y1 = Integer.parseInt(temp.nextToken());
            x2 = Integer.parseInt(temp.nextToken());
            y2 = Integer.parseInt(temp.nextToken());
            for (int x = x1; x <= x2; x++)
                for (int y = y1; y <= y2; y++) {
                    canvas[x][y] = true;
                }
        }
        class Pixel {
            public final int x;
            public final int y;

            public Pixel(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        List<Integer> results = new ArrayList<Integer>();
        Stack<Pixel> neighbours = new Stack<Pixel>();
        int count;
        for (int x = 0; x < 400; x++) {
            for (int y = 0; y < 600; y++) {
                if (canvas[x][y])
                    continue;
                neighbours.push(new Pixel(x, y));
                count = 0;
                while (!neighbours.isEmpty()) {
                    Pixel current = neighbours.pop();
                    if (current.x < 0 | current.x >= 400)
                        continue;
                    if (current.y < 0 | current.y >= 600)
                        continue;
                    if (canvas[current.x][current.y])
                        continue;
                    canvas[current.x][current.y] = true;
                    count++;
                    neighbours.push(new Pixel(current.x + 1, current.y));
                    neighbours.push(new Pixel(current.x - 1, current.y));
                    neighbours.push(new Pixel(current.x, current.y + 1));
                    neighbours.push(new Pixel(current.x, current.y - 1));
                }
                results.add(count);
            }
        }
        System.out.println(results);
    }
}
