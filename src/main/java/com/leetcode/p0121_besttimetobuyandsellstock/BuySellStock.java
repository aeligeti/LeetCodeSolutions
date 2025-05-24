package com.leetcode.p0121_besttimetobuyandsellstock;

public class BuySellStock {
	
	public int maxProfit(int[] prices) {
		
		int n = prices.length;
		int maxProfit = Integer.MIN_VALUE;
		int minPrice = Integer.MAX_VALUE;
		
		for(int i=0; i<n; i++) {
			minPrice = Math.min(minPrice, prices[i]);
			maxProfit = Math.max(maxProfit, prices[i]-minPrice);
		}
		
		return maxProfit<0 ? 0 : maxProfit;
	}
}
