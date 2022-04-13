package com.bhh.leetcode.hot100.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author bhh
 * @description 二叉树的层序遍历
 * @date Created in 2021-12-26 11:54
 * @modified By
 */
public class Question102 {
    class Solution {
        /*
        层序输出每一层的情况
         */
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null){
                return res;
            }
            Queue<TreeNode> queue = new ArrayDeque();
            queue.add(root);
            while (!queue.isEmpty()) {
                List<Integer> lists = new ArrayList<>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    lists.add(node.val);
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                res.add(lists);
            }
            return res;
        }
    }
}
