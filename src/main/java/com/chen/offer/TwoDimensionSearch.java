package com.chen.offer;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序
 * 每一列都按照从上到下的递增顺序排序，请完成一个函数，
 * 输入这样的二维数组和一个整数，判断数组中是否含有该整数。
 */
public class TwoDimensionSearch {

    public boolean solution(int[][] array, int target) {
        if (array == null) {
            return false;
        }
        int x = 0;
        int y = array[0].length - 1;
        for (int i = 0; i < array[0].length * array.length; i++) {
            if (x >= array[0].length || y <0) {
                return false;
            }
            if (array[x][y] > target) {
                y--;
            } else if (array[x][y] < target) {
                x++;
            } else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        boolean find = new TwoDimensionSearch().solution(array, 5);
        System.out.println("find = " + find);
    }
}
