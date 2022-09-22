package org.problem.binarytree;

/**
 * 树的子结构
 *
 * 实现：本题其实思路如果正确的话就比较简单，但是这个思路不容易想到
 *      本题需要次递归遍历，第一次遍历A树的节点和B树Root节点，
 *      另一个遍历A节点和B节点判断是否相同
 */
public class OfferQuestion26 {
    class Solution {
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            if (A == null || B == null) return false;
            return compare(A, B) || isSubStructure(A.left, B)
                    ||isSubStructure(A.right, B);
        }

        private boolean compare(TreeNode a, TreeNode b) {
            if (b == null) return true;
            if (a == null || a.val != b.val) return false;
            return compare(a.left, b.left)
                    && compare(a.right, b.right);
        }
    }
}
