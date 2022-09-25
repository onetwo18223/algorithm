package org.problem.binarytree;

/**
 * 路径总和
 *
 * 实现：二叉树求路径题目
 *      前序遍历，
 *      每次递归targetSum减去root.val，
 *      若是targetSum == 0，则返回true;
 *      注意：题目要求
 */
public class Question112 {

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
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) return false;
            int target = targetSum - root.val;
            if (root.left == null && root.right == null) return target == 0;
            return hasPathSum(root.left, target)
                    || hasPathSum(root.right, target);
        }
    }
}
