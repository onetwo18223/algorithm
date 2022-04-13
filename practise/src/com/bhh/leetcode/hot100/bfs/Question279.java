package com.bhh.leetcode.hot100.bfs;

import com.bhh.lintcode.bfs.Question433;

import java.util.*;

/**
 * @author bhh
 * @description 完全平方数
 * @date Created in 2021-12-27 9:18
 * @modified By
 */
public class Question279 {
    class Solution {
        /*
        这道题第一眼看我看是组合类题目, 全部组合然后选择一个组合
        但是题目又给出要求是最少数量, 我们就可以理解为需要 n 到 0的最短路劲
        求最短路径使用BFS
         */
        public int numSquares(int n) {
            if (n == 0) {
                return 0;
            }
            Queue<Integer> queue = new ArrayDeque<>();
            Set<Integer> visited = new HashSet<>();
            queue.add(n);
            visited.add(n);
            int num = 1;
            while (!queue.isEmpty()) {
                int len = queue.size();
                // 这里使用分层的意义在于, 每一层都只是代表各种情况下n的值,
                // 但这些都只是属于一种情况之下, 都是一个数, num只会加一次
                // 类似于dfs组合
                for (int i = 0; i < len; i++) {
                    Integer element = queue.poll();
                    for (int j = 1; j * j <= element; j++) {
                        int tmp = element - j * j;
                        if (tmp == 0) {
                            return num;
                        }
                        if (visited.contains(tmp)) {
                            continue;
                        }
                        visited.add(tmp);
                        queue.add(tmp);
                    }
                }
                num++;
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question279().
                new Solution().numSquares(12));
    }
}
