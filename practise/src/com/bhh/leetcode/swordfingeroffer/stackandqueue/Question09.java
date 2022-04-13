package com.bhh.leetcode.swordfingeroffer.stackandqueue;

import com.bhh.leetcode.swordfingeroffer.array.Question66;

import java.util.Stack;

/**
 * @author bhh
 * @description 用两个栈实现队列
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead操作返回 -1 )
 * <p>
 * 示例 1：
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * <p>
 * 示例 2：
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * @date Created in 2021-09-20 15:54
 * @modified By
 */
public class Question09 {
    /*
    实现思路 :
    队列是 先进先出
    栈是 先进后出
    俩个栈可以实现 先进先出
        在存储数据时, 存储到栈1
        在取出数据时, 栈1遍历数据存储到栈2, 栈2弹出数据
            改进 : 若是栈2中, 仍然有数据, 则直接返回数据, 若是无数据, 才会获取栈1中的数据
     */
    class CQueue {


        private Stack<Integer> stack1;
        private Stack<Integer> stack2;

        public CQueue() {
            stack1 = new Stack();
            stack2 = new Stack();
        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        /*
        改进前 : 将栈1中的数据添加到栈2, 输出结果后再将栈2中的数据添加到栈1
        时间换空间
         */
        public int deleteHeadError() {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            int res = stack2.isEmpty() ? -1 : stack2.pop();
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            return res;
        }

        /*
        改进后 :
        删除时查看栈2中是否有数据, 有则直接返回
        查看栈1中是否有数据, 没有返回-1
        将栈1中数据存储到栈2
         */
        public int deleteHead() {

            if (!stack2.isEmpty()) {
                return stack2.pop();
            }
            if (stack1.isEmpty()) {
                return -1;
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }

    public static void main(String[] args) {
        CQueue cQueue = new Question09().new CQueue();
        cQueue.appendTail(3);
        cQueue.deleteHead();
        cQueue.deleteHead();
    }
}