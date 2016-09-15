package com.kozyrev;

import java.util.*;

/**
 * Created by sergii on 9/15/16.
 */
public class SearchSuggestions {


    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("foobar");
        trie.insert("foobar");
        trie.insert("foobar");
        trie.insert("football");
        trie.insert("footzal");
        trie.insert("footzal");
        trie.insert("camera");
        trie.insert("feetwork");
        trie.insert("workout");
        trie.insert("gambling");
        trie.insert("sergii");
        trie.insert("natali");

        System.out.println("traverse all data:");
        for (Term t : trie.traverse()) {
            System.out.println(t.text + t.counter);
        }
        String word = "fo";
        System.out.println("show search suggestions for " + word);
        for (String s : trie.searchAutoSuggestion(word)) {
            System.out.println(s);
        }
    }

    public static class Term implements Comparable<Term> {
        int counter;
        String text;

        public Term(int counter, String text) {
            this.counter = counter;
            this.text = text;
        }

        @Override
        public int compareTo(Term another) {
            return another.counter - counter;
        }
    }

    public static class Trie {
        int value;
        String text;
        Map<Character, Trie> children = new HashMap<Character, Trie>();

        public Trie searchNode(String s) {
            Trie node = this;
            for (Character c : s.toCharArray()) {
                if (node.children.get(c) != null) {
                    node = node.children.get(c);
                } else {
                    return null;
                }
            }
            return node;
        }

        public List<String> searchAutoSuggestion(String s) {
            List<String> result = new ArrayList<String>();
            Trie containTrie = searchNode(s);
            if (containTrie != null) {
                for (Term term : containTrie.traverse()) {
                    result.add(term.text);
                }
            }
            return result;
        }

        public List<Term> traverse() {
            List<Term> results = new ArrayList<Term>();

            Stack<Trie> stack = new Stack<Trie>();
            stack.push(this);
            while (!stack.isEmpty()) {
                Trie node = stack.pop();
                if (node.text != null) {
                    results.add(new Term(node.value, node.text));
                }
                for (Trie t : node.children.values()) {
                    stack.push(t);
                }
            }
            Collections.sort(results);
            return results;
        }

        public void insert(String s) {
            int i = 0;
            int length = s.length() - 1;
            Trie node = this;
            while (i < length) {

                if (node.children.get(s.charAt(i)) != null) {
                    node = node.children.get(s.charAt(i));
                } else {
                    break;
                }
                i++;
            }

            while (i < length) {

                Trie newNode = new Trie();
                node.children.put(s.charAt(i), newNode);
                node = newNode;
                i++;
            }

            node.value++;
            node.text = s;

        }
    }
}
