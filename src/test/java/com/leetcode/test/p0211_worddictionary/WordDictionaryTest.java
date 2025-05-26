package com.leetcode.test.p0211_worddictionary;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.leetcode.p0211_worddictionary.*;

/*
 * Test class for WordDictionary.
 * 
 * LeetCode 211 Word Dictionary Test Cases.
 */
class WordDictionaryTest {

	// === register every implementation ===
	static Stream<Arguments> solvers() {
		return Stream.of(
			Arguments.of(new WordDictionary())
		);
	}

	/* ---------- basic sanity check ---------- */
	@ParameterizedTest(name = "{0} basic")
	@MethodSource("solvers")
	void basicCase(WordDictionary solver) {
		solver.addWord("bad");
		solver.addWord("dad");
		solver.addWord("mad");
		assertThat(solver.search("pad")).isFalse(); // not found
		assertThat(solver.search("bad")).isTrue(); // exact match
		assertThat(solver.search(".ad")).isTrue(); // wildcard match
		assertThat(solver.search("b..")).isTrue(); // wildcard match
	}

	/* ---------- edge cases ---------- */
	@ParameterizedTest(name = "{0} edge cases")
	@MethodSource("solvers")
	void edgeCases(WordDictionary solver) {
		solver.addWord("bad");
		solver.addWord("b");
		assertThat(solver.search("a")).isFalse(); // single character word
		assertThat(solver.search(".")).isTrue(); // single wildcard matches single character word

		
	}
	/*custom test case*/
	@ParameterizedTest(name = "{0} custom test case")
	@MethodSource("solvers")
	//add test case ["WordDictionary","addWord","addWord","addWord","addWord","search","search","addWord","search","search","search","search","search","search"]
	//[[],["at"],["and"],["an"],["add"],["a"],[".at"],["bat"],[".at"],["an."],["a.d."],["b."],["a.d"],["."]]
	void customTestCase(WordDictionary solver) {
		solver.addWord("at");
		solver.addWord("and");
		solver.addWord("an");
		solver.addWord("add");
		solver.addWord("bat");
		assertThat(solver.search("a")).isFalse(); // single character not found
		assertThat(solver.search(".at")).isTrue(); // wildcard match for "at"
		solver.addWord("bat");
		assertThat(solver.search(".at")).isTrue(); // wildcard match for "bat"
		assertThat(solver.search("an.")).isTrue(); // wildcard match for "an"
		assertThat(solver.search("a.d.")).isFalse(); // "a.d." not found
		assertThat(solver.search("b.")).isFalse(); // "b." not found
		assertThat(solver.search("a.d")).isTrue(); // "a.d" not found
		assertThat(solver.search(".")).isFalse(); // "." not found, no single character word
	}
	
	
}