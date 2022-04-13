package com.bhh.leetcode.swordfingeroffertwobrushes.array.hash;

/**
 * @author bhh
 * @description 数组中重复的数字
 * @date Created in 2022-01-11 20:23
 * @modified By
 */
public class Question03 {
    class Solution {
        /*
        通过hash/原地交换使索引和数值一一对应
         */
        public int findRepeatNumber(int[] nums) {
            int i = 0;
            while (i < nums.length) {
                // 如果索引和对应值是相等的, 说明已经归位
                // 这里需要注意的是需要先进行这个判断,
                // 因为对于nums[i] == nums[nums[i]], 可能发生, nums[0] = 0
                // 然后nums[0] = nums[nums[0]]的情况出现
                if (nums[i] == i) {
                    i++;
                    continue;
                }
                // 索引i对应的值对应的索引位置的值 nums[nums[i]]
                // 等于该索引的值nums[i]
                // 说明一个索引对应多个值, 返回该值
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                // 进行交换
                int tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
            }
            return -1;
        }
    }
}
