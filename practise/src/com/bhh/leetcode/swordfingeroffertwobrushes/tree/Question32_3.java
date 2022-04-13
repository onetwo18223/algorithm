package com.bhh.leetcode.swordfingeroffertwobrushes.tree;

import java.util.*;

/**
 * @author bhh
 * @description 从上到下打印二叉树 III
 * @date Created in 2022-01-14 14:43
 * @modified By
 */
public class Question32_3 {
    class Solution {
        /*
        第一行按照从左到右的顺序打印
        第二层按照从右到左的顺序打印
        第三行再按照从左到右的顺序打印
         */
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                LinkedList<Integer> list = new LinkedList<>();
                for (int i = queue.size() - 1; i >= 0; i--) {
                    TreeNode element = queue.poll();
                    if (element.left != null) {
                        queue.add(element.left);
                    }
                    if (element.right != null) {
                        queue.add(element.right);
                    }
                    // 偶数层, 从左到右
                    if (res.size() % 2 == 0) {
                        list.addLast(element.val);
                    } else {
                        list.addFirst(element.val);
                    }
                }
                res.add(list);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        for (List<Integer> integers : new Question32_3().new Solution().levelOrder(TreeUtil.getInstance())) {
            System.out.println(integers);
        }
    }
}
