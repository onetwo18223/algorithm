package org.problem.binarytree;

/**
 * 二叉树展开为链表
 *
 * 实现：二叉树结构的变化
 * 中序遍历，记录前一个节点，当遍历到根结点是结束
 */
public class Question114 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        TreeNode pre = null;
        public void flatten(TreeNode root) {
            if (root == null) return;
            flatten(root.left);
            // 存储为前一个节点
            TreeNode pre = root.left;
            flatten(root.right);

            if (pre == null) return;
            // 先记录之前的右子树
            TreeNode right = root.right;
            // 连接左子树到右节点
            root.right = pre;
            // 循环获取新链接的左子树的最后一个节点
            // 结束pre.right == null
            while(pre.right != null) pre = pre.right;

            root.left = null;
            // 连接到右子树
            if (right == null) return;
            pre.right = right;
        }
    }
}
