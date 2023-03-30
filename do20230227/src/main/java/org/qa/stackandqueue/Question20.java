package org.qa.stackandqueue;

import java.util.*;

/**
 * @Desc 有效的括号
 * https://leetcode.cn/problems/valid-parentheses/
 * 实现：
 * 使用栈的先进后出的特性，将String以char[]将字符依次放入栈中
 * 若是入栈元素和栈顶元素相同则出栈，最后栈中没有元素则认为参数为有效的括号
 * @Author Bhh
 * @Date 2023-03-30 14:26
 * @Version 1.0
 */
public class Question20 {
    class Solution {
        public boolean isValid(String str) {
            if (null == str || "".equals(str)) return false;
            Map<Character, Character> map = new HashMap<Character, Character>(){{
                put(')', '(');
                put(']', '[');
                put('}', '{');
            }};
            Deque<Character> stack = new ArrayDeque<Character>();
            char[] array = str.toCharArray();
            for (char tmp : array) {
                if (map.containsKey(tmp)) {
                    Character openChar = map.get(tmp);
                    if (stack.isEmpty() || openChar != stack.removeFirst())
                        return false;
                    continue;
                }
                stack.addFirst(tmp);
            }
            return stack.isEmpty();
        }
    }
}
