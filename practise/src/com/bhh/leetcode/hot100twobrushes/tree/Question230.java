package com.bhh.leetcode.hot100twobrushes.tree;

/**
 * @author bhh
 * @description 二叉搜索树中第K小的元素
 * @date Created in 2022-01-28 10:46
 * @modified By
 */
public class Question230 {
    class Solution {
        /*
        二叉搜索树的中序遍历为递增
        dfs 中序 查询
         */
        int k;

        public int kthSmallest(TreeNode root, int k) {
            this.k = k;
            return dfs(root).val;
        }

        private TreeNode dfs(TreeNode root) {
            if (root == null) {
                return null;
            }
            TreeNode leftNode = dfs(root.left);
            if (leftNode != null) {
                return leftNode;
            }
            k--;
            if (k == 0) {
                return root;
            }
            TreeNode rightNode = dfs(root.right);
            if (rightNode != null) {
                return rightNode;
            }
            return null;
        }
    }
}
