package org.problem.dp;

import org.problem.binarytree.TreeNode;

/**
 * 打家劫舍III
 *
 * dp[i][0] 不偷
 * dp[i][1] 偷
 * 1.1 最后一步
 *      最后一个元素（树遍历，后序遍历）（树的遍历可以看做是数组）偷不偷
 *          + 前一个元素偷不偷的情况下的最大值
 *      因为是二叉树，那么root节点不偷的话，
 *          那么dp[0] = max(root.right[0], root.right[1])
 *                  + max(root.left[0], root.left[1]) // 左右子树可以相加，因为不在一条线上
 *      那么root节偷的话，
 *          那么dp[1] = max(root.left[0], root.left[0]) + root.val;
 * 1.2 子问题
 * 2 转换公式
 * dp[i][0] = max(dp[i - 1][0], dp[i - 1][1])
 *  转换为 二叉树 + 树遍历
 *  dp[0] = max(root.right[0], root.right[1]) + max(root.left[0], root.left[1]);
 * dp[i][1] = dp[i - 1][0] + node.val
 *  转换为 二叉树 + 树遍历
 *  dp[1] = max(root.left[0], root.left[0]) + root.val;
 * 3 初始值和边界值
 *  后序遍历，那么递归结束条件返回 0 即可
 * 4 顺序
 *  后序遍历
 *  左->右->中
 */
public class Question337 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    class Solution {
        public int rob(TreeNode root) {
            if (root == null) return 0;
            return Math.max(doRob(root)[0], doRob(root)[1]);
        }

        private int[] doRob(TreeNode root) {
            if (root == null) return new int[]{0, 0};
            int[] leftDp = doRob(root.left);
            int[] rightDP = doRob(root.right);
            int[] dp = new int[2];
            dp[0] = Math.max(rightDP[0], rightDP[1]) +
                     Math.max(leftDp[0], leftDp[1]);
            dp[1] = leftDp[0] + rightDP[0] + root.val;
            return dp;
        }
    }
}
