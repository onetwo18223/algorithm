package com.bhh.leetcode.hot100.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bhh
 * @description 找到所有数组中消失的数字
 * @date Created in 2022-01-06 20:36
 * @modified By
 */
public class Question448 {
    class Solution {
        /*
        俩种方法 : Hash表和排序
         */
        // 排序
        // 重复元素存在, 判断nums[len - 1], 再遍历判断是否有断层漏掉的元素
        public List<Integer> findDisappearedNumbers(int[] nums) {
            Arrays.sort(nums);
            int len = nums.length;
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < len - 1; i++) {
                if (nums[i + 1] - nums[i] >= 2) {
                    for (int j = nums[i] + 1; j < nums[i + 1]; j++) {
                        list.add(j);
                    }
                }
            }
            if (len > nums[len - 1]) {
                for (int j = nums[len - 1] + 1; j <= len; j++) {
                    list.add(j);
                }
            }
            if (0 < nums[0]) {
                for (int j = 1; j < nums[0]; j++) {
                    list.add(j);
                }
            }
            return list;
        }
    }
}
