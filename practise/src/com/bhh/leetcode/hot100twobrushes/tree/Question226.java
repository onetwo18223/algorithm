package com.bhh.leetcode.hot100twobrushes.tree;

/**
 * @author bhh
 * @description 翻转二叉树
 * @date Created in 2022-01-23 11:21
 * @modified By
 */
public class Question226 {
    class Solution {
        /*
        多节点 重构
         */
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            TreeNode left = root.left;
            root.left = invertTree(root.right);
            root.right = invertTree(left);
            return root;
        }
    }
}
