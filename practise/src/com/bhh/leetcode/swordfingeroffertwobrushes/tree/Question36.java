package com.bhh.leetcode.swordfingeroffertwobrushes.tree;

/**
 * @author bhh
 * @description 二叉搜索树与双向链表
 * @date Created in 2022-01-14 10:41
 * @modified By
 */
public class Question36 {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
    class Solution {
        /*
        重构, 中序遍历
         */
        private Node preNode, head;
        public Node treeToDoublyList(Node root) {
            if (root == null) {
                return null;
            }
            dfs(root);
            root.left = preNode;
            preNode.right = root;
            return head;
        }

        private void dfs(Node root) {
            if (root == null) {
                return;
            }
            dfs(root.left);
            if (preNode != null) {
                preNode.right = root;
                root.left = preNode;
            } else {
                head = root;
            }
            preNode = root;
            dfs(root.right);
        }
    }
}
