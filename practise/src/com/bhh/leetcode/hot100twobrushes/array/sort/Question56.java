package com.bhh.leetcode.hot100twobrushes.array.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bhh
 * @description 合并区间
 * @date Created in 2022-01-25 16:30
 * @modified By
 */
public class Question56 {
    class Solution {
        /*
        先按照元素数组第一个位置进行排序,
        属性preEnd : 获取第一个元素数组的最后一个位置
        遍历判断每个数组元素的第一个位置,
            若是interval[0] > preEnd 表示不可以合并, 则添加上一个元素到res
            若是interval[1] < preEnd 表示可以合并, 这时不可以添加元素到res,
                我们将合并的情况覆盖到interval[i]上, 直到碰到不可合并的情况或者结尾
        更新修改preEnd
        最后添加最后一个元素到res
         */
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
            List<int[]> res = new ArrayList<>();
            // 第一个数组元素的末尾
            int preEnd = intervals[0][1];
            for (int i = 1; i < intervals.length; i++) {
                // 不可以合并, 添加元素到res
                if (intervals[i][0] > preEnd) {
                    res.add(intervals[i - 1]);
                }
                // 可以合并, 将合并的结果覆盖到当前元素
                else {
                    intervals[i][0] = intervals[i - 1][0];
                    intervals[i][1] = Math.max(intervals[i - 1][1],
                            intervals[i][1]);
                }
                preEnd = intervals[i][1];
            }
            res.add(intervals[intervals.length - 1]);
            return res.toArray(new int[][]{});
        }
    }
}
