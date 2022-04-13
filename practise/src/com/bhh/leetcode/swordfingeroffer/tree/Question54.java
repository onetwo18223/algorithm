package com.bhh.leetcode.swordfingeroffer.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bhh
 * @description 二叉搜索树的第k大节点
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 * @date Created in 2021-09-30 10:39
 * @modified By
 */
public class Question54 {
    class Solution {
        /*
        实现思路 : 因为是二分搜索树,  中序遍历是会按照从小到大顺序输出
        中序遍历, 结果存储在list集合, 遍历完之后, 通过size() - k获取结果值
         */
        private List<Integer> list = new ArrayList<>();
        public int kthLargest(TreeNode root, int k) {
            inorder(root);

            return list.get(list.size() - k);
        }

        private TreeNode inorder(TreeNode node) {
            if (node == null){
                return null;
            }
            node.left = inorder(node.left);
            list.add(node.val);
            node.right = inorder(node.right);
            return node;
        }
    }

    class SolutionTest {
        /*
        实现思路 : 因为是二分搜索树,  中序遍历是会按照从小到大顺序输出
        中序遍历, 结果存储在list集合, 遍历完之后, 通过size() - k获取结果值
         */
        private int res = 0, k;
        public int kthLargest(TreeNode root, int k) {
            this.k = k;
            inorder(root);
            return res;
        }

        private void inorder(TreeNode node) {
            if (node == null){
                return;
            }
            inorder(node.right);
//            if (k == 0) return;
            if (--k == 0){
                res = node.val;
            }
            inorder(node.left);
        }
    }
}
