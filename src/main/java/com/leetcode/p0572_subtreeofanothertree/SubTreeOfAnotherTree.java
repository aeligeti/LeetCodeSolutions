package com.leetcode.p0572_subtreeofanothertree;


/*
 *  Leetcode 572: Subtree of another tree
 *  
 *  Needed help with base case checks and understanding the recursive structure.
 *  
 */
public class SubTreeOfAnotherTree {

	public static boolean isSubtree(TreeNode root, TreeNode subRoot) {

		if (subRoot == null) return true;  // empty tree is always a subtree
		if (root == null) return false;    // cannot match anything in null root

		if(isSameTree(root, subRoot)) {
			return true;
		} 
		
		return isSubtree(root.left, subRoot.left) || isSubtree(root.right, subRoot.right);

	}
	
	public static boolean isSameTree(TreeNode root, TreeNode subRoot) {
		if(root==null && subRoot==null) return true;
		if(root==null || subRoot==null) return false;
		
		if(root.val==subRoot.val) {
			return isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);
		}
		
		return false;
	}
	
	public static class TreeNode {
		int val;
		public TreeNode left;
		public TreeNode right;

		TreeNode() {
		}

		public TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	
	
	public static void main(String[] args) {
		SubTreeOfAnotherTree.TreeNode root = new SubTreeOfAnotherTree.TreeNode(3);
		root.left = new SubTreeOfAnotherTree.TreeNode(4);
		root.right = new SubTreeOfAnotherTree.TreeNode(5);
		root.left.left = new SubTreeOfAnotherTree.TreeNode(1);
		root.left.right = new SubTreeOfAnotherTree.TreeNode(2);
		root.left.right.left = new SubTreeOfAnotherTree.TreeNode(0); // This node is not in subRoot

		SubTreeOfAnotherTree.TreeNode subRoot = new SubTreeOfAnotherTree.TreeNode(4);
		subRoot.left = new SubTreeOfAnotherTree.TreeNode(1);
		subRoot.right = new SubTreeOfAnotherTree.TreeNode(2);

		System.out.println(SubTreeOfAnotherTree.isSubtree(root, subRoot)); //true, subRoot is a subtree of root
		
	}

}
