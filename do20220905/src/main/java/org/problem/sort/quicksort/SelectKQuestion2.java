package org.problem.sort.quicksort;

import org.util.Util;

import java.util.Arrays;
import java.util.Random;

/**
 * 快速选择二次变式题目
 * 获取最小的k个数(这些数不要求是排好序的)
 * 只需要找核心点，然后返回前面的值
 */
public class SelectKQuestion2 {

    public int[] getLeastNumbers(int[] nums, int k) {
        // 若是要求第0个数，则直接返回一个空数组
        if (k == 0) return new int[0];
        selectK(nums, 0, nums.length - 1, k - 1);
        // Arrays.copyof(int[], length);
        return Arrays.copyOf(nums, k);
    }

    private int selectK(int[] nums, int start, int end, int k) {
        int p = partition(nums, start, end);
        if (p == k) return nums[p];
        if (p > k) return selectK(nums, start, p - 1, k);
        return selectK(nums, p + 1, end, k);
    }

    private int partition(int[] nums, int start, int end) {
        int p = new Random().nextInt(end - start + 1);
        swap(nums, p, start);
        int i = start + 1;
        int j = end;
        while (true) {
            while (i <= j && nums[i] < nums[start]) i++;
            while (i <= j && nums[j] > nums[start]) j--;
            if (i >= j) break;
            swap(nums, i, j);
            i++;
            j--;
        }
        swap(nums, start, j);
        return j;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        int[] nums = Util.getArray();
        int[] res = new SelectKQuestion2().getLeastNumbers(nums, 5);
        System.out.println("res:");
        Arrays.stream(res).forEach(System.out::println);

        new QuickSort().sort(nums);
        System.out.println("numsRes:");
        Arrays.stream(nums).forEach(System.out::println);
    }
}
