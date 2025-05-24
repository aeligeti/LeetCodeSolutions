package com.leetcode.test.p0001_twosum;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static java.time.Duration.ofMillis;
import static java.util.stream.IntStream.range;

import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.leetcode.p0001_twosum.TwoSum;
import com.leetcode.p0001_twosum.TwoSumHashMap;

class TwoSumTest {

    /* === register every implementation === */
    static Stream<Arguments> solvers() {
        return Stream.of(
            Arguments.of(new TwoSumHashMap())
            // , Arguments.of(new TwoSumBruteForce())
        );
    }

    /* ---------- tiny sanity check ---------- */
    @ParameterizedTest(name = "{0} basic")
    @MethodSource("solvers")
    void basicCase(TwoSum solver) {
        assertThat(solver.solve(new int[]{2, 7, 11, 15}, 9))
                .containsExactly(0, 1);
    }

    /* ---------- large input + perf guard ---------- */
    @ParameterizedTest(name = "{0} large")
    @MethodSource("solvers")
    void stressCase(TwoSum solver) {

        int n = 10_000, target = 10_000;
        int[] nums = range(0, n).toArray();

        int[] idx = assertTimeoutPreemptively(
            ofMillis(50),
            () -> solver.solve(nums, target)
        );

        // generic validity checks
        assertThat(idx).hasSize(2).doesNotHaveDuplicates();
        assertThat(IntStream.of(idx).allMatch(i -> i >= 0 && i < n)).isTrue();
        assertThat(nums[idx[0]] + nums[idx[1]]).isEqualTo(target);
    }
}
