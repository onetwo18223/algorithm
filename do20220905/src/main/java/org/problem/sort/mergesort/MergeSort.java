package org.problem.sort.mergesort;

import org.util.Util;

import java.util.Arrays;

/**
 * 归并排序
 * 思想在于 先分后合
 * 重点在于merge阶段
 */
public class MergeSort {
    public void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        // 寻找中间元素索引位置
        int mid = start + (end - start) / 2;
        sort(nums, start, mid);
        // 注意应该是 mid + 1，而不是 mid, 原因是上一行sort已经分过该元素了
        sort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    private void merge(int[] nums, int start, int mid, int end) {
        // 进行拷贝，方便在原数组上进行数组合并
        // 需要注意的是复制过来的元素索引时从0开始，0 到 end - start + 1
        int[] temp = Arrays.copyOfRange(nums, start, end + 1);

        // 创建俩个索引，分别指向俩个需要合并的数组头首个元素
        int i = start, j = mid + 1;
        for (int k = start; k <= end; k++) {
            // 如果数组1的元素遍历完了，填充数组2的元素到nums[k]
            if (i > mid) {
                nums[k] = temp[j - start];
                j++;
                continue;
            }
            // 如果数组2的元素遍历完了，填充数组1的元素到nums[k]
            if (j > end) {
                nums[k] = temp[i - start];
                i++;
                continue;
            }
            // 俩个数组都有元素存在，比较大小后进行赋值
            if (temp[i - start] > temp[j - start]) {
                nums[k] = temp[j - start];
                j++;
            } else {
                nums[k] = temp[i - start];
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = Util.getArray();
        new MergeSort().sort(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }
}
