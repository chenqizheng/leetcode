package com.chen.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hashMap = getCountHashMap(nums);
        Map.Entry<Integer, Integer> max = null;
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (max == null || max.getValue() < entry.getValue()) {
                max = entry;
            }
        }

        return max.getKey();
    }

    private static HashMap<Integer, Integer> getCountHashMap(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int num : nums) {
            Integer count = hashMap.get(num);
            if (count == null) {
                hashMap.put(num, 0);
            } else {
                hashMap.put(num, count + 1);
            }
        }
        return hashMap;
    }

}
