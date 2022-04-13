package com.bhh.sort.quicksort;

import com.bhh.sort.util.Util;

import java.util.Arrays;
import java.util.Random;

/**
 * @author bhh
 * @description 快排实现
 * @date Created in 2021-07-27 15:17
 * @modified By
 */
public class QuickSortMore {
    public <E extends Comparable> void partition(E[] arr) {
        int left = 0;
        int right = arr.length - 1;
        sort3(arr, left, right);
    }

    // arr[left + 1, ..., j] < v
    // arr[j + 1, ..., right/i-1] > v
    private <E extends Comparable> void sort(E[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        // 交换 left 和 随机索引 的位置, 防止有序数组造成快速排序效率低下问题
        int p = left + new Random().nextInt(right - left);
        swap(arr, left, p);

        // j存储着小于arr[left]的最后一个元素
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (arr[i].compareTo(arr[left]) <= 0 && (j + 1) != i) {
                // 如果需要进行交换, 交换目标是大于arr[left]的第一个元素,
                // 也就是j+1索引位置的元素
                swap(arr, j + 1, i);
                j++;
            }
        }
        // 大小集合排完, 排中间点
        swap(arr, left, j);

        sort(arr, left, j - 1);
        sort(arr, j + 1, right);
    }

    /**
     * 双路快排
     *
     * @param arr
     * @param l
     * @param r
     * @param <E>
     */
    private <E extends Comparable> void sort2(E[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        // 交换 l 和 随机索引 的位置, 防止有序数组造成快速排序效率低下问题
        int p = l + new Random().nextInt(r - l);
        swap(arr, l, p);

        int i = l + 1;
        int j = r;
        // 为什么需要 i <= j, 而不是 <
        // 因为如果只有俩个数情况下, i == j, 而这时候还是需要判断这俩个数的大小
        while (i <= j) {
            // while结束条件是 i越界, 或者 i索引位置的数据有大于a[l]
            while (i <= j && arr[i].compareTo(arr[l]) < 0) {
                i++;
            }
            // while结束条件是 j越界, 或者 j索引位置的数据有小于a[l]
            // 注意事项 arr[j].compareTo(arr[l]) > 0 而不是 >=
            // 否则出现 [1,1,1,1,1]这样的极端情况下时间复杂度退化为O(n^2)
            while (i <= j && arr[j].compareTo(arr[l]) > 0) {
                j--;
            }
            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        // 注意 : j元素在循环结束后总能指向小于arr[l]的最大数索引位置, 极端值为j == i - 1 == left;
        // 而i元素再循环结束后总能指向大于arr[l]的最小数索引位置, 极端值为 i == right + 1 (越界);
        // 大小集合排完, 排中间点
        swap(arr, l, j);

        sort2(arr, l, j - 1);
        sort2(arr, j + 1, r);
    }

    /**
     * 三路快排
     * @param arr
     * @param l
     * @param r
     * @param <E>
     */
    private <E extends Comparable> void sort3(E[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        // 交换 l 和 随机索引 的位置, 防止有序数组造成快速排序效率低下问题
        swap(arr, l, l + new Random().nextInt(r - l));

        // lt指向小于 指定点 的最后一个元素
        // gt指向大于 指定点 的最后一个元素
        int lt = l;
        int gt = r + 1;

        for (int i = l + 1; i < gt; i++) {
            // arr[l + 1, ..., lt] < v
            // arr[lt + 1, ..., i - 1] == v
            // arr[gt, ..., r] > v
            if (arr[i].compareTo(arr[l]) > 0) {
                gt--;
                swap(arr, i, gt);
                // 为什么减一, 因为这时候 i 还没有遍历到索引位置 gt,
                // 交换之后需要进行重新遍历
                i--;
            } else if (arr[i].compareTo(arr[l]) < 0) {
                lt++;
                swap(arr, i, lt);
            }
        }
        // 大小集合排完, 排中间点
        swap(arr, l, lt);

        sort3(arr, l, lt - 1);
        sort3(arr, gt, r);
    }

    private <E extends Comparable> void swap(E[] arr, int k, int i) {
        if (k == i) {
            return;
        }
        E temp = arr[i];
        arr[i] = arr[k];
        arr[k] = temp;
    }

    public static void main(String[] args) {
        QuickSortMore sort = new QuickSortMore();
        Integer[] test = Util.getInteger(10000);
//        Integer[] test = new Integer[]{1, 3, 4, 1, 114, 23};
        sort.partition(test);
        Arrays.stream(test).forEach(System.out::println);
        System.out.println("Util.isSorted(test) = " + Util.isSorted(test));
    }
}
