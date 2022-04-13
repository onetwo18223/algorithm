package com.bhh.sort.sort;

/**
 * @author bhh
 * @description 接口定义sort() 方法
 * @date Created in 2021-07-20 15:26
 * @modified By
 */
public interface Sort {
    public <T extends Comparable> void sort(T[] data);
}
