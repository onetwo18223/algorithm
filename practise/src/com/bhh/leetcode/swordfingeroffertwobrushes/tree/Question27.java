package com.bhh.leetcode.swordfingeroffertwobrushes.tree;

/**
 * @author bhh
 * @description 二叉树的镜像
 * @date Created in 2022-01-14 14:22
 * @modified By
 */
public class Question27 {
    class Solution {
        /*
        这道题求的就是镜像,
        对于node-node.left-node.right来说
        就是左子树变成右子树
        按照这个规律走下去就可
        重构 先序
         */
        public TreeNode mirrorTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            TreeNode tmp = root.right;
            root.right = mirrorTree(root.left);
            root.left = mirrorTree(tmp);
            return root;
        }
    }
}
