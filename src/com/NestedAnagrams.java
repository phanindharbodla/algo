package com;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NestedAnagrams {
    public static void main(String[] args) {
        String a = "chiti yes", b = "sey tichi";

        System.out.println(isAnagram(a, b));
        System.out.println(isAnagram2(a, b));
        System.out.println(isNestedAnagram(a, b));
//        System.out.println(convert("chitti12"));
    }

//
//    public static String  convert(String str) {
//
//
//        return string;
//
//
//    }

    private static boolean isAnagram2(String a, String b) {

        char[] A = a.toCharArray();
        char[] B = b.toCharArray();

        Arrays.sort(A);
        Arrays.sort(B);

        return String.valueOf(A).equals(String.valueOf(B));
    }

    private static boolean isAnagram(String a, String b) {
        Map<Character, Integer> charCountA = getFreq(a);
        Map<Character, Integer> charCountB = getFreq(b);
        return charCountA.equals(charCountB);
    }

    private static Map<Character, Integer> getFreq(String a) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character ch : a.toCharArray()) {
            if (map.containsKey(ch)) {
                int newCount = (map.get(ch) + 1);
                map.put(ch, newCount);
            } else {
                map.put(ch, 1);
            }
        }
        return map;
    }

    private static boolean isNestedAnagram(String a, String b) {
        String[] aa = a.split("\\s");
        String[] bb = b.split("\\s");

        if (aa.length != bb.length)
            return false;

        for (int i = 0; i < aa.length; i++) {
            aa[i] = firstAnagram(aa[i]);
            bb[i] = firstAnagram(bb[i]);
        }
        Map<String, Integer> mapa = getFreq(aa);
        Map<String, Integer> mapb = getFreq(bb);


        return mapa.equals(mapb);
    }


    private static Map<String, Integer> getFreq(String[] strings) {
        Map<String, Integer> map = new HashMap<>();
        for (String ch : strings) {
            if (map.containsKey(ch)) {
                int newCount = (map.get(ch) + 1);
                map.put(ch, newCount);
            } else {
                map.put(ch, 1);
            }
        }
        return map;
    }


    private static String firstAnagram(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }
}
