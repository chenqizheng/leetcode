package com.chen.leetcode;

import java.util.HashSet;
import java.util.Iterator;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<Integer>();
        HashSet<Integer> result = new HashSet<Integer>();
        for (int i : nums1) {
            set.add(i);
        }

        for (int j : nums2) {
            if (set.contains(j)) {
                result.add(j);
            }
        }
        int[] ans = new int[result.size()];
        Iterator<Integer> iterator = result.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            int temp = iterator.next();
            ans[i] = temp;
            i++;
        }
        return ans;
    }
}
