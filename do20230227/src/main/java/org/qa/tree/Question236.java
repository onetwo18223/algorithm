package org.qa.tree;

/**
 * @Desc 二叉树的最近公共祖先
 * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/
 * @Author Bhh
 * @Date 2023-04-04 14:46
 * @Version 1.0
 */
public class Question236 {
    {
        /* 实现：
        树的查找
        本题的解法核心在于理解题目
        核心目的是找到目标节点p或者q，若是有相等节点则直接返回
        若是不符合条件则会返回null
        若是有p和q同时返回，则返回root
        复习绑定Question230 可以将这类题分类到 树的查找中的筛选查找
         */
    }
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (null == root || root == p || root == q) return root;
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (left != null && right != null) return root;
            if (left == null) return right;
            return left;
        }
    }
}
