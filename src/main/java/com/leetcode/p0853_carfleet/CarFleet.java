package com.leetcode.p0853_carfleet;

import java.util.Arrays;

/*
 * LeetCode problem 853: Car Fleet.
 */
public class CarFleet implements ICarFleet{
	
	@Override
	public int solve(int target, int[] position, int[] speed) {
		
		int n = position.length;
		
		Integer[] indices = new Integer[n];
		
		int countFleet=0;
	
		for (int i = 0; i < n; i++) {
			indices[i] = i;
		}

		Arrays.sort(indices, (a, b) -> position[b] - position[a]); // descending
		
		double prevTime = 0.0;
		for(int pos: indices) {
			double time = ((double)(target - position[pos]))/speed[pos];
			
			if(time > prevTime) {
				countFleet++;
				prevTime=time;
			} 
		}
		
		
		return countFleet;
	}

	@Override
	public String name() {
		return "CarFleet";
	}

	public static void main(String[] args) {
		CarFleet carFleet = new CarFleet();
		int target = 12;
		int[] position = {10, 8, 0, 5, 3};
		int[] speed = {2, 4, 1, 1, 3};
		
		int result = carFleet.solve(target, position, speed);
		System.out.println("Number of car fleets: " + result); // Expected output: 3
	}


}
