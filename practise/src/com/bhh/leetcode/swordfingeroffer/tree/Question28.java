package com.bhh.leetcode.swordfingeroffer.tree;

/**
 * @author bhh
 * @description 对称的二叉树
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。
 * 如果一棵二叉树和它的镜像一样，那么它是对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * @date Created in 2021-09-29 17:51
 * @modified By
 */
public class Question28 {
    class Solution {
        /*
        实现思路 : 因为需要比较的节点处于一层的俩个极端位置,
        所以不同于前序遍历等一次只遍历一个节点, 需要一次遍历俩个节点
        每次比较俩个节点是否相等, 若是相等则继续遍历 左节点的左和右节点的右, 左节点的右和右节点的左
        俩个遍历的结果共同决定返回

        收获 :
        关于树的很多题都可以使用递归来实现, 关于递归
            很多是重塑树,(删除节点)
            也有一部分是返回某一个节点,(查询最大小节点)
            也有是遍历输出,(前序遍历和该问题)
                该问题也是遍历, 不同点在于前序遍历是每次都是循环一个节点, 而该遍历是每次循环俩个节点
         */
        public boolean isSymmetric(TreeNode root) {
            return root == null ? true : isSymmetric(root.left, root.right);
        }

        private boolean isSymmetric(TreeNode left, TreeNode right) {
            if (left == null && right == null) return true;
            if (left == null || right == null || left.val != right.val) return false;
            return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        }
    }
}
