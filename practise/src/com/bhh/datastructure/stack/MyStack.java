package com.bhh.datastructure.stack;

import com.bhh.datastructure.array.MyArrayList;

/**
 * @author bhh
 * @description 栈实现
 * @date Created in 2021-08-22 20:57
 * @modified By
 */
public class MyStack<E> {

    private MyArrayList<E> array;

    public MyStack(){
        array = new MyArrayList<>();
    }

    public void push(E e){
        array.addLast(e);
    }

    public E pop(){
        return array.removeLast();
    }

    public E peek(){
        return array.get(getSize() - 1);
    }

    public int getSize(){
        return array.getSize();
    }

    public boolean isEmpty(){
        return array.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack :");
        sb.append("[ ");
        for (int i = 0; i < getSize(); i++) {
            sb.append(array.get(i));
            if (i != getSize() - 1) {
                sb.append(", ");
            }
        }
        sb.append(" ] top");
        return sb.toString();
    }

    public static void main(String[] args) {
        MyStack<String> stack = new MyStack();
        for (int i = 0; i < 10; i++) {
            stack.push(String.valueOf(i));
        }
        stack.pop();
        stack.pop();
        stack.push("a");
        System.out.println(stack);
    }
}
