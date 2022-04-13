package com.bhh.leetcode.headquarters.bitoperation;

import com.bhh.leetcode.swordfingeroffer.stackandqueue.Question59_1;

/**
 * @author bhh
 * @description 4的幂
 * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。
 * 如果是，返回 true ；否则，返回 false 。
 * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x
 * <p>
 * 示例 1：
 * 输入：n = 16
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：n = 5
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：n = 1
 * 输出：true
 * <p>
 * 提示：
 * -2^31 <= n <= 2^31 - 1
 * @date Created in 2021-09-25 19:21
 * @modified By
 */
public class Question342 {
    class Solution {
        /*
        实现思路 : 4的幂次方不同于2的幂次方
        将n进行开方, 判断开方值是不是2的幂次方
         */
        /*
        若 n & 0xaaaaaaaa == 0, 则表示是4的幂次方
        0xaaaaaaaa = 10101010101010101010101010101010 (偶数位为1，奇数位为0)
        依次类推 :
        8的幂次方
        n & 10001000100010001000100010001000 > 0, 则表示是8的幂次方
        1字节 = 2位16进制 = 8位2进制, 所以4位2进制 = 1位16进制
        所以
        1000 1000 1000 1000 1000 1000 1000 1000 转换为 16进制 = 0x88888888

        0xaaaaaaaa = 10101010101010101010101010101010 (偶数位为1，奇数位为0)
        0x55555555 = 1010101010101010101010101010101 (偶数位为0，奇数位为1）
         */
        public boolean isPowerOfFour(int n) {
            return n > 0 && (n & (n - 1)) == 0 && (n & (0xAAAAAAAA)) == 0;
        }
        public boolean isPowerOfEight(int n) {
            return n > 0 && (n & (n - 1)) == 0 && (n & (0x88888888)) > 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question342().new Solution().isPowerOfEight(8));
    }
}
