package com.bhh.leetcode.four.tree;

/**
 * @author bhh
 * @description 打家劫舍 III
 * @date Created in 2022-03-05 8:32
 * @modified By
 */
public class Question337 {
    class Solution {
        /*
        这道题使用dp比较特殊
        特殊点在于对树使用遍历需要使用dfs递归,
        缺点 : dp数组无法使用索引存储数据
        解决办法 : 每次递归都返回dp[0]和dp[1]对应 不偷 与 偷
            因为获取dp[i]的值和dp[i - 1]有关, 所以递归可以解决
            如果dp[i]的值和dp[i - 2]有关, 则可能无法解决
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
            // 选择这个节点
            int select = root.val + left[0] + right[0];
            // 不选择这个节点
            // 对于子节点则从 选择 和 不选择 俩种状态选择最大值
            int notSelect = Math.max(left[0], left[1]) +
                    Math.max(right[0], right[1]);
            return new int[]{notSelect, select};
        }
    }
}
