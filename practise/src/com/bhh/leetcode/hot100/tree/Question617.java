package com.bhh.leetcode.hot100.tree;

/**
 * @author bhh
 * @description 合并二叉树
 * @date Created in 2021-12-26 14:19
 * @modified By
 */
public class Question617 {
    class Solution {
        /*
        重构, dfs
         */
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            if (root1 == null && root2 == null) {
                return null;
            }
            if (root1 != null) {
                return root2;
            }
            if (root2 != null) {
                return root1;
            }
            root1.val = root1.val + root2.val;
            root1.left = mergeTrees(root1.left, root2.left);
            root1.right = mergeTrees(root1.right, root2.right);
            return root1;
        }
    }
}
