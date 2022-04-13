package com.bhh.leetcode.swordfingeroffer.array;

/**
 * @author bhh
 * @description 在排序数组中查找数字 I
 * 统计一个数字在排序数组中出现的次数。
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 * @date Created in 2021-09-15 19:52
 * @modified By
 */
public class Question53_1 {
    class Solution {
        /*
        实现思路 :
        通过二分查找查找到指定target, 因为是有序数组, 所以只需查找前后索引是否还为target, 直到不是target为止
         */
        public int search(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            // 二分查找查询
            int index = -1;
            int l = 0, r = nums.length - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] > target) {
                    r = mid - 1;
                } else if (nums[mid] <= target) {
                    l = mid + 1;
                }
//                else {
//                    index = mid;
//                    break;
//                }
            }

            if (index == -1) {
                return 0;
            }

            int sum = 1;
            int ll = index - 1, rr = index + 1;
            // 判断索引左右是否还有对应值
            while (ll >= 0 && nums[ll] == nums[index]) {
                ll--;
                sum++;
            }
            while (rr < nums.length && nums[rr] == nums[index]) {
                rr++;
                sum++;
            }

            return sum;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question53_1().new Solution().
                search(new int[]{5, 7, 7, 8, 8, 10}, 8));
    }
}
