package com.bhh.leetcode.hot100.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bhh
 * @description 打家劫舍 III
 * @date Created in 2021-12-26 14:43
 * @modified By
 */
public class Question337 {
    class Solution {
        /*
        这道题用递推是最优解, 但是在二叉树中, 那么使用DFS也可以完成
        题意 : 要么选择爷爷 + 儿子字节, 要么选择 父节点 而放弃 爷爷 + 儿子 节点
        也就是一直跳一个节点单位
         */
        private Map<TreeNode, Integer> map = new HashMap<>();
        public int rob(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int value = root.val;
            if (root.left != null) {
                value = value
                        + getValue(root.left.left)
                        + getValue(root.left.right);
            }
            if (root.right != null) {
                value = value
                        + getValue(root.right.left)
                        + getValue(root.right.right);
            }

            return Math.max(value, getValue(root.left) + getValue(root.right));
        }

        private int getValue(TreeNode node) {
            int value;
            if (map.containsKey(node)) {
                value = map.get(node);
            } else {
                value = rob(node);
                map.put(node, value);
            }
            return value;
        }
    }
}
