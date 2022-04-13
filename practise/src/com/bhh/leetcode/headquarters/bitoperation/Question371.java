package com.bhh.leetcode.headquarters.bitoperation;

/**
 * @author bhh
 * @description 两整数之和
 * <p>
 * 给你两个整数 a 和 b ，不使用 运算符 + 和 - ，计算并返回两整数之和。
 * <p>
 * 示例 1：
 * 输入：a = 1, b = 2
 * 输出：3
 * <p>
 * 示例 2：
 * 输入：a = 2, b = 3
 * 输出：5
 * <p>
 * 提示：
 * -1000 <= a, b <= 1000
 * @date Created in 2021-09-25 20:11
 * @modified By
 */
public class Question371 {
    class Solution {
        /*
        实现思路 : return a + b;
        方法 :
        转换为二进制,
        相加的操作类似于二进制中的 异或 操作, 但是这个没有进位操作
        进位需要使用 (a & b) << 1来实现, 俩数同位都是1时才会进位, 所以使用&,
            但是直接 &, 结果还是同位, 所以左移一位以表示进位
        循环操作, 直到没有进位, 输出 a ^ b;
         */
        public int getSumBad(int a, int b) {
            return a + b;
        }
        public int getSum(int a, int b) {
            if (((a & b) << 1) == 0){
                return a ^ b;
            }
            return getSum(((a & b) << 1), a ^ b);
        }
    }
}
