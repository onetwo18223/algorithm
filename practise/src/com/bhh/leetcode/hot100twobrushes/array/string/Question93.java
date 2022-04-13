package com.bhh.leetcode.hot100twobrushes.array.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author bhh
 * @description 复原 IP 地址
 * @date Created in 2022-02-03 14:37
 * @modified By
 */
public class Question93 {
    class Solution {
        /*
        错误
        dfs获取所有组合
        dfs结束条件是 点数为3, 索引指向s.length(), 当前值小于等于255
         */
        Set<String> res1;

        public List<String> restoreIpAddressesError(String s) {
            res1 = new HashSet<>();
            dfs1(s, 0, 0, 0, "");
            return new ArrayList<>(res1);
        }

        private void dfs1(String str, int index, int count, int sum, String ip) {
            if (index == str.length() && count == 3 && sum <= 255) {
                res1.add(ip);
                return;
            }
            if (sum > 255) {
                return;
            }
            for (int i = index; i < str.length(); i++) {
                char currChar = str.charAt(i);
                sum = sum * 10 + currChar - '0';
                ip += currChar;
                dfs1(str, i + 1, count + 1, sum, ip + ".");
            }
        }

        /*
        最多递归四层, 每层最多获取三个索引位置的元素组成数字
        结束条件为 点数为3, 索引指向s.length()
         */
        public List<String> restoreIpAddresses(String s) {
            int len = s.length();
            List<String> res = new ArrayList<>();
            if (len > 12 || len < 4) {
                return res;
            }
            List<String> path = new ArrayList<>();
            dfs(s, len, 0, 0, path, res);
            return res;
        }

        private void dfs(String s, int len, int count, int index, List<String> path, List<String> res) {
            if (index == len && count == 4) {
                res.add(String.join(".", path));
                return;
            }

            if (len < index) {
                return;
            }

            for (int i = 0; i < 3; i++) {
                if (index + i >= len) {
                    break;
                }
                int ipSegment = getSegment(s, index, index + i);
                if (ipSegment != -1) {
                    path.add(ipSegment + "");
                    dfs(s, len, count + 1, index + i + 1, path, res);
                    path.remove(path.size() - 1);
                }
            }
        }

        private int getSegment(String s, int start, int end) {
            // 多位时, 不可0开头
            if (end > start && s.charAt(start) == '0') {
                return -1;
            }
            int res = 0;
            for (int i = start; i <= end; i++) {
                res = res * 10 + s.charAt(i) - '0';
            }
            if (res > 255) {
                return -1;
            }
            return res;
        }
    }
}
