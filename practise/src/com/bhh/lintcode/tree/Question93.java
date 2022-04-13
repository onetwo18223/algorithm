package com.bhh.lintcode.tree;

/**
 * @author bhh
 * @description 平衡二叉树
 * <p>
 * 类型一 : 二叉树上求值，求路径
 * @date Created in 2021-12-09 22:35
 * @modified By
 */
public class Question93 {
    public class Solution {
        /*
        这道题应该是由下到上, 后序遍历
         */
        private boolean judge;

        public boolean isBalanced(TreeNode root) {
            judge = true;
            dfs(root);
            return judge;
        }

        private int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = dfs(root.left);
            int right = dfs(root.right);
            if (Math.abs(left - right) > 1) {
                judge = false;
            }
            return Math.max(left, right) + 1;
        }
    }
}
