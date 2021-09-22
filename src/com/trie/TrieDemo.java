package com.trie;

class TrieDemo {
    public static void main(String[] args) {
        // Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the
        // concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
        String[] input = {"abcd", "dcba", "lls", "s", "sssll"};
        Trie dict = new Trie();
        for (String str : input) {
            dict.insert(str);
        }

        for (String str : input) {
            System.out.println(dict.search(str));
        }

        for (String str : input) {
            System.out.println(dict.startsWith(str));
        }


    }
}
