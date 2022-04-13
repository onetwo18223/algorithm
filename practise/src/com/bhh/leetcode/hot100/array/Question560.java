package com.bhh.leetcode.hot100.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author bhh
 * @description 给你一个整数数组 nums 和一个整数 k ，请你统计并返回该数组中和为 k 的连续子数组的个数。
 * @date Created in 2021-12-21 8:37
 * @modified By
 */
public class Question560 {
    class Solution {
        /*
        错误解法
        实现思路 : 要求是连续子数组的个数
        指针 left 遍历 nums
        指针 right 跟随 left, 向left后进行递增到sum,
            若是sum值大于k, 则sum - nums[left++]
            若是sum值等于k, 则记录个数num++, sum - nums[left++]
            若是sum值小于k, 则sum + nums[++right]
         */
        public int subarraySum1(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            Arrays.sort(nums);
            int num = 0, sum = 0;
            int left = 0, right;
            sum += nums[left];
            right = left + 1;
            while (left < nums.length) {
                if (right == left) {
                    sum += nums[left];
                    right++;
                }
                while (right < nums.length) {
                    if (sum > k) {
                        sum -= nums[left++];
                        break;
                    } else if (sum < k) {
                        right++;
                        if (right >= nums.length) {
                            return num;
                        }
                    } else {
                        num++;
                        sum -= nums[left++];
                        break;
                    }
                    sum += nums[right];
                }
            }
            return num;
        }

        /*
        求数组连续元素的和可以使用前缀和完成
            前缀和：nums 的第 0 项到 当前项 的和。
            定义 prefixSum 数组，prefixSum[x]：第 0 项到 第 x 项 的和。
            prefixSum[x] = nums[0] + nums[1] +…+nums[x]

            nums 的某项 = 两个相邻前缀和的差：
            nums[x] = prefixSum[x] - prefixSum[x - 1]

            nums 的 第 i 到 j 项 的和，有：
            nums[i] +…+ nums[j] = prefixSum[j] - prefixSum[i - 1]

            当 i 为 0，此时 i-1 为 -1，我们故意让 prefixSum[-1] 为 0，使得通式在i=0时也成立：
            nums[0] +…+ nums[j] = prefixSum[j]

            其次, 本题只要求求出个数, 所以只需配合map即可以O(n)复杂度求出
            原理 : nums[i] +…+nums[j] = prefixSum[j] - prefixSum[i - 1]
            那么我们向map中存储每一个元素的前缀和
            当 map.contain(当前元素的前缀和 - k), 表示有历史元素前缀和存在,
                若是 当前元素的前缀和 - k 的元素前缀和存在, 那么 k 充当元素前缀和是一定存在的
                这时, count + 1即可


         */
        public int subarraySum(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            int preSum = 0;
            int num = 0;
            for (int i = 0; i < nums.length; i++) {
                preSum += nums[i];
                if (map.containsKey(preSum - k)){
                    num += map.get(preSum - k);
                }
                map.put(preSum, map.getOrDefault(preSum, 0) + 1);
            }
            return num;
        }
    }
}
