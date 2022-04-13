package com.bhh.leetcode.headquarters.dynamic;


import java.util.HashMap;
import java.util.Map;

/**
 * @author bhh
 * @description 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * @date Created in 2021-10-07 9:55
 * @modified By
 */
public class Question70 {
    class Solution {
        /*
        先通过递归实现 :
        这就是一个树, root = n, 左右子树分别都是 n - 1, n - 2,
            方法一 : 通过记数来完成
                若是 n == 0, 则num ++;
            方法二 : 直接方法返回完成
                若是 n == 1, 则返回1
                若是 n == 2, 则返回2

        收获 : 递归时, 需要对参数进行相减, 直接在递归方法里减就好
         */
        private int num = 0;

        public int climbStairs1(int n) {
            if (n <= 0) {
                return 0;
            }
            if (climbStairs1(n - 1) == 0 || climbStairs1(n - 2) == 0) {
                return ++num;
            }
            return num;
        }

        public int climbStairs2(int n) {
            if (n == 1) {
                return 1;
            }
            if (n == 2) {
                return 2;
            }
            return climbStairs2(n - 1) + climbStairs2(n - 2);
        }

        /*
        使用记忆化搜索法(自上而下解决问题)
         */
        public Map<Integer, Integer> map = new HashMap<>();
            public int climbStairs3(int n) {
            if (n == 1) {
                return 1;
            }
            if (n == 2) {
                return 2;
            }
            if (map.get(n) == null) {
                map.put(n, climbStairs3(n - 1) + climbStairs3(n - 2));
            }
            return map.get(n);
        }

        /*
        使用动态规划(自下而上解决问题)
         */
        public int climbStairs4(int n) {
            map = new HashMap<>();
            map.put(1, 1);
            map.put(2, 2);
            for (int i = 3; i <= n; i++) {
                map.put(i, map.get(i - 1) + map.get(i - 2));
            }
            return map.get(n);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question70().new Solution().climbStairs3(44));
    }
}
