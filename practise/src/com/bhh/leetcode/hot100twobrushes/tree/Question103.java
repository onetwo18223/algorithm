package com.bhh.leetcode.hot100twobrushes.tree;

import java.util.*;

/**
 * @author bhh
 * @description 二叉树的锯齿形层序遍历
 * @date Created in 2022-02-03 13:26
 * @modified By
 */
public class Question103 {
    class Solution {
        /*
        z字形遍历
        第一层 从右向左
        第二层 从左向右
        第三层 从右向左
        使用Queue接收每层元素, 当层数是偶数时翻转, 当层数是奇数时正常输出
         */
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            boolean sign = true;
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                LinkedList<Integer> list = new LinkedList<>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode element = queue.poll();
                    if (element.left != null) {
                        queue.add(element.left);
                    }
                    if (element.right != null) {
                        queue.add(element.right);
                    }
                    if (sign) {
                        list.addLast(element.val);
                    } else {
                        list.addFirst(element.val);
                    }
                }
                sign = !sign;
                res.add(list);
            }
            return res;
        }
    }
}
