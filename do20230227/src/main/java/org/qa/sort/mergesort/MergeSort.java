package org.qa.sort.mergesort;

import java.util.Arrays;

/**
 * @Desc 归并排序
 * 归并排序和快排相反，归并是先小后大，而快排是先大小
 * 归并使用深层递归
 * @Author bhh
 * @Date 2023-03-01 15:02
 * @Version 1.0
 */
public class MergeSort {
    public void sort(int[] nums){
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int start, int end) {
        // TODO: 递归结束条件
        if (start >= end) return;
        int mid = start + (end - start) / 2;
        sort(nums, start, mid);
        sort(nums, mid + 1, end);

        merge(nums, start, mid, end);
    }

    private void merge(int[] nums, int start, int mid, int end) {
        // TODO: 需要复制数组，暂时使用非原地归并方法
        //  在使用Arrays.copyOfRange() 需要注意结尾参数应该是end + 1
        //  复制数组充当参考，对原数组进行重新赋值
        int[] temp = Arrays.copyOfRange(nums, start, end + 1);
        // 创建俩个索引分别指向数组俩边首部
        int i = start, j = mid + 1;
        for (int k = start; k <= end; k++) {
            // 数组1已经遍历完成
            if (i > mid) {
                // TODO: 是因为是复制的数组，所以索引位置并没有完全一致
                //  复制的数组索引 - start 才和原数组对其
                nums[k] = temp[j - start];
                j++;
                continue;
            }
            if (j > end) {
                nums[k] = temp[i - start];
                i++;
                continue;
            }
            if (temp[i - start] > temp[j - start]) {
                nums[k] = temp[j - start];
                j++;
            } else {
                nums[k] = temp[i - start];
                i++;
            }
        }
    }

    public static void main(String[] args) throws Exception {

        int n = 1000000;
        int[] arr = new int[n];

        new MergeSort().sort(arr);

        for (int i = 1; i < n; i++)
            if (arr[i - 1] < arr[i]) throw new Exception("Error");
        System.out.println("Test completed.");
    }
}
