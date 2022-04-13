package com.bhh.leetcode.hot100twobrushes.tree;

/**
 * @author bhh
 * @description 二叉树展开为链表
 * @date Created in 2022-01-23 13:11
 * @modified By
 */
public class Question114 {
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
        /*
        转换为链表, 转换后的链表为先序遍历情况
        node->node.left->node.right
        单节点 先序和后序 结构
         */
        TreeNode pre = new TreeNode();

        public void flatten(TreeNode root) {
            if (root == null) {
                return;
            }
            TreeNode right = root.right;
            pre.right = root;
            pre = root;
            flatten(root.left);
            root.left = null;
            flatten(right);
        }
    }
}
