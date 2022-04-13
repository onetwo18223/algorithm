package com.bhh.sort.insertionsort;

import com.bhh.sort.sort.Sort;
import com.bhh.sort.util.Util;

/**
 * @author bhh
 * @description 插排实现
 * <p>
 * 实现思路 :
 * 遍历数组, 将当前索引对应的元素交换到正确的位置( 索引之前数组中寻找正确的位置 )
 * (类比排序扑克牌)
 * @date Created in 2021-08-26 13:54
 * @modified By
 */
public class InsertionSort implements Sort {

    @Override
    public <T extends Comparable> void sort(T[] data) {
//        for (int i = 0; i < data.length; i++) {
//            for (int j = i; j - 1 >= 0 ; j--) {
//                if (data[j].compareTo(data[j - 1]) < 0){
//                    swap(data, j, j-1);
//                }else {
//                    break;
//                }
//            }
//        }
        for (int i = 0; i < data.length; i++) {
            T t = data[i];
            int j;
            for (j = i; j - 1 >= 0 && t.compareTo(data[j - 1]) < 0; j--) {
                data[j] = data[j - 1];
            }
            data[j] = t;
        }
    }

    private <T extends Comparable> void swap(T[] data, int j, int i) {
        T swap = data[j];
        data[j] = data[i];
        data[i] = swap;
    }

    public static void main(String[] args) {
        try {
            Util.sortTest("com.bhh.sort.insertionsort.InsertionSort", 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
