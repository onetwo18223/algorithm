package org.qa.twopointer.copointer.sliding;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc 和为s的连续正数序列
 * https://leetcode.cn/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 * 实现：
 * 类似于Question209
 * @Author Bhh
 * @Date 2023-03-28 16:20
 * @Version 1.0
 */
public class OfferQuestion57 {
    class Solution {
        public int[][] findContinuousSequence(int target) {
            List<List<Integer>> res = new ArrayList<>();
            int l = 0, r = 0;
            int sum = 0;
            while(l <= r && r < target) {
                if (sum >= target) {
                    if (sum > target) {
                        sum -= l++;
                        continue;
                    }
                    List<Integer> tempList = new ArrayList<>();
                    for (int i = l; i <= r; i++) {
                        tempList.add(i);
                    }
                    sum -= l++;
                    res.add(tempList);
                }
                // sum < target
                else {
                    sum += ++r;
                }
            }
            return res.toArray(new int[0][]);
        }
    }
}
