package com.letcode.tree.二叉树的层序遍历;

/**
 * @author licongrong
 * @create 2020-07-26 20:26
 **/

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    ArrayList<List<Integer>> levels = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return levels;
        }
        helper(root,0);
        return levels;

    }

    private void helper(TreeNode node, int level) {
        if(levels.size()==level){
            levels.add(new ArrayList<>());
        }
        levels.get(level).add(node.val);
        if(node.left!=null){
            helper(node.left,level+1);
        }
        if(node.right!=null){
            helper(node.right,level+1);
        }
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