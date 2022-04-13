package com.bhh.leetcode.four.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bhh
 * @description 找到字符串中所有字母异位词
 * @date Created in 2022-03-04 21:01
 * @modified By
 */
public class Question438 {
    class Solution {
        /*
        字母异位词
        本题需要注意点, 使用Hash可以完成题目, 但是复杂度过高, 而且使用了Hash空间
        最好使用字典, 使用字典对比, 可以提高复杂度
         */
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> res = new ArrayList<>();
            if (p.length() > s.length()) {
                return res;
            }
            // 创建字典
            int[] sMap = new int[26];
            int[] pMap = new int[26];
            // 因为p的长度可能较少, 所以先遍历p
            for (int i = 0; i < p.length(); i++) {
                pMap[p.charAt(i) - 'a']++;
                sMap[s.charAt(i) - 'a']++;
            }
            // 如果都相等, 则索引0符合条件
            if (Arrays.equals(sMap, pMap)) {
                res.add(0);
            }
            // 移动窗口, 然后重复比较
            for (int i = p.length(); i < s.length(); i++) {
                sMap[s.charAt(i) - 'a']++;
                sMap[s.charAt(i - p.length()) - 'a']--;
                if (Arrays.equals(sMap, pMap)) {
                    res.add(i - p.length() + 1);
                }
            }
            return res;
        }
    }
}
