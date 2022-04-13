package com.bhh.leetcode.hot100twobrushes.array.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bhh
 * @description 找到字符串中所有字母异位词
 * @date Created in 2022-01-24 19:24
 * @modified By
 */
public class Question438 {
    class Solution {
        /*
        字母异位词类题目
        排序 + Hash + 滑动窗口
         */
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> res = new ArrayList<>();
            char[] arrayP = p.toCharArray();
            char[] arrayS = s.toCharArray();
            Arrays.sort(arrayP);
            p = new String(arrayP);
            // a aa
            for (int i = arrayP.length - 1; i < arrayS.length; i++) {
                int start = i - arrayP.length + 1;
                char[] tmp = s.substring(start, i + 1).toCharArray();
                Arrays.sort(tmp);
                if (new String(tmp).equals(p)) {
                    res.add(start);
                }
            }
            return res;
        }

        /*
        使用字典方式
         */
        public List<Integer> findAnagramsBetter(String s, String p) {
            List<Integer> res = new ArrayList<>();
            int sLen = s.length();
            int pLen = p.length();
            int[] pCut = new int[26];
            int[] sCut = new int[26];
            if (sLen < pLen) {
                return res;
            }
            for (int i = 0; i < pLen; i++) {
                pCut[p.charAt(i) - 'a']++;
                sCut[s.charAt(i) - 'a']++;
            }
            // 如果这时候俩个字典内容相等
            if (Arrays.equals(pCut, sCut)) {
                res.add(0);
            }
            // 遍历后面部分
            for (int i = pLen; i < sLen; i++) {
                // 每添加一个元素就需要删除另一端的一个元素, 滑动窗口
                sCut[s.charAt(i) - 'a']++;
                sCut[s.charAt(i - pLen) - 'a']--;
                if (Arrays.equals(pCut, sCut)) {
                    res.add(i - pLen + 1);
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question438().new Solution().findAnagramsBetter("cbaebabacd", "abc"));
    }
}
