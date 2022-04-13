package com.bhh.lintcode.tree;

/**
 * @author bhh
 * @description 最近公共祖先
 * <p>
 * 类型一 : 二叉树上求值，求路径
 * @date Created in 2021-12-03 12:32
 * @modified By
 */
public class Question88 {
    public class Solution {
        /*
        类型一 : 二叉树上求值，求路径
        一般返回的都是Node/path集合
        这道题是需要返回Node节点, 需要思考如何返回?
        + 思考, 分治法是先序中序还是后序
            先序 : 该node符合某个条件, 就直接返回
            后序 : 整合leftNode和rightNode的结果, 进行处理返回
            都需要
        + 情况 :
         1          1
        1 A        A B
       1   B
         */
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
            if (root == null) {
                return null;
            }
            if (root == A || root == B) {
                return root;
            }
            TreeNode leftNode = lowestCommonAncestor(root.left, A, B);
            TreeNode rightNode = lowestCommonAncestor(root.right, A, B);
            if (leftNode != null && rightNode != null){
                return root;
            }
            if (leftNode != null){
                return leftNode;
            }
            if (rightNode != null){
                return rightNode;
            }
            return null;
        }
    }
}
