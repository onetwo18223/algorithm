package com.bhh.leetcode.hot100.tree;

/**
 * @author bhh
 * @description 把二叉搜索树转换为累加树
 * @date Created in 2021-12-26 21:05
 * @modified By
 */
public class Question538 {
    class Solution {
        /*
        查询/重构value, dfs, 反向中序遍历
         */
        private int pre = 0;
        public TreeNode convertBST(TreeNode root) {
            change(root);
            return root;
        }

        private void change(TreeNode root) {
            if (root == null) {
                return;
            }
            change(root.right);
            root.val += pre;
            pre = root.val;
            change(root.left);
        }
    }
}
