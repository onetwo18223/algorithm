package com.bhh.datastructure.queue;

import com.bhh.datastructure.array.MyArrayList;

/**
 * @author bhh
 * @description 队列实现
 * @date Created in 2021-08-24 16:25
 * @modified By
 */
public class MyQueue<E> {

    private MyArrayList<E> array;

    public MyQueue() {
        array = new MyArrayList();
    }

    /**
     * 入队
     *
     * @param e
     */
    public void enqueue(E e) {
        array.addLast(e);
    }

    /**
     * 出队
     */
    public E dequeue() {
        return array.removeFirst();
    }

    public E getFront() {
        return array.get(0);
    }

    public int getSize() {
        return array.getSize();
    }

    public boolean isEmpty() {
        return array.isEmpty();
    }
}
