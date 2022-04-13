package com.bhh.datastructure.array;

/**
 * @author bhh
 * @description 二分查找各种问题
 * @date Created in 2021-10-13 15:18
 * @modified By
 */
public class BinarySearch {
    int left_bound(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length; // 注意

        while (left < right) { // [left, right)
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid; // 注意
            }
        }
        return left;
    }

    int right_bound(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                left = mid + 1; // 注意
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return left - 1; // 注意
    }

    public static void main(String[] args) {
        System.out.println(new BinarySearch().left_bound(new int[]{
//                1, 3, 3, 4, 5, 5, 6, 6
                0, 1, 2, 2, 3, 4
        }, 2));
    }

}
