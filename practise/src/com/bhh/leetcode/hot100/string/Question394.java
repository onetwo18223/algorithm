package com.bhh.leetcode.hot100.string;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author bhh
 * @description 字符串解码
 * @date Created in 2021-12-27 21:51
 * @modified By
 */
public class Question394 {
    class Solution {
        /*
        字符串解码
        辅助栈方法
            因为栈是后进先出, 而这道题解题顺序应该是从内到外, 所以比较适合辅助栈的方法
        需要俩个栈, 一个存储数字, 一个存储String
         */
        public String decodeString(String s) {
            if (s == null || "".equals(s)) {
                return "";
            }
            int num = 0;
            StringBuilder res = new StringBuilder();
            Deque<Integer> numStack = new ArrayDeque<>();
            Deque<String> strStack = new ArrayDeque<>();
            for (char c : s.toCharArray()) {
                // 将str和num分别放入栈中
                if (c == '[') {
                    numStack.push(num);
                    // 将[之前的字符添加到栈中, 字符栈栈顶元素一直会是]之后的字符串
                    strStack.push(res.toString());
                    // 重置
                    num = 0;
                    res = new StringBuilder();
                } else if (c == ']') {
                    // 这里tmp使用SB的原因是好追加 res
                    // res一直表示的是未添加到strStack里的字符串, 也就是需要倍数的字符串
                    // 因为若是没有'[', res是不会入栈的, 那么这是res只会在'['']'之间
                    StringBuilder tmp = new StringBuilder();
                    // 数字出栈
                    int numTmp = numStack.pop();
                    for (int i = 0; i < numTmp; i++) {
                        tmp.append(res);
                    }
                    res = new StringBuilder(strStack.pop() + tmp.toString());
                }
                // 若果是数字
                else if ('0' <= c && c <= '9') {
                    num = num * 10 + (c - '0');
                }
                // 字符
                else {
                    res.append(c);
                }
            }
            return res.toString();
        }
    }
}
