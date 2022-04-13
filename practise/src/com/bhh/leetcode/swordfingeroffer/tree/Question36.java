package com.bhh.leetcode.swordfingeroffer.tree;

import com.bhh.leetcode.swordfingeroffer.dynamic.Question42;

/**
 * @author bhh
 * @description 二叉搜索树与双向链表
 * @date Created in 2021-10-03 19:22
 * @modified By
 */
public class Question36 {
    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    class Solution {
        /*
        实现思路 :
        + 由二分搜索树转换为由小到大的双端链表 (二分搜索树的中序遍历)
        + 树的left转换为前驱, right转换为后驱
            + 因为是中序遍历, left -> now -> right, 在now时, 存储当前节点信息到pre(前) pre = node
            到下一个now, pre.right = node, node.left = pre, pre = node
        + 关注第一个节点和最后一个节点
            + 第一个节点 pre == null 时, 不进行 pre.right = node
            + 最后一个节点 pre.right = node, node.left = pre, pre = node 完成了倒数第一个节点的left和right
              此时第一个节点的left和最后一个节点的right是没有赋值的,
              需要另一个来存储第一个节点信息, pre此时存储的是最后一个节点

        收获 : 树类问题, 一般和递归有关, 查找规律, 可以使用叶子节点 + root下的左右子树来查找规律
            特殊情况 : 二分搜索树, 惯用中序遍历可以获取升序数组, 或者是倒叙中序遍历, 可获取降序数组

         */
        private Node pre;
        private Node head;

        public Node treeToDoublyList(Node root) {
            if (root == null) return null;
            this.pre = null;
            this.head = null;
            re(root);
            head.left = pre;
            pre.right = head;
            return head;
        }

        private void re(Node node) {
            if (node == null) return;
            re(node.left);
            if (pre == null) {
                head = node;
            } else {
                pre.right = node;
                node.left = pre;
            }
            pre = node;
            re(node.right);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question36().new Solution().treeToDoublyList(
                new Node(4, new Node(2, new Node(1), new Node(3)), new Node(5))));
    }
}
