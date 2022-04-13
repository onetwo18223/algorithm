package com.bhh.leetcode.swordfingeroffer.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author bhh
 * @description 从上到下打印二叉树 II
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 * @date Created in 2021-09-29 20:56
 * @modified By
 */
public class Question32_2 {
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }

            Queue<TreeNode> queue = new ConcurrentLinkedQueue<>(), tmp;
            List<List<Integer>> zList = new ArrayList<>();
            List<Integer> list;
            queue.add(root);
            boolean sign = true;
            while (!queue.isEmpty()) {
                tmp = new ConcurrentLinkedDeque<>();
                list = new ArrayList<>();
                for (TreeNode treeNode : queue) {
                    if (treeNode.left != null) {
                        tmp.add(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        tmp.add(treeNode.right);
                    }
                    list.add(treeNode.val);
                }
                zList.add(list);
                queue = tmp;
                sign = !sign;
            }
            return zList;
        }
    }
}
