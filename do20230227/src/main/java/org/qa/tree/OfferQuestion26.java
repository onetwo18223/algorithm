package org.qa.tree;

/**
 * @Desc 树的子结构
 * https://leetcode.cn/problems/shu-de-zi-jie-gou-lcof/
 * @Author Bhh
 * @Date 2023-04-04 13:48
 * @Version 1.0
 */
public class OfferQuestion26 {
    {
        /* 实现；
        本题可以分类为二叉树查询
        题意很好理解，判断TreeB是否是TreeA的子树，
        需要分为俩个步骤
        第一步获取起点，遍历树获取treeA == treeB，
            结束条件为treeA == null || treeB == null 返回
        第二步从获取到的起点开始进行遍历判断是否相等，
            结束条件为treeB == null，返回true 反之返回 false
         */
    }
    class Solution {
        public boolean isSubStructure(TreeNode treeA, TreeNode treeB) {
            if(null == treeA || null == treeB) return false;
            return this.doJudge(treeA, treeB) ||
                    this.isSubStructure(treeA.left, treeB) ||
                    this.isSubStructure(treeA.right, treeB);
        }

        private boolean doJudge(TreeNode treeA, TreeNode treeB) {
            if (null == treeB) return true;
            if (null == treeA || treeA.val != treeB.val) return false;
            return doJudge(treeA.left, treeB.left) &&
                    doJudge(treeA.right, treeB.right);
        }
    }
}
