package org.problem.twopointer.reversepointer.partition;

import java.util.Random;

/**
 * 相向双指针 快速排序
 */
public class Partition {
    public void sort(int[] nums) {
        if (nums == null || nums.length == 0) return;
        sort(nums, 0, nums.length - 1);
    }

    public void sort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int temp = start + new Random().nextInt(end - start);
        swap(nums, start, temp);
        int i = start + 1, j = end;
        while (i <= j) {
            while (i <= j && nums[i] < nums[start]) i++;
            while (i <= j && nums[j] > nums[start]) j--;
            if (i <= j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }
        swap(nums, start, j);

        sort(nums, start, j);
        sort(nums, i, end);
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) throws Exception {
        Partition partition = new Partition();

        int n = 1000000;
        Random random = new Random();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = random.nextInt(Integer.MAX_VALUE);

        partition.sort(arr);

        for (int i = 1; i < n; i++)
            if (arr[i - 1] > arr[i]) throw new Exception("Error");

        System.out.println("Test MaxHeap completed.");

    }
}
