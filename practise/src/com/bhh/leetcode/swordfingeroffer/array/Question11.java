package com.bhh.leetcode.swordfingeroffer.array;

/**
 * @author bhh
 * @description 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 * <p>
 * 输入：[3,4,5,1,2] 2 < 5 最小值在中间值的右边
 * 输出：1
 * <p>
 * 输入：[1,2,3,4,5] 3 < 5 最小值在中间值左边
 * 输出：1
 * <p>
 * 输入：[3,0,3] 0 < 3 最小值为中间值
 * 输出：0
 * <p>
 * 输入：[2,0,1,1,1] 1 == 1 最小值在中间值的左边
 * 输出：0
 * <p>
 * 输入：[1,1,1,0,1] 1 == 1 最小值在中间值得右边
 * 输出：0
 * <p>
 * @date Created in 2021-09-14 21:07
 * @modified By
 */
public class Question11 {
    class Solution {
        /*
        实现思路 :
        方法一 : 遍历寻找最小数 时间复杂度 : O(n)
        正确方法二 : 利用二分查找寻找最小值 时间复杂度 : O(logn)

         */
        public int minArray(int[] numbers) {
            int l = 0;
            int r = numbers.length - 1;
            if (numbers[r] > numbers[0]) {
                return numbers[0];
            }
            while (l < r)// 范围[l,r), 为什么不遍历最后一个元素,
                         // 因为最后一个元素是被用来做参照的
            {
                int mid = l + (r - l) / 2;
                if (numbers[mid] < numbers[r]) {
                    r = mid;
                } else if (numbers[mid] > numbers[r]) {
                    l = mid + 1;
                } else {
                    r--;
                }
            }
            return numbers[l];
        }
    }

    public static void main(String[] args) {
        Solution test = new Question11().new Solution();
        System.out.println(test.minArray(new int[]{3, 1, 3}));
    }
}
