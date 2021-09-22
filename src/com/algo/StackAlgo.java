package com.algo;

import java.util.Arrays;
import java.util.Stack;

public class StackAlgo {

    public static void main(String[] args) {
        Integer[] a = {1, 3, 7, 5, 2};
        Stack<Integer> stack = new Stack<Integer>();
        stack.addAll(Arrays.asList(a));
        System.out.println(stack + "<-");
        reverseStack(stack);
        System.out.println(stack + "<-");
        sortStack(stack);
        System.out.println(stack + "<-");
    }

    private static void sortStack(Stack<Integer> stack) {
        if (stack.empty())
            return;
        int i = stack.pop();
        sortStack(stack);
        insertAtSortedPosition(stack, i);
    }

    private static void insertAtSortedPosition(Stack<Integer> stack, int i) {
        if (stack.empty()) {
            stack.push(i);
            return;
        }
        int top = stack.pop();
        if (i > top) {
            stack.push(top);
            stack.push(i);
        } else {
            insertAtSortedPosition(stack, i);
            stack.push(top);
        }
    }

    private static void reverseStack(Stack<Integer> stack) {
        if (stack.empty())
            return;
        int i = stack.pop();
        reverseStack(stack);
        insertAtBottom(stack, i);
        // System.out.println(stack + "<-" );
    }

    private static void insertAtBottom(Stack<Integer> stack, int i) {
        if (stack.empty()) {
            stack.push(i);
            return;
        }
        int top = stack.pop();
        insertAtBottom(stack, i);
        stack.push(top);
    }
}
