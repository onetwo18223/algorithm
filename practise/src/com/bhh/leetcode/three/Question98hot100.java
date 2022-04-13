package com.bhh.leetcode.three;

/**
 * @author bhh
 * @description 验证二叉搜索树
 * @date Created in 2022-01-30 22:19
 * @modified By
 */
public class Question98hot100 {
    class Solution {
        /*
        验证方法 : 限定上限和下限
         */
        public boolean isValidBST(TreeNode root) {
            return dfs(root, Long.MAX_VALUE, Long.MIN_VALUE);
        }

        private boolean dfs(TreeNode root, long top, long floor) {
            if (root == null) {
                return true;
            }
            if (root.val > floor && root.val < top) {
                return dfs(root.left, root.val, floor) &&
                        dfs(root.right, top, root.val);
            } else {
                return false;
            }
        }
    }
}
