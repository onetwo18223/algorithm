package org.structure.queue;

/**
 * Queue接口，定义方法
 */
public interface Queue {
    int getSize();
    boolean isEmpty();
    void enqueue(int num);
    int dequeue() throws Exception;
    int getFront() throws Exception;
}
