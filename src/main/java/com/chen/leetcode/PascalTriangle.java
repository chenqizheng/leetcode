package com.chen.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chen on 2017/4/18.
 */
public class PascalTriangle {
    /***
     * [
     * [1],             1
     * [1,1],           2
     * [1,2,1],         3
     * [1,3,3,1],       4
     * [1,4,6,4,1]      5
     * ]
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        if (numRows <= 1) {
            List<List<Integer>> temp = new ArrayList<List<Integer>>();
            if (numRows == 1) {
                ArrayList<Integer> row = new ArrayList<Integer>();
                row.add(1);
                temp.add(row);
            }
            return temp;
        }
        List<List<Integer>> list = generate(numRows - 1);
        List<Integer> current = new ArrayList<Integer>();
        current.add(1);
        List<Integer> last = list.get(list.size() - 1);
        for (int i = 0; i < last.size() - 1; i++) {
            current.add(last.get(i) + last.get(i + 1));
        }
        current.add(1);
        list.add(current);
        return list;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new PascalTriangle().generate(5);
        System.out.println(lists);
    }
}
