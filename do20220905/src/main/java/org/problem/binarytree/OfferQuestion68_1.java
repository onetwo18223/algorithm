package org.problem.binarytree;

/**
 * 二叉搜索树的最近公共祖先
 *
 * 实现：最近公共祖先类型题目是标准的回溯返回对应节点题目，
 *      根据方法返回的节点来进行判断
 */
public class OfferQuestion68_1 {
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) return root;
            if (root.val > q.val && root.val > p.val)
                return lowestCommonAncestor(root.left, p, q);
            if (root.val < q.val && root.val < p.val)
                return lowestCommonAncestor(root.right, p, q);
            return root;
        }
    }
}
