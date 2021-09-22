package com;

public class PatternMatching {
    public static void main(String args[]) {
        String a = new String("abcdcdccd");
        String b = new String("cd");


        String sen = "srilok is from      cbit";


        String[] strings = sen.split("\\s+");

        printIndices(b + '$' + a, b);
        buildZArray("aaa" + '$' + "aaaaaabb");
    }

    private static int[] buildZArray(String s) {
        char[] id = s.toCharArray(); // aaa$aaaaaabb


        // l -> refers to left index of current match
        // r -> refers to index of next unmatched char in pattern
        // i -> refers to current char where we start comparision
        int l = 0, r = 0, i = 0;
        int[] z = new int[s.length()];
        // z[i] = k -> indicates that we have k length-ed prefix match starting at i
        //z[0]= s.length();


        for (i = 1; i < id.length; i++) {
            if (r > i) {
                z[i] = Math.min(z[i - l], r - i); // we track l to
            }
            while (i + z[i] < id.length && id[z[i]] == id[i + z[i]]) // shop[z[i]].equals(shop[z[i]+i])
                z[i]++;
            if (r < i + z[i]) {
                r = i + z[i];
                l = i;
            }
        }
        return z;


    }

    private static void printIndices(String a, String b) {
        int i = 0;
        while (i < a.length()) {
            int j = 0;
            if (a.charAt(i) != b.charAt(j)) {
                i++;
                continue;
            }
            while (i < a.length() && j < b.length() && a.charAt(i) == b.charAt(j)) {
                i++;
                j++;
            }
            if (j == b.length() && i - j - (b.length() + 1) >= 0) {
                System.out.println(i - j - (b.length() + 1));
            }
        }
    }
}
