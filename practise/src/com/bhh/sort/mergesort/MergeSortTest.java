package com.bhh.sort.mergesort;

import com.bhh.sort.sort.Sort;
import com.bhh.sort.util.Util;

import java.util.Arrays;


/**
 * @author bhh
 * @description 归并排序
 * @date Created in 2021-09-13 10:49
 * @modified By
 */
public class MergeSortTest implements Sort {

    @Override
    public <T extends Comparable> void sort(T[] data) {
        sort(data, 0, data.length - 1);
    }

    private <T extends Comparable> void sort(T[] data, int l, int r) {

        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        sort(data, l, mid);
        sort(data, mid + 1, r);
        merge(data, l, mid, r);
    }

    private <T extends Comparable> void merge(T[] data, int l, int mid, int r) {
        T[] temp = Arrays.copyOfRange(data, l, r + 1);
        int small = l;
        int big = mid + 1;
        for (int i = l; i <= r; i++) {
            /*
            优先考虑越界
            其次考虑对比
             */
            if (small > mid) {
                data[i] = temp[big - l];
                big++;
            } else if (big > r) {
                data[i] = temp[small - l];
                small++;
            } else if (temp[small - l].compareTo(temp[big - l]) < 0) {
                data[i] = temp[small - l];
                small++;
            } else {
                data[i] = temp[big - l];
                big++;
            }
        }
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Util.sortTest("com.bhh.sort.mergesort.MergeSortTest", 1);
    }
}
