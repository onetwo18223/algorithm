package org.qa.tree;

/**
 * @Desc 二叉搜索树中第K小的元素
 * https://leetcode.cn/problems/kth-smallest-element-in-a-bst/
 * @Author Bhh
 * @Date 2023-04-04 15:56
 * @Version 1.0
 */
public class Question230 {
    {
        /* 实现：
        二叉搜索树类型 || 树的筛选查找dawd
        复习绑定Question236
         */
    }
    class Solution {
        private int k;
        public int kthSmallest(TreeNode root, int k) {
            this.k = k;
            return this.recursion(root).val;
        }

        private TreeNode recursion(TreeNode node) {
            if (node == null) return null;
            TreeNode left = this.recursion(node.left);
            if (--k == 0) return node;
            TreeNode right = this.recursion(node.right);
            return left == null ? right : left;
        }
    }
}
