package org.problem.binarytree;

/**
 * 二叉搜索树中第K小的元素
 *
 * 实现：需要将目标数和第k小的元素中的k设置为全局变量，
 *      因为每次递归k都会递减，
 */
public class Question230 {
    class Solution {
        int k = 0;
        int target = 0;
        public int kthSmallest(TreeNode root, int k) {
            this.k = k;
            if (root == null) return k;
            getTarget(root);
            return target;
        }

        private void getTarget(TreeNode root) {
            if (root == null) return;
            getTarget(root.left);
            if (--k == 0) target = root.val;
            getTarget(root.right);
        }
    }
}
