package org.problem.twopointer.copointer.sliding;

/**
 * 长度最小的子数组
 *
 * 实现：使用滑动窗口（类似于相向twoSum），
 *      对比值的和与target，
 *          若是和过小则right++；
 *          若是和过大则left--；
 * 注意：需要注意left和right的定义关系
 * 是(left, right) 还是 (left, right]
 * 在本题之中，(left, right)的实现较为简单
 *
 * 类比OfferQuestion57
 */
public class Question209 {
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            if (nums == null || nums.length == 0) return 0;

            int length = nums.length + 1;
            // (left, right)
            int left = 0, right = 0;
            int sum = nums[0];
            // 循环结束为 left == right || right == nums.length
            while(left <= right && right < nums.length) {
                // 如果sum和大于target，left右移
                if (sum >= target) {
                    length = Math.min(length, right - left + 1);
                    sum -= nums[left++];
                }
                // 如果sum和小于target，right右移
                else {
                    ++right;
                    if (right >= nums.length) break;
                    sum += nums[right];
                }
            }
            return length == nums.length + 1 ? 0 : length;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question209().new Solution().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }
}
