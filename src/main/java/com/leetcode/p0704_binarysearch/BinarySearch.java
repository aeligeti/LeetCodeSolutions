package com.leetcode.p0704_binarysearch;


/*
 * LeetCode 704. Binary Search
 * https://leetcode.com/problems/binary-search/
 * Binary search algorithm to find the index of a target value in a sorted array.
 * 
 */
public class BinarySearch {
	
		public int search(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		
		while (left <= right) {
			int mid = left + (right - left) / 2; // Avoid potential overflow
			
			if (nums[mid] == target) {
				return mid; // Target found
			} else if (nums[mid] < target) {
				left = mid + 1; // Search in the right half
			} else {
				right = mid - 1; // Search in the left half
			}
		}
		
		return -1; // Target not found
	}
}
