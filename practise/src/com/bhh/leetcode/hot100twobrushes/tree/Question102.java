package com.bhh.leetcode.hot100twobrushes.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author bhh
 * @description 二叉树的层序遍历
 * @date Created in 2022-01-23 9:13
 * @modified By
 */
public class Question102 {
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int len = queue.size();
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < len; i++) {
                    TreeNode node = queue.poll();
                    list.add(node.val);
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                res.add(list);
            }
            return res;
        }
    }
}
