package org.util;

import java.util.Random;

public class Util {

    final static int ARRAY_NUM = 100;

    public static int[] getArray() {
        int[] nums = new int[ARRAY_NUM];
        for (int i = 0; i < ARRAY_NUM; i++) {
            nums[i] = new Random().nextInt(100);
        }
        return nums;
    }
}
