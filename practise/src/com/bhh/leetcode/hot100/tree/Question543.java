package com.bhh.leetcode.hot100.tree;

/**
 * @author bhh
 * @description 二叉树的直径
 * @date Created in 2021-12-26 13:50
 * @modified By
 */
public class Question543 {
    class Solution {
        /*
        查询, dfs, 后序
        返回值为路径, 定义一个max属性承接最大值
         */
        private int max = Integer.MIN_VALUE;
        public int diameterOfBinaryTree(TreeNode root) {
            path(root);
            return max;
        }

        private int path(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int leftPath = path(node.left);
            int rightPath = path(node.right);
            int nodePath = Math.max(leftPath, rightPath) + 1;
            max = Math.max(max, leftPath + rightPath);
            return nodePath;
        }
    }
}
