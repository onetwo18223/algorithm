package com.bhh.lintcode.twopointr.facing.partition;

/**
 * @author bhh
 * @description 数组划分
 * @date Created in 2021-12-01 17:20
 * @modified By
 */
public class Question31 {
    public class Solution {
        /*
        目标不同
            Partition Array需要严格的左半部分<k,右半部分>=k
            Quick Sort / Quick Select只需要左半部分整体<=右半部分即可
                如果Quick Sort / Quick Select把== pivot的严格划分到左边或者右边，
                会导致极端情况发生从而时间复杂度很容易退化到O(n^2)
                如排序[1,1,1,1,1]
         */
        public int partitionArray(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int start = 0;
            int end = nums.length - 1;
            // 寻找 k 的下标
            int kIndex = search(nums, k, start, end);
            if (kIndex == -1) {
                return 0;
            }
            swap(nums, kIndex, start);
            start++;
            while (start <= end) {
                while (start <= end && nums[start] < nums[0]) {
                    start++;
                }
                while (start <= end && nums[end] >= nums[0]) {
                    end--;
                }
                if (start <= end) {
                    swap(nums, start, end);
                    start++;
                    end--;
                }
            }
            swap(nums, 0, end);
            return end;
        }

        private void swap(int[] nums, int kIndex, int start) {
            int temp = nums[kIndex];
            nums[kIndex] = nums[start];
            nums[start] = temp;
        }

        private int search(int[] nums, int k, int start, int end) {
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (nums[mid] == k) {
                    return mid;
                } else if (nums[mid] > k) {
                    end = mid;
                } else {
                    start = mid;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question31().new Solution().partitionArray(new int[]{
                7, 7, 9, 8, 6, 6, 8, 7, 9, 8, 6, 6
        }, 10));
    }
}
