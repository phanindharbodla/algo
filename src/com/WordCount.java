package com;

public class WordCount {
    public static void main(String[] args) {
        WordCount wordCount = new WordCount();

        wordCount.add("");
        wordCount.solve("abaabbbc.");
    }

    private void solve(String abaabbbca) {
        char[] chars = abaabbbca.toCharArray();
        char c = '.';
        int count = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == c)
                count++;
            else {
                if (count > 1) {
                    stringBuilder.append(c);
                    stringBuilder.append(count);
                    //System.out.print(c+""+count);
                } else if (c != '.')
                    stringBuilder.append(c);
                //System.out.print(c);
                count = 1;
            }

            c = chars[i];
        }
        System.out.println(stringBuilder.toString());
    }


    private void add(String s) {
    }
}
