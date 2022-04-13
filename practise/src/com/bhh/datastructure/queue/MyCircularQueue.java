package com.bhh.datastructure.queue;

/**
 * @author bhh
 * @description 循环队列实现
 * 循环队列注意点
 * 队列实际容量是 capacity + 1, 因为有一个索引位置是空的
 * @date Created in 2021-08-24 16:30
 * @modified By
 */
public class MyCircularQueue<E> {

    private E[] data;

    private int capacity;

    private int size;

    /*
     当 front == tail 时表明size == 0
     当 (tail + 1) % capacity == front 时表明 队列已满
     */
    // front 指向首个元素索引位置
    private int front;
    // tail 指向下个添加元素的索引位置
    private int tail;

    public MyCircularQueue(int capacity) {
        this.capacity = capacity + 1;
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 入队
     *
     * @param e 入队元素
     */
    public void enqueue(E e) {
        if ((tail + 1) % capacity == front) {
            reSize(capacity * 2);// 扩容
        }
        data[tail] = e;
        tail = (++tail) % capacity;
        size++;
    }

    public E dequeue() {
        E e = data[front];
        size--;
        front = (++front) % capacity;
        return e;
    }

    public void reSize(int newCapacity) {
        E[] newArray = (E[]) new Object[(newCapacity + 1)];

        for (int i = 0; i < size; i++) {
            newArray[i] = data[((front + i) % capacity)];
        }
        data = newArray;
        capacity = newCapacity + 1;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("MyCircularQueue : size = %d, front = %d, tail = %d, capacity = %d\n"
                , size, front, tail, capacity));
        sb.append("队尾 [ ");
        for (int i = 0; i < size; i++) {
            sb.append(data[((front + i) % capacity)]);
            if (i != size - 1) {
                sb.append(", ");
            }
        }
        sb.append(" ] 队首");
        return sb.toString();
    }

    public static void main(String[] args) {
        MyCircularQueue<Integer> queue = new MyCircularQueue(10);
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        queue.dequeue();
        queue.dequeue();
        queue.reSize((queue.capacity - 1) * 2);
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(100);
        queue.enqueue(100);
        queue.enqueue(100);
        queue.enqueue(100);
        queue.enqueue(100);
        System.out.println(queue);
    }
}
