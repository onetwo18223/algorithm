package com.bhh.leetcode.four;

/**
 * @author bhh
 * @description  二叉树的最近公共祖先
 * @date Created in 2022-02-25 21:11
 * @modified By
 */
public class Question236 {
    class Solution {
        /*
        查找 先序
         */
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return null;
            }
            if (root == p || root == q) {
                return root;
            }
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return root;
        }
    }
}
