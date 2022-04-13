package com.bhh.leetcode.hot100.array;

/**
 * @author bhh
 * @description 除自身以外数组的乘积
 * @date Created in 2021-12-21 21:48
 * @modified By
 */
public class Question238 {
    class Solution {
        /*
        这道题提出了要求获取除自身以外数组的乘积, 且不可以使用除法
        那就只能使用乘法
        如何乘?
            如果没遍历一个元素都需要进行一次乘法的话, 复杂度太高, 会超时
            那就需要将多余的步骤省略

         */
        public int[] productExceptSelf(int[] nums) {
            int[] line = new int[nums.length];
            line[0] = 1;
            /*
            从上往下走
              1 2 3 4

          1   1
          2   1 2
          6   1 2 3
          24  1 2 3 4
             */
            for (int i = 1; i < nums.length; i++) {
                line[i] = line[i - 1] * nums[i - 1];
            }
            /*
            从上往下走
              1 2 3 4

         24   x 2 3 4
        1*12  1 x 3 4
         2*4  1 2 x 4
          6   1 2 3 x
             */
            int temp = 1;
            for (int i = nums.length - 2; i >= 0 ; i--) {
                temp *= nums[i + 1];
                line[i] *= temp;
            }
            return line;
        }
    }
}
