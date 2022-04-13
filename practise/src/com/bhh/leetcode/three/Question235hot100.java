package com.bhh.leetcode.three;

/**
 * @author bhh
 * @description 二叉搜索树的最近公共祖先
 * @date Created in 2022-01-29 21:59
 * @modified By
 */
public class Question235hot100 {
    class Solution {
        /*
        求公共祖先
        方法一 : 直接当做二叉树解决问题
        方法二 : 利用二分搜索树的性质解决问题
         */
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root == p || root == q) {
                return root;
            }
            if (root.val > p.val && root.val > q.val) {
                return lowestCommonAncestor(root.left, p, q);
            } else if (root.val < p.val && root.val < q.val) {
                return lowestCommonAncestor(root.right, p, q);
            } else {
                return root;
            }
        }
    }
}
