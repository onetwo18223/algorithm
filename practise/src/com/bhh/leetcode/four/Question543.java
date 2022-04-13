package com.bhh.leetcode.four;

/**
 * @author bhh
 * @description 二叉树的直径
 * @date Created in 2022-02-23 17:35
 * @modified By
 */
public class Question543 {
    class Solution {
        /*
        求直径长度
        二叉树的直径长度是任意两个结点路径长度中的最大值
        求节点左右深度
         */
        int res = 0;
        public int diameterOfBinaryTree(TreeNode root) {
            getDepth(root);
            return res;
        }

        private int getDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = getDepth(root.left);
            int right = getDepth(root.right);
            res = Math.max(res, left + right);
            return Math.max(left, right) + 1;
        }
    }
}
