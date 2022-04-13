package com.bhh.leetcode.hot100twobrushes.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bhh
 * @description 括号生成
 * @date Created in 2022-01-24 13:17
 * @modified By
 */
public class Question22 {
    class Solution {
        /*
        组合问题, 尝试dfs
         */
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            dfs(0, 0, n, "", res);
            return res;
        }

        /**
         * 括号规则
         * left == n && right == left 则添加到res
         * <p>
         * 若left > n || left < right 左括号数大于总括号对或者右括号数大于左括号数
         * 则退出
         *
         * @param left  左括号数
         * @param right 右括号数
         * @param n     括号对数量
         * @param res   结果集
         */
        private void dfs(int left, int right, int n, String str, List<String> res) {
            if (left == n && right == left) {
                res.add(str);
                return;
            }
            if (left > n || left < right) {
                return;
            }
            // 左括号小于总对数, 则生成左括号
            if (left < n) {
                dfs(left + 1, right, n, str + "(", res);
            }
            // 右括号小于左括号, 则可生成右括号
            if (right < left) {
                dfs(left, right + 1, n, str + ")", res);
            }
        }
    }
}
