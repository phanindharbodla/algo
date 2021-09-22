package com.trie;

import java.util.HashMap;


class Trie {
    TrieNode root = new TrieNode();

    public void insert(String word) {
        char[] chars = word.toCharArray();
        TrieNode temp = root;
        for (char c : chars) {
            if (temp.node.get(c) == null)
                temp.node.put(c, new TrieNode());
            temp = temp.node.get(c);
        }
        temp.is_word = true;
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

        TrieNode() {
            node = new HashMap<>();
            is_word = false;
        }
    }
}
