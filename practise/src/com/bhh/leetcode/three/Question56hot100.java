package com.bhh.leetcode.three;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bhh
 * @description 合并区间
 * @date Created in 2022-01-31 16:17
 * @modified By
 */
public class Question56hot100 {
    class Solution {
        /*
        记录pre, 即前一个元素索引
        遍历一遍, 判断当前索引数组的开头元素是否大于pre索引位置元素的结尾元素
        若是大于则重组为一个数组, 添加到res
        若是小于则重组该数组
         */
        public int[][] merge(int[][] nums) {
            // 排序, 根据第一位排序
            Arrays.sort(nums, (o1, o2) -> (o1[0] - o2[0]));

            List<int[]> res = new ArrayList<>();
            int pre = 0;
            for (int i = 1; i < nums.length; i++) {
                // 不能合并
                if (nums[i][0] > nums[pre][1]) {
                    // 添加到res
                    res.add(new int[]{nums[pre][0], nums[pre][1]});
                }
                // 可以合并, 覆盖nums[i]
                else {
                    nums[i][0] = nums[pre][0];
                    nums[i][1] = Math.max(nums[pre][1], nums[i][1]);
                }
                pre = i;
            }
            // 处理最后一个元素
            res.add(new int[]{nums[pre][0], nums[pre][1]});
            return res.toArray(new int[res.size()][]);
        }
    }
}
