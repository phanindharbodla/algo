package com.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class temp {
    public static void main(String[] args) {
/*        int a[] = new int[9];
        Random rand = new Random();
        int result = 0, max = 0;
        System.out.println();
        for (int i = 0; i < 9; i++) {
            a[i] = rand.nextInt(50);
            System.out.print(a[i] + " ");
        }
        System.out.println();
        int N = 9;
        for (int i = N - 1; i >= 0; --i) {
            if (a[i] > max)
                max = a[i];
            int tmpResult = max - a[i];
            if (tmpResult > result)
                result = tmpResult;
        }
        System.out.println(result + " " + max);*/
        //int input[] = {1456, 345671, 43218, 123};
        //String output = solve(input);
        //System.out.print(output);
        int out = findnum("NMMN");
        System.out.println(out);
        System.out.println(findmin("NMMN"));

    }

    private static int findmin(String string) {
        char[] input = string.toCharArray();
        int min = 0;
        Stack<Integer> stack = new Stack<>();
        /*for (int i = 0; i <= input.length; i++) {
            stack.add(i + 1);
            if (input.length == i || input[i] == 'N') {
                while (!stack.isEmpty()) {
                    min = (min * 10) + stack.peek();
                    stack.pop();
                }
            }
        }*/
        int lastNindex = 0;
        List list = new ArrayList();
        list.add(1);
        stack.add(1);
        for (int i = 0; i < input.length; i++) {
            if (input[i] == 'N') {
                lastNindex = i + 1;
                list.add((i + 2));
                while (!stack.isEmpty()) {
                    min = (min * 10) + stack.peek();
                    stack.pop();
                }
            } else if (input[i] == 'M') {
                list.add(lastNindex, (i + 2));
            }
            stack.add(i + 2);
        }
        while (!stack.isEmpty()) {
            min = (min * 10) + stack.peek();
            stack.pop();
        }
        System.out.println(list);

        return min;
    }

    private static int findnum(String pattern) {
        if (pattern == null || pattern.isEmpty()) return -1;
        char[] seq = pattern.toCharArray();
        int result = 0;

        // create an empty stack of integers
        Stack<Integer> stk = new Stack<>();

        // run n+1 times where n is length of input sequence
        for (int i = 0; i <= seq.length; i++) {
            // push number i+1 into the stack
            stk.add(i + 1);

            // if all characters of the input sequence are
            // processed or current character is 'I'
            // (increasing)
            if (i == seq.length || seq[i] == 'N') {
                // run till stack is empty
                while (!stk.empty()) {
                    // remove top element from the stack and
                    // add it to solution
                    result *= 10;
                    result += stk.peek();
                    //result += " ";
                    stk.pop();
                }
            }
        }
        return result;
    }

    private static String solve(int[] input) {
        String temp;
        ArrayList<Integer> out = new ArrayList<Integer>();
        for (int i : input) {
            temp = Integer.toString(i);
            if (temp.contains("1") && temp.contains("2") && temp.contains("3"))
                out.add(i);
        }
        Collections.sort(out);
        temp = out.toString().replace("[", "").replace("]", "").replaceAll(" ", "");
        if (temp.isEmpty())
            return "-1";
        else return temp;
    }


}
