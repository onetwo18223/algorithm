package com.bhh.leetcode.hot100.string;

/**
 * @author bhh
 * @description 最长回文子串
 * @date Created in 2021-11-05 21:24
 * @modified By
 */
public class Question5 {
    class Solution {
        /*
        寻找最长回文子串, 虽然不是寻找最长长度, 但是我们可以使用dp存储长度, 使用res, 存储最长长度的子串
        DP/ 序列性和坐标型都可以吧(序列性可能更适用)
        1.状态
            最后一步
                判断从 j 到 len - 1 的字符串是最长回文串
            子问题
                判断前j个元素的最长回文串
        2.转换公式
            dp[i] = Math.max(dp[j], len - 1 - j | j ~ len - 1是回文串)
        3.初始值和边界值
            dp[0] = 0;
        4.顺序
            正序
         */
        public String longestPalindrome(String s) {
            if (s == null || "".equals(s)) {
                return "";
            }
            char[] array = s.toCharArray();
            int len = array.length;
            int[] dp = new int[len + 1];
            dp[0] = 0;
            int resLen = Integer.MIN_VALUE;
            String res = new String();
            for (int i = 1; i < len + 1; i++) {
                for (int j = 0; j < i; j++) {
                    // 判断回文数这里多了一个for循环, 所以是O(n^3),
                    // 如果需要降到O(n^2)的建议是先获取所有的回文串,
                    // 但是这样的话其实就不需要动归了
                    if (isPalindromic(array, i - 1, j)) {
                        dp[i] = Math.max(dp[i], Math.max(dp[j], i - j));
                        if (resLen < (i - j)) {
                            res = s.substring(j, i);
                            resLen = i - j;
                        }
                    }
                }
            }
            return res;
        }

        // 判断是否是回文串
        // i > j
        private boolean isPalindromic(char[] array, int i, int j) {
            while (i >= j) {
                if (array[i] != array[j]) {
                    return false;
                }
                i--;
                j++;
            }
            return true;
        }

        // 中心扩散法
        // 获取所有的回文串, 并记录最长的回文子串
        public String longestPalindromeMidToTwo(String s) {
            if (s == null || "".equals(s)) {
                return "";
            }
            // 获取所有的回文串, 并记录最长的回文子串
            // 遍历s, 以任何一个元素为中心, 获取所有回文串
            int len = s.length();
            int start = 0;
            int end = 0;
            int maxLen = Integer.MIN_VALUE;
            String maxString = new String();
            for (int i = 0; i < len; i++) {
                start = end = i;
                while (start >= 0 && end < len && s.charAt(start) == s.charAt(end)) {
                    if (end - start > maxLen) {
                        maxLen = end - start + 1;
                        maxString = s.substring(start, end + 1);
                    }
                    start--;
                    end++;
                }

                start = i;
                end = i + 1;
                while (start >= 0 && end < len && s.charAt(start) == s.charAt(end)) {
                    if (end - start > maxLen) {
                        maxLen = end - start + 1;
                        maxString = s.substring(start, end + 1);
                    }
                    start--;
                    end++;
                }
            }
            return maxString;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question5().
                new Solution().longestPalindromeMidToTwo("babad"));
    }
}
