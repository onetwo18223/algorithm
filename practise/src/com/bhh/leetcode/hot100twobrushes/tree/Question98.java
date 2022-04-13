package com.bhh.leetcode.hot100twobrushes.tree;

/**
 * @author bhh
 * @description 验证二叉搜索树
 * @date Created in 2022-01-23 14:08
 * @modified By
 */
public class Question98 {
    class Solution {
        /*
        验证二叉树, 二叉树的左子树全部小于node, 二叉树的右子树全部大于node
        设置上界和下界
         */
        public boolean isValidBST(TreeNode root) {
            return dfs(root, Long.MAX_VALUE, Long.MIN_VALUE);
        }

        private boolean dfs(TreeNode root, long up, long low) {
            if (root == null) {
                return true;
            }
            if (root.val >= up || root.val <= low) {
                return false;
            }
            return dfs(root.left, root.val, low)
                    && dfs(root.right, up, root.val);
        }
    }
}
