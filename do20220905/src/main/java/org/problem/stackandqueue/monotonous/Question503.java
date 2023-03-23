package org.problem.stackandqueue.monotonous;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 下一个更大元素II
 * <p>
 * 实现：
 * 类比Question739
 * 不同点在于循环数组
 * 可以使用模拟的方法完成实现
 * 遇到循环数组问题时，可以模拟循环一次来解决问题
 * <p>
 * Arrays.fill(array, -1);
 */
public class Question503 {
    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            if (nums == null || nums.length == 0)
                return new int[]{};
            int length = nums.length;

            // 单调递栈
            Deque<Integer> stack = new ArrayDeque<>();
            int[] array = new int[length];
            // 初始化为-1
            Arrays.fill(array, -1);
            // 模拟循环数组，俩次遍历
            for (int i = 0; i < length * 2; i++) {
                // index表示i在nums中的真实索引位置
                while(!stack.isEmpty() && nums[i % length] > nums[stack.getLast()]) {
                    array[stack.getLast()] = nums[i % length];
                    stack.removeLast();
                }
                stack.addLast(i % length);
            }
            return array;
        }
    }
}
