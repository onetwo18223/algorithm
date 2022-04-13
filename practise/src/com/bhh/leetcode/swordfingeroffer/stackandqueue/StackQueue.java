package com.bhh.leetcode.swordfingeroffer.stackandqueue;

import java.util.Stack;

/**
 * @author bhh
 * @description 通过Stack来完成Queue
 * @date Created in 2021-10-14 17:59
 * @modified By
 */
public class StackQueue {
    private Stack<Integer> stack;
    StackQueue(){
        stack = new Stack<>();
    }

    public void push(int i) {
        stack.push(i);
    }

    /**
     将栈底充当队首, 先将除最后的元素全部存放在另一个栈
     在输出
     再将元素重新存放到该栈
     */
    public int pop(){
        Stack<Integer> stack1 = new Stack<>();
        while(stack.size() > 1){
            stack1.push(stack.pop());
        }
        int res = stack.pop();
        while (!stack1.isEmpty()){
            stack.push(stack1.pop());
        }
        return res;
    }

    public static void main(String[] args) {
        StackQueue queue = new StackQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        System.out.println(queue.pop()); // 1
        System.out.println(queue.pop()); // 2
        queue.push(5);
        System.out.println(queue.pop()); // 3
        System.out.println(queue.pop()); // 4
        System.out.println(queue.pop()); // 5
    }
}
