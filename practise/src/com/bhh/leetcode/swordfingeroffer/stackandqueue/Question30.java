package com.bhh.leetcode.swordfingeroffer.stackandqueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

/**
 * @author bhh
 * @description 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
 * 调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * <p>
 * 示例:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 * @date Created in 2021-09-20 17:50
 * @modified By
 */
public class Question30 {
    /*
    栈的最小值问题
     */
    class MinStack {

        private List<Integer> list;
        private Stack<Integer> stack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            list = new ArrayList<>();
            stack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if (list.size() == 0 || x <= list.get(0)) {
                // 在新增时也添加到list中
                list.add(x);
                list.sort(Comparator.comparingInt(o -> o));
            }
        }

        public void pop() {
            if (stack.pop().equals(list.get(0))) {
                list.remove(0);
            }
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return list.get(0);
        }
    }
    class MinStack1 {
        Stack<Integer> A, B;
        public MinStack1() {
            A = new Stack<>();
            B = new Stack<>();
        }
        public void push(int x) {
            A.add(x);
            if(B.empty() || B.peek() >= x)
                B.add(x);
        }
        public void pop() {
            if(A.pop().equals(B.peek()))
                B.pop();
        }
        public int top() {
            return A.peek();
        }
        public int min() {
            return B.peek();
        }
    }



    public static void main(String[] args) {
        MinStack minStack = new Question30().new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-1);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.min());
    }

}
