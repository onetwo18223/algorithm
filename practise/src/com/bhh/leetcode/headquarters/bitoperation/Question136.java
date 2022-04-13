package com.bhh.leetcode.headquarters.bitoperation;

/**
 * @author bhh
 * @description 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。
 * 找出那个只出现了一次的元素。
 * <p>
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 * <p>
 * 示例2:
 * 输入: [4,1,2,1,2]
 * 输出: 4
 * @date Created in 2021-09-26 7:32
 * @modified By
 */
public class Question136 {
    class Solution {
        /*
        实现思路 : 重复数据, 先想到了HashMap
        但是若不允许额外空间产生, 位运算是不错的方法
        除了某个元素之外的其他元素均出现了俩次, 那么
        根据x ^ x = 0, x ^ 0 = x
        遍历数组, 将res = 0和所有数据进行异或, 剩余的值就是出现一次的结果
         */
        public int singleNumber(int[] nums) {
            int res = 0;
            for (int num : nums) {
                res ^= num;
            }
            return res;
        }
    }
}
