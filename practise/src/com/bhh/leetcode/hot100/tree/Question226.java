package com.bhh.leetcode.hot100.tree;

/**
 * @author bhh
 * @description 翻转二叉树
 * @date Created in 2021-12-26 12:06
 * @modified By
 */
public class Question226 {
    class Solution {
        /*
        重构, DFS, 后序遍历
         */
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            TreeNode left = invertTree(root.left);
            TreeNode right = invertTree(root.right);
            root.left = right;
            root.right = left;
            return root;
        }
    }
}
