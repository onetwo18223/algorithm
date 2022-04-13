package com.bhh.leetcode.hot100.array.doublepointer.slidingwindow;

/**
 * @author bhh
 * @description 最小覆盖子串
 * @date Created in 2022-01-06 10:03
 * @modified By
 */
public class Question76 {
    class Solution {
        /*
        使用滑动窗口完成
        需要配合字典判断窗口中是否有全部的t元素
        s里面找t
         */
        public String minWindow(String s, String t) {
            if (s == null || t == null) {
                return "";
            }
            char[] sArray = s.toCharArray();
            char[] tArray = t.toCharArray();
            int sLen = s.length();
            int tLen = t.length();
            int[] need = new int[128];

            // 定义需要哪些字符
            for (int i = 0; i < tLen; i++) {
                need[tArray[i]] += 1;
            }
            // 左右指针
            int l = 0, r = 0;
            // 子串长度
            int size = Integer.MAX_VALUE;
            // 需求字符个数, 搭配need使用
            int count = tLen;
            // 开始索引, 这个start用作于结尾字符串切割,
            // 因为left会一直右移, 破坏符合题意的滑动窗口来寻找新的窗口
            // 所以需要一个属性来存储左指针
            int start = 0;
            while (r < sLen) {
                char c = sArray[r];
                if (need[c] > 0) {
                    count--;
                }
                need[c]--;
                // 窗口已经包含所有字符
                if (count == 0) {
                    // 如果l指向的元素不负需求(不被需求), 则left++, 寻求最小窗口
                    while (l < r && need[sArray[l]] < 0) {
                        need[sArray[l++]]++;
                    }
                    // 寻找到最小窗口
                    if (r - l + 1 < size) {
                        // 获取较小窗口
                        size = r - l + 1;
                        // 记录l索引
                        start = l;
                    }
                    // 移动l指针, 打破窗口, 寻找下一个窗口
                    need[sArray[l]]++;
                    l++;
                    count++;
                }
                r++;
            }
            return size == Integer.MAX_VALUE ? "" :
                    s.substring(start, start + size + 1);
        }
    }
}
