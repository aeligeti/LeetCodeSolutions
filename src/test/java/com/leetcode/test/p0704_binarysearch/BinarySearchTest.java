package com.leetcode.test.p0704_binarysearch;


import static java.time.Duration.ofMillis;
import static java.util.stream.IntStream.range;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.leetcode.p0704_binarysearch.BinarySearch;
	
/*
 * Test class for BinarySearch.
 * 
 * LeetCode testcases can be added here to validate the BinarySearch implementation.
 * 
 */
class BinarySearchTest {
	
	// add test methods similar to the TwoSumTest class. GO!

	/* === register every implementation === */
	static Stream<Arguments> solvers() {
		return Stream.of(
			Arguments.of(new BinarySearch())
			// , Arguments.of(new BinarySearchOtherImplementation())
		);
	}

	/* ---------- basic sanity check ---------- */
	@ParameterizedTest(name = "{0} basic")
	@MethodSource("solvers")
	void basicCase(BinarySearch solver) {
		assertThat(solver.search(new int[]{-1, 0, 3, 5, 9, 12}, 9)).isEqualTo(4);
		assertThat(solver.search(new int[]{-1, 0, 3, 5, 9, 12}, 2)).isEqualTo(-1);
	}
	
	/* ---------- edge cases ---------- */
	@ParameterizedTest(name = "{0} edge cases")
	@MethodSource("solvers")
	void edgeCases(BinarySearch solver) {
		assertThat(solver.search(new int[]{}, 5)).isEqualTo(-1); // empty array
		assertThat(solver.search(new int[]{1}, 1)).isEqualTo(0); // single element match
		assertThat(solver.search(new int[]{1}, 2)).isEqualTo(-1); // single element no match
		assertThat(solver.search(new int[]{-5, -3, -1, 0, 2, 4}, -3)).isEqualTo(1); // negative numbers
		assertThat(solver.search(new int[]{-5, -3, -1, 0, 2, 4}, 5)).isEqualTo(-1); // target greater than max
	}

	
	/* ---------- large input + perf guard ---------- */
	@ParameterizedTest(name = "{0} large")
	@MethodSource("solvers")
	void stressCase(BinarySearch solver) {

		int n = 10_000;
		int[] nums = range(0, n).toArray();

		int idx = assertTimeoutPreemptively(
			ofMillis(50),
			() -> solver.search(nums, n - 1)
		);

		// generic validity checks
		assertThat(idx).isGreaterThanOrEqualTo(0).isLessThan(n);
		assertThat(nums[idx]).isEqualTo(n - 1);
	}
	
}