package com.leetcode.p0001_twosum;

import java.util.HashMap;
import java.util.Map;

// Time: O(n), Space: O(n)
// Uses a hash map to store complements and find the target sum in one pass.
public class TwoSumHashMap implements TwoSum {
   

	@Override
	public int[] solve(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
	}

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return null;
	}
}