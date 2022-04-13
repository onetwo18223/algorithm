package com.bhh.leetcode.hot100twobrushes.array.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * @author bhh
 * @description 最长连续序列
 * @date Created in 2022-01-21 13:09
 * @modified By
 */
public class Question128 {
    class Solution {
        /*
        时间要求在O(n), 那么不能排序, 不能排序就无法二分
        O(n)就是遍历一遍, 双指针, Hash, 动归
        使用Hash存储数据, 然后再次遍历获取连续值最长长度
         */
        public int longestConsecutive(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }

            int max = 0;
            // 遍历set集合
            for (int num : set) {
                // 只有当上一个元素不存在时, 才会进行遍历
                if (set.contains(num - 1)) {
                    continue;
                }
                int curNum = num;
                int count = 1;
                while (set.contains(curNum + 1)) {
                    count++;
                    curNum++;
                }
                max = Math.max(max, count);
            }
            return max;
        }
    }
}
