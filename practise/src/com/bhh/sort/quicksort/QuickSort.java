package com.bhh.sort.quicksort;

import com.bhh.sort.sort.Sort;
import com.bhh.sort.util.Util;

import java.util.Arrays;

/**
 * @author bhh
 * @description 快排实现
 * <p>
 * 实现原理 :
 * 选取数组首个元素为标定点
 * 将数组数据分为 小于标定点, 大于标定点
 * 需要一个索引指向 小于范围
 * @date Created in 2021-08-27 10:53
 * @modified By
 */
public class QuickSort implements Sort {
    @Override
    public <T extends Comparable> void sort(T[] data) {

        sort(data, 0, data.length - 1);
    }

    private <T extends Comparable> void sort(T[] data, int l, int r) {

        if (l >= r) {
            return;
        }

        int j = partition(data, l, r);
        sort(data, l, j - 1);
        sort(data, j + 1, r);
    }

    private <T extends Comparable> int partition(T[] data, int l, int r) {
        /*
        将数组分为俩部分 <= data[l] 和 > data[r]
         */
        // 索引 j 指向小于等于集合最后一个元素
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (data[i].compareTo(data[l]) < 0) {
                j++;
                swap(data, i, j);
            }
        }
        swap(data, l, j);
        return j;
    }

    private <T extends Comparable> void swap(T[] data, int i, int j) {
        T swap = data[i];
        data[i] = data[j];
        data[j] = swap;
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
//        Integer[] integer = Util.getInteger(10);
//        Arrays.stream(integer).forEach(System.out::println);
//        QuickSort qs = new QuickSort();
//        qs.sort(integer);
//        System.out.println("-------------------------------------");
//        Arrays.stream(integer).forEach(System.out::println);
        Util.sortTest("com.bhh.sort.quicksort.QuickSort", 10);
    }
}
