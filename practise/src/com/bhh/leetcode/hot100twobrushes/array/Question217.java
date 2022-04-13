package com.bhh.leetcode.hot100twobrushes.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author bhh
 * @description 存在重复元素
 * @date Created in 2022-01-27 9:04
 * @modified By
 */
public class Question217 {
    class Solution {
        /*
        方法一 : 遍历添加到Hash
        // 方法二 : 原地交换
        // 方法三 : 二分
        // 方法四 : 循环链表
         */
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                if (set.contains(num)) {
                    return true;
                }
                set.add(num);
            }
            return false;
        }
    }
}
