package com.bhh.lintcode.twopointr.samedirection;

import java.util.Arrays;

/**
 * @author bhh
 * @description 去除重复元素
 * @date Created in 2021-12-23 10:35
 * @modified By
 */
public class Question521 {
    public class Solution {
        /*
        去重而不用Hash, 时间换空间
        找不重复元素, 然后覆盖
         */
        public int deduplication(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            Arrays.sort(nums);
            int start = 0, end = 1;
            for (start = 0; start < nums.length; start++) {
                // 寻找不等于nums[start]的数值, 进行交换
                while (end < nums.length && nums[start] == nums[end]){
                    end++;
                }
                if (end >= nums.length){
                    break;
                }
                // 覆盖
                nums[start + 1] = nums[end];
            }
            return start + 1;
        }
    }
}
