package org.qa.twopointer.copointer.sliding;

/**
 * @Desc 长度最小的子数组
 * https://leetcode.cn/problems/minimum-size-subarray-sum/
 * 实现：
 * 滑动窗口获取和
 *      取最小num
 * @Author bhh
 * @Date 2023-03-27 20:29
 * @Version 1.0
 */
public class Question209 {
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            if (null == nums || nums.length == 0) return 0;

            int res = nums.length + 1;
            int left = 0, right = 0;
            int sum = nums[0];
            while(left <= right && right < nums.length) {
                if (sum >= target) {
                    res = Math.min(res, right - left + 1);
                    sum -= nums[left++];
                }
                else {
                    if (++right >= nums.length) break;
                    sum += nums[right];
                }
            }
            return res == nums.length + 1 ? 0 : res;
        }
    }
}
