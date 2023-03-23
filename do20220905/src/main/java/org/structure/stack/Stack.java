package org.structure.stack;

/**
 * 定义栈的基本方法
 */
public interface Stack {
    // push pop peek
    int getSize();
    boolean isEmpty();
    void push(int num);
    int pop();
    int peek();
}
