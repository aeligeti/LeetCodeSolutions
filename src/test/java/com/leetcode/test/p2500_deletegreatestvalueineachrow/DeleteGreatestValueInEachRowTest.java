package com.leetcode.test.p2500_deletegreatestvalueineachrow;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.leetcode.p2500_deletegreatestvalueineachrow.DeleteGreatestValueInEachRow;

	
/*
 * Test class for DeleteGreatestValueInEachRow.
 * 
 * LeetCode testcases can be added here to validate the DeleteGreatestValueInEachRow implementation.
 * 
 */
class DeleteGreatestValueInEachRowTest {
	
	/* === register every implementation === */
	static Stream<Arguments> solvers() {
		return Stream.of(
			Arguments.of(new DeleteGreatestValueInEachRow())
			// , Arguments.of(new DeleteGreatestValueInEachRowOtherImplementation())
		);
	}

	/* ---------- basic sanity check ---------- */
	@ParameterizedTest(name = "{0} basic")
	@MethodSource("solvers")
	void basicCase(DeleteGreatestValueInEachRow solver) {
		assertThat(solver.deleteGreatestValue(new int[][]{{1, 2, 4}, {3, 3, 1}})).isEqualTo(8);
		assertThat(solver.deleteGreatestValue(new int[][]{{10}})).isEqualTo(10);
	}

	/* ---------- edge cases ---------- */
	@ParameterizedTest(name = "{0} edge cases")
	@MethodSource("solvers")
	void edgeCases(DeleteGreatestValueInEachRow solver) {
		assertThat(solver.deleteGreatestValue(new int[][]{{}})).isEqualTo(0); // empty grid
		assertThat(solver.deleteGreatestValue(new int[][]{{1}, {2}, {3}})).isEqualTo(3); // single column
		assertThat(solver.deleteGreatestValue(new int[][]{{1, 2}, {3, 4}})).isEqualTo(7); // small grid
	}
	
		
	
}