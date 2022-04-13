package com.bhh.leetcode.swordfingeroffer.tree;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author bhh
 * @description 二分搜索树实现
 * @date Created in 2021-08-27 16:33
 * @modified By
 */
public class Tree {
    public TreeNode root;
    private int size;

    public Tree() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 向二分搜索树中添加新的元素e
    public void add(int value) {
        root = add(root, value);
    }

    /**
     * 添加节点
     * 遍历树, 从左到右, 比较大小, 若是碰到null, 则返回新的节点
     *
     * @param node
     * @param value
     * @return
     */
    private TreeNode add(TreeNode node, int value) {
        if (node == null) {
            size++;
            return new TreeNode(value);
        }
        if (node.val > value) {
            node.left = add(node.left, value);
        } else if (node.val < value) {
            node.right = add(node.right, value);
        }
        return node;
    }

    public boolean contains(int value) {
        return contains(root, value);
    }

    /**
     * 判断树中是否包含该节点
     *
     * @param root
     * @param value
     * @return
     */
    private boolean contains(TreeNode root, int value) {
        if (root == null) {
            return false;
        }

        if (root.val == value) {
            return true;
        } else if (root.val > value) {
            return contains(root.left, value);
        } else {
            return contains(root.right, value);
        }
    }


    /**
     * 实现前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 前序遍历具体实现
     *
     * @param node
     */
    private void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        // 先root后左最后右
        System.out.println(node.val);
        // 会一直递归调用左子树, 直到左子树为null
        preOrder(node.left);
        // 调用完左子树才调用右子树
        preOrder(node.right);
    }

    /**
     * 中序遍历
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * 中序遍历具体实现
     *
     * @param node
     */
    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        // 会一直递归调用左子树, 直到左子树为null
        inOrder(node.left);
        // 先左后root最后右
        System.out.println(node.val);
        // 调用完左子树才调用右子树
        inOrder(node.right);
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        postOrder(root);
    }

    /**
     * 后序遍历具体实现
     *
     * @param node
     */
    private void postOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        // 会一直递归调用左子树, 直到左子树为null
        postOrder(node.left);
        // 调用完左子树才调用右子树
        postOrder(node.right);
        // 先左后右最后root
        System.out.println(node.val);
    }

    /**
     * 层序遍历, 层序遍历需要依靠队列来实现
     * 因为队列的特性, 会将root节点下的近距离(距离为1)的左右节点都输出
     * 才会继续遍历 因为遍历左右子节点而入队的节点(左右子节点的子节点)
     */
    public void levelOrder() {
        Queue<TreeNode> queue = new ConcurrentLinkedQueue();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            System.out.println(node.val);

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    /**
     * 寻找树中的最小值
     *
     * @return
     */
    public int minimum() {
        if (size == 0)
            throw new IllegalArgumentException("BST is empty!");

        return minimum(root).val;
    }

    /**
     * 寻找树中最小值具体实现
     *
     * @param node
     * @return
     */
    private TreeNode minimum(TreeNode node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    /**
     * 寻找树中的最大值
     *
     * @return
     */
    public int maximum() {
        if (size == 0)
            throw new IllegalArgumentException("BST is empty!");

        return maximum(root).val;
    }

    /**
     * 寻找树中最大值具体实现
     *
     * @param node
     * @return
     */
    private TreeNode maximum(TreeNode node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    /**
     * 删除最小值节点
     *
     * @return
     */
    public int removeMin() {
        int min = minimum();
        removeMin(root);
        return min;
    }

    /**
     * 删除最小值具体实现
     * 删除最小值, 寻找到最小子节点之后, 需要将该节点的右子树移动该节点位置
     *
     * @param node
     */
    private TreeNode removeMin(TreeNode node) {
        // 如果节点无左子节点
        if (node.left == null) {
            TreeNode right = node.right;
            node.right = null;
            size--;
            return right;
        }
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 删除最大值节点
     */
    public int removeMax() {
        int max = maximum();
        root = removeMax(root);
        return max;
    }

    /**
     * 删除最大值节点具体实现
     *
     * @param node 删除之后的树
     * @return
     */
    private TreeNode removeMax(TreeNode node) {
        // 该节点已经是二分搜索树中的最大节点
        if (node.right == null) {
            TreeNode left = node.left;
            node.left = null;
            size--;
            return left;
        }
        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 删除值为value的节点
     *
     * @param value 节点属性
     */
    public void remove(int value) {
        root = remove(root, value);
    }

    /**
     * 删除值为value的节点具体实现
     * <p>
     * 遍历找到指定节点,
     * 判断节点状态,
     * 若是无左右子树, 则直接删除
     * 若是有左子树, 则
     * 若是有右子树
     * 如实有左右子树
     *
     * @param node  对应树中某一节点 (递归)
     * @param value 节点属性
     * @return
     */
    private TreeNode remove(TreeNode node, int value) {

        if (node == null) {
            return null;
        } else if (node.val > value) {
            node.left = remove(node.left, value);
            return node;
        } else if (node.val > value) {
            node.right = remove(node.right, value);
            return node;
        }
        /* node.value == value
           判断node是否有做左子节点
           判断node是否有做右子节点
           判断是否左右子节点都存在
         */
        else {
            // 左子节点存在
            if (node.right == null) {
                TreeNode left = node.left;
                node.left = null;
                size--;
                return left;
            }
            // 右子节点存在
            else if (node.left == null) {
                TreeNode right = node.right;
                node.right = null;
                size--;
                return right;
            }
            // 俩个子节点都存在, 去左子树的最大值来替换node
            TreeNode temp = maximum(node.left);
            removeMax(node.left);
            temp.left = node.left;
            temp.right = node.right;
            node.left = node.right = null;
            return temp;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    // 生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateBSTString(TreeNode node, int depth, StringBuilder res) {

        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.val + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++)
            res.append("--");
        return res.toString();
    }
}
