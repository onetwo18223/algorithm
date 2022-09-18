package org.problem.sort.quicksort;

import org.util.Util;

import java.util.Arrays;
import java.util.Random;

/**
 * 快排实现：
 * 实现快排需要先拿一个元素和其他元素进行比较，
 * 遍历数组，将数组元素分为大于等于指定值和小于指定值，
 * 递归分好的俩个数组
 * 结束条件为只有一个元素存在
 *
 * @author Bhh
 */
public class QuickSort {

    public void sort(int[] nums) {
        sortTwoLine(0, nums.length - 1, nums);
    }

    private void sortTwoLine(int start, int end, int[] nums) {
        if (start >= end) {
            return;
        }
        // 选择一个数进行交换，防止快排时间复杂度降低
        // int random = new Random().nextInt(end - start);
        int random = start + new Random().nextInt(end - start);
        // 交换
        swap(nums, start, random);
        // 建立俩个索引
        // 索引i永远指向下一个大于nums[start]的元素
        // 索引j永远指向下一个小于nums[start]的元素
        int i = start + 1;
        int j = end;
        while (i <= j) {
            // 结束循环的条件是 越界 或者是 出现nums[i] <= nums[start]
            while (i <= j && nums[i] > nums[start]) {
                i++;
            }
            // 结束循环的条件是 越界 或者是 出现nums[j] >= nums[start]
            while (i <= j && nums[j] < nums[start]) {
                j--;
            }
            if (i <= j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }

        // i 结束时指向小于nums[start]的第一个元素
        // j 结束时指向大于nums[start]的最后一个元素
        // j == i - 1
        // 交换j和start后，从 start 到 j 都是大于等于 nums[start]的数据
        // 如果不交换，strat 到 j 也是大于等于 nums[start]的数据
        // 不交换会出现StackOverflow报错
        /*
        非常愚蠢的问题但也容易忽视的问题：为啥要交换标定点start 和 j的位置？
        因为是排序，应该让合适的值（标定点值）处于中心位置
        这个标定点的位置在排序中一定是正确的
        */
        swap(nums, j, start);

        sortTwoLine(start, j, nums);
        sortTwoLine(i, end, nums);
    }

    private void swap(int[] nums, int index1, int index2) {
        int num = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = num;
    }

    public static void main(String[] args) throws Exception {

        QuickSort quick = new QuickSort();

        int n = 1000000;
        Random random = new Random();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = random.nextInt(Integer.MAX_VALUE);

        quick.sort(arr);

        for (int i = 1; i < n; i++)
            if (arr[i - 1] < arr[i]) throw new Exception("Error");

        System.out.println("Test MaxHeap completed.");
    }
}
