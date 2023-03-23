package org.problem.twopointer.reversepointer.twosum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * <p>
 * 实现：返回数值，那么可以使用和俩数之和相同方法的双指针算法
 * 先使用for循环定位一个数值，再寻找另外俩个数值
 * 注意：这个数组有重复数值，需要进行处理
 */
public class Question15 {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            ArrayList<List<Integer>> arrayList = new ArrayList<List<Integer>>();
            if (nums == null || nums.length == 0) {
                return arrayList;
            }
            Arrays.sort(nums);
            int l, r, target;
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                l = i + 1;
                r = nums.length - 1;
                target = -nums[i];
                while (l < r) {
                    int sum = nums[l] + nums[r];
                    if (sum == target) {
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[l]);
                        list.add(nums[r]);
                        arrayList.add(list);
                        l++;
                        r--;
                        while (l < r && nums[l] == nums[l - 1]) {
                            l++;
                        }
                    }
                    else if (sum > target) r--;
                    else l++;
                }
            }
            return arrayList;
        }
    }
}
