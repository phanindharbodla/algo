package com;

import java.util.LinkedHashMap;
import java.util.Map;

public class IntToRoman {
    public static void main(String[] args) {
        int num = 45;
        Map<Integer, String> mappings = new LinkedHashMap<>();
        mappings.put(1000, "M");
        mappings.put(900, "CM");
        mappings.put(500, "D");
        mappings.put(400, "CD");
        mappings.put(100, "C");
        mappings.put(90, "XC");
        mappings.put(50, "L");
        mappings.put(40, "XL");
        mappings.put(10, "X");
        mappings.put(9, "IX");
        mappings.put(5, "V");
        mappings.put(4, "IV");
        mappings.put(1, "I");
        StringBuilder s = new StringBuilder();
        for (int leftNum : mappings.keySet()) {
            while (num >= leftNum) {
                num -= leftNum;
                s.append(mappings.get(leftNum));
            }
        }
        System.out.println(s);
        romanToInt("X");
    }

    public static void romanToInt(String s) {
        Map<Character, Integer> mappings = new LinkedHashMap<>();
        mappings.put('M', 1000);
        //mappings.put('CM', 900);
        mappings.put('D', 500);
        //mappings.put('CD', 400);
        mappings.put('C', 100);
        //mappings.put('XC', 90);
        mappings.put('L', 50);
        //mappings.put('XL', 40);
        mappings.put('X', 10);
        //mappings.put('IX', 9);
        mappings.put('V', 5);
        //mappings.put('IV', 4);
        mappings.put('I', 1);
        int result = 0;
        int prev = 0;
        for (int i = 0; i < s.length(); i++) {
            System.out.println(s.charAt(i));
            int cur = mappings.get(s.charAt(i));
            if (prev < cur) {
                result = result - prev;
            }
            result = result + cur;
            prev = cur;
        }
        System.out.println(result);
    }
}
