package com.bhh.leetcode.hot100twobrushes.stackandqueue.monotonic;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author bhh
 * @description 接雨水
 * @date Created in 2022-01-26 9:09
 * @modified By
 */
public class Question42 {
    class Solution {
        /*
        单调栈实现, 单调递减栈, 每次碰到新的元素大于栈顶元素,
            则说明雨水的右边界找到了, 而栈顶元素可以充当低洼(pop)
        再在栈中找到一个left左边界即可(因为是单调递减),
            所以此时新的栈顶元素可以充当left
         */
        public int trap(int[] nums) {
            Deque<Integer> stack = new ArrayDeque<>();
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                // 如果栈顶元素小于等于当前元素, 则当前元素可以做右边界
                while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                    // 低洼
                    int lowLying = stack.pop();
                    // 寻找左边界, 若没有左边界, 则直接退出循环
                    if (stack.isEmpty()) {
                        break;
                    }
                    int right = i;
                    int left = stack.peek();

                    // 最短边 - 低洼
                    int height = Math.min(nums[right], nums[left]) - nums[lowLying];
                    int length = right - left - 1;
                    sum += height * length;
                }
                // 存储索引的原因是需要使用索引来计算长度间距
                stack.push(i);
            }
            return sum;
        }
    }
}
