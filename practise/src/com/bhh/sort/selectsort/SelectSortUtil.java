package com.bhh.sort.selectsort;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author bhh
 * @description 工具类
 *
 * @date Created in 2021-07-20 9:35
 * @modified By
 */
public class SelectSortUtil {

    /**
     * 获取从index 到 end最小的值
     * @param data
     * @param index
     * @param end
     * @param <T>
     * @return
     */
    public static <T extends Comparable> Map<String, Object> findMin(T[] data, int index, int end){

        int minIndex = index;
        T min = data[index];

        for (int i = index; i < end; i++) {
            if (min.compareTo(data[i]) > 0){
                min = data[i];
                minIndex = i;
            }
        }

        Map<String, Object> map = new HashMap<>();
        map.put("min", min);
        map.put("minIndex", minIndex);
        return map;
    }
}
