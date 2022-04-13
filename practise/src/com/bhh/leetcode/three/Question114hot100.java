package com.bhh.leetcode.three;

/**
 * @author bhh
 * @description 二叉树展开为链表
 * @date Created in 2022-01-30 17:30
 * @modified By
 */
public class Question114hot100 {
    class Solution {
        /*
        方法一 : 将左节点转换到右节点, 原来右节点改变到尾部
        方法二 : 先序遍历, 记录前一个节点, 进行拼接
         */
        public void flatten(TreeNode root) {
            if (root == null) {
                return;
            }
            flatten(root.left);
            flatten(root.right);
            TreeNode right = root.right;
            root.right = root.left;
            root.left = null;
            TreeNode left = root;
            while (left != null && left.right != null) {
                left = left.right;
            }
            left.right = right;
        }

        TreeNode pre = null;
        public void flattenTwo(TreeNode root) {
            if (root == null) {
                return;
            }
            if (pre != null) {
                pre.left = null;
                pre.right = root;
            }
            pre = root;
            TreeNode right = root.right;
            flatten(root.left);
            flatten(right);
        }
    }
}
