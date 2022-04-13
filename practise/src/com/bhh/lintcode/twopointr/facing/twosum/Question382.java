package com.bhh.lintcode.twopointr.facing.twosum;

import java.util.Arrays;

/**
 * @author bhh
 * @description 三角形计数
 * 给定一个整数数组，在该数组中，寻找三个数，分别代表三角形三条边的长度，
 * 问，可以寻找到多少组这样的三个数来组成三角形？
 * @date Created in 2021-12-01 14:56
 * @modified By
 */
public class Question382 {
    public class Solution {
        /*
        错误解法 :
        这道题类似于 三数之和, 不同点在于
            三数之和, 降维确定了a, 寻找b, c时, b + c = -a
            这道题是 降维确定了a, 寻找b, c时, a + b > c

        先通过降维思想确定一个数a, 然后获取 b, c, 使得 a + b > c
         */
        /*
        正确解法 :
        求总数, 这一类题核心为 批量数
        批量处理之后, 减少了一次O(n), 所以时间复杂度是O(n^2)而不是O(n^3)
        在使用降维思想 + 相向双指针时, 双指针的值最好是相加起来的, 否则不再会是相向双指针
            也就是说 如果确定了a值, 就最好是 b + c > a,判断条件中不变的在右方
         */
        public int triangleCount(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            Arrays.sort(nums);
            int sum = 0;
            // 确定a的值, 寻找b, c, 使得 b + c > a
            for (int i = 0; i < nums.length; i++) {
                sum += findTwo(nums, i);
            }
            return sum;
        }

        private int findTwo(int[] nums, int i) {
            int res = 0;
            int start = 0, end = i - 1;

            while (start < end) {
                int twoSum = nums[start] + nums[end];
                if (twoSum > nums[i]) {
                    res += (end - start);
                    // 为什么是end--, 而不是start++
                    // end-- 可能会让 twoSum <= nums[i]
                    // start ++ 一定会是 twoSum > nums[i]
                    // 我们是寻找更多可能
                    end--;
                } else {
                    start++;
                }
            }
            return res;
        }
    }
}
