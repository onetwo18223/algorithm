package com.bhh.leetcode.hot100.tree;

import javax.swing.*;

/**
 * @author bhh
 * @description 路径总和 III
 * @date Created in 2021-12-26 13:06
 * @modified By
 */
public class Question437 {
    class Solution {
        /*
        查询, DFS, 先序
         */
        private int num = 0;
        public int pathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return num;
            }
            dfs(root, targetSum - root.val);
            pathSum(root.left, targetSum);
            pathSum(root.right, targetSum);
            return num;
        }

        // 注意 : 组合获取target时, 如果找到target就直接返回, 后续情况会被忽略
        private void dfs(TreeNode node, int targetSum) {
            if (targetSum == 0){
                num++;
//                return;
            }
            if (node.left != null) {
                dfs(node.left, targetSum - node.left.val);
            }
            if (node.right != null) {
                dfs(node.right, targetSum - node.right.val);
            }
        }
    }
}
