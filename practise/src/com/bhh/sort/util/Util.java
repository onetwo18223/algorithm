package com.bhh.sort.util;

import com.bhh.sort.sort.Sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author bhh
 * @description 各个排序共用的方法
 * @date Created in 2021-07-20 9:46
 * @modified By
 */
public class Util {
    /**
     * 获取int随机数组
     *
     * @param num
     * @return
     */
    public static Integer[] getInteger(int num) {
        Integer[] data = new Integer[num];
        for (int i = 0; i < num; i++) {
            data[i] = new Random().nextInt(10000);
        }
        return data;
    }

    /**
     * 对泛型数组中的元素进行排序判断,
     * 若是降序则返回true
     * 若是非降序则返回false
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T extends Comparable> Boolean isSorted(T[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i].compareTo(data[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 对排序算法进行测试
     * @param packageName 排序类的全类名
     * @param num 需要进行多少次测试
     * @param <T>
     */
    public static <T extends Comparable> void sortTest(String packageName, int num) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        // 根据package 反射获取对象, 然后执行sort() 方法
        Class<?> clazz = Class.forName(packageName);
        Sort sort = (Sort)clazz.newInstance();

        Long start = System.currentTimeMillis();
        for (int i = 0; i < num; i++) {
            Integer[] data = getInteger(10000);
            sort.sort(data);
            if(! isSorted(data)) {
                throw new RuntimeException("排序出错");
            }
            System.out.println("data ");
            Arrays.stream(data).forEach(System.out::println);
        }
        Long end= System.currentTimeMillis();


        System.out.println((end - start) + "ms");
    }
}
