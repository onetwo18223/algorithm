package com.bhh.leetcode.four.tree;

/**
 * @author bhh
 * @description 合并二叉树
 * @date Created in 2022-03-04 17:00
 * @modified By
 */
public class Question617 {
    class Solution {
        /*
        合并二叉树
         */
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            if (root1 == null || root2 == null) {
                return root1 == null ? root2 : root1;
            }
            TreeNode node = new TreeNode(root1.val + root2.val);
            node.left = mergeTrees(root1.left, root2.left);
            node.right = mergeTrees(root1.right, root2.right);
            return node;
        }
    }
}
