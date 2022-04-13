package com.bhh.leetcode.three;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bhh
 * @description 找到字符串中所有字母异位词
 * @date Created in 2022-01-29 17:11
 * @modified By
 */
public class Question438hot100 {
    class Solution {
        /*
        字母异位词
        需要使用排序 + 判断 或者 字典
         */
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> res = new ArrayList<>();
            if (p.length() > s.length()) {
                return res;
            }
            int[] sDic = new int[26];
            int[] pDic = new int[26];

            for (int i = 0; i < p.length(); i++) {
                sDic[s.charAt(i) - 'a']++;
                pDic[p.charAt(i) - 'a']++;
            }
            if (Arrays.equals(sDic, pDic)) {
                res.add(0);
            }
            for (int i = p.length(); i < s.length(); i++) {
                sDic[s.charAt(i) - 'a']++;
                sDic[s.charAt(i - p.length()) - 'a']--;
                if (Arrays.equals(sDic, pDic)) {
                    res.add(i - p.length() + 1);
                }
            }
            return res;
        }
    }
}
