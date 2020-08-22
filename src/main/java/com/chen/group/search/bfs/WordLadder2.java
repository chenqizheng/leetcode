package com.chen.group.search.bfs;

import java.util.ArrayList;
import java.util.List;

public class WordLadder2 {
    public static void main(String[] args) {

    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int step = 0;
        if (!wordList.contains(endWord)) {
            return step;
        }
        List<String> q1 = new ArrayList<String>();
        List<String> q2 = new ArrayList<String>();
        q1.add(beginWord);
        q2.add(endWord);

        int length = beginWord.length();
        while (q1.size() > 0 && q2.size() > 0) {
            step++;
            if (q1.size() > q2.size()) {
                List<String> temp = q1;
                q1 = q2;
                q2 = temp;
            }
            List<String> tempQ = new ArrayList<String>();
            for (String word : q1) {
                for (int i = 0; i < length; i++) {
                    for (int j = 'a'; j <= 'z'; j++) {
                        char[] chars = word.toCharArray();
                        chars[i] = (char) j;
                        String s = new String(chars);
                        if (q2.contains(s)) {
                            return step + 1;
                        }
                        if (!wordList.contains(s)) {
                            continue;
                        }
                        wordList.remove(s);
                        tempQ.add(s);
                    }
                }
            }
            q1 = tempQ;
        }

        return 0;
    }
}