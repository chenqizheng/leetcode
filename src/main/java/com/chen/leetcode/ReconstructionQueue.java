package com.chen.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * href: https://leetcode.com/problems/queue-reconstruction-by-height/#/description
 * Created by Chen on 2017/4/18.
 */
public class ReconstructionQueue {
    /**
     * 效率太慢
     *
     * @param people
     * @return
     */
    @Deprecated
    public int[][] reconstructQueue1(int[][] people) {
        for (int i = 0; i < people.length; i++) {
            int[] temp = people[i];
            int count = count(people, i, temp);
            if (count > temp[1]) {
                int sub = count - temp[1];
                int index = i - 1;
                while (sub > 0) {
                    if (people[index][0] >= temp[0]) {
                        sub--;
                    }
                    people[index + 1] = people[index];
                    people[index] = temp;
                    index--;
                }
                i = index;
            } else if (count < temp[1]) {
                int sub = temp[1] - count;
                int index = i;
                while (sub > 0) {
                    if (people[index + 1][0] >= temp[0]) {
                        sub--;
                    }
                    people[index] = people[index + 1];
                    people[index + 1] = temp;
                    index++;
                }
                i = i - 1;
            }
        }
        return people;
    }

    public int count(int[][] people, int index, int[] target) {
        int count = 0;
        while (--index >= 0) {
            if (people[index][0] >= target[0]) {
                count++;
            }
        }
        return count;
    }

    /**
     * 先排序,再对排序
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (b[0] == a[0]) return a[1] - b[1];
                return b[0] - a[0];
            }
        });


        int n = people.length;
        ArrayList<int[]> tmp = new ArrayList<int[]>();
        for (int i = 0; i < n; i++)
            tmp.add(people[i][1], new int[]{people[i][0], people[i][1]});

        int[][] res = new int[people.length][2];
        int i = 0;
        for (int[] k : tmp) {
            res[i][0] = k[0];
            res[i++][1] = k[1];
        }

        return res;
    }

    public static void main(String[] args) {

        int[][] temp = new ReconstructionQueue().reconstructQueue(new int[][]{{9, 0}, {7, 0}, {1, 9}, {3, 0}, {2, 7}, {5, 3}, {6, 0}, {3, 4}, {6, 2}, {5, 2}});
        for (int[] array : temp) {
            System.out.println(array[0] + "," + array[1]);
        }
    }

}
