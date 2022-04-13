package com.bhh.leetcode.hot100.tree;

/**
 * @author bhh
 * @description 二叉树的最大深度
 * @date Created in 2021-12-26 9:48
 * @modified By
 */
public class Question104 {
    class Solution {
        /*
        先序
         */
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }
}
