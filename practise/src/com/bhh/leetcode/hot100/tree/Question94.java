package com.bhh.leetcode.hot100.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bhh
 * @description 二叉树的中序遍历
 * @date Created in 2021-12-26 9:55
 * @modified By
 */
public class Question94 {
    class Solution {
//        private List<Integer> res = new ArrayList<>();
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            inOrder(root, res);
            return res;
        }

        private void inOrder(TreeNode root, List<Integer> res) {
            if (root == null) {
                return;
            }
            inOrder(root.left, res);
            res.add(root.val);
            inOrder(root.right, res);
        }
    }
}
