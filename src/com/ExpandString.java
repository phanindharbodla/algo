package com;

import java.util.Stack;

public class ExpandString {
    public static void main(String[] args) {
        ExpandString expandString = new ExpandString();
        String out = expandString.run("3[a]");
        System.out.println(out);
    }

    private String run(String s) {

        char[] chars = s.toCharArray();
        int count = 0;
        int l = -1, r;
        char c;
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        String t;

        for (int i = 0; i < chars.length; i++) {
            c = chars[i];
            if (stack.isEmpty()) {
                if (c <= 'z' && c >= 'a')
                    result.append(c);
                else if (c <= '9' && c >= '0') {
                    count *= 10;
                    count += (c - '0');
                }
            }


            if (c == '[') {
                if (stack.isEmpty()) {
                    l = i + 1;
                }
                stack.push('[');
            } else if (c == ']') {
                stack.pop();
                if (stack.isEmpty()) {
                    r = i - 1;
                    t = run(s.substring(l, r + 1));
                    while (count != 0) {
                        result.append(t);
                        count--;
                    }
                }
            }
        }

        return result.length() == 0 ? s : result.toString();
    }
}
