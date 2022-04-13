package com.bhh.leetcode.three;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bhh
 * @description 括号生成
 * @date Created in 2022-01-31 17:30
 * @modified By
 */
public class Question22hot100 {
    class Solution {
        /*
        括号通过dfs组合生成
        若是当前左括号 < n , 则生成左括号
        若是当前右括号 < 左括号, 生成右括号
        右括号 > 左括号 || 左括号 > n return
         */
        List<String> res;
        public List<String> generateParenthesis(int n) {
//            int left = 0;
//            int right = 0;
            res = new ArrayList<>();
            dfs(0, 0, n, "");
            return res;
        }

        private void dfs(int left, int right, int n, String str) {
            if (right > left || left > n) {
                return;
            }
            if (left == n && right == n) {
                res.add(str);
                return;
            }
            // 左括号较少, 可以生成左括号
            if (left < n) {
                dfs(left + 1, right, n, str + "(");
            }
            // 右括号较少, 可以生成右括号
            if (right < left) {
                dfs(left, right + 1, n, str + ")");
            }
        }
    }
}
