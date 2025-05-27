package com.leetcode.test.p0572_subtreeofanothertree;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.leetcode.p0572_subtreeofanothertree.*;

/*
 * Test Class for Leetcode 572: Subtree of another tree
 * 
 */
class SubTreeOfAnotherTreeTest {
	
	// === register every implementation ===
	static Stream<Arguments> solvers() {
		return Stream.of(
			Arguments.of(new SubTreeOfAnotherTree())
		);
	}
	
	/* ---------- basic sanity check ---------- */
	@ParameterizedTest(name = "{0} basic")
	@MethodSource("solvers")
	void basicCase(SubTreeOfAnotherTree solver) {
		SubTreeOfAnotherTree.TreeNode root = new SubTreeOfAnotherTree.TreeNode(3);
		root.left = new SubTreeOfAnotherTree.TreeNode(4);
		root.right = new SubTreeOfAnotherTree.TreeNode(5);
		root.left.left = new SubTreeOfAnotherTree.TreeNode(1);
		root.left.right = new SubTreeOfAnotherTree.TreeNode(2);
		root.left.right.left = new SubTreeOfAnotherTree.TreeNode(0); // This node is not in subRoot

		SubTreeOfAnotherTree.TreeNode subRoot = new SubTreeOfAnotherTree.TreeNode(4);
		subRoot.left = new SubTreeOfAnotherTree.TreeNode(1);
		subRoot.right = new SubTreeOfAnotherTree.TreeNode(2);

		assertThat(solver.isSubtree(root, subRoot)).isTrue(); // subRoot is a subtree of root
	}
	
	/* ---------- edge cases ---------- */
	@ParameterizedTest(name = "{0} edge cases")
	@MethodSource("solvers")
	void edgeCases(SubTreeOfAnotherTree solver) {
		SubTreeOfAnotherTree.TreeNode root = new SubTreeOfAnotherTree.TreeNode(1);
		SubTreeOfAnotherTree.TreeNode subRoot = new SubTreeOfAnotherTree.TreeNode(1);
		
		assertThat(solver.isSubtree(root, subRoot)).isTrue(); // single node trees are equal
		
		root.left = new SubTreeOfAnotherTree.TreeNode(2);
		assertThat(solver.isSubtree(root, subRoot)).isTrue(); // subRoot is a subtree of root
	}
	
}
