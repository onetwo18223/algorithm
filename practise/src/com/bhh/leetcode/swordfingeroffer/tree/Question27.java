package com.bhh.leetcode.swordfingeroffer.tree;

/**
 * @author bhh
 * @description 二叉树的镜像
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * <p>
 * 示例 1：
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 * @date Created in 2021-09-29 16:05
 * @modified By
 */
public class Question27 {
    class Solution {
        /*
        实现思路 : 以层序遍历
         */
        public TreeNode mirrorTree(TreeNode root) {
            if (root == null) return null;
            TreeNode tmp = root.left;
            root.left = mirrorTree(root.right);
            root.right = mirrorTree(tmp);
            return root;
        }
    }
}
