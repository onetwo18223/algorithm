package com.bhh.leetcode.headquarters;

import java.util.Arrays;

/**
 * @author bhh
 * @description TODO
 * @date Created in 2021-07-28 12:07
 * @modified By
 */
public class Question75 {
    //    class Solution {
    public void sortColors(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int l, int r) {
        int lt = l - 1;
        int gt = r + 1;
        for (int i = l; i < gt; i++) {
            if (nums[i] == 0) {
                lt++;
                swap(nums, i, lt);
            } else if (nums[i] == 2) {
                gt--;
                swap(nums, i, gt);
                i--;
            }
        }
    }

    private void swap(int[] arr, int k, int i) {
        if (k == i) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[k];
        arr[k] = temp;
    }

    public static void main(String[] args) {
        Question75 test = new Question75();
        int[] nums = {0, 1, 2, 2, 0};
        test.sortColors(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }
}
