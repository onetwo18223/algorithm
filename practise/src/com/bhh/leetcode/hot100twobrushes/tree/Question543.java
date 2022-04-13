package com.bhh.leetcode.hot100twobrushes.tree;

/**
 * @author bhh
 * @description 二叉树的直径
 * @date Created in 2022-01-23 11:33
 * @modified By
 */
public class Question543 {
    class Solution {
        /*
        左深度 + 右深度
        求出最大值
        dfs 后序遍历 单节点 查询
         */
        int max = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            if (root == null) {
                return max;
            }
            get(root);
            return max;
        }

        private int get(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = get(root.left);
            int right = get(root.right);
            max = Math.max(max, left + right);
            return Math.max(left, right) + 1;
        }
    }
}
