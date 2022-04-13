package com.bhh.leetcode.swordfingeroffer.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bhh
 * @description 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 示例1:
 * <p>
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 * @date Created in 2021-09-15 18:10
 * @modified By
 */
public class Question39 {
    class Solution {
        /*
        实现思路 :
        方法一 :
            使用HashMap来存储数据, key存储数据, value存储次数, 之后寻找超过数组长度一半的key
        方法二 :
            这是一个众数, 且众数数量大于数组的一半, 那我们就将 相邻的 不相同的 俩个数 进行消除,
            最差情况就是消除了一个众数和一个非众数, 最后剩余的一定是众数

        对于本题来说, 方法二效率更高, 但是我认为HashMap用法更为广泛
         */
        public int majorityElement(int[] nums) {
            if (nums == null || nums.length == 0){
                return -1;
            }

            Map<Integer, Integer> map = new HashMap();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], (map.getOrDefault(nums[i], 0) + 1));
                if (map.get(nums[i]) >= Math.ceil(nums.length / 2.0)){
                    return nums[i];
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question39().new Solution().
                majorityElement(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
    }
}
