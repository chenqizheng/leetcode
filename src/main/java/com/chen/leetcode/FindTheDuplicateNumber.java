package com.chen.leetcode;

/***
 * https://leetcode.com/problems/find-the-duplicate-number/
 */
public class FindTheDuplicateNumber {

    public int findDuplicate(int[] nums) {

        int fast = nums[0];
        int slow = nums[0];

        do {
            fast = nums[nums[fast]];
            slow = nums[slow];
        } while (fast != slow);

        fast = nums[0];
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }

    public static void main(String[] args) {
        new FindTheDuplicateNumber().findDuplicate(new int[]{1, 3, 4, 2, 2});
    }
}
