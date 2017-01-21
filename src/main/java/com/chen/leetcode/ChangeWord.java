package com.chen.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Chen on 2017/1/21.
 */
public class ChangeWord {
    public static void main(String[] args) {

        String[] arrays = new String[]{"stop", "post", "psto", "addb", "ddab", "abbc", "acb", "stta", "atts"};
        printChangeWord(arrays);
    }


    /***
     * 变形词:
     * 找出字符串中的变形词
     * 如post 和 stop 互相为变形词
     *
     * @param arrays
     */
    public static void printChangeWord(String[] arrays) {
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (String str : arrays) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortChar = new String(chars);
            if (map.containsKey(sortChar)) {
                map.get(sortChar).add(str);
            } else {
                ArrayList<String> arrayList = new ArrayList<String>();
                arrayList.add(str);
                map.put(sortChar, arrayList);
            }
        }
        for (List<String> list : map.values()) {
            System.out.println(list.toString());
        }

    }

}
