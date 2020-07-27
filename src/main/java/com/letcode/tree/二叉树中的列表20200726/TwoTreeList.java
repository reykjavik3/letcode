package com.letcode.tree.二叉树中的列表20200726;

/**
 * @author licongrong
 * @create 2020-07-26 20:06
 **/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class TwoTreeList {

    public boolean dfs(TreeNodes treeNodes,ListNode head) {
        if (head == null) {
            return true;
        }
        if(treeNodes==null){
            return false;
        }
        if(head.val!=treeNodes.val){
            return false;
        }
        return dfs(treeNodes.left,head.next)||dfs(treeNodes.right,head.next);

    }
    public boolean isSubPath(ListNode head, TreeNodes root) {
        if(root==null){
            return false;
        }
        return dfs(root,head)||isSubPath(head,root.left)||isSubPath(head,root.right);
    }
}

   class ListNode {
      int val;
      ListNode next;
     ListNode(int x) { val = x; }
  }

   class TreeNodes {
      int val;
      TreeNodes left;
      TreeNodes right;
      TreeNodes(int x) { val = x; }
  }
