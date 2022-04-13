package com.bhh.lintcode.tree;

/**
 * @author bhh
 * @description BST中第K小的元素
 * 给一棵二叉搜索树，写一个 KthSmallest 函数来找到其中第 K 小的元素。
 * @date Created in 2021-12-03 16:40
 * @modified By
 */
public class Question902 {
    public class Solution {
        /*
        因为BST中序遍历是升序, 所以输出第K个在中序遍历条件下的数
         */
        private int num;
        public int kthSmallest(TreeNode root, int k) {
            num = k;
            return getK(root).val;
        }

        private TreeNode getK(TreeNode root) {
            if (root == null) {
                return null;
            }
            TreeNode leftNode = getK(root.left);
            if (leftNode != null && num == 0) {
                return leftNode;
            }
            if (num == 0) {
                return root;
            }
            num--;
            TreeNode rightNode = getK(root.right);
            if (rightNode != null && num == 0) {
                return rightNode;

            }
            return root;
        }
    }
}
