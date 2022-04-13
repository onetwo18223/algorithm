package com.bhh.leetcode.swordfingeroffertwobrushes.tree;

/**
 * @author bhh
 * @description 二叉树的深度
 * @date Created in 2022-01-14 14:14
 * @modified By
 */
public class Question55_1 {
    class Solution {
        /*
        求最大深度
         */
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }
}
