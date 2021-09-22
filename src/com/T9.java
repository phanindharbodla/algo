package com;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class T9 {
    private static Map<Integer, Character[]> keyMappings = new HashMap<>();

    static {
        keyMappings.put(2, new Character[]{'a', 'b', 'c'});
        keyMappings.put(3, new Character[]{'d', 'e', 'f'});
        keyMappings.put(4, new Character[]{'g', 'h', 'i'});
        keyMappings.put(5, new Character[]{'j', 'k', 'l'});
        keyMappings.put(6, new Character[]{'m', 'n', 'o'});
        keyMappings.put(7, new Character[]{'p', 'q', 'r', 's'});
        keyMappings.put(8, new Character[]{'t', 'u', 'v'});
        keyMappings.put(9, new Character[]{'w', 'x', 'y', 'z'});
    }


    public static void main(String[] args) {
        T9 t9 = new T9();
        int input = 239;
        t9.run(input);
    }

    private void run(int input) {
        Stack<Integer> stack = new Stack<>();
        while (input != 0) {
            stack.push(input % 10);
            input = input / 10;
        }
        printAllRec("", stack);

    }

    private void printAllRec(String prefix, Stack<Integer> stack) {
        if (stack.isEmpty()) {
            System.out.println(prefix);
            return;
        }

        int curInt = stack.pop();
        Character[] chars = keyMappings.get(curInt);
        for (int i = 0; i < chars.length; i++) {
            printAllRec(prefix + chars[i], stack);
        }
        stack.push(curInt);
    }
}
