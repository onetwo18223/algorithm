package com.bhh.leetcode.four.tree;

/**
 * @author bhh
 * @description 验证二叉搜索树
 * @date Created in 2022-03-04 19:43
 * @modified By
 */
public class Question98 {
    class Solution {
        /*
        二叉搜索树判断条件
            左子树小于node
            右子树大于node
        注意 : 左子树的右节点不仅需要满足小于node, 还需要满足大于左子树root
                所以需要使用上限和下限
         */
        public boolean isValidBST(TreeNode root) {
            return judge(root, Long.MAX_VALUE, Long.MIN_VALUE);
        }

        private boolean judge(TreeNode root, long maxValue, long minValue) {
            if (root == null) {
                return true;
            }
            if (root.val >= maxValue || root.val <= minValue) {
                return false;
            }
            return judge(root.left, root.val, minValue) &&
                    judge(root.right, maxValue, root.val);
        }
    }
}
