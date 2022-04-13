package com.bhh.leetcode.swordfingeroffer.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author bhh
 * @description 二叉树中和为某一值的路径
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
 * 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * @date Created in 2021-10-03 19:23
 * @modified By
 */
public class Question34 {
    class Solution {
        /*
        实现原理 : 使用前序遍历, 遍历节点,

        递归过程 :
        每次添加节点到集合,
        且若是 taget == 0 && node.right || left == null, res.add(path)
        若是节点不合适, 则在遍历完之后path.removeLast

        收获 : 在递归最后一步, 也就是回溯阶段, 将节点删除处理
        回溯这个步骤处理很重要,
        遍历是将节点加入集合, 而回溯是将本个节点进行删除
         */
        LinkedList<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();

        public List<List<Integer>> pathSum(TreeNode root, int target) {
            recur(root, target);
            return res;
        }

        private void recur(TreeNode node, int target) {
            if (node == null) {
                return;
            }
            path.add(node.val);
            target -= node.val;
            if (target == 0 && node.right == null && node.left == null) {
                res.add(new ArrayList<>(path));
            }
            recur(node.left, target);
            recur(node.right, target);
            path.removeLast();
        }

    }
}
