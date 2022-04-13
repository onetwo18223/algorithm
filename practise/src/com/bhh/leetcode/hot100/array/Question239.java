package com.bhh.leetcode.hot100.array;

import com.bhh.lintcode.bfs.Question433;

/**
 * @author bhh
 * @description 滑动窗口最大值
 * @date Created in 2021-12-23 13:54
 * @modified By
 */
public class Question239 {
    class Solution {
        /*
        错误(超时)
        标准的滑动窗口问题, 题目类型都写在了标题上
        第一次写出来这道题是使用到了 math.max() 比较三个数
        然后遍历, 每次滑动窗口移动, 判断max是否被删除, 再比较max和新入的数
        是一道很简单的hard


         */
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return new int[0];
            }
            if (k == 0 || k == 1) {
                return nums;
            }
            int end = 0;
            int max = Integer.MIN_VALUE;
            int[] res = new int[nums.length - k + 1];

            for (int start = 0; start < nums.length; start++) {
                // 结束条件 越界 或者 end - start == k
                while (end < nums.length && end - start < k) {
                    max = Math.max(max, nums[end]);
                    end++;
                }
                // 滑动窗口大小等于k
                if (end - start == k) {
                    res[start] = max;
                }
                // 如果当前最大值等于nums[start], 则更换最大值,
                // 因为下一个循环start会++
                if (end < nums.length && max == nums[start]) {
                    // 从start + 1 到 end 选取一个最大值
                    // 当start + 1 == end 时, 不会执行, 也就是k == 1的情况
                    // 这种情况下直接返回原数组即可
                    max = Integer.MIN_VALUE;
                    for (int i = start + 1; i < end; i++) {
                        max = Math.max(nums[i], max);
                    }
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        for (int i : new Question239().new Solution().maxSlidingWindow(new int[]{
                -7,-8,7,5,7,1,6,0
        }, 4)) {
            System.out.println(i);
        }
    }
}
