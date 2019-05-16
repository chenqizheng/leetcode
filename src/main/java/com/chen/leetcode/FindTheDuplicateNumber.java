package com.chen.leetcode;

public class FindTheDuplicateNumber {


    public int findDuplicate(int[] nums) {

        if (nums == null) return -1;
        int fast = 0;
        int slow = 0;
        do {
            fast = nums[nums[fast]];
            slow = nums[slow];
        } while (fast != slow);
        fast = 0;

        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return fast;
    }

    public static void main(String[] args) {
        int duplicate = new FindTheDuplicateNumber().findDuplicate(new int[]{3,1,3,4,2});
        System.out.println(duplicate);
    }
}
