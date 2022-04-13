package com.bhh.leetcode.headquarters;

import java.util.Arrays;

/**
 * @author bhh
 * @description 1011
 * @date Created in 2021-07-30 17:03
 * @modified By
 */
public class Question1011 {
    class Solution {
        public int shipWithinDays(int[] weights, int days) {
            int min = Arrays.stream(weights).max().getAsInt();
            int max = Arrays.stream(weights).sum();
            return search(weights, min, max, days);
        }

        private int search(int[] weights, int min, int max, int days) {
            int mid;
            while (min < max) {
                mid = min + (max - min + 1) / 2;
                int sum = 0, count = 0;
                for (int i = 0; i < weights.length; i++) {
                    sum += weights[i];
                    if (sum >= mid) {
                        count++;
                        sum = 0;
                        i--;
                    }
                }

                if (count < days){
                    max = mid - 1;
                }else{
                    min = mid;
                }
            }
            return min;
        }
    }

    public static void main(String[] args) {
        Solution test = new Question1011().new Solution();
        System.out.println(test.shipWithinDays(new int[]{3,2,2,4,1,4}, 3));
    }
}
