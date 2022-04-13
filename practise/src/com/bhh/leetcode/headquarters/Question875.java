package com.bhh.leetcode.headquarters;

import java.util.Arrays;

/**
 * @author bhh
 * @description 875
 * 思路 : 总共piles.length()堆, 根据piles最小堆数量和最大堆数量, 选择刚好完成的最小数量
 * @date Created in 2021-07-30 15:30
 * @modified By
 */
public class Question875 {
    class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            int min = 1;
            int max = Arrays.stream(piles).max().getAsInt();
            return search(piles, min, max, h);
        }

        /**
         * 获取小于等于h的最大值
         *
         * @param piles
         * @param min
         * @param max
         * @param h
         */
        private int search(int[] piles, int min, int max, int h) {
            int mid;
            while (min < max) {
                mid = min + (max - min) / 2;
                int sum = 0;
                for (int i = 0; i < piles.length; i++) {
                    sum += Math.ceil(piles[i] / (double) mid);
                }
                if (sum <= h) {
                    max = mid;
                } else {
                    min = mid + 1;
                }
            }
            return min;
        }
    }

    public static void main(String[] args) {
        Solution test = new Question875().new Solution();
        int[] arr = new int[]{1000000000};
        System.out.println("test.minEatingSpeed(arr, 8) = " + test.minEatingSpeed(arr, 2));
    }
}
