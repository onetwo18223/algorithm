package com.bhh.leetcode.swordfingeroffer.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author bhh
 * @description 和为s的连续正数序列
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * <p>
 * 示例 1：
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * <p>
 * 示例 2：
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 * @date Created in 2021-09-17 11:43
 * @modified By
 */
public class Question57_2 {
    /**
     * 收货 :
     *      使用 List<int[]> list 来收集 int[]
     *      返回数组, 或者是二维数组时, 使用 list.toArray(new int[0])
     *          toArray()和toArray(new int[0])区别 :
     *              toArray() 方法会返回Object[]数组, 用(int[])强转会报错,
     *                  因为java只可以对单个对象进行强转, 数组不可以直接强转
     *              toArray(new int[0]) 方法会传入一个参数, 这样就可以返回对应类型(int[])的数组
     *                  参数new int[0]只是指代类型, 不指定大小
     *
     */
    class Solution {
        /*
        实现思路 :
        方法一 : 求和公式
        方法二 : 滑动窗口 (双指针)
            构建一个从左向右滑动的滑动窗口, 一个指针l = 0指向窗口开端, 另一个指针r = 1指向窗口结束
            将l到r之间的所有元素进行相加,
            若是等于target, 则添加到list中,
            小于target, 则r++;
            大于target, 则l--;
         */
        public int[][] findContinuousSequence(int target) {
            int l = 1, r = 2;
            List<int[]> list = new ArrayList<>();
            while (l < r) {
                if (sum(l, r) == target) {
                    int[] array = new int[r - l + 1];
                    for (int i = l; i <= r; i++) {
                        array[i - l] = i;
                    }
                    list.add(array);
                    l++;
                } else if (sum(l, r) > target) {
                    l++;
                } else {
                    r++;
                }
            }
            return list.toArray(new int[0][]);
        }

        private int sum(int l, int r) {
            return (l + r) * (r - l + 1) / 2;
        }
    }

    public static void main(String[] args) {
        for (int[] ints : new Question57_2().new Solution().findContinuousSequence(15)) {
            Arrays.stream(ints).forEach(System.out::println);
        }

        int[][] array = new int[0][];
        array[1] = new int[]{1,2,3};
        for (int[] ints : array) {
            Arrays.stream(ints).forEach(System.out::println);
        }
    }
}
