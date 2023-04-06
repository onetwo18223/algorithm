package org.qa.tree;

/**
 * @Desc 路径总和
 * https://leetcode.cn/problems/path-sum/
 * @Author Bhh
 * @Date 2023-04-04 11:06
 * @Version 1.0
 */
public class Question112 {
    {
        /* 实现：从根节点到叶子结点的和为target
         */
    }
    class TreeNode {
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

    // TODO: 比较经典的二叉树求路径和问题
    class Solution {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (null == root) return false;
            int value = targetSum - root.val;
            if (value == 0 && null == root.right && null == root.left) return true;

            return hasPathSum(root.left, value) ||
                    hasPathSum(root.right, value);
        }
    }
}
