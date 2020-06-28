package com.chen.base.topic;


public class FindErrorNums {

    public static int[] findErrorNums(int[] nums) {
        int miss = -1;
        int dup = -1;
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]);
            if (nums[index] < 0) {
                dup = Math.abs(nums[i]);
            } else {
                nums[index] = -nums[index];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                miss = i + 1;
            }
        }
        int[] result = new int[2];
        result[0] = miss;
        result[1] = dup;

        return result;
    }

    public static void main(String[] args) {
        int[] result = findErrorNums(new int[]{
                1, 2, 3, 4, 5, 5
        });

        for (int a : result
                ) {
            System.out.println(a);
        }

    }
}
