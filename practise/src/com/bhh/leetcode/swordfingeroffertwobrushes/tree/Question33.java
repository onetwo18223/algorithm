package com.bhh.leetcode.swordfingeroffertwobrushes.tree;

/**
 * @author bhh
 * @description 二叉搜索树的后序遍历序列
 * @date Created in 2022-01-14 15:18
 * @modified By
 */
public class Question33 {
    /*
    二叉搜索树的判断,
    根据前序后序来判断是否是二叉搜索树要看左右子树是否符合大小关系
    先找到左右子树
    后序遍历, 父节点是最后一个node, 右子树时大于node的部分, 而其余部分为左子树, 必须小于node
     */
    class Solution {
        public boolean verifyPostorder(int[] postorder) {
            if (postorder == null || postorder.length == 0) {
                return true;
            }
            return judge(postorder, 0, postorder.length - 1);
        }

        private boolean judge(int[] postorder, int left, int right) {
            if (left >= right) {
                return true;
            }
            // 父节点
            int node = postorder[right];
            // 寻找左子树开始点
            int leftNodeIndex = right;
            while (leftNodeIndex >= 0 && postorder[leftNodeIndex] >= node) {
                leftNodeIndex--;
            }
            // 继续向左, 判断是否全部都是小于node
            int index = leftNodeIndex;
            while (index >= 0) {
                if (postorder[index] > node) {
                    return false;
                }
                index--;
            }
            return judge(postorder, left, leftNodeIndex)
                    && judge(postorder, leftNodeIndex + 1, right - 1);
        }
    }
}
