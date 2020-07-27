package com.letcode.tree.二叉树检查平衡性2020727;

/**
 * @author licongrong
 * @create 2020-07-27 13:49
 **/

public class Solution {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (getDep(root.left) - getDep(root.right) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int getDep(TreeNode left) {
        if(left==null){
            return 0;
        }
        return Math.max(getDep(left.left),getDep(left.right))+1;
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