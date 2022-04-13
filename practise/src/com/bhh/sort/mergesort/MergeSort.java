package com.bhh.sort.mergesort;

import com.bhh.sort.sort.Sort;
import com.bhh.sort.util.Util;

import java.util.Arrays;

/**
 * @author bhh
 * @description 归并排序实现
 * <p>
 * 实现原理 : 将数组进行拆分, 进行排序, 之后再进行合并
 * 归并排序的时间复杂度如何计算?
 * 拆分 + 合并, 每一层都是一个O(n)的复杂度
 * 而因为是中间拆分, 所以会有 logn 层
 * 长乘以宽 = O(nlogn)
 * @date Created in 2021-08-26 14:47
 * @modified By
 */
public class MergeSort implements Sort {

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
        /*
        合并思路 : 需要俩个索引, 每一个都标注一个集合的开端
        判断俩个集合的大小
         */
        T[] temp = Arrays.copyOfRange(data, l, r + 1);
        int small = l; // small
//        int small = 0;

        int big = mid + 1; // big
//        int big = mid + 1 - l;

        for (int i = l; i <= r; i++) {
            // 如果 左边集合 越界,(左集合数据已经遍历完)
            if (small > mid) {
                data[i] = temp[big - l];
                big++;
            }
            // 如果 右边集合 越界,(右集合数据已经遍历完)
            else if (big > r) {
                data[i] = temp[small - l];
                small++;
            }
            // 左集合当前索引对应值和右集合当前索引对应值进行比较, 若左小于等于右, 使用左
            else if ( temp[small - l].compareTo(temp[big - l]) < 0){
                data[i] = temp[small - l];
                small++;
            }
            // 左集合当前索引对应值和右集合当前索引对应值进行比较, 若右小于等于左, 使用右
            else{
                data[i] = temp[big - l];
                big++;
            }
        }
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        MergeSort ms = new MergeSort();
        Integer[] integer = Util.getInteger(10);
        Arrays.stream(integer).forEach(System.out::println);
        System.out.println("---------------------");
        ms.sort(integer);
        Arrays.stream(integer).forEach(System.out::println);
        Util.sortTest("com.bhh.sort.mergesort.MergeSort", 1);
    }
}
