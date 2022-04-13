package com.bhh.leetcode.hot100twobrushes.array.twopoint.twosum;

import java.util.Arrays;

/**
 * @author bhh
 * @description 最接近的三数之和
 * @date Created in 2022-01-27 9:15
 * @modified By
 */
public class Question16 {
    class Solution {
        /*
        与三数之和不同点在于求得是最接近的数, 那么我们需要将所有可能遍历完 O(n^2)
        来获取最接近的可能
        我们需要一个可以临时存储的容器和对应的最接近的程度的属性(不需要了)
         */
        int res;
        public int threeSumClosest(int[] nums, int target) {
            // 用来存储最接近的三个数的和
            res = Integer.MAX_VALUE;
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                findSum(nums, i, target);
                if (res - target == 0) {
                    return res;
                }
            }
            return res;
        }

        private void findSum(int[] nums, int index, int target) {
            int start = index + 1, end = nums.length - 1;
            while (start <  end) {
                int sum = nums[index] + nums[start] + nums[end];
                res = res == Integer.MAX_VALUE ? sum : res;
                res = Math.abs(sum - target) < Math.abs(res - target) ? sum : res;
                if (sum > target) {
                    end--;
                } else if (sum < target) {
                    start++;
                } else {
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question16().new Solution().threeSumClosest(new int[]{1, 1, -1, -1, 3}
                , -1));
    }
}
