package com.bhh.leetcode.hot100twobrushes.tree;

/**
 * @author bhh
 * @description 二叉树的最大深度
 * @date Created in 2022-01-23 12:00
 * @modified By
 */
public class Question104 {
    class Solution {
        // 后序 查询
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }
    }
}
