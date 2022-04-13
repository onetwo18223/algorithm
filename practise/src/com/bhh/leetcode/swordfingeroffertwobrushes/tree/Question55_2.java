package com.bhh.leetcode.swordfingeroffertwobrushes.tree;

/**
 * @author bhh
 * @description 平衡二叉树
 * @date Created in 2022-01-14 19:24
 * @modified By
 */
public class Question55_2 {
    class Solution {
        /*
        也是算深度的题目
        查询 后续遍历
         */
        private boolean judge;
        public boolean isBalanced(TreeNode root) {
            dfs(root);
            return !judge;
        }

        private int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = dfs(root.left);
            int right = dfs(root.right);
            if (Math.abs(right - left) > 1) {
                judge = true;
            }
            return Math.max(left, right) + 1;
        }
    }
}
