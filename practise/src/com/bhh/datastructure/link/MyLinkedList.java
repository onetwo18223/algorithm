package com.bhh.datastructure.link;

/**
 * @author bhh
 * @description 链表实现
 * <p>
 * 使用虚拟头可以避免头节点操作的特殊情况
 * 但是有了头结点遍历容器需要循环 size 次
 * 循环到index位置, 需要循环index + 1次
 * @date Created in 2021-08-25 12:50
 * @modified By
 */
public class MyLinkedList<E> {
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public MyLinkedList() {
        dummyHead = new Node();
        size = 0;
    }

    /**
     * 获取容器元素数量
     *
     * @return size
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断容器是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 添加元素
     * <p>
     * 获取 index - 1索引位置,  index.next = index-1.next
     * index-1.next = index
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        /*
        实现逻辑 :
        找到index - 1索引位置
        index.next = index - 1.next
        index - 1.next = index
         */
        if (index > size || index < 0) {
            throw new RuntimeException("index 越界");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        prev.next = new Node(e, prev.next);
        size++;
    }

    /**
     * 添加元素到头结点
     *
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 添加元素到尾部
     *
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 删除指定索引的元素
     * node.next = node.next.next
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index > size || index < 0) {
            throw new RuntimeException("index 越界");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node removedNode = prev.next;
        prev.next = prev.next.next;
        size--;
        return removedNode.e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 获取指定索引位置的值
     *
     * @param index
     * @return
     */
    public E get(int index) {
        if (index > size || index < 0) {
            throw new RuntimeException("index 越界");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        return prev.next.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    /**
     * 改变指定索引位置的值
     *
     * @param index
     * @param e
     * @return
     */
    public E set(int index, E e) {
        if (index > size || index < 0) {
            throw new RuntimeException("index 越界");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        return prev.next.e = e;
    }

    public E setFirst(E e) {
        return set(0, e);
    }

    public E setLast(E e) {
        return set(size - 1, e);
    }

    /**
     * 判断容器中是否有某一个元素
     *
     * @param e
     * @return
     */
    public boolean contain(E e) {
        Node node = dummyHead;
        for (int i = 0; i < size; i++) {
            node = node.next;
            if (node.e.equals(e)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        res.append(String.format("LinkList size : %d\n", size));
        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");

        return res.toString();
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.addLast(i);
        }
        list.removeFirst();
        System.out.println(list);
        list.removeLast();
        System.out.println(list);
        list.remove(3);
        System.out.println(list);
        System.out.println(list.get(0));
        list.setFirst(100);
        System.out.println(list);
        list.setLast(200);
        System.out.println(list);
        System.out.println(list.contain(100));
        System.out.println(list.contain(200));
    }
}
