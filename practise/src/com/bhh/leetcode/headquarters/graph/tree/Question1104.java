package com.bhh.leetcode.headquarters.graph.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author bhh
 * @description 二叉树寻路
 * 在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按“之” 字形进行标记。
 * 在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记；
 * 而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。
 * 给你树上某一个节点的标号 label，请你返回从根节点到该标号为 label 节点的路径，该路径是由途经的节点标号所组成的。
 * <p>
 * 示例 1：
 * 输入：label = 14
 * 输出：[1,3,4,14]
 * <p>
 * 示例 2：
 * 输入：label = 26
 * 输出：[1,2,6,10,26]
 * @date Created in 2021-09-29 9:04
 * @modified By
 */
public class Question1104 {
    class Solution {
        /*
        错误思路 :
        实现思路 :
        使用栈 + 队列来实现, 使用 depth 来描述深度,
        若是当前深度为奇数(子节点深度为偶数), 则使用栈存储子节点
        若是当前深度为偶数(子节点深度为奇数), 则使用队列来存储子节点

            从1开始, 到depth结束
            若是i为奇数, 则读取队列(直到没有数据(这一层数据读完了))
            若是i为偶数, 则读取栈(直到没有数据(这一层数据读完了))

                寻找指定节点, 遍历时判断节点value是否等于label, 记录当前深度labelDepth
                创建labelDepth长度的数组, 遍历labelDepth - 1, 寻找父节点存储到数组
                返回数组
         */

        /*
        这是一道找规律的题, 通过label, 反推父节点
        通过子节点找父节点 : 子节点的镜像 << 1 = 父节点
        子节点的镜像 = (层最大值 + 层最小值) << 1
        层最大值 = 大于label的 2的幂次方
        层最小值 = 大于label的 2的幂次方 << 1
         */
        public List<Integer> pathInZigZagTree(int label) {
            int max = 1;
            for (; max <= label; max <<= 1) {
            }

            LinkedList<Integer> list = new LinkedList<>();
            for (; max >= 2; max >>= 1) {
                list.push(label);
                // (最大值 + 最小值 - label) >> 1
                label = ((max - 1) + (max / 2) - label) >> 1;
            }
            return list;
        }
    }
}
