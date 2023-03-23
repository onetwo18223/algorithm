package org.structure.queue;

/**
 * 循环队列
 * 规律：
 * front == tail时队列为空
 * （tail + 1） % size == front时队列已满
 * 循环队列会浪费一个空间
 *
 */
public class LoopQueue implements Queue{

    private int[] data;
    private int front, tail;
    // 当前元素个数
    private int size;
    LoopQueue(int capacity) {
        // 循环队列会浪费一个节点位置，所以总容量需要 + 1
        data = new int[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    LoopQueue() {
        this(10);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    public int getCapacity() {
        return data.length - 1;
    }

    /**
     * 入队操作
     * 需要先判断队列是否满，扩容，参数为当前可用容量的2倍
     * 之后进行数据添加，最后需要size（数据量）++
     * @param num
     */
    @Override
    public void enqueue(int num) {
        // 判断队列是否满
        if ((tail + 1) % size == front)
            resize(getCapacity() * 2);
        data[tail] = num;
        tail = (tail + 1) % data.length;
        size++;
    }

    /**
     * 扩容
     * 数据转移时需要注意偏移量
     * front和tail索引位的更新
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        int[] newData = new int[newCapacity];
        for (int i = 0; i < size; i++)
            // 数据转移
            // 转移时会出现一个偏移量
            newData[i] = data[(i + front) % data.length];
        data = newData;
        // front 指向数据开端第一个元素索引位
        front = 0;
        // tail 指向数据下一个应该存储的索引位
        tail = size;
    }

    /**
     * 元素出队
     * @return
     * @throws Exception
     */
    @Override
    public int dequeue() throws Exception {
        if (isEmpty())
            throw new Exception("队列为空");
        int pop = data[front];
        // 防止front越界
        front = (front + 1) % data.length;
        size--;
        return pop;
    }


    @Override
    public int getFront() throws Exception {
        if (isEmpty())
            throw new Exception("队列为空");
        return data[front];
    }
}
