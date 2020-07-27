package com.letcode.tree.二叉树的最大路径和;

/**
 * @author licongrong
 * @create 2020-07-27 13:58
 *
 * 拿到树的每个节点，遍历，深度优先？
 * 递归
 **/
public class Solution {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null){
            return 0;
        }
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftMax = Math.max(dfs(root.left), 0);
        int rightMax = Math.max(dfs(root.right), 0);
        max = Math.max(max,leftMax+rightMax+root.val);
        return root.val+Math.max(leftMax,rightMax);
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}