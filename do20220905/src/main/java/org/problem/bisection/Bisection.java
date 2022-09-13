package org.problem.bisection;

import org.problem.sort.mergesort.MergeSort;

import java.util.Arrays;
import java.util.Random;

/**
 * 分
 */
public class Bisection {
    /**
     * 获取指定数值的索引值
     *
     * @param nums   数组
     * @param target 目标值
     * @return 索引值
     */
    public int getIndex(int[] nums, int target) {
        return getIndex(nums, target, 0, nums.length - 1);
    }

    private int getIndex(int[] nums, int target, int l, int r) {
        // 结束条件 l + 1 == r
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) return mid;
            if (nums[mid] > target) {
                r = mid - 1;
            }
            // if (nums[mid] < target)
            else {
                l = mid + 1;
            }
        }
        if (nums[l] == target) {
            return l;
        }
        return r;
    }

    public static void main(String[] args) {

        Bisection bisection = new Bisection();

        int n = 100;
        int[] arr = new int[n];
        Random random = new Random();
        for (int i = 0; i < n - 1; i++)
            arr[i] = random.nextInt(Integer.MAX_VALUE);

        arr[n - 1] = 200000000;
        MergeSort sort = new MergeSort();
        sort.sort(arr);

        Arrays.stream(arr).forEach(System.out::println);
        System.out.println("res");

        System.out.println(bisection.getIndex(arr, 200000000));
    }
}
