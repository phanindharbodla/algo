package com.algo;

public class Braces {

    public static void main(String[] args) {
        String previous = "";
        String input = "{(}()()[]())";
        while (input.length() != previous.length()) {
            previous = input;
            input = input
                    .replace("()", "")
                    .replace("[]", "")
                    .replace("{}", "");
        }
        System.out.println(input.length() == 0 ? "YES" : "NO");
    }

}
