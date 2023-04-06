package org.qa.twopointer.copointer.sliding;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc 和为s的连续正数序列
 * https://leetcode.cn/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 * @Author Bhh
 * @Date 2023-03-28 16:20
 * @Version 1.0
 */
public class OfferQuestion57 {
    {
        /* 实现：
        类似于Question209
         */
    }

    class Solution {
        public int[][] findContinuousSequence(int target) {
            List<List<Integer>> res = new ArrayList<>();
            int l = 1, r = 1;
            int sum = 1;
            while(l <= r && r < target) {
                if (sum >= target) {
                    if (target == sum) {
                        List<Integer> tempList = new ArrayList<>();
                        for (int i = l; i <= r; i++) tempList.add(i);
                        res.add(tempList);
                    }
                    sum -= l++;
                }
                // sum < target
                else {
                    sum += ++r;
                }
            }
            // TODO: 无法直接通过toArray() 转为二层数组
            //  方法一：直接遍历完成赋值到二层数组
            //  方法二：现将内层通过toArray()转换为数组，再将外层通过toArray()转换为数组
            //         但是这种方法无法直接转换为基础数组类型数组
            return this.toArrayM2(res);
        }

        private Integer[][] toArrayM1(List<List<Integer>> res) {
            List<Integer[]> intList = new ArrayList<Integer[]>();
            for (List<Integer> list : res) {
                intList.add(list.toArray(new Integer[0]));
            }
            return intList.toArray(new Integer[0][]);
        }

        private int[][] toArrayM2(List<List<Integer>> res) {
            int[][] resArray = new int[res.size()][];
            for (int i = 0; i < res.size(); i++) {
                List<Integer> list = res.get(i);
                resArray[i] = new int[list.size()];
                for (int j = 0; j < list.size(); j++) {
                    resArray[i][j] = list.get(j);
                }
            }
            return resArray;
        }
    }
}
