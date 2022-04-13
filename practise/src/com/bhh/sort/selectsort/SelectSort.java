package com.bhh.sort.selectsort;

import com.bhh.sort.sort.Sort;

import java.util.Map;

/**
 * @author bhh
 * @description 选择排序, 原地排序
 * <p>
 * 实现思路 :
 * 遍历集合
 * 每次寻找未排序数据中的最小值, 和当前索引位置元素进行交换
 * @date Created in 2021-07-20 9:32
 * @modified By
 */
public class SelectSort implements Sort {

    /**
     * 选择排序
     *
     * @param data
     * @param <T>
     */
    @Override
    public <T extends Comparable> void sort(T[] data) {

        for (int i = 0; i < data.length; i++) {
            // 获取剩余索引中的最小值和最小值指定的索引位置
            Map<String, Object> map = SelectSortUtil.findMin(data, i, data.length);
            Integer min = (Integer) map.get("min");
            Integer minIndex = (Integer) map.get("minIndex");

            // 交换值
            if (minIndex != i) {
                T swap;
                swap = data[minIndex];
                data[minIndex] = data[i];
                data[i] = swap;
            }
        }

//        Arrays.stream(data).forEach(System.out::println);
    }
}
