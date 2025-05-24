package com.leetcode.test.p0009_palindromenumber;

import static java.time.Duration.ofMillis;
import static java.util.stream.IntStream.range;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.leetcode.p0009_palindromenumber.PalindromeNumber;


/**
 * Test class for PalindromeNumber.
 * 
 * LeetCode testcases can be added here to validate the PalindromeNumber implementation.
 * 
 */
class PalindromeNumberTest {

	/* === register every implementation === */
	static Stream<Arguments> solvers() {
		return Stream.of(
			Arguments.of(new PalindromeNumber())
			// , Arguments.of(new PalindromeNumberOtherImplementation())
		);
	}

	/* ---------- basic sanity check ---------- */
	@ParameterizedTest(name = "{0} basic")
	@MethodSource("solvers")
	void basicCase(PalindromeNumber solver) {
		assertThat(solver.isPalindrome(121)).isTrue();
		assertThat(solver.isPalindrome(-121)).isFalse();
		assertThat(solver.isPalindrome(10)).isFalse();
	}

	/* ---------- edge cases ---------- */
	@ParameterizedTest(name = "{0} edge cases")
	@MethodSource("solvers")
	void edgeCases(PalindromeNumber solver) {
		assertThat(solver.isPalindrome(0)).isTrue(); // single digit
		assertThat(solver.isPalindrome(1)).isTrue(); // single digit
		assertThat(solver.isPalindrome(11)).isTrue(); // two digits, same
		assertThat(solver.isPalindrome(22)).isTrue(); // two digits, same
		assertThat(solver.isPalindrome(12)).isFalse(); // two digits, different
		assertThat(solver.isPalindrome(1221)).isTrue(); // four digits, is a palindrome
		assertThat(solver.isPalindrome(1234)).isFalse(); // four digits, not a palindrome
	}

	/* ---------- large input + perf guard ---------- */
	@ParameterizedTest(name = "{0} large")
	@MethodSource("solvers")
	void stressCase(PalindromeNumber solver) {

		int n = 10_000;
		int[] nums = range(0, n).toArray();

		boolean isPalindrome = assertTimeoutPreemptively(
			ofMillis(50),
			() -> solver.isPalindrome(Integer.parseInt(String.valueOf(nums[0]) + new StringBuilder(String.valueOf(nums[0])).reverse().toString()))
		);

		assertThat(isPalindrome).isTrue();
	}

}