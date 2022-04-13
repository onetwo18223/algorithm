package com.bhh.leetcode.hot100.tree;

/**
 * @author bhh
 * @description 对称二叉树
 * @date Created in 2021-12-26 9:26
 * @modified By
 */
public class Question101 {
    class Solution {
        /*
        错误解法 : 题目是需求全部对称, 这个解对node点来说是对称

        判断是否是对称, 前序和后序都是一个不错的选择
         */
        public boolean isSymmetricError(TreeNode root) {
            if (root == null) {
                return true;
            }
            if (!isSymmetricError(root.left)
                    || !isSymmetricError(root.right)) {
                return false;
            }
            if (root.left != null
                    && root.right != null
                    && root.left.val != root.right.val) {
                return false;
            }
            return true;
        }

        public boolean isSymmetric(TreeNode root) {
            return check(root, root);
        }

        private boolean check(TreeNode right, TreeNode left) {
            if (right == null && left == null) {
                return true;
            }
            if (right == null || left == null) {
                return false;
            }
            return right.val == left.val
                    && check(right.right, left.left)
                    && check(right.left, left.right);
        }
    }
}
