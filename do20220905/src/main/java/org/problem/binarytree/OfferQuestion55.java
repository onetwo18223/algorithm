package org.problem.binarytree;

/**
 * 平衡二叉树
 *
 * 实现：求出树的深度，然后进行判断，因为树的深度是从子节点开始向上计算，
 *      root节点可以获取到树的深度
 *      后序遍历
 */
public class OfferQuestion55 {
    class Solution {
        public boolean judge = true;

        public boolean isBalanced(TreeNode root) {
            doJudge(root);
            return judge;
        }

        private int doJudge(TreeNode root) {
            if (root == null) return 0;
            int left = doJudge(root.left);
            int right = doJudge(root.right);
            if (Math.abs(left - right) > 1) {
                judge = false;
            }
            return Math.max(left, right) + 1;
        }
    }
}