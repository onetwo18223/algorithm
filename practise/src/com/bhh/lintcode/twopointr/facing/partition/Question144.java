package com.bhh.lintcode.twopointr.facing.partition;

/**
 * @author bhh
 * @description 交错正负数
 * 给出一个含有正整数和负整数的数组，重新排列成一个正负数交错的数组。
 * @date Created in 2021-12-01 17:33
 * @modified By
 */
public class Question144 {
    public class Solution {
        /*
        这道题挺有意思, 先将正负数分割开来(快排)
        再根据正数和负数个数来进行交换
        -1 -2 -3 -4 1 2 3 负数较多, left从1开始, right从nums.length - 1开始进行交换
        每次left += 2, right -= 2
        正数较多时相反
        当正数和负数个数相等时, left从0开始, 则right从nums.length - 1开始
        总结 : 负数 > 正数 left从1开始, right从nums.length - 1开始
              负数 == 正数 left从0开始, right从nums.length - 1开始
              正数 > 负数 left从0开始, right从nums.length - 2开始
         */
        public void rerange(int[] nums) {
            if (nums == null || nums.length == 0){
                return;
            }
            int smallCount = partition(nums);
            int bigCount = nums.length - smallCount;
            int start = smallCount > bigCount ? 1 : 0;
            int end = nums.length - (smallCount < bigCount ? 2 : 1);
            swap(nums, start, end);
        }

        private void swap(int[] nums, int start, int end) {
            while (start < end){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start += 2;
                end -= 2;
            }
        }

        private int partition(int[] nums) {
            int start = 0, end = nums.length - 1;
            while (start <= end){
                while (start <= end && nums[start] < 0) {
                    start++;
                }
                while (start <= end && nums[end] > 0) {
                    end--;
                }
                if (start <= end){
                    int temp = nums[start];
                    nums[start] = nums[end];
                    nums[end] = temp;
                    start++;
                    end--;
                }
            }
            // start在while循环结束指向第一个正数,
            // 而第一个正数的索引可以用来表示负数的个数(因为索引从0开始)
            return start;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-33,-19,30,26,21,-9};
        new Question144().new Solution().rerange(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
