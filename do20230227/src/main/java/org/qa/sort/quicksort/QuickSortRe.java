package org.qa.sort.quicksort;

import java.util.Random;

/**
 * @Desc 快速排序
 *
 * @Author bhh
 * @Date 2023-03-28 20:46
 * @Version 1.0
 */
public class QuickSortRe {
    public void sort(int[] nums) {
        if (null == nums || nums.length == 0) return;
        this.quickSort(nums, 0, nums.length );
    }

    private void quickSort(int[] nums, int start, int end) {
        // 递归结束条件
        if (start >= end) return;
        int fir = new Random().nextInt(end - start) + start;
        this.swap(nums, fir, start);
        int value = nums[start];
        int l = start + 1, r = end - 1;
        while(l <= r){
            while(l <= r && nums[l] < value) l++;
            while(l <= r && nums[r] > value) r--;
            if (l > r) break;
            swap(nums, l, r);
            l++;r--;
        }
        swap(nums, start, r);
        quickSort(nums, start, r);
        quickSort(nums, l, end);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) throws Exception {
        QuickSortRe quick = new QuickSortRe();

        int n = 1000000;
        Random random = new Random();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = random.nextInt(Integer.MAX_VALUE);

        quick.sort(arr);

        for (int i = 1; i < n; i++)
            if (arr[i - 1] > arr[i]) throw new Exception("Error");

        System.out.println("Test MaxHeap completed.");
    }
}
