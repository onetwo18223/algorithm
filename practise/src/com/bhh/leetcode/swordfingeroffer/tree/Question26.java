package com.bhh.leetcode.swordfingeroffer.tree;

import com.bhh.leetcode.swordfingeroffer.dynamic.Question42;

/**
 * @author bhh
 * @description 树的子结构
 * @date Created in 2021-10-12 14:08
 * @modified By
 */
public class Question26 {
    class Solution {
        /*
        这道题实现思路类似于
        二维数组 Question12

        总结 : 思路没错, 进行前序遍历 + 判断, 但是判断也是依赖递归完成,
        也就是递归 + 递归完成

        收获 : 递归 嵌套 递归实现
        递归的返回值我认为一直是递归中不好解决的问题
         */
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            if (A == null || B == null) return false;

            // pre指对于A节点与B节点比较结果
            // 后俩个方法值 A其他节点与B节点的比较结果
            // 总之只要有一个true就是有这个子结构树
            return pre(A, B) || isSubStructure(A.left, B) ||
                    isSubStructure(A.right, B);
        }

        /**
         * 递归嵌套, 进行判断
         */
        private boolean pre(TreeNode a, TreeNode b) {
            if (b == null) return true;
            if (a == null || a.val != b.val) return false;
            return pre(a.left, b.left) && pre(a.right, b.right);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question26().new Solution().isSubStructure(
                TreeUtil.getInstance(), TreeUtil.getInstance()));
    }
}
