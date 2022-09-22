package org.problem.binarytree;

/**
 * 二叉树的最近公共祖先
 *
 * 实现：回溯法也就是后序遍历
 *      从底向上，若是碰到p或者q则返回
 *
 */
public class Question236 {
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root == q || root == p) return root;
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (left != null && right != null) return root;
            if (left == null) return right;
            return left;
        }
    }
}
