package com.bhh.leetcode.hot100.stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author bhh
 * @description 柱状图中最大的矩形
 * @date Created in 2022-01-05 12:04
 * @modified By
 */
public class Question84 {
    class Solution {
        /*
        使用单调递增栈, 存储着关于元素的索引
        创建heights数组, 使首位都添加一个0, 首位0的作用在于
        遍历heights数组, 若是栈顶元素大于当前元素, 说明找到了栈顶元素的右边界
            while
            {弹出当前元素, 高为弹出元素的高
            右边界为当前元素, 找左边界, 左边界是新的栈顶元素}
        获取长宽则计算矩阵, 取最大值返回
         */
        public int largestRectangleArea(int[] heights) {
            if (heights == null || heights.length == 0) {
                return 0;
            }
            int res = 0;
            int len = heights.length;
            // 在数组首位添加 0
            int[] newHeights = new int[len + 2];
            for (int i = 1; i < len + 1; i++) {
                newHeights[i] = heights[i - 1];
            }
            // 创建栈
            Deque<Integer> stack = new ArrayDeque();

            for (int i = 0; i < len + 2; i++) {
                while (!stack.isEmpty() && newHeights[stack.peek()] > newHeights[i]) {
                    // 高等于出栈元素的值
                    int height = newHeights[stack.pop()];
                    // 右边界是当前元素
                    int right = i;
                    // 左边界是新栈顶元素
                    int left = stack.peek();
                    // 计算长度
                    // 这里的right指向的是要入栈的小于栈顶的元素, left指向的是高度的前一个位置
                    // 所以需要再减一
                    int length = right - left - 1;
                    // 获取最大值
                    res = Math.max(res, height * length);
                }
                stack.push(i);
            }
            return res;
        }
    }
}
