package com.bhh.leetcode.swordfingeroffer.stackandqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bhh
 * @description 滑动窗口的最大值
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * <p>
 * 示例:
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * <p>
 * 滑动窗口的位置                最大值
 * ---------------            -------
 * [1  3  -1] -3  5  3  6  7      3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * <p>
 * 提示：
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小
 * @date Created in 2021-09-21 11:16
 * @modified By
 */
public class Question59_1 {
    class Solution {
        /*
        实现思路 :
        方法一 : 第一想法是数组问题, 寻找规律, 双指针移动, 在双指针范围内寻找最大值
        第一层时, 寻找出最大值和最大值索引
        若是左指针l > 最大指索引, 则重新寻找最大值和最大值索引
        若是左指针l < 最大值索引, 则判断右指针指向的值是否大最大值 若大于则替换
        方法二 : 本题考察的其实是队列问题
         */
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return new int[0];
            }

            // 存储结果
            List<Integer> list = new ArrayList<>();
            int l = 0, r = k - 1;
            int max = Integer.MIN_VALUE;
            int maxIndex = -1;
            while (r < nums.length) {
                if (l > maxIndex) {
                    max = Integer.MIN_VALUE;
                    // 寻找范围内最大值
                    for (int i = l; i <= r; i++) {
                        if (nums[i] > max) {
                            max = nums[i];
                            maxIndex = i;
                        }
                    }
                }
                // maxIndex 还在范围之内, 比较max和nums[r]的大小
                else {
                    if (max < nums[r]) {
                        max = nums[r];
                        maxIndex = r;
                    }
                }
                list.add(max);
                l++;
                r++;
            }

            int[] array = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                array[i] = list.get(i);
            }
            return array;
        }
    }

    public static void main(String[] args) {
        Arrays.stream(new Question59_1().new Solution().maxSlidingWindow(new int[]{
                1, 3, -1, -3, 5, 3, 6, 7
        }, 3)).forEach(System.out::println);
    }
}
