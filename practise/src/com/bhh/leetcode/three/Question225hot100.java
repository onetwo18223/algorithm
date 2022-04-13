package com.bhh.leetcode.three;

/**
 * @author bhh
 * @description 翻转二叉树
 * @date Created in 2022-01-29 22:11
 * @modified By
 */
public class Question225hot100 {
    class Solution {
        /*
        单节点 后序 结构
         */
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            TreeNode right = root.right;
            root.right = invertTree(root.left);
            root.left = invertTree(right);
            return root;
        }
    }
}
