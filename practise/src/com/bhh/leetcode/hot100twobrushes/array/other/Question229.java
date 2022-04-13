package com.bhh.leetcode.hot100twobrushes.array.other;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bhh
 * @description 求众数 II
 * @date Created in 2022-01-12 21:19
 * @modified By
 */
public class Question229 {
    class Solution {
        public List<Integer> majorityElement(int[] nums) {
            //  候选者和次数
            int candidate1 = nums[0];
            int count1 = 0;
            int candidate2 = nums[0];
            int count2 = 0;
            // 抵消阶段
            for (int num : nums) {
                if (num == candidate1) {
                    count1++;
                    // continue防止俩个数都加, 避免俩个候选人是同一个
                    continue;
                }
                if (num == candidate2) {
                    count2++;
                    continue;
                }
                if (count1 == 0) {
                    candidate1 = num;
                    count1 = 1;
                    continue;
                }
                if (count2 == 0) {
                    candidate2 = num;
                    count2 = 1;
                    continue;
                }
                count1--;
                count2--;
            }

            // 计数验证阶段
            count1 = 0;
            count2 = 0;
            List<Integer> res = new ArrayList<>();
            for (int num : nums) {
                if (candidate1 == num) {
                    count1++;
                }
                // 使用else if原因是避免同一个候选人
                else if (candidate2 == num) {
                    count2++;
                }
            }
            if (count1 > nums.length / 3) {
                res.add(candidate1);
            }
            if (count2 > nums.length / 3) {
                res.add(candidate2);
            }
            return res;
        }
    }
}
