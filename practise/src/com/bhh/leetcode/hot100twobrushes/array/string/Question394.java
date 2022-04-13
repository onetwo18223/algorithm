package com.bhh.leetcode.hot100twobrushes.array.string;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author bhh
 * @description 字符串解码
 * @date Created in 2022-01-25 11:06
 * @modified By
 */
public class Question394 {
    class Solution {
        /*
        涉及到括号, 想到栈
        碰到'[', 我们需要将数字和字符都分别添加到数字栈和字符栈
        添加数字是因为本次我们会使用到这个数字
        添加字符是需要保存之前的字符
        碰到']', 就需要进行字符串解码了
        为什么数字和字符处理方式不一样?
            因为数字到[结束
            而字符是到]结束
         */
        public String decodeString(String s) {
            if (s == null || "".equals(s)) {
                return "";
            }
            Deque<String> strStack = new ArrayDeque<>();
            Deque<Integer> intStack = new ArrayDeque<>();
            int num = 0;
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char tmp = s.charAt(i);
                if (tmp == '[') {
                    // 存储这次的num
                    intStack.push(num);
                    num = 0;
                    str = new StringBuilder();
                    // 存储之前的str
                    strStack.push(str.toString());
                }
                // 如果为']', 则进行解析
                else if (tmp == ']') {
                    int count = intStack.pop();
                    StringBuilder strTmp = new StringBuilder();
                    for (int j = 0; j < count; j++) {
                        strTmp.append(str);
                    }
                    str = new StringBuilder(strStack.pop() +
                            strTmp.toString());
                }
                // 数字, 存储在stack
                else if ('0' <= tmp && tmp <= '9') {
                    num = num * 10 + (tmp - '0');
                }
                // 字符
                else {
                    str.append(tmp);
                }
            }
            return str.toString();
        }
    }
}
