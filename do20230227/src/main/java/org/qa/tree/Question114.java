package org.qa.tree;

/**
 * @Desc 二叉树展开为链表
 * https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/
 * right 子指针指向链表中下一个结点，而左子指针始终为 null
 * @Author Bhh
 * @Date 2023-04-04 15:59
 * @Version 1.0
 */
public class Question114 {
    {
        /* 实现：
        后序遍历
        先将左右子树结构进行调整
        调整为：
            将左子树转移到右子树，设置node.left = null
            向右遍历到结尾处，添加原先的右链表到结尾
         */
    }
    class Solution {
        public void flatten(TreeNode root) {
            if (null == root) return;
            flatten(root.left);
            flatten(root.right);
            TreeNode left = root.left;
            TreeNode right = root.right;
            if (left == null) return;
            // 左子树必须为null
            root.left = null;
            // 将左子树添加到right端
            root.right = left;
            // 遍历到添加的结尾
            TreeNode tmp = root;
            while(tmp.right != null) tmp = tmp.right;
            // 在结尾拼接之前的right子树
            tmp.right = right;
        }
    }
}
