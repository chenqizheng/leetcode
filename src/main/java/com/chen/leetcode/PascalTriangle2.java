package com.chen.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chen on 2017/5/3.
 */
public class PascalTriangle2 {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
        if (rowIndex < 1) {
            list.add(1);
            return list;
        }
        list.add(1);
        if (rowIndex > 1) {
            List<Integer> preList = getRow(rowIndex - 1);
            for (int i = 0; i <= rowIndex - 2; i++) {
                int temp = preList.get(i) + preList.get(i + 1);
                list.add(temp);
            }
        }
        list.add(1);
        return list;
    }


    public static void main(String[] args) {
        new PascalTriangle2().getRow(2);
    }
}
