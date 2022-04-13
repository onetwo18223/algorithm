package com.bhh.sort.selectsort;

import com.bhh.sort.util.Util;

/**
 * @author bhh
 * @description 调用测试方法
 * @date Created in 2021-07-20 15:33
 * @modified By
 */
public class Main {
    public static void main(String[] args) {
        try {
            Util.sortTest("com.bhh.sort.selectsort.SelectSort", 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
