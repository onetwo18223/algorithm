package com.bhh.leetcode.hot100twobrushes.array.sort;

import com.bhh.leetcode.hot100twobrushes.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bhh
 * @description 从前序与中序遍历序列构造二叉树
 * @date Created in 2022-01-22 16:37
 * @modified By
 */
public class Question105 {
    class Solution {
        /*
        前序和中序构造二叉树
        pre : 3,9,20,15,7 第一个元素为根节点
        in : 9,3,15,20,7
         */
        private Map<Integer, Integer> map = new HashMap<>();

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            for (int i = 0; i < inorder.length; i++) {
                // 以value做key, 以index做value
                map.put(inorder[i], i);
            }
            return build(preorder, 0, preorder.length - 1,
                    inorder, 0, inorder.length - 1);
        }

        private TreeNode build(int[] preorder, int preStart, int preEnd,
                               int[] inorder, int inStart, int inEnd) {
            if (preStart > preEnd) {
                return null;
            }
            // 取第一个元素
            int tmp = preorder[preStart];
            TreeNode node = new TreeNode(tmp);
            int inIndex = map.get(tmp);
            node.left = build(preorder, preStart + 1, preStart + inIndex - inStart,
                    inorder, inStart, inIndex);
            node.right = build(preorder, preStart + inIndex - inStart + 1,
                    preEnd, inorder, inIndex + 1, inEnd);
            return node;
        }
    }
}
