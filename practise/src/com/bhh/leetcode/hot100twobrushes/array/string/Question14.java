package com.bhh.leetcode.hot100twobrushes.array.string;

/**
 * @author bhh
 * @description 最长公共前缀
 * @date Created in 2022-01-27 15:11
 * @modified By
 */
public class Question14 {
    class Solution {
        /*
        从第二个元素到最后一个元素遍历, 判断相等元素
         */
        public String longestCommonPrefix(String[] strs) {
            String publicPre = strs[0];
            // 遍历第二个元素到最后一个元素
            // 判断每个元素和publicPre 的公共前缀
            for (int i = 1; i < strs.length; i++) {
                // 遍历元素, 结束之后的 0 ~ j - 1 表示公共元素
                int j = 0;
                for (; j < Math.min(strs[i].length(), publicPre.length()); j++) {
                    if (publicPre.charAt(j) != strs[i].charAt(j)) {
                        break;
                    }
                }
                publicPre = publicPre.substring(0, j);
            }
            return publicPre;
        }
    }
}
