package com.leetcode.test.p0121_besttimetobuyandsellstock;

import static java.time.Duration.ofMillis;
import static java.util.stream.IntStream.range;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.leetcode.p0121_besttimetobuyandsellstock.BuySellStock;

/**
 * Test class for BuySellStock.
 * 
 * LeetCode testcases can be added here to validate the BuySellStock implementation.
 * 
 */

class BuySellStockTest {

	/* === register every implementation === */
	static Stream<Arguments> solvers() {
		return Stream.of(
			Arguments.of(new BuySellStock())
			// , Arguments.of(new BuySellStockOtherImplementation())
		);
	}

	/* ---------- basic sanity check ---------- */
	@ParameterizedTest(name = "{0} basic")
	@MethodSource("solvers")
	void basicCase(BuySellStock solver) {
		assertThat(solver.maxProfit(new int[]{7, 1, 5, 3, 6, 4})).isEqualTo(5);
		assertThat(solver.maxProfit(new int[]{7, 6, 4, 3, 1})).isEqualTo(0);
	}

	/* ---------- large input + perf guard ---------- */
	@ParameterizedTest(name = "{0} large")
	@MethodSource("solvers")
	void stressCase(BuySellStock solver) {

		int n = 10_000;
		int[] prices = range(1, n + 1).toArray(); // increasing prices

		int maxProfit = assertTimeoutPreemptively(
			ofMillis(50),
			() -> solver.maxProfit(prices)
		);

		assertThat(maxProfit).isEqualTo(n - 1); // max profit is n-1 for increasing prices
	}
}
