package com.bhh.leetcode.hot100.array;

/**
 * @author bhh
 * @description 下一个排列
 * @date Created in 2021-12-25 9:48
 * @modified By
 */
public class Question31 {
    class Solution {
        /*
        后面的一个较大的数和前面的一个较小的数进行交换, 交换之后对于前面后面的数进行排序即可
        从后向前寻找升序的元素对(i,j)(较大的排列, 那么一定是全部降序, 本题思想便是寻找升序元素对)
            相对的j到end一定是降序
        再从后向前(j到end)寻找一个大于i的元素k, 交换i和k
        交换之后, 因为需要的是下一个排列组合, 所以j 到 end 需要由 降序改为升序
         */
        public void nextPermutation(int[] nums) {
            if (nums == null || nums.length == 0) {
                return;
            }
            // 从后向前寻找升序元素对, 如果没有升序对, 则可直接进行降序转升序
            int aesStart = -1, aesEnd = 0;
            int end = nums.length - 1;
            for (int i = end; i > 0; i--) {
                if (nums[i] > nums[i - 1]) {
                    aesStart = i - 1;
                    aesEnd = i;
                    break;
                }
            }
            // aesEnd 到 end 寻找大于 aesStart 的数进行交换
            for (int i = end; i >= aesEnd; i--) {
                if (aesStart == -1) {
                    break;
                }
                if (nums[i] > nums[aesStart]) {
                    swap(nums, i, aesStart);
                    break;
                }
            }

            // 交换aesEnd 到 end, 降序转升序
            while (aesEnd < end) {
                swap(nums, aesEnd, end);
                aesEnd++;
                end--;
            }
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] ints = {
                2, 3, 1
        };
        new Question31().new Solution().nextPermutation(ints);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
