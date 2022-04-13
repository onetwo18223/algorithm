package com.bhh.leetcode.headquarters.bitoperation;

/**
 * @author bhh
 * @description 只出现一次的数字 II
 * 给你一个整数数组nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。
 * 请你找出并返回那个只出现了一次的元素。
 * <p>
 * 示例 1：
 * 输入：nums = [2,2,3,2]
 * 输出：3
 * <p>
 * 示例 2：
 * 输入：nums = [0,1,0,1,0,1,99]
 * 输出：99
 * @date Created in 2021-09-26 9:02
 * @modified By
 */
public class Question137 {
    class Solution {
        /*
        查询重复数据, 首先先到的是 位运算和Hash
        Hash会浪费空间, 优先使用位运算
        本题不同于出现俩次的数据题目, 俩次可以使用 ^ 进行抵消, 而寻找出现三次的数据题目直接使用 ^ 无用

        题解详细 :
        https://leetcode-cn.com/problems/single-number-ii/solution/single-number-ii-mo-ni-san-jin-zhi-fa-by-jin407891/

        实现思路 :
        二进制中 每一个位都只有0和1俩种状态, 可以通过记录 0 1出现的位数来记录数据
        记录数组中所有数形成一个数, 将这个数每一位都取余3, 剩下的数就可看做是二进制的数, 这个数就是只出现一次的结果数
        例如 :
        nums = [3,4,3,3];
        3   = 0 0 1 1
        3   = 0 0 1 1
        3   = 0 0 1 1
        4   = 0 1 0 0
        sum = 0 1 3 3
        #取余3得
        res = 0 1 0 0
        而res就是我们求的结果 十进制的4

        进入一个nums[i], 如何动态改变res
        将nums[i] 和 res进行 ^ 操作 (其实就是相加)
        但是 ^ 不进位, 所以需要俩位来表示
        two one : 00

        若是nums[i] 的 某一位
        为0 则
        状态不变
        为1 则
        00 -> 01 -> 10 -> 00 循环
        状态变化公式 :
            if two == 0:
                if n == 0:
                    one = one
                if n == 1:
                    one = ~one
            if two == 1:
                one = 0

            简写 :
            if two == 0:
                one = one ^ n
            if two == 1:
                one = 0

            简写 : one = one ^ n & ~two

            two同理

            if(one == 1)
                two = 0
            if(one == 0)
                if(n == 0)
                    two = two
                if(n == 1)
                    two = ~two
            即 : two = two ^ n & ~one

        nums[i] 一位对应一对状态, 32位对应32对状态
        遍历完之后, ones只会处于 0 或者 1俩个状态, 而two只会处于 0 状态( 因为不会出现余2的情况 ),
        所以结果只返回ones即可
         */
        public int singleNumber(int[] nums) {
            int one = 0, two = 0;
            for (int num : nums) {
                two = two ^ num & ~one;
                one = one ^ num & ~two;
            }
            return one;
        }
    }
}
