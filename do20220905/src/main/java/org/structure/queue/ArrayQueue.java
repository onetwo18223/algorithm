package org.structure.queue;

import java.util.ArrayList;

/**
 * 队列实现
 * <p>
 * 实现：和实现栈类似 ArrayStack
 */
public class ArrayQueue implements Queue {
    private ArrayList<Integer> list;

    ArrayQueue() {
        list = new ArrayList<>();
    }

    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void enqueue(int num) {
        list.add(num);
    }

    @Override
    public int dequeue() {
        return list.remove(0);
    }

    @Override
    public int getFront() {
        return list.get(0);
    }
}
