package org.qa.sort.quicksort;

import org.util.Util;

import java.util.Arrays;
import java.util.Random;

/**
 * @Desc 快速选择：获取数组中第K大的值
 * 使用快排每次可以获取一个元素的正确索引位置，
 * 可以依据此特性获取第K大的值
 * @Author bhh
 * @Date 2023-03-28 22:13
 * @Version 1.0
 */
public class QuickSelect {
    public int getKValue(int[] nums, int k) {
        // TODO: 如果是寻找第K个最大数，则需要使用len - k，
        //  例如最大值为len - 1
        //  如果要寻找的是第K个最小数，则需要使用 K - 1
        //  例如最小值为 1 - 1
        return this.doGetKValue(nums, nums.length - k, 0, nums.length - 1);
    }

    private int doGetKValue(int[] nums, int k, int start, int end) {
        int p = this.partition(nums, start, end);
        if (p == k) return nums[p];
        if (k < p) return this.doGetKValue(nums, k, start, p - 1);
        return this.doGetKValue(nums, k, p + 1, end);
    }

    private int partition(int[] nums, int l, int r) {
        if (l >= r) return r;
        // 生成 [l, r] 之间的随机索引
        int p = l + new Random().nextInt(r - l);
        this.swap(nums, l, p);
        // arr[l+1...i-1] <= v; arr[j+1...r] >= v
        int i = l + 1, j = r;
        while (i <= j) {
            while (i <= j && nums[i] < nums[l]) i++;
            while (i <= j && nums[j] > nums[l]) j--;
            if (i >= j) break;
            this.swap(nums, i, j);
            i++;j--;
        }
        this.swap(nums, l, j);
        return j;
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = Util.getArray();
        Arrays.stream(nums).forEach(System.out::println);
        QuickSelect test = new QuickSelect();
        System.out.println("\nreq:" + test.getKValue(nums, 2 - 1));
    }
}
