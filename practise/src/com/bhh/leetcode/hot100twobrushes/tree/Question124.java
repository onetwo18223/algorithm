package com.bhh.leetcode.hot100twobrushes.tree;

/**
 * @author bhh
 * @description 二叉树中的最大路径和
 * @date Created in 2022-01-26 9:50
 * @modified By
 */
public class Question124 {
    class Solution {
        /*
        类似于二叉树求深度
        很多求最大值和问题, 都有需要若出现负数情况则清0的小技巧
         */
        int max = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            dfs(root);
            return max;
        }

        // 返回当前节点的最大值路劲
        private int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            // 左节点最大路劲
            int left = Math.max(0, dfs(root.left));
            // 右节点最大路劲
            int right = Math.max(0, dfs(root.right));
            max = Math.max(max, left + right + root.val);
            return Math.max(left, right) + root.val;
        }
    }
}
