package com.leetcode.test.p01448_countgoodnodesinbinarytree;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.leetcode.base.TreeNode;
import com.leetcode.p01448_countgoodnodesinbinarytree.CountGoodNodes;

/*
 * Test Class for Leetcode 1448: Count Good Nodes in Binary Tree
 */
public class CountGoodNodesTest {
	
	// === register every implementation ===
	// Currently, there is only one implementation
	static Stream<Arguments> solvers() {
		return Stream.of(
			Arguments.of(new CountGoodNodes())
		);
	}
	/* ---------- basic sanity check ---------- */
	@ParameterizedTest(name = "{0} basic")
	@MethodSource("solvers")
	void basicCase(CountGoodNodes solver) {
		// Test case: [2,null,4,10,8,null,null,4]
		TreeNode root = new TreeNode(2);
		root.right = new TreeNode(4);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(8);
		root.right.left.left = new TreeNode(4);
		
		assertThat(solver.goodNodes(root)).isEqualTo(4); // Output: 4
	
		// Additional test case: [3,1,4,3,null,1,5]
		TreeNode root2 = new TreeNode(3);
		root2.left = new TreeNode(1);
		root2.right = new TreeNode(4);
		root2.left.left = new TreeNode(3);
		root2.right.left = new TreeNode(1);
		root2.right.right = new TreeNode(5);
		assertThat(solver.goodNodes(root2)).isEqualTo(4); // Output: 4
		
		
	}
	
	/* ---------- edge cases ---------- */
	@ParameterizedTest(name = "{0} edge cases")
	@MethodSource("solvers")
	void edgeCases(CountGoodNodes solver) {
		// Edge case: Single node tree
		TreeNode singleNode = new TreeNode(1);
		assertThat(solver.goodNodes(singleNode)).isEqualTo(1); // Single node is a good node
		
		// Edge case: All nodes are bad
		TreeNode allBad = new TreeNode(1);
		allBad.left = new TreeNode(0);
		allBad.right = new TreeNode(-1);
		allBad.left.left = new TreeNode(-2);
		allBad.left.right = new TreeNode(-3);
		allBad.right.left = new TreeNode(-4);
		allBad.right.right = new TreeNode(-5);
		assertThat(solver.goodNodes(allBad)).isEqualTo(1); // Only the root is a good node
		
		// Edge case: Empty tree
		TreeNode emptyTree = null;
		assertThat(solver.goodNodes(emptyTree)).isEqualTo(0); // Empty tree has no good nodes
		
		// Edge case: Tree with negative values
		TreeNode negativeTree = new TreeNode(-10);
		negativeTree.left = new TreeNode(-20);
		negativeTree.right = new TreeNode(-5);
		negativeTree.left.left = new TreeNode(-30);
		negativeTree.left.right = new TreeNode(-15);
		assertThat(solver.goodNodes(negativeTree)).isEqualTo(2); // -10 and -5 are good nodes
		
		// Edge case: Tree with duplicate values
		TreeNode duplicateTree = new TreeNode(2);
		duplicateTree.left = new TreeNode(2);
		duplicateTree.right = new TreeNode(2);
		duplicateTree.left.left = new TreeNode(2);
		duplicateTree.left.right = new TreeNode(2);
		assertThat(solver.goodNodes(duplicateTree)).isEqualTo(5); // All nodes are good nodes since they are equal to the root value`
	}
}
