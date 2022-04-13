package com.bhh.leetcode.four;

/**
 * @author bhh
 * @description 翻转二叉树
 * @date Created in 2022-02-23 17:12
 * @modified By
 */
public class Question226 {
    class Solution {
        /*
        对左右节点进行交换
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
