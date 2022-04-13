package com.bhh.leetcode.swordfingeroffer.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author bhh
 * @description 扑克牌中的顺子
 * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。
 * A 不能视为 14。
 * <p>
 * 示例1:
 * 输入: [1,2,3,4,5]
 * 输出: True
 * <p>
 * 示例2:
 * 输入: [0,0,1,2,5]
 * 输出: True
 * @date Created in 2021-09-17 17:47
 * @modified By
 */
public class Question61 {
    class Solution {
        /*
        实现思路 :
        判断5张牌是否是连续的(也就是说最大值和最小值之间不会超过5),
        所以只需要判断, max - min 与 5 的关系
        若是 max - min >= 5, 则不连续
        max - min < 5, 则是连续的
        实现还需注意 : 若是集合中包含 相同牌, 也认为是不连续
        方法一 : 使用Hash (判断是否有相同数据)
        方法二 : 排序 + 遍历 (排序之后遍历时候有相邻的数据相同)
         */
        public boolean isStraight1(int[] nums) {
            if (nums == null || nums.length == 0) {
                return false;
            }
            int max = 0, min = 14;
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    continue;
                }
                if (nums[i] > max) {
                    max = nums[i];
                }
                if (nums[i] < min) {
                    min = nums[i];
                }
                if (set.contains(nums[i])) {
                    return false;
                }
                set.add(nums[i]);
            }
            return max - min < 5;
        }

        public boolean isStraight2(int[] nums) {
            if (nums == null || nums.length == 0) {
                return false;
            }
            // 进行排序
            Arrays.sort(nums);
            int index = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] == nums[i + 1] && nums[i] != 0) {
                    return false;
                }
                if (nums[i] != 0 && index == 0) {
                    index = i;
                }

            }
            return nums[nums.length - 1] - nums[index] < 5;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question61().new Solution().isStraight2(new int[]{
                0,0,1,2,10
        }));
    }
}
