package com.chen.group.search.bfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode.com/problems/word-ladder/
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        ArrayList<String> queue = new ArrayList<String>();
        int step = 0;
        if (!wordList.contains(endWord)) {
            return 0;
        }
        queue.add(beginWord);
        int length = beginWord.length();

        while (queue.size() != 0) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String temp = queue.remove(0);
                for (int j = 0; j < length; j++) {
                    for (int ch = 'a'; ch <= 'z'; ch++) {
                        char[] chars = temp.toCharArray();
                        chars[j] = (char) ch;
                        String s = new String(chars);
                        if (s.equals(endWord)) {
                            return step + 1;
                        }
                        if (!wordList.contains(s)) {
                            continue;
                        }
                        String newWord = new String(chars);
                        wordList.remove(newWord);
                        queue.add(newWord);
                    }
                }

            }
        }
        return 0;
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        // ["hot","dot","dog","lot","log","cog"
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");

        System.out.println(new WordLadder().ladderLength("hit", "cog", list));
    }
}