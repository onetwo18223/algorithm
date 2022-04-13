package com.bhh.leetcode.headquarters.dynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bhh
 * @description 01背包问题
 * 有一个背包, 容量为C, 现在有n种不同的物品, 编号为0...n-1,
 * 其中每一件物品的重量为w(i), 价值为v(i), 问可以向这个背包盛放哪些物品,
 * 可以使不超过背包容量的情况下, 物品的总价值最大
 * @date Created in 2021-10-08 11:45
 * @modified By
 */
public class ZeroOneBackpack {
    /*
    实现思路 : 暴力解法
    定义方法re()为获取最大价值的选择, 在方法中判断是否选择
    从索引index开始到结尾的物品
    若是选择了, 就是将数组分为了 以index + 1 索引开始, 以 c - w[j]为重量的新方法(新数组)
     */

    /**
     * @param w 重量集合
     * @param v 价值集合
     * @param C 背包总容量
     * @return 最大价值和/物品的集合
     */
    private Map<Integer, Integer> map;
    private int[][] nums;

    public int knapsack01(int[] w, int[] v, int C) {
        map = new HashMap<>();
        nums = new int[w.length][C + 1];
        return re(w, v, C, 0);
    }

    /**
     * @param w 重量集合
     * @param v 价值集合
     * @param c 当前背包总容量
     * @param i 当前物品索引
     * @return 最大价值和/物品的集合
     */
    private int re(int[] w, int[] v, int c, int i) {
        int n = w.length;
        if (c <= 0 || i >= w.length) {
            return 0;
        }
        if (nums[i][c] != 0) {
            return nums[i][c];
        }
        // res表示的是最大价值
        int res = -1;
        for (int j = i; j < n; j++) {
            res = Math.max(res, (c - w[j] >= 0 ?
                    (v[j] + re(w, v, c - w[j], j + 1)) : 0));
        }
        nums[i][c] = res;
        return res;
    }

    /*
    动态规划, 自底向上完成
     */
    private int reD(int[] w, int[] v, int c) {
        int n = w.length;
        if (c <= 0) {
            return 0;
        }

        // 自底向上, 完成底
        for (int j = 0; j < c + 1; j++) {
            // 索引为0, 表示第一个物品, 如果容量大于第一个物品质量,
            // 则改变价值为v[j], 否则为 0
            nums[0][j] = j > w[0] ? v[0] : 0;
        }


        // 表示二维数组中的重量
        for (int j = 0; j < c + 1; j++) {
            // 表示二维数组中的索引
            for (int i = 1; i < n; i++) {
//                nums[i][j] = nums[i-1][j];
                nums[i][j] = Math.max(nums[i][j],
                        (j - w[i] >= 0 ? (v[i] + nums[i - 1][j - w[i]]) : 0));
            }
        }
        return nums[n - 1][c];
    }

    public static void main(String[] args) {
        System.out.println(new ZeroOneBackpack().knapsack01(new int[]{
                1, 2, 3, 4
        }, new int[]{
                6, 10, 20, 50
        }, 6));
    }
}
