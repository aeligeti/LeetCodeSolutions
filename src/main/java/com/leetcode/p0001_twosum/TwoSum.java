package com.leetcode.p0001_twosum;

/** Contract that every Two-Sum variant must follow. */
public interface TwoSum {
    int[] solve(int[] nums, int target);
    String name();          // for nice display in parameterized tests
}
