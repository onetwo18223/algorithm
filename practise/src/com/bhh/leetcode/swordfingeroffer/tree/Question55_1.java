package com.bhh.leetcode.swordfingeroffer.tree;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author bhh
 * @description 二叉树的深度
 * 输入一棵二叉树的根节点，求该树的深度。
 * 从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 * @date Created in 2021-09-29 20:15
 * @modified By
 */
public class Question55_1 {
    class Solution {
        /*
        实现思路 :
        求深度, 可以使用深度优先遍历,
        树的深度 = Math.max(左子树, 右子树) + 1
         */
        public int maxDepthDfs(TreeNode root) {
            if (root == null) return 0;
            return Math.max(maxDepthDfs(root.left), maxDepthDfs(root.right)) + 1;
        }

        /*
        使用层序遍历
        求出深度
        关键点 : 如何确认queue遍历玩的就是一层的数据
        解决 : 使用另一个集合 tmp 存储 queue 中所有节点的子节点,
           在queue中数据处理完之后, queue = tmp, depth++
           等最后queue.isEmpty() == true时, 返回depth
           + 也可以使用for(i = queue.size() - 1; i >= 0 ; i--) 来决定循环次数, 然后直接向queue中添加子节点

        收获 : 知道了如何在层序遍历遍历完一层之后进行暂停,
              进行一些输出, 或者根据标记进行其他操作
         */
        public int maxDepthBfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            Queue<TreeNode> queue = new ConcurrentLinkedQueue<>(), tmp;
            queue.add(root);
            int depth = 0;
            System.out.println("层序遍历 : ");
            while (!queue.isEmpty()) {
                tmp = new ConcurrentLinkedDeque<>();
                for (TreeNode treeNode : queue) {
                    System.out.println(treeNode.val);
                    if (treeNode.left != null) {
                        tmp.add(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        tmp.add(treeNode.right);
                    }
                }
                depth++;
                queue = tmp;
            }
            System.out.println("------------");
            return depth;
        }

        /*
        之字形遍历实现
        提供当前标记,
        若是标记为0, 则直接使用队列输出
        标记为1, 则通过stack承载数据, 再将数据传递给队列(这个过程数据已经反序)
         */
        public void maxDepthZ(TreeNode root) {
            if (root == null) {
                return;
            }

            Queue<TreeNode> queue = new ConcurrentLinkedQueue<>(), tmp;
            List<TreeNode> list;
            queue.add(root);
            boolean sign = true;
            System.out.println("之字形遍历 : ");
            while (!queue.isEmpty()) {
                tmp = new ConcurrentLinkedDeque<>();
                list = new ArrayList<>();
                for (TreeNode treeNode : queue) {
                    if (treeNode.left != null) {
                        tmp.add(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        tmp.add(treeNode.right);
                    }
                    list.add(treeNode);
                }
                // 正序输出
                if (sign) {
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println(list.get(i).val);
                    }
                }
                // 倒叙输出
                else {
                    for (int i = list.size() - 1; i >= 0; i--) {
                        System.out.println(list.get(i).val);
                    }
                }
                queue = tmp;
                sign = !sign;
            }
            System.out.println("------------");
        }

        /*
        力扣解题版本
         */
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }

            Queue<TreeNode> queue = new ConcurrentLinkedQueue<>(), tmp;
            List<List<Integer>> zList = new ArrayList<>();
            List<Integer> list;
            queue.add(root);
            boolean sign = true;
            while (!queue.isEmpty()) {
                tmp = new ConcurrentLinkedDeque<>();
                list = new ArrayList<>();
                for (TreeNode treeNode : queue) {
                    if (treeNode.left != null) {
                        tmp.add(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        tmp.add(treeNode.right);
                    }
                    list.add(treeNode.val);
                }
                // 倒序输出
                if (!sign) {
                    Collections.reverse(list);
                }
                zList.add(list);
                queue = tmp;
                sign = !sign;
            }
            return zList;
        }

        /*
        改进版本
         */
        public List<List<Integer>> zigzagLevelOrderPlus(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }

            Queue<TreeNode> queue = new LinkedList<>();
            List<List<Integer>> zList = new ArrayList<>();
            LinkedList<Integer> tmp;
            queue.add(root);
            boolean sign = true;
            while (!queue.isEmpty()) {
                tmp = new LinkedList<>();
                for (int i = queue.size() - 1; i >= 0 ; i--) {
                    TreeNode node = queue.poll();

                    if (!sign) {
                        tmp.addFirst(node.val);
                    }else{
                        tmp.addLast(node.val);
                    }

                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                zList.add(tmp);
                sign = !sign;
            }
            return zList;
        }
    }


    public static void main(String[] args) {
//        System.out.println(new Question55_1().new Solution().
//                maxDepthBfs(TreeUtil.getInstance()));
//        new Question55_1().new Solution().
//                maxDepthZ(TreeUtil.getInstance());
//        for (List<Integer> list : new Question55_1().new Solution().
//                zigzagLevelOrder(TreeUtil.getInstance())) {
//            for (Integer integer : list) {
//                System.out.println(integer);
//            }
//        }
        for (List<Integer> list : new Question55_1().new Solution().
                zigzagLevelOrderPlus(TreeUtil.getInstance())) {
            for (Integer integer : list) {
                System.out.println(integer);
            }
        }
    }
}