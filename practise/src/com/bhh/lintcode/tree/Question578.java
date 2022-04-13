package com.bhh.lintcode.tree;

/**
 * @author bhh
 * @description 最近公共祖先 III
 * <p>
 * 类型一 : 二叉树上求值，求路径
 * @date Created in 2021-12-03 15:20
 * @modified By
 */
public class Question578 {
    public class Solution {
        /*
        这道题相对于 Question88 最近公共祖先 来说, 添加了一个条件在于 "这两个节点未必都在这棵树上出现"
        所以现在需要完成
        1. 判断这俩个节点是否存在
            需要遍历所有节点, 所以先序中序都不适用, 后序更加适用
            提出俩个属性, 判断节点是否存在
            因为分治法返回符合题意要求是TreeNode, 而不是boolean, 所以boolean设置为全局变量
        2. 寻找公共祖先
            将先序条件转到后序
         */
        private boolean existA;
        private boolean existB;

        public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
            existA = false;
            existB = false;
            TreeNode ancestor = getAncestor(root, A, B);
            if (existA && existB) {
                return ancestor;
            }
            return null;
        }

        private TreeNode getAncestor(TreeNode root, TreeNode a, TreeNode b) {
            if (root == null) {
                return null;
            }

            TreeNode leftNode = getAncestor(root.left, a, b);
            TreeNode rightNode = getAncestor(root.right, a, b);

            if (root == a){
                existA = true;
                return root;
            }
            if (root == b){
                existB = true;
                return root;
            }

            if (leftNode != null && rightNode != null) {
                return root;
            }
            if (leftNode != null) {
                return leftNode;
            }
            if (rightNode != null) {
                return rightNode;
            }
            return null;
        }
    }
}
