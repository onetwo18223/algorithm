package com.bhh.leetcode.swordfingeroffertwobrushes.tree;

import java.util.*;

/**
 * @author bhh
 * @description 从上到下打印二叉树
 * @date Created in 2022-01-14 14:03
 * @modified By
 */
public class Question32_1 {
    class Solution {
        /*
        层序遍历
         */
        public int[] levelOrder(TreeNode root) {
            if(root == null) {
                return new int[0];
            }
            Queue<TreeNode> queue = new ArrayDeque();
            List<Integer> list = new ArrayList();
            queue.add(root);
            while(!queue.isEmpty()) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
            int[] res = new int[list.size()];
            for(int i = 0; i < list.size(); i++) {
                res[i] = list.get(i);
            }
            return res;
        }
    }
}
