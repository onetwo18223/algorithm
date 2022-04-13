package com.bhh.leetcode.four;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author bhh
 * @description 有效的括号
 * @date Created in 2022-02-25 20:32
 * @modified By
 */
public class Question20 {
    class Solution {
        /*
        我记得这道题是没有括号嵌套的
        使用栈
         */
        char[][] dict = new char[][]{{'(', ')'}, {'[', ']'}, {'{', '}'}};

        public boolean isValidError(String str) {
            ArrayDeque<Character> stack = new ArrayDeque<>();
            for (int i = 0; i < str.length(); i++) {
                char tmp = str.charAt(i);
                for (int j = 0; j < 3; j++) {
                    // 结尾括号
                    if (tmp == dict[j][1]) {
                        // 如果栈顶是一个括号开始, 则poll, 否则add
                        if (stack.isEmpty()) {
                            return false;
                        } else if (stack.peek() == dict[j][0]) {
                            stack.pop();
                        } else {
                            stack.push(tmp);
                        }
                    } else {
                        stack.push(tmp);
                    }
                }

            }
            return stack.isEmpty();
        }

        public boolean isValid(String str) {
            Map<Character, Character> map = new HashMap<>();
            ArrayDeque<Character> stack = new ArrayDeque<>();
            map.put(')', '(');
            map.put(']', '[');
            map.put('}', '{');
            for (int i = 0; i < str.length(); i++) {
                char tmp = str.charAt(i);
                if (map.containsKey(tmp)) {
                    if (stack.isEmpty() || stack.peek() != map.get(tmp)) {
                        return false;
                    }
                    stack.pop();
                } else {
                    stack.push(tmp);
                }
            }
            return stack.isEmpty();
        }
    }
}
