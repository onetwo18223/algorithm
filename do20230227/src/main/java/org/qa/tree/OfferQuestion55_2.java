package org.qa.tree;

/**
 * @Desc 平衡二叉树
 * https://leetcode.cn/problems/ping-heng-er-cha-shu-lcof
 * @Author Bhh
 * @Date 2023-04-04 14:18
 * @Version 1.0
 */
public class OfferQuestion55_2 {
    {
        /* 实现：

         */
    }
    class Solution {
        public boolean isBalanced(TreeNode root) {
            if (null == root) return true;
            return Math.abs(this.getDepth(root.left) - this.getDepth(root.right)) < 2 &&
                    isBalanced(root.left) && isBalanced(root.right);
        }

        private int getDepth(TreeNode node) {
            if (null == node) return 0;
            return Math.max(getDepth(node.right), getDepth(node.left)) + 1;
        }
    }
}
