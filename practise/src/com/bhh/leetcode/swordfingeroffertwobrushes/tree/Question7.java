package com.bhh.leetcode.swordfingeroffertwobrushes.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bhh
 * @description 重建二叉树
 * @date Created in 2022-01-14 9:55
 * @modified By
 */
public class Question7 {
    class Solution {
        /*
        从前序和中序生成二叉树
        前序找父节点, 中序找父节点索引, 然后判断左右节点
        将中序
        参数肯定是需要俩个数组的开始, 结束索引
         */
        Map<Integer, Integer> map = new HashMap();

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder == null || inorder == null || preorder.length == 0) {
                return new TreeNode();
            }
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        }

        private TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
            if (preEnd == preStart) {
                return new TreeNode(preStart);
            }
            // 找前序第一个元素
            int firstEle = preorder[preStart];
            TreeNode node = new TreeNode(firstEle);
            // 该元素在inorder中的索引
            Integer inIndex = map.get(firstEle);
            node.left = build(preorder, preStart + 1, preStart + (inIndex - inStart),
                    inorder, inStart, inIndex - 1);
            node.right = build(preorder, preStart + (inIndex - inStart) + 1, preEnd,
                    inorder, inIndex + 1, inEnd);
            return node;
        }
    }
}
