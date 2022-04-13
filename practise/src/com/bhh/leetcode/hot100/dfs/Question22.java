package com.bhh.leetcode.hot100.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bhh
 * @description 括号生成
 * @date Created in 2022-01-02 14:32
 * @modified By
 */
public class Question22 {
    class Solution {
        /*
        求组合/ DFS/
        这道题目是括号类型题目, 如果需要生成合法括号的话, 左括号数 一定等于 右括号数
        而对于任意子串而言, 也是左括号数 >= 右括号数

         */
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            if (n == 0) {
                return res;
            }
            // 将n划分为左右括号数
            dfs(0, 0, n, "", res);
            return res;
        }

        private void dfs(int left, int right, int n, String s, List<String> res) {
            if (left == right && left == n) {
                res.add(s);
                return;
            }
            if (left > n || right > left) {
                return;
            }
            if (left < n) {
                // 生成左括号
                dfs(left + 1, right, n, s + "(", res);
            }
            if (right < left) {
                //  生成右括号
                dfs(left, right + 1, n, s + ")", res);
            }
        }
    }
}
