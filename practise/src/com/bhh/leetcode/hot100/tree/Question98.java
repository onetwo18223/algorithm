package com.bhh.leetcode.hot100.tree;

/**
 * @author bhh
 * @description 验证二叉搜索树
 * @date Created in 2021-12-26 15:26
 * @modified By
 */
public class Question98 {
    class Solution {
        /*
        中序遍历定然可以解决问题
        查询, DFS, 先序
        错误思想 :
            验证二叉搜索树, 并非只是 左节点 < node < 右节点
            而是 左子树 < node < 右子树
        错误例子 :
            5
        1       6
            2       7
        这并不是一颗二分搜索树, 因为2<5,
        但是按照 isValidBSTError() 返回true,
            因为对于2只考虑了小于6但没有考虑需要>5
         */
        public boolean isValidBSTError(TreeNode root) {
            if (root == null) {
                return true;
            }
            if (root.left != null && root.val <= root.left.val
                    || (root.right != null && root.val >= root.right.val)) {
                return false;
            }
            if (!(isValidBSTError(root.left) && isValidBSTError(root.right))){
                return false;
            }
            return true;
        }

        /*
        设置上界和下界
        左子树传入上界, 右子树传入下界
            这样的情况, 即使右子树的左子树不仅会上界, 且有下界, 符合题意
        判断左子树, 右子树
         */
        public boolean isValidBST(TreeNode root) {
            return judge(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        private boolean judge(TreeNode root, long lower, long upper) {
            if (root == null) {
                return true;
            }
            // 上界赋给左子树, 下界赋值给右子树
            // 这个节点值大于上界 或者 小于下界
            if (root.val >= upper || root.val <= lower) {
                return false;
            }
            return judge(root.left, lower, root.val) && judge(root.right, root.val, upper);
        }

    }
}
