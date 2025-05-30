package com.leetcode.test.p0853_carfleet;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.leetcode.p0853_carfleet.CarFleet;

/*
 * Test class for LeetCode problem 853: Car Fleet.
 */
class CarFleetTest {
	
	// === register every implementation ===
	static Stream<Arguments> solvers() {
		return Stream.of(
			Arguments.of(new CarFleet())
		);
	}
	/* ---------- basic sanity check ---------- */
	@ParameterizedTest(name = "{0} basic")
	@MethodSource("solvers")
	void basicCase(CarFleet solver) {
		int target = 12;
		int[] position = {10, 8, 0, 5, 3};
		int[] speed = {2, 4, 1, 1, 3};
		
		assertThat(solver.solve(target, position, speed)).isEqualTo(3); // Expected output: 3
	}
	/* ---------- edge cases ---------- */
	@ParameterizedTest(name = "{0} edge cases")
	@MethodSource("solvers")
	void edgeCases(CarFleet solver) {

		int target;
		int[] position;
		int[] speed;
		
		// Test case with one car
		target = 10;
		position = new int[]{5};
		speed = new int[]{2};
		
		assertThat(solver.solve(target, position, speed)).isEqualTo(1); // Expected output: 1
		
		// Test case with two cars that will form a fleet
		target = 10;
		position = new int[]{5, 3};
		speed = new int[]{2, 1};
		
		assertThat(solver.solve(target, position, speed)).isEqualTo(2); // Expected output: 2
	}
}
