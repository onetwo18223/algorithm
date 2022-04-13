package com.bhh.nowcoder.swordfingeroffer.array;

import java.util.*;

/**
 * @author bhh
 * @description 描述
 * 一个整型数组里除了两个数字只出现一次，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 * 示例1
 * 输入：
 * [1,4,1,6]
 * 返回值：
 * [4,6]
 * 说明：
 * 返回的结果中较小的数排在前面
 * @date Created in 2021-09-10 16:42
 * @modified By
 */
public class Question40 {
    public class Solution {

        /**
         * 解决思路 :
         * 遍历数组将数组数据存放在Map当中, value存储数据次数
         * 遍历map,取出value为1的key
         *
         * @param array
         * @return
         */
        public int[] FindNumsAppearOnce(int[] array) {
            if (array == null || array.length == 0) {
                return null;
            }

            // 将数据存储在hashMap中
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < array.length; i++) {
                int key = array[i];
                if (map.containsKey(key)){
                    map.remove(key);
                }else{
                    map.put(key, 0);
                }
            }

            int[] nums = new int[2];
            int i = 0;
            for (Integer integer : map.keySet()) {
                nums[i] = integer;
                i++;
            }

            return nums;
        }
    }

    public static void main(String[] args) {
        Solution test = new Question40().new Solution();
        System.out.println(test.FindNumsAppearOnce(new int[]{2, 4, 3, 6, 3, 2, 5, 5}));
    }
}
