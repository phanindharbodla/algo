package com;

import java.util.Arrays;

public class Te {


    public static void main(String[] args) {
        Te te = new Te();
        System.out.println(te.sortSentence("is123 sentence4 This1 a3"));

    }

    public String sortSentence(String s) {

        String[] ss = s.split("\\s+");


        Obj[] out = new Obj[ss.length];
        for (int i = 0; i < ss.length; i++) {
            out[i] = convert(ss[i]);
        }

        Arrays.sort(out, (a, b) -> a.index - b.index);
        String res = "";
        for (Obj o : out) {
            res = res + " " + o.str;
        }

        return res;


    }

    Obj convert(String str) {
        Obj obj = new Obj();
        char[] chars = str.toCharArray();
        boolean found = false;
        String index = "";
        String string = "";

        for (int i = chars.length - 1; i >= 0; i--) {
            if (found == false) {
                if (chars[i] >= '0' && chars[i] <= '9') {
                    index = chars[i] + index;

                } else {
                    found = true;
                    string = chars[i] + "";
                }
            } else {
                string = chars[i] + string;
            }
        }
        obj.index = Integer.parseInt(index);
        obj.str = string;
        return obj;
    }

    class Obj {
        String str;
        int index;
    }
}

