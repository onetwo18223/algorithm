package com.bhh.leetcode.swordfingeroffer.array;

import java.util.Arrays;

/**
 * @author bhh
 * @description 构建乘积数组
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，
 * 其中B[i] 的值是数组 A 中除了下标 i 以外的元素的积,
 * 即B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 * @date Created in 2021-09-18 11:51
 * @modified By
 */
public class Question66 {
    /**
     * 收获 : 关于这种对数组处理进行返回的, 可以将返回结果和原数组排列出来, 查找规律, 一般有序列的题都有规律
     */
    class Solution {
        /*
        实现思路 :
        方法一 : 暴力解法, 超时
        方法二 : 题解非常有意思, 题目要求不可以使用除法, 那么只可以使用乘法, 该题目图解可以看出规律,
        https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof/solution/mian-shi-ti-66-gou-jian-cheng-ji-shu-zu-biao-ge-fe/
        这种有序的一定是有规律的, 加减乘除
        关于乘除的规律,

        该题中 A[i](对角中间线)会将数据分为上三角和下三角, 俩次遍历, 第一次遍历下三角, 第二次遍历下三角 :
        创建待返回数组b, 并初始化b[0] = 1;
        下三角每次计算 : b[i] = b[i - 1] * a[i - 1]; // 也就是说在 中间线 将下三角为递增
        上三角每次计算 : tmp *= a[i + 1]; // 从len - 2开始(因为最后b[len-1]会去掉a[len-1]), 到0结束
                      b[i] *= tmp; // 需要俩步是因为, 既需要存储a[i + 1] 递乘的值, 又要乘以b[i]
         */
        public int[] constructArr(int[] a) {
            if (a == null || a.length == 0) {
                return new int[0];
            }
            int len = a.length;
            int[] b = new int[len];
            b[0] = 1;
            int tmp = 1;

            for (int i = 1; i < len; i++) {
                b[i] = b[i - 1] * a[i - 1];
            }
            for (int i = len - 2; i >= 0; i--) {
                tmp *= a[i + 1];
                b[i] *= tmp;
            }
            return b;
        }
    }

    public static void main(String[] args) {
        Arrays.stream(new Question66().new Solution().constructArr(new int[]{
                1, 2, 3, 4, 5
        })).forEach(System.out::println);
    }
}
