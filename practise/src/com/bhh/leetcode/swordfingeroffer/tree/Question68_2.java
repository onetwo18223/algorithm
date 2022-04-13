package com.bhh.leetcode.swordfingeroffer.tree;

/**
 * @author bhh
 * @description 二叉树的最近公共祖先
 * @date Created in 2021-10-03 16:08
 * @modified By
 */
public class Question68_2 {
    class Solution {
        /*
        实现思路 : while循环遍历 p 节点的父节点, 若是父节点 == q, 或者父节点 == q.父节点
        则循环终止
        但是父节点因为不是顺序满二叉树所以不能通过公式寻找
        所以只能通过后序遍历, 来获取指定节点

        几种情况分析 :
            若是root == q || root == p 返回 root
            若是p,q不在同一侧子树, 则返回root

        收获 : 这个递归是在判断p,q是否是属于哪一个节点
        将单独节点方法了树当中, 易于遍历
        会一直通过遍历来寻找p,q的公共祖先
        单个 lowestCommonAncestor寻找的其实是 有等于p,q的节点, 就将这个节点返回, 也就是说将这个节点向上推一层
        例如 : 1
            2  3
          4 5  6 7
          寻找5和7
          第3次方法过后(5 == p,5在遍历时替代了2的位置(没有造成实际结构变化)) :
                1
              5   3
                 6  7

          第5次方法后(7 == q, 7在便利时替代了3的位置) :
                1
              5   7
          第6次 :
          返回1
         */
        public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root == p || root == q) return root;
            TreeNode left = lowestCommonAncestor1(root.left, p, q);
            TreeNode right = lowestCommonAncestor1(root.right, p, q);
            if (left == null) return right;
            if (right == null) return left;
            return root;
        }

        public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root == p || root == q) return root;
            TreeNode left = lowestCommonAncestor2(root.left, p, q);
            TreeNode right = lowestCommonAncestor2(root.right, p, q);
            if (left == null) return right;
            if (right == null) return left;
            return root;
        }
    }
}
