package com.bhh.leetcode.four;

import java.util.HashSet;
import java.util.Set;

/**
 * @author bhh
 * @description 最长连续序列
 * @date Created in 2022-02-25 20:23
 * @modified By
 */
public class Question128 {
    class Solution {
        /*
        存储数据到map, 遍历map.keySet(), 寻找是否有下一个数
        注意要先寻找是否有上一个数, 如果有则continue;
         */
        public int longestConsecutive(int[] nums) {
            int max = 0;
            Set<Integer> set = new HashSet<>();
            // 添加数据到HashSet
            for (int i = 0; i < nums.length; i++) {
                set.add(nums[i]);
            }
            // 遍历Set
            for (Integer num : set) {
                // 如果存在前一个大小的元素, 说明是已经被遍历过了
                if (set.contains(num - 1)) {
                    continue;
                }
                // 计算连续序列长度
                int count = 1;
                while (set.contains(num + 1)) {
                    num++;
                    count++;
                }
                max = Math.max(max, count);
            }
            return max;
        }
    }
}
