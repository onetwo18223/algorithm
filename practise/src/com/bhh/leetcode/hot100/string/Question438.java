package com.bhh.leetcode.hot100.string;

import java.util.*;

/**
 * @author bhh
 * @description 找到字符串中所有字母异位词
 * @date Created in 2021-12-27 20:44
 * @modified By
 */
public class Question438 {
    class Solution {
        /*
        同向双指针, 快指针和慢指针相差s.length(),
        for循环从慢指针到快指针遍历一遍, 添加到HashSet中,
        有一个char不存在都表明不是异位词
         */
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> res = new ArrayList<>();
            Set<String> set = new HashSet<>();
            char[] array = p.toCharArray();
            Arrays.sort(array);
            p = new String(array);
            set.add(p);
            int end = 1;

            for (int start = 0; start < s.length(); start++) {
                // 结束 : 越界 或者 end - start + 1 = p.length()
                while (end < s.length() && end - start + 1 < p.length()) {
                    end++;
                }
                if (end >= s.length()) {
                    break;
                }
                String str = s.substring(start, end + 1);
                array = str.toCharArray();
                Arrays.sort(array);
                str = new String(array);
                if (set.contains(str)) {
                    res.add(start);
                }
            }
            return res;
        }
    }
}
