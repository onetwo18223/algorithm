package com.bhh.leetcode.swordfingeroffertwobrushes.tree;

/**
 * @author bhh
 * @description 树工具类
 * @date Created in 2021-09-29 21:17
 * @modified By
 */
public class TreeUtil {
    public static TreeNode getInstance(){
        Tree tree = new Tree();
        tree.add(10);
        tree.add(3);
        tree.add(7);
        tree.add(12);
        tree.add(11);
        tree.add(15);
        return tree.root;
    }
}
