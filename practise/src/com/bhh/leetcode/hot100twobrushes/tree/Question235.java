package com.bhh.leetcode.hot100twobrushes.tree;

/**
 * @author bhh
 * @description 二叉搜索树的最近公共祖先
 * @date Created in 2022-01-27 14:34
 * @modified By
 */
public class Question235 {
    class Solution {
        /*
        求公共祖先
        二叉树是一种情况
        二叉搜索树又是一种情况
         */
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root.val == p.val || root.val == q.val) {
                return root;
            }
            // 该节点的数值小于p和q, 递归左子树
            if (p.val > root.val && root.val < q.val) {
                return lowestCommonAncestor(root.left, p, q);
            }
            // 反则同理, 递归右子树
            else if (p.val < root.val && root.val > q.val) {
                return lowestCommonAncestor(root.right, p, q);
            }
            // 介于俩者直接, 直接返回最近的该节点
            else {
                return root;
            }
        }

        public TreeNode lowestCommonAncestorMore(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root.val == p.val || root.val == q.val) {
                return root;
            }
            TreeNode left = lowestCommonAncestorMore(root.left, p, q);
            TreeNode right = lowestCommonAncestorMore(root.right, p, q);
            if (left != null && right != null) {
                return root;
            }
            if (left != null) {
                return left;
            }
            if (right != null) {
                return right;
            }
            return null;
        }
    }
}
