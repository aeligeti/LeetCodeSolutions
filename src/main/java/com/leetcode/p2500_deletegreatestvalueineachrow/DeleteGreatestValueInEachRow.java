package com.leetcode.p2500_deletegreatestvalueineachrow;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class DeleteGreatestValueInEachRow {
	
	public int deleteGreatestValue(int[][] grid) {
		/*
		 * initial idea is to create m priority queues for m rows, one each.
		 * poll from queues, compare m values and determine max
		 * add max to result; repeat polling and adding n times
		 * return result
		 * 
		 * Time Complexity: O(m*n*log n); m*n inserts take log n time each
		 * Space Complexity: O(m*n); as entire data is copied to Priority Queues
		 */
		
		int m = grid.length;
		int n = grid[0].length;
		
		int result = 0;
		List<PriorityQueue<Integer>> pqList = new ArrayList<>();
		
		for(int i=0; i<m; i++) {
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			for(int j=0; j<n; j++) {
				pq.offer(grid[i][j]);
			}
			pqList.add(pq);
		}
		for(int j=0; j<n; j++) {
			int max = Integer.MIN_VALUE;
			for(PriorityQueue<Integer> pq : pqList) {
				max = Math.max(max, pq.poll());
			}
			
			result += max;
		}
		
		
		return result;
    }
	
	public static void main(String[] args) {
		int[][]grid = new int[][]{{1}, {2}, {3}};
		System.out.println(new DeleteGreatestValueInEachRow().deleteGreatestValue(grid));
	}
}
