package com.leetcode.p0009_palindromenumber;

public class PalindromeNumber {
	
	public boolean isPalindrome(int x) {
		if(x<0) return false;
		
		char[] nums = String.valueOf(x).toCharArray();
		
		int left = 0;
		int right = nums.length-1;
		
		while(left<=right) {
			if(nums[left]!=nums[right]) {
				return false;
			}
			
			left++;
			right--;
		}
		
		return true;
	}
}
