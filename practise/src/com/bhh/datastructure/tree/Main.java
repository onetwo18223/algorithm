package com.bhh.datastructure.tree;

/**
 * @author bhh
 * @description 测试Tree
 * @date Created in 2021-09-28 13:29
 * @modified By
 */
public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.add(10);
        tree.add(3);
        tree.add(7);
        tree.add(12);
        tree.add(11);
        tree.add(15);
        System.out.println(tree);
        System.out.println("--------------");
        tree.preOrder();
        System.out.println("--------------");
        tree.preOrderNR();
        System.out.println("--------------");
        tree.inOrder();
        System.out.println("--------------");
        tree.postOrder();
        System.out.println("--------------");
        tree.levelOrder();
        System.out.println("--------------");
//        tree.removeMin();
//        tree.preOrder();
//        System.out.println("--------------");
//        System.out.println(tree);
//        System.out.println("--------------");
        tree.remove(10);
//        tree.preOrder();
        System.out.println(tree);
//        tree.removeMax();
//        tree.preOrder();
//        BST tree1 = new BST();
//        tree1.add(10);
//        tree1.add(3);
//        tree1.add(1);
//        tree1.add(12);
//        tree1.add(11);
//        tree1.add(15);
//        System.out.println(tree1);
//        System.out.println("--------------");
//        tree1.preOrder();
//        System.out.println("--------------");
//        tree1.inOrder();
//        System.out.println("--------------");
//        tree1.postOrder();
//        System.out.println("--------------");
//        tree1.levelOrder();
//        System.out.println("--------------");

    }
}
