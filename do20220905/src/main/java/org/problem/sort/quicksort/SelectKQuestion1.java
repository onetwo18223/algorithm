package org.problem.sort.quicksort;

import org.util.Util;

import java.util.Arrays;
import java.util.Random;

/**
 * 获取到数组中第K索引的值
 * Select题目可以使用优先队列和快速选择（快速排序变形）
 */
public class SelectKQuestion1 {

    /**
     * @param nums
     * @param k    第K大的元素对应的索引位置
     *             需要注意转换，例如第一大的元素索引位置是在0
     * @return
     */
    public int selectK(int[] nums, int k) {
        return selectK(nums, 0, nums.length - 1, k - 1);
    }

    public int selectK(int[] nums, int start, int end, int k) {
        int p = partition(nums, start, end);
        // 题目一般要求值，返回nums[index]即可
        // 注意k和p的比较，在本方法中，使用的是降序排序
        // 若是k较大，表示索引对应的值较小，所以要去右侧查询
        // 若是升序排序，k较小，表示索引对应的值较小，所以要去右侧查询
        if (k == p) {
            return nums[p];
        } else if (k > p) {
            return selectK(nums, p + 1, end, k);
        }
        return selectK(nums, start, p - 1, k);
    }

    /**
     * QuickSort核心代码的变式
     *
     * @param nums  数组
     * @param start 开始索引
     * @param end   结束索引
     * @return 返回中心元素的索引值
     */
    public int partition(int[] nums, int start, int end) {
        // 因为是快速选择，所以不可能不存在要寻找的数值，
//        if (start >= end) {
//            return 0;
//        }
        if (start < end) {
            int random = start + new Random().nextInt(end - start);
            swap(nums, start, random);
        }

        int i = start + 1, j = end;

        while (i <= j) {
            while (i <= j && nums[i] > nums[start]) {
                i++;
            }
            while (i <= j && nums[j] < nums[start]) {
                j--;
            }
            if (i <= j) {
                swap(nums, i, j);
                i++;
                j--;
            }
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
        Arrays.stream(nums).forEach(System.out::println);
        SelectKQuestion1 test = new SelectKQuestion1();
        new QuickSort().sort(nums);
        System.out.println("test");
        Arrays.stream(nums).forEach(System.out::println);
        System.out.println("\nreq:" + test.selectK(nums, 5));
    }
}
