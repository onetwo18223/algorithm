package com.bhh.leetcode.hot100twobrushes.tree;

/**
 * @author bhh
 * @description 路径总和 III
 * @date Created in 2022-01-23 13:46
 * @modified By
 */
public class Question437 {
    class Solution {
        /*
        需要先遍历一遍寻找dfs()起始点
        dfs()寻找节点形成targetSum
         */
        int count = 0;
        int targetSum;

        public int pathSum(TreeNode root, int targetSum) {
            this.targetSum = targetSum;
            dfs(root);
            return count;
        }

        private void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            // 调用dfs() 寻找路劲
            dfs(root, targetSum);
            // 遍历节点寻找起始点
            dfs(root.left);
            dfs(root.right);
        }

        private void dfs(TreeNode root, int target) {
            if (root == null) {
                return;
            }
            target = target - root.val;
            if (target == 0) {
                count++;
            }
            dfs(root.left, target);
            dfs(root.right, target);
        }
    }
}
