package com.bhh.leetcode.swordfingeroffer.bit;

/**
 * @author bhh
 * @description 数组中数字出现的次数
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * <p>
 * 示例 1：
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * <p>
 * 示例 2：
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 * @date Created in 2021-09-26 18:38
 * @modified By
 */
public class Question56_1 {
    /*
    实现思路 : 先是使用异或获取 这俩个数值的异或值s
    再通过 s ^= s & (s - 1) 或者 s &= (-s); 对num进行分类,
    遍历 nums, 根据分类, 通过异或 提取 数值到 int[0]和int[1]
     */
    class Solution {
        public int[] singleNumbers(int[] nums) {
            int s = 0;
            for (int num : nums) {
                s ^= num;
            }
            s &= (-s);
            int[] array = new int[2];
            for (int num : nums) {
                array[(num | s) == num ? 0 : 1] ^= num;
            }
            return array;
        }
    }
}
