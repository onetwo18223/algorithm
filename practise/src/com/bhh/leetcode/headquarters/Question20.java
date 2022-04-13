package com.bhh.leetcode.headquarters;

import java.util.Stack;

/**
 * @author bhh
 * @description leetcode
 * 第20题 括号匹配
 * @date Created in 2021-07-21 9:46
 * @modified By
 */
// class Solution
public class Question20 {
    public static void main(String[] args) {
        Question20 test = new Question20();
        System.out.println("test.isValid(\"(])\") = " + test.isValid("(])"));
    }
    public boolean isValid(String s) {

        // 使用栈来完成括号的对比
        Stack stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.size() == 0) {
                    return false;
                }
                char topc = (char) stack.peek();
                if ((c == ')' && topc == '(') ||
                        (c == ']' && topc == '[') ||
                        (c == '}' && topc == '{')) {
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
