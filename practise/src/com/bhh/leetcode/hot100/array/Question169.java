package com.bhh.leetcode.hot100.array;

import com.bhh.lintcode.bfs.Question433;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bhh
 * @description 多数元素
 * @date Created in 2021-12-21 19:20
 * @modified By
 */
public class Question169 {
    class Solution {
        /*
        时间复杂度为O(n)
        空间复杂度为O(1)
        hash表 / 因为是众数, 所以可以使用摩尔投票法
         */
        public int majorityElement(int[] nums) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            int len = nums.length;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < len; i++) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
            for (Integer key : map.keySet()) {
                if (map.get(key) > len / 2){
                    return key;
                }
            }
            return -1;
        }

        /*
        因为是众数, 所以可以使用摩尔投票法
        假设第一个数是众数, 以后每碰到一个相同的数count++, 没碰到一个不同的数count--
        count == 0, 则假设当前数是众数
         */
        public int majorityElement1(int[] nums) {
            int more = nums[0];
            int count = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == more){
                    count++;
                } else {
                    if (--count == 0){
                        more = nums[i];
                        count = 1;
                    }
                }
            }
            return more;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question169().new Solution().majorityElement1(new int[]{
                3, 2, 3
        }));
    }
}
