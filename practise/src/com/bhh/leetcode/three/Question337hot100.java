package com.bhh.leetcode.three;

/**
 * @author bhh
 * @description 打家劫舍 III
 * @date Created in 2022-01-29 12:26
 * @modified By
 */
public class Question337hot100 {
    class Solution {
        /*
        动态规划
        因为dfs遍历二叉树必须使用递归, 所以我们在使用递归时应该返回dp[]数组
        每次遍历返回dp[0], dp[1], 递归叠加起来也就相当于了二维数组
         */
        public int rob(TreeNode root) {
            int[] res = dfs(root);
            return Math.max(res[0], res[1]);
        }

        private int[] dfs(TreeNode root) {
            if (root == null) {
                return new int[]{0, 0};
            }
            int[] left = dfs(root.left);
            int[] right = dfs(root.right);
            int select = root.val + left[0] + right[0];
            int notSelect = Math.max(left[0], left[1]) +
                    Math.max(right[0], right[1]);
            return new int[]{notSelect, select};
        }
    }
}
