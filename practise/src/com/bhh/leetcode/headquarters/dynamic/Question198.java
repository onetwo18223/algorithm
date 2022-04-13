package com.bhh.leetcode.headquarters.dynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bhh
 * @description 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，
 * 计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * @date Created in 2021-10-07 21:18
 * @modified By
 */
public class Question198 {
    class Solution {
        /*
        这类题都可以通过方法取数组中某一部分, 将另一部分重新交给方法来完成处理
        递归实现

        实现思路 :
            暴力解法 : 遍历i = 0, i < nums.length - 1, i++
            i表示选择的索引位置, 会将数组分为 i 和 i + 1,...nums.length - 1

        收获 :
        碰到问题没有思路可以先暴力解法, 尝试可不可以将大问题化小, 形成递归
        这种递归是通过for来形成递归, 感觉与之前不同
        但是递归中一旦有了for, 就很有可能出现重复子查询, 可以使用记忆化搜索和动态规划
         */
        private int[] memo;

        public int rob(int[] nums) {
            memo = new int[nums.length];
            return re(nums, 0);
        }

        /*
        记忆化搜索
         */
        private int re(int[] nums, int index) {
            int n = nums.length;
            if (index > n - 1) {
                return 0;
            }
            if (memo[index] != 0) {
                return memo[index];
            }

            int res = -1;
            for (int i = index; i < n; i++) {
                res = Math.max(res, nums[i] + re(nums, i + 2));
            }
            memo[index] = res;
            return res;
        }

        /*
        动态规划
        收获 : 记忆化搜索和动态规划的转换 :
        关键点在于记忆化搜索在使集合中其他位数据时可能是空的,
        而动态规划是自底向上的, 使用集合中数据的时候是存在的
        形容不甚好, 可观看俩个方法
         */
        private int reD(int[] nums) {
            int n = nums.length;
            if (n == 0) {
                return 0;
            }
            memo[n - 1] = nums[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                for (int j = i; j < n; j++) {
                    memo[i] = Math.max(memo[i], nums[j] + memo[j + 2]);
                }
            }
            return memo[0];
        }
    }
}
