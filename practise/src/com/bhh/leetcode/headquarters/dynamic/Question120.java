package com.bhh.leetcode.headquarters.dynamic;

import com.bhh.leetcode.swordfingeroffer.stackandqueue.Question59_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bhh
 * @description 三角形最小路径和
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者
 * 等于 上一层结点下标 + 1 的两个结点。
 * 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 * @date Created in 2021-10-07 13:19
 * @modified By
 */
public class Question120 {
    class Solution {
        /*
        实现思路 : 每次选择最小节点进行返回
         */
        public int minimumTotal(List<List<Integer>> triangle) {

            return re(triangle, 0, 0);
        }

        private int re(List<List<Integer>> triangle, int i, int i1) {
            if (i == triangle.size() - 1) {
                if (i1 == triangle.get(i).size() - 1) {
                    return triangle.get(i).get(i1);
                }
                return Math.min(triangle.get(i).get(i1), triangle.get(i).get(i1 + 1));
            }

            return triangle.get(i).get(i1) +
                    Math.min(re(triangle, i + 1, i1), re(triangle, i + 1, i1 + 1));
        }

    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>() {
            {
                add(new ArrayList<Integer>(Arrays.asList(2)));
                add(new ArrayList<Integer>(Arrays.asList(3, 4)));
                add(new ArrayList<Integer>(Arrays.asList(6, 5, 7)));
                add(new ArrayList<Integer>(Arrays.asList(4, 1, 8, 3)));
            }
        };

        System.out.println(new Question120().new Solution().minimumTotal(lists));
    }
}
