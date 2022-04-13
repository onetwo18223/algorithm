package com.bhh.leetcode.swordfingeroffer.array;

/**
 * @author bhh
 * @description 0～n-1中缺失的数字
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [0,1,3]
 * 输出: 2
 * 示例2:
 * <p>
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 * @date Created in 2021-09-16 8:13
 * @modified By
 */
public class Question53_2 {
    class Solution {
        /*
        实现思路 :
            方法一 : 暴力解法
                直接遍历, 如果(当前数 + 1)不等于下一个数, 则返回 (当前数 + 1)
            方法二 : 二分查找
                因为这是一个递增的数组, 那么中间数就应该等于
                    (nums[l] + nums[r])/2
                    如果不等于就表示缺失数据在mid前
                    如果等于就表示缺失数据在mid后
                while循环, 循环结束条件为 l + 1 == r, 结束后判断 nums[l] + 1 是否等于 nums[r]
                    如果等于表示没有缺失
                    不等于表示缺失数据为nums[l] + 1
                错误

         */
        public int missingNumberError(int[] nums) {
            if (nums == null || nums.length == 0) {
                return -1;
            }

            if (nums[0] != 0){
                return 0;
            }
            if (nums.length == 1) {
                if (nums[0] == 0) {
                    return 1;
                }
            }

            // 寻找相邻的 l,r
            int l = 0, r = nums.length - 1;
            while (l < r && l + 1 != r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] < (nums[l] + nums[r]) / 2) {
                    l = mid;
                } else if (nums[mid] >(nums[l] + nums[r]) / 2){
                    r = mid;
                } else{
                    l++;
                }
            }

            // 判断 nums[l] + 1 是否等于 nums[r]
            if (nums[l] + 1 != nums[r]) {
                return nums[l] + 1;
            } else {
                return nums[r] + 1;
            }
        }
        public int missingNumber(int[] nums) {
            // 寻找相邻的 l,r
            int l = 0, r = nums.length - 1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] == mid) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            return l;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question53_2().new Solution().
                missingNumber(new int[]{
                        0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49
                }));
    }
}
