package com.leetcode.test.p0098_validatebinarysearchtree;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.leetcode.base.TreeNode;
import com.leetcode.p0098_validatebinarysearchtree.ValidateBinarySearchTree;

/*
 * Test Class for Leetcode 98: Validate Binary Search Tree
 * 
 */
class ValidateBinaryTreeTest {
	// === register every implementation ===
	static Stream<Arguments> solvers() {
		return Stream.of(
			Arguments.of(new ValidateBinarySearchTree())
		);
	}
	
	/* ---------- basic sanity check ---------- */
	@ParameterizedTest(name = "{0} basic")
	@MethodSource("solvers")
	void basicCase(ValidateBinarySearchTree solver) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(2);
		root.right.left = new TreeNode(4); 
		
		assertThat(solver.isValidBST(root)).isTrue(); // Valid BST
		// add test cases
		TreeNode root2 = new TreeNode(3);
		root2.left = new TreeNode(1);
		root2.right = new TreeNode(6);	
		root2.left.left = new TreeNode(0);
		root2.right.left = new TreeNode(2);
			
		assertThat(solver.isValidBST(root2)).isFalse(); // Invalid BST
		
	}
	
	/* ---------- edge cases ---------- */
	@ParameterizedTest(name = "{0} edge cases")
	@MethodSource("solvers")
	void edgeCases(ValidateBinarySearchTree solver) {
		//add edge cases from Leetcode discussion
		// Single node tree
		TreeNode singleNode = new TreeNode(1);	
		assertThat(solver.isValidBST(singleNode)).isTrue(); // Single node tree is a valid BST
		// Empty tree
		// An empty tree is also considered a valid BST
		TreeNode emptyTree = null;
		assertThat(solver.isValidBST(emptyTree)).isTrue(); // Empty tree is a valid BST
		// Tree with duplicate values
		// A tree with duplicate values is not a valid BST
		TreeNode duplicateRoot = new TreeNode(2);
		duplicateRoot.left = new TreeNode(1);
		duplicateRoot.right = new TreeNode(2); // Duplicate value on the right
		assertThat(solver.isValidBST(duplicateRoot)).isFalse(); // Tree with duplicate values is not a valid BST
		// test case with negative values
		TreeNode negativeRoot = new TreeNode(-10);
		negativeRoot.left = new TreeNode(-20);
		negativeRoot.right = new TreeNode(-5);
		assertThat(solver.isValidBST(negativeRoot)).isTrue(); // Negative values can still form a valid BST
		
	}
}
