package org.qa.twopointer.reversepointer.partition;

import java.util.Random;

/**
 * @Desc 快速排序
 * @Author bhh
 * @Date 2023-03-01 11:13
 * @Version 1.0
 */
public class Partition {
    public void sort(int[] nums) {
        if (null == nums || nums.length == 0) return;
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int start, int end) {
        // TODO:为什么递归结束条件需要为 start >= end？
        //  因为当start == end时便不需要排序了
        if (start >= end) return;
        // 随机选取一个数据进行交换
        int temp = start + new Random().nextInt(end - start);
        swap(nums, start, temp);
        // 双路快排 从小到大排
        int i = start + 1, j = end;
        // 循环判断条件为 i <= j，循环结束条件为 j + 1 == i
        while (i <= j) {
            // TODO:等于的情况也需要交换
            while(i <= j && nums[i] < nums[start]) i++;
            while(i <= j && nums[j] > nums[start]) j--;
            if (i <= j) {
                swap(nums, i, j);i++;j--;
            }
        }
        // 位置还原
        // TODO:为什么交换的元素是 j，而不是 i
        //  因为循环交换判断之后，所有 i 到 end 都大于等于nums[start]
        //  而所有 start 到 j 都小于等于nums[start]
        //  所以 j 是指向小于等于 nums[start] 的最后一个元素
        //  i 是指向大于等于 nums[start] 的第一个元素
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
