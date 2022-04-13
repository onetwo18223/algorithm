package com.bhh.nowcoder.swordfingeroffer.array;

import java.util.*;

/**
 * @author bhh
 * @description 描述
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任一一个重复的数字。
 * 例如，如果输入长度为7的数组[2,3,1,0,2,5,3]，
 * 那么对应的输出是2或者3。
 * 存在不合法的输入的话输出-1
 * 示例1
 * 输入：
 * [2,3,1,0,2,5,3]
 * 返回值：
 * 2
 * 说明：
 * 2或3都是对的
 * @date Created in 2021-09-10 16:10
 * @modified By
 */
public class Question50 {
    public class Solution {
        /**
         * 实现思路 :
         * 方法一 : 使用排序( 排序时进行比较若是有相等的, 直接返回 )
         * 方法二 : 使用 HashMap
         * 方法三 :
         * @param numbers
         * @return
         */
        public int duplicate(int[] numbers) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < numbers.length; i++) {
                map.put(numbers[i], map.getOrDefault(numbers[i], 0) + 1);
                if (map.get(numbers[i]) > 1){
                    return numbers[i];
                }
            }
            return -1;
        }
    }
}
