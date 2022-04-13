package com.bhh.leetcode.hot100.array;

import com.bhh.leetcode.swordfingeroffer.dynamic.Question42;

/**
 * @author bhh
 * @description 盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i的两个端点分别为(i,ai) 和 (i, 0) 。
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器。
 * @date Created in 2021-10-13 8:56
 * @modified By
 */
public class Question11 {
    class Solution {
        /*
        实现思路 :
        线索 : 开始点不明确(不可以直接选取最小点最大点), 结束点需要遍历
        节点与节点之间值因为开始点不同而结果不同(动态规划不好使用)
        ## 线索过多, 而使用暴力解法或许更好, (暴力解法容易超时)

        新线索 : 开始点和结束点之间会选择最小的一端最为边
        以index = 0 和 index = height.length - 1为测试,
        短边内移 : 面积可能增大
        长边内移 : 因为短边限制, 面积一定减小

        总结 :
        为什么会想到使用双指针?
        关于数组可以使用的方法?
            遍历, 二分, 指针对撞, 滑动窗口, 找规律
                二分, 题目一般会涉及到查询某个数据
                    二分搜索的技巧 : 二分搜索一般来说 while(l < r) 是不会怎么变的 (可能会变成l <= r)


                指针对撞, 查询某个范围, 双指针分别指向开始和结束点, 寻找规律, 指针碰撞时为结束条件
                  ,或许使用暴力遍历也可以实现(会超时)
                滑动窗口,
         */
        public int maxArea1(int[] height) {
            int max = 0;
            for (int i = 0; i < height.length; i++) {
                for (int j = i + 1; j < height.length; j++) {
                    max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
                }
            }
            return max;
        }

        public int maxArea(int[] height) {
            if (height == null || height.length == 0){
                return 0;
            }
            int start = 0, end = height.length - 1;
            int max = 0;
            while (start < end){
                max = Math.max(max,
                        Math.min(height[start], height[end]) * (end - start));
                // 长边不动, 动短边
                // 因为, 长边即使动碰到更长边, 也会因为短边限制而面积变小
                if (height[start] > height[end]){
                    end--;
                } else {
                    start++;
                }
            }
            return max;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question11().new Solution().maxArea(new int[]{
                1, 8, 6, 2, 5, 4, 8, 3, 7
        }));
    }
}
