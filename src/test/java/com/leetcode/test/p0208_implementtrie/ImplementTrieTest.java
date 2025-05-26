package com.leetcode.test.p0208_implementtrie;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.leetcode.p0208_implementtrie.ImplementTrie;


/*
 * Test class for ImplementTrie. Leetcode 208 Implement Trie (Prefix Tree) Test Cases
 */
class ImplementTrieTest {
	// === register every implementation ===
	static Stream<Arguments> solvers() {
		return Stream.of(
			Arguments.of(new ImplementTrie())
		);
	}
	
	
	/* ---------- basic sanity check ---------- */
	@ParameterizedTest(name = "{0} basic")
	@MethodSource("solvers")
	void basicCase(ImplementTrie solver) {
		solver.insert("apple");
		assertThat(solver.search("apple")).isTrue(); // exact match
		assertThat(solver.search("app")).isFalse(); // prefix not a word
		assertThat(solver.startsWith("app")).isTrue(); // prefix exists
		solver.insert("app");
		assertThat(solver.search("app")).isTrue(); // now "app" is a word
	}
	
	/* ---------- edge cases ---------- */
	@ParameterizedTest(name = "{0} edge cases")
	@MethodSource("solvers")
	void edgeCases(ImplementTrie solver) {
		solver.insert("a");
		assertThat(solver.search("a")).isTrue(); // single character word
		assertThat(solver.startsWith("a")).isTrue(); // prefix of single character
		assertThat(solver.search("b")).isFalse(); // non-existent word
		solver.insert("ab");
		assertThat(solver.search("ab")).isTrue(); // two-character word
		assertThat(solver.startsWith("a")).isTrue(); // prefix of two-character word
		solver.insert(""); // inserting empty string should not affect search or startsWith
		assertThat(solver.search("")).isFalse(); // empty string is not a valid word
	}
	
}
