package com.bhh.lintcode.tree;

import com.bhh.leetcode.swordfingeroffer.tree.TreeUtil;
import com.bhh.leetcode.swordfingeroffer.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bhh
 * @description 寻找节点和路劲
 * @date Created in 2021-12-09 21:22
 * @modified By
 */
public class FindNodeAndPath {
    public List<TreeNode> nodes;
    public List<String> paths;

    FindNodeAndPath() {
        nodes = new ArrayList<>();
        paths = new ArrayList<>();
    }

    /**
     * 获取所有节点
     *
     * @param node
     */
    public void findNodes(TreeNode node) {
        if (node == null) {
            return;
        }
        nodes.add(node);
        findNodes(node.left);
        findNodes(node.right);
    }

    // 分治法
    public void findPaths1(TreeNode node, String path) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            paths.add(path);
            return;
        }
        // 防止 node.left.val 报错
        if (node.left != null) {
            findPaths1(node.left, path + "->" + node.left.val);
        }
        if (node.right != null) {
            findPaths1(node.right, path + "->" + node.right.val);
        }
    }

    // 分治法
    public void findPaths2(TreeNode node, String path) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            paths.add(path + "->" + node.val);
            return;
        }
        path = path + "->" + node.val;
        findPaths1(node.left, path);
        findPaths1(node.right, path);
    }

    // 遍历法
    public void findPaths3() {

    }

    public static void main(String[] args) {
        FindNodeAndPath test = new FindNodeAndPath();
        TreeNode instance = TreeUtil.getInstance();
        test.findNodes(instance);
        test.findPaths1(instance, "" + instance.val);
//        test.findPaths2(instance, "");
        for (TreeNode node : test.nodes) {
            System.out.println(node.val);
        }
        System.out.println("test.paths = " + test.paths);
    }

}
