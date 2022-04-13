package com.bhh.leetcode.swordfingeroffertwobrushes.tree;

/**
 * @author bhh
 * @description 二叉搜索树的第k大节点
 * @date Created in 2022-01-14 16:37
 * @modified By
 */
public class Question54 {
    class Solution {
        /*
        查询 中序遍历, 回溯k
         */
        private int res, k;

        public int kthLargest(TreeNode root, int k) {
            this.k = k;
            dfs(root);
            return res;
        }

        private void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            dfs(root.right);
            if (k == 0) {
                return;
            }
            if (--k == 0) {
                res = root.val;
            }
            dfs(root.left);
        }
    }
}
