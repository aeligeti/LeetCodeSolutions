package com.leetcode.test.p0014_longestcommonprefix;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.MethodSource;

import com.leetcode.p0014_longestcommonprefix.ILongestCommonPrefix;
import com.leetcode.p0014_longestcommonprefix.LongestCommonPrefixBruteForce;


/*
 * Test class for LeetCode 14. LongestCommonPrefix
 */
class LongestCommonPrefixTest {
	/* === register every implementation === */
	static ILongestCommonPrefix[] solvers() {
		return new ILongestCommonPrefix[] {
			new LongestCommonPrefixBruteForce()
		};
	}
	
	/* ---------- test cases  ---------- */
	@Test
	@MethodSource("solvers")
	void testBasicCases() {
		for (ILongestCommonPrefix solver : solvers()) {
			Assertions.assertEquals("fl", solver.solve(new String[]{"flower","flow","flight"}));
			Assertions.assertEquals("", solver.solve(new String[]{"dog","racecar","car"}));
			Assertions.assertEquals("a", solver.solve(new String[]{"a"}));
			Assertions.assertEquals("", solver.solve(new String[]{"", "b", "c"}));
			Assertions.assertEquals("a", solver.solve(new String[]{"abc", "ab", "a"}));
			Assertions.assertEquals("", solver.solve(new String[]{}));
		}
	}
	

}
