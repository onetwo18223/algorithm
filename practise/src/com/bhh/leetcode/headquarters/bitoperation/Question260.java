package com.bhh.leetcode.headquarters.bitoperation;

/**
 * @author bhh
 * @description 只出现一次的数字 III
 * 给定一个整数数组nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。
 * 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
 * <p>
 * 进阶：你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,1,3,2,5]
 * 输出：[3,5]
 * 解释：[5, 3] 也是有效的答案。
 * <p>
 * 示例 2：
 * 输入：nums = [-1,0]
 * 输出：[-1,0]
 * <p>
 * 示例 3：
 * 输入：nums = [0,1]
 * 输出：[1,0]
 * @date Created in 2021-09-26 17:52
 * @modified By
 */
public class Question260 {
    class Solution {
        /*
        实现思路 : 对空间做出了要求, 使用位运算完成
        先根据异或求出 俩个值得异或值s
        然后根据 s ^= s & (s - 1),也就是 s %= (-s)
        获取俩个数在最低位发生不同的值 (最低位出现1 ,说明俩个值在这一位一个为0, 一个为1) (根据s进行了分类)
        遍历nums, 若是 num | s == num, 则说明num在s存在1的这一位上是1, 否则就是0
        根据该位0或者1的不同, 分别 ^= 即可
         */
        public int[] singleNumber(int[] nums) {
            int s = 0;
            for (int num : nums){
                s ^= num;
            }
            s &= (-s);
            int[] array = new int[2];
            for (int num : nums){
                array[(num | s) == num ? 0 : 1] ^= num;
            }
            return array;
        }
    }
}
