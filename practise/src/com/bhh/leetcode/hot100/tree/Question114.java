package com.bhh.leetcode.hot100.tree;

/**
 * @author bhh
 * @description 二叉树展开为链表
 * @date Created in 2021-12-24 20:43
 * @modified By
 */
public class Question114 {
    class Solution {
        /*
        使用后序遍历,
        node左接右子树, 右子树尾部接左子树
         */
        public void flatten(TreeNode root) {
            if (root == null){
                return;
            }
//            dfs(root);
            flatten(root.left);
            flatten(root.right);
            TreeNode right = root.right;
            root.right = root.left;
            root.left = null;
            // 遍历到右子树末端
            while (root.right != null) {
                root = root.right;
            }
            root.right = right;
        }
    }
}
