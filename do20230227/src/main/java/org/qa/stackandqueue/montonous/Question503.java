package org.qa.stackandqueue.montonous;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Desc 下一个更大元素 II
 * https://leetcode.cn/problems/next-greater-element-ii/
 * @Author Bhh
 * @Date 2023-03-31 15:42
 * @Version 1.0
 */
public class Question503 {
    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            if (null == nums || nums.length == 0) return new int[]{};
            Deque<Integer> stack = new ArrayDeque<Integer>();
            int length = nums.length;
            int[] res = new int[length];

            for (int i = 0; i < length * 2; i++) {
                int index = i >= length ? i - length : i;
                while(!stack.isEmpty() && nums[stack.getFirst()] < nums[index])
                    res[stack.removeFirst()] = nums[index];
                if (i < length)
                    stack.addFirst(index);
            }

            while(!stack.isEmpty()) {
                res[stack.removeFirst()] = -1;
            }
            return res;
        }
    }
    public static void main(String[] args) {
        for (int i : new Question503().new Solution().nextGreaterElements(new int[]{3, 2, 1})) {
            System.out.print(i);
            System.out.print(" ");
        }
    }
}
