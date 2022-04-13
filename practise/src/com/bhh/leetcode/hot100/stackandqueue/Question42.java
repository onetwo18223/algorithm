package com.bhh.leetcode.hot100.stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author bhh
 * @description 接雨水
 * @date Created in 2022-01-05 12:05
 * @modified By
 */
public class Question42 {
    class Solution {
        /*
        使用单调递减栈(寻找大值, 大值和栈底元素可以形成高低高的形式来接雨水)
        不需要对0做额外处理
        遍历height数组, 若是当前元素大于栈顶元素, while{
            栈顶元素出栈, 记录 cur = 其值(高度)
            right = i(当前遍历的元素)
            left = 当前新的栈顶元素
            length = right - left - 1
            高度 = min(当前新的栈顶元素, nums[i])
            面积 = length * (高度 - cur)
        }
         */
        public int trap(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int res = 0;
            // 创建栈, 只能单调递减
            Deque<Integer> stack = new ArrayDeque<>();

            for (int i = 0; i < nums.length; i++) {
                // 碰到元素大于栈堆元素时
                while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                    int cur = nums[stack.pop()];
                    // 看看栈里还有没有东西（左墙是否存在）
                    // 有右墙+有低洼+没有左墙=白搭
                    if (stack.isEmpty()) {
                        break;
                    }
                    int right = i;
                    int left = stack.peek();
                    int length = right - left - 1;
                    int height = Math.min(nums[left], nums[right]) - cur;
                    res += length * height;
                }
                stack.push(i);
            }
            return res;
        }
    }
}
