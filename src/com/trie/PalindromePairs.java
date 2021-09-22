package com.trie;

import java.util.*;

public class PalindromePairs {

    public static void main(String[] args) {
        // Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the
        // concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
        String[] input = {"abcd", "dcba", "lls", "s", "sssll"};
        Trie trie = new Trie();
        for (int i = 0; i < input.length; i++) {
            trie.insert(input[i], i);
        }
        List<List<Integer>> output = new LinkedList<>();
        for (int i = 0; i < input.length; i++) {
            Trie.TrieNode node = trie.prefix(input[i]);
            HashSet<Integer> ids;
            if (node != null && (node.palindrome_ids.size() > 0)) {
                ids = (HashSet<Integer>) node.palindrome_ids.clone();
                ids.remove(i);
                if (!ids.isEmpty()) {
                    System.out.print(i + " : ");
                    System.out.println(ids);
                }
            }
        }
    }

    private static BitSet palindrome_indices(String string) {
        int constant = string.length();
        int modulus = 100000007;
        int left = 0, right = 0;
        BitSet bitSet = new BitSet(constant);
        for (int i = 0; i < constant; i++) {
            left += Math.pow(constant, i + 1) * (1 + string.charAt(i) - 'a');
            right = (right * constant) + constant * (1 + string.charAt(i) - 'a');
            left %= modulus;
            right %= modulus;
            if (left == right && is_palindrome(string, 0, i))
                bitSet.set(i);
        }
        return bitSet;
    }

    private static boolean is_palindrome(String string, int l, int r) {
        if (l == r)
            return true;
        while (l <= r)
            if (string.charAt(l) != string.charAt(r))
                return false;
            else {
                l++;
                r--;
            }
        return true;
    }

    static class Trie {
        TrieNode root = new TrieNode();

        public void insert(String word, int id) {
            BitSet is_palindrome = palindrome_indices(word);
            TrieNode temp = root;
            char c;
            int last = word.length() - 1;
            for (int i = last; i >= 0; i--) {
                c = word.charAt(i);
                if (temp.node.get(c) == null)
                    temp.node.put(c, new TrieNode());
                if (i > 0 && is_palindrome.get(i - 1))
                    temp.node.get(c).palindrome_ids.add(id);
                temp = temp.node.get(c);
            }
            temp.is_word = true;
            temp.palindrome_ids.add(id);
        }

        public boolean search(String word) {
            TrieNode node = prefix(word);
            return node == null ? false : node.is_word;

        }

        public boolean startsWith(String word) {
            return prefix(word) != null;
        }

        public TrieNode prefix(String word) {
            TrieNode temp = root;
            char[] chars = word.toCharArray();
            for (char c : chars) {
                if (temp.node.get(c) == null)
                    return null;
                temp = temp.node.get(c);
            }
            return temp;
        }

        class TrieNode {
            HashMap<Character, TrieNode> node;
            boolean is_word;
            HashSet<Integer> palindrome_ids;

            TrieNode() {
                node = new HashMap<>();
                is_word = false;
                palindrome_ids = new HashSet<>();
            }
        }
    }
}
