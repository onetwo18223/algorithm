package org.qa.twopointer.reversepointer.twosum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Desc 三数之和
 * https://leetcode.cn/problems/3sum/?favorite=2cktkvj
 * 实现：
 * 返回值，使用双指针
 * 因为是三个数，所以先固定一个数，然后再使用双指针遍历确定另外俩个数
 * 即使用for+双指针遍历模式
 * @Author bhh
 * @Date 2023-02-27 14:15
 * @Version 1.0
 */
public class Question15 {
    class Solution {
        // [-1,0,1,2,-1,-4]
        public List<List<Integer>> threeSum(int[] nums) {

            ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
            if (null == nums || nums.length == 0) return res;
            Arrays.sort(nums);

            int length = nums.length;
            int target;
            int left, right;
            for (int i = 0; i < length; i++) {
                // TODO:避免重复第一步
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                target = -nums[i];
                left = i + 1;
                right = length - 1;
                twoSum(nums, res, target, left, right);
            }
            return res;
        }

        private void twoSum(int[] nums, ArrayList<List<Integer>> res, int target, int left, int right) {
            int sum;
            while (left < right) {
                sum = nums[left] + nums[right];
                if (sum == target) {
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(-target);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                    left++;
                    right--;
                    // 避免重复元素出现
                    // TODO:避免重复第二步
                    while(left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }
                else if (sum > target) {
                    right--;
                }
                else {
                    left++;
                }
            }
        }
    }
}
