package com.chen.offer;

/**
 * 将字符创的空格替换为%20
 */
public class RepaceBlack {
    public String solution(String str) {

        if (str == null) {
            return null;
        }


        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                count++;
            }
        }

        char[] result = new char[str.length() + 2 * count];

        int i = str.length() - 1;
        int j = result.length - 1;
        while (i >= 0) {
            if (str.charAt(i) == ' ') {
                result[j--] = '0';
                result[j--] = '2';
                result[j--] = '%';
            } else {
                result[j--] = str.charAt(i);
            }
            i--;
        }


        return new String(result);
    }

    public static void main(String[] args) {
        System.out.println(new RepaceBlack().solution("Hello World "));
    }
}
