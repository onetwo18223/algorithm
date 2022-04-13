package com.bhh.leetcode.hot100.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bhh
 * @description 给你一个包含 n 个整数的数组nums，
 * 判断nums中是否存在三个元素 a，b，c ，
 * 使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 输入：nums = [-1,0,1,2,-1,-4]
 * -4, -1, -1, 0, 1, 2, 3
 * <p>
 * <p>
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 注意：答案中不可以包含重复的三元组。
 * @date Created in 2021-11-05 21:33
 * @modified By
 */
public class Question15 {
    class Solution {
        /*
        实现思路 : 排序 + 双指针碰撞 + hash
        排序, 双指针left == 0, right == size() - 1
        (若是nums[left]>0, 则可中断循环)从left开始, 和right进行判断, 相加再通过hash获取剩余的一位,
            若找不到, 则right -- , 直到right == left
            若找的到, 若是第三个数索引位置大于right, 或是小于left, 则left ++;
                    否则right --;
        三数之和 = for + 俩数之和
         */
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
//            if (nums == null || nums.length == 0){
//                return res;
//            }
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                if(i > 0 && nums[i] == nums[i-1]) continue;
                findTwoSum(nums, i, res);
            }
            return res;
        }

        private void findTwoSum(int[] nums, int index, List<List<Integer>> res) {
            int target = -nums[index];
            int start = index + 1;
            int end = nums.length - 1;
            while (start < end) {
                if (nums[start] + nums[end] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[index]);
                    list.add(nums[start]);
                    list.add(nums[end]);
                    res.add(new ArrayList<>(list));
                    start++;
                    end--;
                    // 寻找 b, c 值时, 防止出现 题目所不要求的"结果不能包含重复的三元组"
                    while (start < end && nums[start] == nums[start - 1]) {
                        start++;
                    }
                } else if (nums[start] + nums[end] > target) {
                    end--;
                } else {
                    start++;
                }
            }
        }
    }
}
