package org.qa.twopointer.reversepointer.twosum;

import java.util.Arrays;

/**
 * @Desc 有效三角形的个数
 * https://leetcode.cn/problems/valid-triangle-number/
 * @Author bhh
 * @Date 2023-02-27 16:15
 * @Version 1.0
 */
public class Question611 {
    {
        /* 实现：
        使用双指针，先确定第三边，再使用while确定另外俩条边
        俩边之和若大于另外一边，则减少大边
        否则增加小边
         */
    }

    class Solution {
        public int triangleNumber(int[] nums) {

            int num = 0;
            if (null == nums || nums.length == 0) return num;
            Arrays.sort(nums);

            num = getNum(nums);
            return num;
        }

        // TODO:这道题涉及到选边问题
        // 在三数之和问题之中，例如，a + b + c = 0，即 a + b = -c
        //  我们一般先确定数c，然后再while遍历获取a和b，
        //  在取数c时，从小到大取数或者从大到小的取数都是可以接受的，
        //  从小到大时，需要l = i + 1
        //  从大到小时，需要r = i - 1
        //  因为判断条件是等式，所以从小到大或者从大到小都是可以实现代码
        // 但是在本题中，因为是三角问题，a + b > c
        //  如果我们先确定选择长边c，那么a + b一定就是短边，那么就需要从大到小取数
        private int getNum(int[] nums) {

            // 选择边错误
            /*for (int i = 0; i < length; i++) {
                left = i;
                right = length - 1;
                while(left < right) {
                    int sum = nums[left] + nums[right];
                    if (sum > nums[i]) {
                        num += right - left;
                        right--;
                    } else if (sum < nums[i]) {
                        left++;
                    }
                }
            }*/

            int num = 0;
            int length = nums.length;
            int left, right;
            // >= 2 是因为选取的第三边，那么前面最少有俩条边
            // 也可以 >= 1
            for (int i = length - 1; i >= 2 ; i--) {
                left = 0;
                right = i - 1;
                while(left < right) {
                    if (nums[left] + nums[right] > nums[i]) {
                        // TODO:若是left + right > nums[i]
                        //  那么left到right之间的left边都可用
                        num += right - left;
                        right--;
                    } else {
                        left++;
                    }
                }
            }
            return num;
        }
    }
}
