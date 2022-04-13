package com.bhh.leetcode.hot100.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author bhh
 * @description 以数组 intervals 表示若干个区间的集合，
 * 其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * @date Created in 2021-11-07 20:49
 * @modified By
 */
public class Question56 {
    class Solution {
        /*
        实现思路 : 先根据starti进行排序,
        设置参数获取前一个数组的endi,
        从 index = 1, 开始循环, 结束为size()
            若是无法合并( preEnd < starti ), 则将前一个数组放到新的数组中
            若是可以合并, 获取上一个数组starti和这个数组的endi,
                重写在当前数组intervals的当前索引, 且continue

        收获 : 哪些题目一看就需要排序? 合并区间
        Comparator接口实现 : 其中Compare() 方法,
            返回为正, 则先o2后o1
            返回为负, 则先o1后o2
            反正, return o1 - o2位升序, return o2 - o1位降序
         */
        public int[][] merge(int[][] intervals) {
            if (intervals == null) {
                return null;
            }
            Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
            List<int[]> list = new ArrayList<>();
            int preEnd = intervals[0][1];
            int length = intervals.length;
            for (int i = 1; i < length; i++) {
                // 当前数组starti > 前一个数组的endi, 不合并
                if (intervals[i][0] > preEnd) {
                    list.add(intervals[i - 1]);
                }
                // 合并
                else {
                    intervals[i][0] = intervals[i - 1][0];
                    intervals[i][1] = Math.max(intervals[i - 1][1], intervals[i][1]);
                }
                preEnd = intervals[i][1];
            }
            // 最后一个元素
            list.add(intervals[length - 1]);
            return list.toArray(new int[0][]);
        }
    }
}
