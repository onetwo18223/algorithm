package com.bhh.leetcode.headquarters.bitoperation;

/**
 * @author bhh
 * @description 2 的幂
 * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。
 * 如果是，返回 true ；否则，返回 false 。
 * <p>
 * 如果存在一个整数 x 使得n == 2^x ，则认为 n 是 2 的幂次方。
 * @date Created in 2021-09-25 19:03
 * @modified By
 */
public class Question231 {
    class Solution {
        /*
        实现思路 :
            我的想法 : 2的幂次方的值转换为二进制都是 单个1的格式
                     只需要判断 n ^ (1<<i) == 0
                缺点 : 需要大量循环遍历, 得不偿失
            更好的方法 : 2的幂次方的值转换为二进制都是 单个1的格式
                       只需要判断将n中的1去除之后, 是否为0即可
                       n & (n - 1) == 0
         */
        public boolean isPowerOfTwoBad(int n) {
            int i = 0;
            while (i <= Integer.MAX_VALUE){
                if ((n ^ (1 << i)) == 0){
                    return true;
                }
                if ((1 << i) > n){
                    return false;
                }
                i++;
            }
            return false;
        }
        public boolean isPowerOfTwo(int n) {
            return n > 0 && (n & (n - 1)) == 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question231().new Solution().isPowerOfTwo(8-1));
    }
}
