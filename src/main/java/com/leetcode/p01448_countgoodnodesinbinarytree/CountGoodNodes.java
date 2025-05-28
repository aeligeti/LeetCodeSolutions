package com.leetcode.p01448_countgoodnodesinbinarytree;

import com.leetcode.base.TreeNode;

public class CountGoodNodes {


    public static int goodNodes(TreeNode root) {
        
        return dfs(root, Integer.MIN_VALUE);

    }

    public static int dfs(TreeNode root, int maxSoFar) {
        int countGoodNodes = 0;
        if(root==null) return 0;

        if(root.val>=maxSoFar) {
			countGoodNodes = 1; // This node is a good node
			maxSoFar = root.val; // Update the maximum value seen so far
		} else {
			countGoodNodes = 0; // This node is not a good node
        }
        countGoodNodes += dfs(root.left, maxSoFar);
        countGoodNodes += dfs(root.right, maxSoFar);

        return countGoodNodes;
    }
    
    public static void main(String[] args) {
    	//use testcase [2,null,4,10,8,null,null,4]
    	TreeNode root = new TreeNode(2);
    	root.right = new TreeNode(4);
    	root.right.left = new TreeNode(10);
    	root.right.right = new TreeNode(8);
    	root.right.left.left = new TreeNode(4);
    	
		
		System.out.println(goodNodes(root)); // Output: 4
	}
}
