package com.bhh.leetcode.swordfingeroffer.tree;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author bhh
 * @description 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * 4,8,6,12,16,14,10 left->postorder_left + index - inorder_left - 1 | postorder_left + index - inorder_left -> right - 1
 * 4,6,8,10,12,14,16 left-> index-1 | index + 1->right
 * <p>
 * 1,2,5,10,6,9,4,3
 * 1,2,3,4,5,6,9,10
 * <p>
 * 1,6,3,2,5
 * 1,2,3,5,6
 * @date Created in 2021-10-03 20:03
 * @modified By
 */
public class Question33 {
    class Solution {
        /*
        实现思路 : 因为树是二叉搜索树, 而给的参数是后续遍历结果
        将后序遍历进行排序, 生成中序遍历结果集合
        中序遍历和后序遍历共同生成树, 若是可以生成则返回true

        递归
        结束条件 : 数组越界 返回true, 当 俩个数组 len 不同时, 返回false
        递归条件 :
        node.left = buildTree(inorder_left , index - 1, postorder_left, index - 1)
        node.right = buildTree(index + 1, inorder_right, index, postorder_right - 1)

         */
        private HashMap<Integer, Integer> map = new HashMap<>();

        public boolean verifyPostorder(int[] postorder) {
            // 后续集合
            int[] nums = Arrays.copyOf(postorder, postorder.length);
            // 排序, 中序集合
            Arrays.sort(postorder);
            for (int i = 0; i < postorder.length; i++) {
                map.put(postorder[i], i);
            }
            return buildTree(postorder, nums, 0, postorder.length - 1, 0, postorder.length - 1);
        }

        private boolean buildTree(int[] inorder, int[] postorder, int inorderLeft,
                                  int inorderRight, int postorderLeft, int postorderRight) {
            if (inorderLeft > inorderRight) {
                return true;
            }

            int tmp = 1;
            for (int i = inorderLeft; i <= inorderRight; i++) {
                tmp ^= inorder[i];
            }
            for (int i = postorderLeft; i <= postorderRight; i++) {
                tmp ^= postorder[i];
            }
            if (tmp != 1) {
                return false;
            }
            // 根节点
            int root = postorder[postorderRight];
            int index = map.get(root);
            if (!buildTree(inorder, postorder, inorderLeft, index - 1, postorderLeft, postorderLeft + index - inorderLeft - 1))
                return false;

            if (!buildTree(inorder, postorder, index + 1, inorderRight, postorderLeft + index - inorderLeft, postorderRight - 1))
                return false;
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question33().new Solution().verifyPostorder(new int[]{
                1, 2, 3, 4, 5
        }));
    }
}
