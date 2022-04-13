package com.bhh.leetcode.four;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bhh
 * @description 合并区间
 * @date Created in 2022-02-25 20:06
 * @modified By
 */
public class Question56 {
    class Solution {
        /*
        先进行排序, 按照第一个元素排序
        对比前一个元素尾和当前元素的头, 若是不能合并, 则添加前一个区间到res
        若是可以合并, 则修改原数组intervals的值
         */
        public int[][] merge(int[][] intervals) {
            List<int[]> res = new ArrayList<>();
            // 排序
            Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
            // 比较
            for (int i = 1; i < intervals.length; i++) {
                // 可以合并
                if (intervals[i][0] <= intervals[i - 1][1]) {
                    intervals[i][0] = Math.min(intervals[i - 1][0], intervals[i][0]);
                    intervals[i][1] = Math.max(intervals[i - 1][1], intervals[i][1]);
                }
                // 不可以合并
                // 存储上一个元素
                else {
                    res.add(intervals[i - 1]);
                }
            }
            // 将数组最后一组数组添加到res
            res.add(intervals[intervals.length - 1]);
            return res.toArray(new int[][]{});
        }
    }
}
