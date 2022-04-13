package com.bhh.sort.quicksort;

import com.bhh.sort.util.Util;

import java.util.Arrays;
import java.util.Random;

/**
 * @author bhh
 * @description 二路快排实现
 * @date Created in 2021-12-22 15:34
 * @modified By
 */
public class Test {
    // 快排, 将一个数组分为大于x的一部分, 小于x的一部分, 然后让他们继续排序
    // 排序的顺序是从宏观到微观, 相反与归并排序
    public void sort2(Integer[] nums, int start, int end) {
        // 递归结束条件
        // 结束条件为 start < end, 不放过任何一个元素
        if (start >= end) {
            return;
        }

        // 随机获取一个数, 防止出现极端情况导致快排退化
        int p = start + new Random().nextInt(end - start);
//        int mid = start + (end - start) / 2;
        swap(nums, p, start);

        // i 指向下一个小于 nums[start] 的数
        int i = start + 1;
        // j 指向下一个大于 nums[start] 的数
        int j = end;
        while (i <= j) {
            // 结束条件是 越界 或者 i对应的数值大于nums[start]
            while (i <= j && nums[i] < nums[start]) {
                i++;
            }
            // 结束条件是 越界 或者 j对应的数值小于nums[start]
            while (i <= j && nums[j] > nums[start]) {
                j--;
            }
            if (i <= j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }
        // 遍历结束后, j + 1 == i, 即j指向小于nums[start]的最后一个元素
        swap(nums, j, start);

        sort2(nums, start, j);
        sort2(nums, i, end);
    }

    private void swap(Integer[] arr, int k, int i) {
        if (k == i) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[k];
        arr[k] = temp;
    }

    public static void main(String[] args) {
        Test sort = new Test();
        Integer[] testInteger = Util.getInteger(10000);
//        Integer[] testInteger = new Integer[]{1, 3, 4, 1, 114, 23};
        sort.sort2(testInteger, 0, testInteger.length - 1);
        Arrays.stream(testInteger).forEach(System.out::println);
        System.out.println("Util.isSorted(testInteger) = " + Util.isSorted(testInteger));
    }

}
