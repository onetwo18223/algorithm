package org.structure.queue;

/**
 * 实现双端队列
 *
 */
public class MyArrayDeque {
    // 数据集合
    private int[] data;
    // front指向数据开头，tail指向下一个数据应该存储的索引位置
    private int front, tail;
    // 数据多少
    private int size;

    public MyArrayDeque(int capacity) {
        data = new int[capacity];
        front = 0;
        tail = 0;
        size = 0;
    }

    public MyArrayDeque() {
        this(10);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 获取容器大小
    public int getCapacity() {
        return data.length;
    }

    public int getSize() {
        return size;
    }

    public void addFirst(int num) {
        if (size == getCapacity())
            resize(getCapacity() * 2);

        front = front == 0 ? data.length - 1 : front - 1;
        data[front] = num;
        size++;
    }

    public void addLast(int num) {
        if (size == getCapacity())
            resize(getCapacity() * 2);
        data[tail] = num;
        tail = (tail + 1) % data.length;
        size++;
    }

    private void resize(int newCapacity) {
        int[] newData = new int[newCapacity];
        for (int i = 0; i < size; i++)
            newData[i] = data[(i + front) % data.length];

        data = newData;
        front = 0;
        tail = size;
    }

    public int removeFirst() throws Exception {
        if (isEmpty())
            throw new Exception("队列为空");
        int remove = data[front];
        front = (front + 1) % data.length;
        size--;
        return remove;
    }

    public int removLast() throws Exception {
        if (isEmpty())
            throw new Exception("队列为空");
        tail = tail == 0 ? data.length - 1 : tail - 1;
        size--;
        return data[tail];
    }

    public int getFront() throws Exception {
        if (isEmpty())
            throw new Exception("队列为空");
        return data[front];
    }

    public int getLast() throws Exception {
        if (isEmpty())
            throw new Exception("队列为空");
        int last = tail == 0 ? data.length - 1 : tail - 1;
        return data[last];
    }

    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", getSize(), getCapacity()));
        res.append("front [");
        for(int i = 0 ; i < size ; i ++){
            res.append(data[(i + front) % data.length]);
            if(i != size - 1)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) throws Exception {

        // 在下面的双端队列的测试中，偶数从队尾加入；奇数从队首加入
        MyArrayDeque dq = new MyArrayDeque();
        for(int i = 0 ; i < 16 ; i ++){
            if(i % 2 == 0) dq.addLast(i);
            else dq.addFirst(i);
            System.out.println(dq);
        }

        // 之后，我们依次从队首和队尾轮流删除元素
        System.out.println();
        for(int i = 0; !dq.isEmpty(); i ++){
            if(i % 2 == 0) dq.removeFirst();
            else dq.removLast();
            System.out.println(dq);
        }
    }
}
