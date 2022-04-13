package com.bhh.leetcode.hot100twobrushes.array.sort;

import java.util.Arrays;

/**
 * @author bhh
 * @description 下一个排列
 * @date Created in 2022-01-21 21:26
 * @modified By
 */
public class Question31 {
    class Solution {
        /**
         * 错误 : 这个做法无法AC
         * 本题做法比较固定
         * 靠后的元素找前面第一个比他小的元素进行交换
         * 交换之后后面所有元素进行升序排列
         * 1 2 4 5 5
         * 1 2 5 4 5
         */
        public void nextPermutationError(int[] nums) {
            // 交换
            int len = nums.length;
            int index = -1;
            for (int i = len - 1; i >= 0; i--) {
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[i] > nums[j]) {
                        // 交换, 只交换一次
                        int tmp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = tmp;
                        index = j;
                        break;
                    }
                }
                if (index != -1) {
                    break;
                }
            }
            if (index == -1) {
                Arrays.sort(nums);
                return;
            }
            // 对index后的数组进行排序
            Arrays.sort(nums, index + 1, len);
        }

        /**
         * 先从后往前获取升序对, 记录升序对的俩个元素索引位置, coupleStart, coupleEnd
         * 遍历从元素对后coupleEnd到结尾end, 获取靠后的比coupleStart大的元素进行交换
         * 因为这时候从coupleEnd到end一定是降序, 翻转成升序
         *
         * @param nums
         */
        public void nextPermutation(int[] nums) {
            int len = nums.length;
            int coupleStart = 0, coupleEnd = 0;
            // 获取升序对俩个索引位置
            for (int i = len - 1; i > 0; i--) {
                if (nums[i] > nums[i - 1]) {
                    coupleStart = i - 1;
                    coupleEnd = i;
                    break;
                }
            }

            // 获取大于coupleStart元素的值, 交换
            for (int i = len - 1; i >= coupleEnd; i--) {
                if (nums[i] > nums[coupleStart]) {
                    swap(nums, i, coupleStart);
                    break;
                }
            }

            // coupleEnd到end翻转交换
            int end = len - 1;
            while (coupleEnd < end) {
                swap(nums, coupleEnd, end);
                coupleEnd++;
                end--;
            }
        }

        /**
         * 交换
         *
         * @param nums
         * @param i
         * @param j
         */
        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] array = {
                4, 2, 0, 2, 3, 2, 0
        };
        new Question31().new Solution().nextPermutation(array);
        for (int anInt : array) {
            System.out.println(anInt);
        }
    }
}
