package org.qa.twopointer.copointer.sliding;

import java.util.HashMap;
import java.util.Map;

/**
 * @Desc 无重复字符的最长子串
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 * @Author bhh
 * @Date 2023-03-27 19:19
 * @Version 1.0
 */
public class Question3 {
    {
        /* 实现：使用HashMap + 滑动窗口
         */
    }
    class Solution {
        public int lengthOfLongestSubstring(String str) {
            if (null == str || "".equals(str)) return 0;
            Map<Character, Integer> map = new HashMap<Character, Integer>();
            int max = 1;
            int end = 0;
            // TODO: 设置左边界
            //  遍历，i充当子串的左边界
            for (int i = 0; i < str.length(); i++) {
                char iChar = str.charAt(i);
                map.put(iChar, i);
                // TODO: 设置右边界，为什么需要进行比对？
                //  如果上一次循环获取到的end大于 i + 1，表示这个 i - 1 ~ end 是不含重复元素的，
                //  即i ~ end也是不含重复元素的，可以直接获取较大值
                end = Math.max(end, i + 1);
                // 继续向下推进end的值, 当map中不含有该元素就表示该元素不存在于 i ~ end 子串
                while(end < str.length() && !map.containsKey(str.charAt(end)))
                    map.put(str.charAt(end), end++);
                // 获取最大边界
                // TODO: 这里为何是end - i，不是end - i + 1
                //  注意左右索引代表的意义 i表示从i开始，包含i， end表示end之前，不包含end
                //  [i, end)
                max = Math.max(max, end - i);
                // TODO: map在这道题中的意义？
                //  map存储的是从每个元素开始的最长不重复子串
                map.remove(iChar);
            }
            return max;
        }
    }
}
