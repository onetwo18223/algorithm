package com.bhh.leetcode.swordfingeroffertwobrushes.tree;

/**
 * @author bhh
 * @description 树的子结构
 * @date Created in 2022-01-13 14:18
 * @modified By
 */
public class Question26 {
    class Solution {
        /*
        一定是dfs, 但是是俩个节点一起进入方法
        如果值相等
         */
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            if (A == null || B == null) {
                return false;
            }
            return dfs(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }

        private boolean dfs(TreeNode a, TreeNode b) {
            if (b == null) {
                return true;
            }
            if (a == null || a.val != b.val) {
                return false;
            }
            // 为什么这里使用的是 &&, 而不是 ||
            // 毕竟TreeB是有可能没有某一个左/右节点
            // 但是我们一想, 如果B树, 没某一个节点,
            // 那么它也应该是null, 也是先结束返回true
            return dfs(a.left, b.left) && dfs(a.right, b.right);
        }
    }
}
