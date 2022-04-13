package com.bhh.leetcode.three;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author bhh
 * @description 字符串解码
 * @date Created in 2022-01-29 15:33
 * @modified By
 */
public class Question394hot100 {
    class Solution {
        /*
        解码, 配合栈使用
        碰到 '[', 字符栈记录str, 数字栈记录num
        碰到 ']', 取出栈顶元素, 遍历numTmp遍str, 并将元素添加到字符栈后
        碰到 '数字', num记录
        碰到 '字符', str记录
         */
        public String decodeString(String s) {
            StringBuilder str = new StringBuilder();
            int num = 0;
            char[] array = s.toCharArray();
            Deque<String> strStack = new ArrayDeque<>();
            Deque<Integer> intStack = new ArrayDeque<>();
            for (char currChar : array) {
                if (currChar == '[') {
                    intStack.push(num);
                    strStack.push(str.toString());
                    num = 0;
                    str = new StringBuilder();
                }
                // 拼接
                else if (currChar == ']') {
                    StringBuilder strTmp = new StringBuilder();
                    int intTmp = intStack.pop();
                    for (int i = 0; i < intTmp; i++) {
                        strTmp.append(str);
                    }
                    str = new StringBuilder(strStack.pop() + strTmp.toString());
                }
                else if (currChar >= '0' && currChar <= '9') {
                    num = num * 10 + currChar - '0';
                }
                // 字符
                else {
                    str.append(currChar);
                }
            }
            return str.toString();
        }
    }
}
