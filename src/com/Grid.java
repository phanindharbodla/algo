package com;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;

public class Grid {


    public static void main(String[] args) {
        System.out.println(solve(new String[]{"...", "X..", "..."}));
        //System.out.println(solve2(new String[]{"."}));
    }

//    private static int solve2(String[] strings) {
//        boolean [][] grid = transform(strings);
//        int r = grid.length;
//        int c = grid[0].length;
//        HashMap<Integer,HashSet<Character>> stepMap = new HashMap<>();
//        HashSet<Character> t= new HashSet<>();
//        HashSet<Character> e= new HashSet<>();
//        t.add('r');
//        stepMap.put(0,t);
//        int i=0,j=0;
//        while (stepMap.getOrDefault(id(i,j,grid), e.contains('r') )
//
//        return stepMap.size();
//    }

    public static int id(int i, int j, boolean[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        return (i * c) + j;
    }

    private static int solve(String[] R) {
        boolean[][] grid = transform(R);
        int r = grid.length;
        int c = grid[0].length;
        HashSet<Step> steps = new HashSet<>();
        Step next = null, start = new Step(0, 0, 'r');
        Step current;
        while (!steps.contains(next)) {
            if (steps.isEmpty())
                current = start;
            else
                current = next;
            steps.add(current);
            next = current.nextStep(grid);
        }
        LinkedHashSet<Integer> covered = new LinkedHashSet<>();

        for (Step step : steps) {
            covered.add((step.x * c) + step.y);
        }

        return covered.size();
    }

    private static boolean[][] transform(String[] r) {

        boolean[][] grid = new boolean[r.length][r[0].length()];
        for (int i = 0; i < r.length; i++) {
            for (int j = 0; j < r[i].length(); j++) {
                if (r[i].charAt(j) == '.') grid[i][j] = true;
            }
        }
        return grid;
    }

}

class Step {
    int x, y;
    char z;

    public Step(int x, int y, char z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Step step = (Step) o;
        return x == step.x && y == step.y && z == step.z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    char dir(char c) {
        switch (c) {
            case 'r':
                return 'd';
            case 'd':
                return 'l';
            case 'l':
                return 'u';
            case 'u':
            default:
                return 'r';
        }
    }

    boolean canMoveTo(int a, int b, boolean[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        return a > -1 && a < r && b > -1 && b < c && grid[a][b];
    }

    public Step nextStep(boolean[][] grid) {
        int i = x, j = y;

        switch (z) {
            case 'r':
                j++;
                break;
            case 'd':
                i++;
                break;
            case 'l':
                j--;
                break;
            case 'u':
            default:
                i--;
        }

        if (canMoveTo(i, j, grid))
            return new Step(i, j, z);

        return new Step(x, y, dir(z));
    }
}