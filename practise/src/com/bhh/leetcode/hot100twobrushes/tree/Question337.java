package com.bhh.leetcode.hot100twobrushes.tree;

/**
 * @author bhh
 * @description 打家劫舍 III
 * @date Created in 2022-01-23 12:20
 * @modified By
 */
public class Question337 {
    class Solution {
        /*
        ps : 这年头小偷也起码得是个硕士了吧
        思路其实也是dp, 由dp转到dfs 单节点 后序 查询
        偷这家 + 孙子家
        不偷这家 + 儿子家
         */
        public int robDfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int grandMoney = root.val;
            if (root.left != null) {
                grandMoney += robDfs(root.left.left) + robDfs(root.left.right);
            }
            if (root.right != null) {
                grandMoney += robDfs(root.right.left) + robDfs(root.right.right);
            }
            int sonMoney = robDfs(root.left) + robDfs(root.right);
            return Math.max(grandMoney, sonMoney);
        }
        // 动态规划, 因为需要遍历, 所以必须依靠dfs
        // 后序 dfs 查询 返回int[]
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
