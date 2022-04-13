package com.bhh.lintcode.tree;

/**
 * @author bhh
 * @description 将二叉树拆成链表
 * <p>
 * 类型二 : 二叉树结构变化
 * 这类题一般都是 后序遍历
 * @date Created in 2021-12-03 15:42
 * @modified By
 */
public class Question453 {
    public class Solution {
        /*
        使用先序遍历完成二叉树构造
        分治法, 每一层递归都包含 root, root.left, root.right
        使用属性right = root.right
        root.right = root.left
        root.right.right = right
        递归处理左右节点
        root.left = null

        后序遍历
         */
        public void flatten(TreeNode root) {
            if (root == null) {
//                || (root.right == null && root.left == null)
                return;
            }
            flatten(root.left);
            flatten(root.right);
            TreeNode right = root.right;
            root.right = root.left;
            root.left = null;

            TreeNode node = root;
            while (node.right != null) {
                node = node.right;
            }

            node.right = right;
        }
    }
}
