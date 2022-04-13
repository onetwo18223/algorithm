package com.bhh.leetcode.swordfingeroffer.tree;

/**
 * @author bhh
 * @description 平衡二叉树
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
 * 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 * @date Created in 2021-09-30 17:50
 * @modified By
 */
public class Question55_2 {
    class Solution {
        /*
        实现思路 :
        题目涉及深度问题, 可以使用DFS实现
        结束条件 : if(node == null) return 0;
        递归条件 : 左节点深度减去右节点深度, 判断 是否 > 1,
                若是则直接返回-1
                不是则返回depth
        注意点 : 若是递归返回-1, 则所有回溯都要返回-1
         */
        public boolean isBalanced(TreeNode root) {
            return dfs(root) != -1;
        }

        private int dfs(TreeNode node) {
            // 叶子节点的子节点返回null
            if (node == null) {
                return 0;
            }

            // 获取关于左节点的深度
            int left = dfs(node.left);
            if (left == -1) return -1;
            // 获取关于右节点的深度
            int right = dfs(node.right);
            if (right == -1) return -1;
            // 判断深度差是否大于1, 不是则返回该节点深度
            return Math.abs(left - right) > 1 ? -1 :
                    Math.max(left, right) + 1;
        }
    }
}
