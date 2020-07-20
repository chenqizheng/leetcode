package com.chen.group.search.combination;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinationsOfPhoneNumber {
    private String[] phoneNumber = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        if (digits == null || "".equals(digits)) {
            return result;
        }
        backtracking("", digits);
        return result;
    }

    public void backtracking(String combination, String nextDigits) {
        if (nextDigits == null || "".equals(nextDigits)) {
            result.add(combination);
        } else {
            char digits = nextDigits.charAt(0);
            String letters = phoneNumber[digits - '2'];
            for (char letter : letters.toCharArray()) {
                backtracking(combination + letter, nextDigits.substring(1));
            }
        }
    }

    public static void main(String[] args) {
        List<String> result = new LetterCombinationsOfPhoneNumber().letterCombinations("23");
        for (String s : result) {
            System.out.println(s);
        }
    }
}
