package com.bhh.leetcode.hot100twobrushes.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bhh
 * @description 二叉树的中序遍历
 * @date Created in 2022-01-23 13:36
 * @modified By
 */
public class Question94 {
    class Solution {
        List<Integer> res = new ArrayList<>();
        public List<Integer> inorderTraversal(TreeNode root) {
            dfs(root);
            return res;
        }

        private void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            dfs(root.left);
            res.add(root.val);
            dfs(root.right);
        }
    }
}
