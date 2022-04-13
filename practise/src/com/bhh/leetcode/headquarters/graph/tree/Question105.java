package com.bhh.leetcode.headquarters.graph.tree;

import java.util.HashMap;

/**
 * @author bhh
 * @description 从前序与中序遍历序列构造二叉树
 * 给定一棵树的前序遍历 preorder 与中序遍历  inorder。
 * 请构造二叉树并返回其根节点。
 * @date Created in 2021-09-29 12:09
 * @modified By
 */
public class Question105 {
    class Solution {
        /*
        实现思路 : 经典例题
        给你前序, 中序, 后序来完成二叉树的构建
        给前序和中序可以构建唯一二叉树
        给中序和后序可以构建唯一二叉树
        但是给前序和后序构建的二叉树不唯一

        实现思路 :
        preorder第一个节点便是根节点, 将根节点提取,
        然后在inorder中寻找根节点对应的索引, inorder向左的索引为左子树, 向右的索引为右子树
        递归遍历, 直到越界
        递归方法 : 参数为preorder, inorder, preorder_left, preorder_right, inorder_left, inorder_right
                 返回TreeNode,
                 结束条件 : if(preorder_left > preorder_right || inorder_left > inorder_right)
                 递归循环 : node.left = buildTree(preorder, inorder, preorder_left + 1,
                                                inorder_root_index - inorder_left + preorder_left, inorder_left, inorder_root_index-1)
                          node.right = buildTree(preorder, inorder, inorder_root_index - inorder_left + preorder_left + 1,
                                                preorder_right, inorder_root_index + 1, inorder_right)

         */
        // 存储关于中序遍历的元素的信息, 分别是 节点在树中的索引 和 节点在数组中的索引位置
        private HashMap<Integer, Integer> indexMap;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            indexMap = new HashMap<>();
            int inLen = inorder.length;
            for (int i = 0; i < inLen; i++) {
                indexMap.put(inorder[i], i);
            }
            return buildTree(preorder, inorder, 0, inLen - 1, 0, inLen - 1);
        }

        private TreeNode buildTree(int[] preorder, int[] inorder, int preLeft, int preRight,
                                   int inLeft, int inRight) {

            if (preLeft > preRight) {
                return null;
            }

            TreeNode root = new TreeNode(preorder[preLeft]);
            // 根节点在中序遍历中的位置
            Integer inIndex = indexMap.get(root.val);

            root.left = buildTree(preorder, inorder,
                    preLeft + 1, inIndex - inLeft + preLeft, inLeft, inIndex - 1);
            root.right = buildTree(preorder, inorder,
                    inIndex - inLeft + preLeft + 1, preRight, inIndex + 1, inRight);
            return root;
        }
    }

    public static void main(String[] args) {

        TreeNode treeNode = new Question105().new Solution().buildTree(new int[]{
                3, 9, 20, 15, 7
        }, new int[]{
                9, 3, 15, 20, 7
        });

//        Queue<TreeNode> queue = new ConcurrentLinkedQueue();
//        queue.add(treeNode);
//        while (!queue.isEmpty()) {
//            TreeNode node = queue.remove();
//            System.out.println(node.val);
//            if (node.left != null) {
//                queue.add(node.left);
//            }
//            if (node.right != null) {
//                queue.add(node.right);
//            }
//        }

        postOrder(treeNode);
    }

    private static void postOrder(TreeNode treeNode) {
        if (treeNode == null){
            return;
        }
        postOrder(treeNode.left);
        postOrder(treeNode.right);
        System.out.println(treeNode.val);
    }
}
