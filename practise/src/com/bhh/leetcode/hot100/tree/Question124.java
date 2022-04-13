package com.bhh.leetcode.hot100.tree;

/**
 * @author bhh
 * @description 二叉树中的最大路径和
 * @date Created in 2022-01-05 18:11
 * @modified By
 */
public class Question124 {
    class Solution {
        /*
        三种情况 :
            left-node-right
            left-node-node的父节点
            right-node-node的父节点
        后俩种可以使用递归来完成
        但是第一种无法使用到递归, 需要在一个方法完成
         */
        int max = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            dfs(root);
            return max;
        }

        // dfs()是要返回值的, 返回是int类型,
        // 需要返回left + node/ right + node的值
        private int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = Math.max(0, dfs(root.left));
            int right = Math.max(0, dfs(root.right));
            // 判断 left-node-right 这条路径
            max = Math.max(left + right + root.val, max);
            return Math.max(left, right) + root.val;
        }
    }
}
