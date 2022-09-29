package org.problem.stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/**
 * 有效的括号
 * <p>
 * 实现：这道题并没有设计多重括号嵌套，
 * 所以只需要匹配栈顶元素和遍历的字符串元素是否匹配即可
 */
public class Question20 {
    class Solution {
        public boolean isValid(String s) {
            if (s == null || "".equals(s)) return true;

            Deque<Character> stack = new ArrayDeque<>();

            HashMap<Character, Character> map = new HashMap<>();
            map.put(')', '(');
            map.put(']', '[');
            map.put('}', '{');

            for (int i = 0; i < s.length(); i++) {
                char temp = s.charAt(i);
                if (temp == '(' || temp == '[' || temp == '{') {
                    stack.addLast(temp);
                } else {
                    if (!stack.isEmpty()
                            && stack.getLast().equals(map.get(temp))) {
                        stack.removeLast();
                    } else {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }
    }
}
