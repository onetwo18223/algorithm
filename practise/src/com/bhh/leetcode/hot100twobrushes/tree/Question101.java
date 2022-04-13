package com.bhh.leetcode.hot100twobrushes.tree;

/**
 * @author bhh
 * @description 对称二叉树
 * @date Created in 2022-01-23 12:04
 * @modified By
 */
public class Question101 {
    class Solution {
        // 多节点 先序 查询
        public boolean isSymmetric(TreeNode root) {
            return judge(root, root);
        }

        private boolean judge(TreeNode node1, TreeNode node2) {
            if (node1 == null && node2 == null) {
                return true;
            }
            if (node1 == null || node2 == null || node1.val != node2.val) {
                return false;
            }
            return judge(node1.left, node2.right) && judge(node1.right, node2.left);
        }
    }
}
