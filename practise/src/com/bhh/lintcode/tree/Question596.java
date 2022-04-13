package com.bhh.lintcode.tree;

/**
 * @author bhh
 * @description 最小子树
 * 描述
 * 给一棵二叉树, 找到和为最小的子树, 返回其根节点。
 * 输入输出数据范围都在int内。
 * <p>
 * 类型一 : 二叉树上求值，求路径
 * @date Created in 2021-12-03 11:51
 * @modified By
 */
public class Question596 {
    public class Solution {
        /*
        找出和为最小的子树, 需要子树求和, 且需要记录最小和的节点和值
        子数如何求和?
        一个树的和 = 左子树和 + 右子树和 + 当前节点value
         */
        private int minSum;
        private TreeNode minNode;

        public TreeNode findSubtree(TreeNode root) {
            minSum = Integer.MAX_VALUE;
            minNode = null;
            getTreeSum(root);
            return minNode;
        }

        private int getTreeSum(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftSum = getTreeSum(root.left);
            int rightSum = getTreeSum(root.right);
            int nodeSum = leftSum + rightSum + root.val;

            if (nodeSum < minSum) {
                minSum = nodeSum;
                minNode = root;
            }
            return nodeSum;
        }
    }
}
