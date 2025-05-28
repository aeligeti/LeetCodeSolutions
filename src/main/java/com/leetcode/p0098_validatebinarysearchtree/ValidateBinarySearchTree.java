package com.leetcode.p0098_validatebinarysearchtree;

import com.leetcode.base.TreeNode;
import com.leetcode.p0572_subtreeofanothertree.SubTreeOfAnotherTree;

/*
 * Leetcode 98. Validate Binary Search Tree
 * 
 * Intuition, we can use in-order traversal to check if the tree is a valid binary search tree.
 * as the in-order traversal of a valid BST should yield a sorted sequence of values.
 * We keep track of the previous node's value and ensure that the current node's value is greater than the previous one.
 * 
 * Time Complexity: O(n), where n is the number of nodes in the tree.
 * Space Complexity: O(h), where h is the height of the tree, due to the recursion stack.
 *
 */
public class ValidateBinarySearchTree {
	
	public static Integer prev = null;
	
	public static boolean isValidBST(TreeNode root) {
		prev= null;
		return inOrderTraversal(root);
	}
	
	public static boolean inOrderTraversal(TreeNode root) {
		
		if(root==null) return true;
		
		if(!inOrderTraversal(root.left)) return false;
		
		if(prev!=null && root.val<= prev) return false;
		prev = root.val;
		
		return inOrderTraversal(root.right);

	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(2);
		root.right.left = new TreeNode(4); 
		
		System.out.println(isValidBST(root)); //true
		
		TreeNode root2 = new TreeNode(3);
		root2.left = new TreeNode(1);
		root2.right = new TreeNode(6);
		root2.left.left = new TreeNode(0);
		root2.right.left = new TreeNode(2); 
		System.out.println(isValidBST(root2)); //false
		
	}
}
