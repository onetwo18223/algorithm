package com.bhh.leetcode.hot100twobrushes.array.string;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author bhh
 * @description 有效的括号
 * @date Created in 2022-01-24 11:33
 * @modified By
 */
public class Question20 {
    class Solution {
        /*
        将括号防止到栈内, 后括号碰到相对应的前括号则前括号移除
        这道题比想象中简单一些, 因为"{[}]"的字符串会被认为是无效字符串
         */
        public boolean isValid(String s) {
            Deque<Character> stack = new ArrayDeque<>();
            Map<Character, Character> map = new HashMap<>();
            map.put(']', '[');
            map.put('}', '{');
            map.put(')', '(');
            for (int i = 0; i < s.length(); i++) {
                char tmp = s.charAt(i);
                if (map.containsKey(tmp)) {
                    if (stack.isEmpty() || !stack.peek().equals(map.get(tmp))) {
                        return false;
                    }
                    stack.pop();
                } else {
                    stack.push(tmp);
                }
            }
            return stack.size() == 0;
        }
    }
}
