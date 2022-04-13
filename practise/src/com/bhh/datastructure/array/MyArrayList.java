package com.bhh.datastructure.array;

import java.util.ArrayList;

/**
 * @author bhh
 * @description 实现动态数组
 * @date Created in 2021-08-22 17:13
 * @modified By
 */
public class MyArrayList<E> {

    private static final int CAPACITY = 10;

    // 数组的元素数量
    private int size;

    // 数组
    private E[] data;

    public MyArrayList(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public MyArrayList() {
        this(CAPACITY);
    }

    /**
     * 获取数组中数据的数量
     *
     * @return size
     */
    public int getSize() {
        return size;
    }

    /**
     * 返回数组容量
     *
     * @return data.length
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 返回数组中是否有数据
     *
     * @return size == 0
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 添加元素到数组中
     *
     * @param index 要添加的元素的索引位置
     * @param e     要添加的元素
     */
    public void add(int index, E e) {
        /*
        添加逻辑 :
        若是 index < 0 || index > size则不允许插入
         */
        if (size == data.length) {
            resize();
        }

        if (index < 0 || index > size) {
            System.out.println("index = " + index);
            System.out.println("size = " + size);
            throw new RuntimeException("woc error");
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 添加数据到数组末尾
     *
     * @param e 要添加的元素
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 添加数据到数组首位
     *
     * @param e 要添加的元素
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 删除某个索引处的数据
     *
     * @param index 索引位置
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeException("index 越界");
        }

        E delEle = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return delEle;
    }

    /**
     * 删除数组尾部索引
     */
    public E removeLast() {
         return remove(size - 1);
    }

    /**
     * 删除数据头部索引
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 修改指定索引位置的值
     *
     * @param index 索引
     * @param e     修改后的值
     * @return 修改前的值
     */
    public E update(int index, E e) {
        if (index < 0 || index >= size) {
            throw new RuntimeException("index 越界");
        }
        E updatedElement = data[index];
        data[index] = e;
        return updatedElement;
    }

    /**
     * 修改数组末尾索引的值
     *
     * @param e 修改后的值
     * @return 修改前的值
     */
    public E updateLast(E e) {
        return update(size - 1, e);
    }

    /**
     * 修改数据首位索引的值
     *
     * @param e 修改后的值
     * @return 修改前的值
     */
    public E updateFirst(E e) {
        return update(0, e);
    }

    /**
     * 获取指定索引的值
     *
     * @param index 索引
     * @return 数据
     */
    public E get(int index) {
        return data[index];
    }

    /**
     * 数组中是否包含指定元素
     *
     * @param e 元素
     * @return boolean
     */
    public boolean contains(E e) {
        if (e == null) {
            throw new RuntimeException("参数错误");
        }
        for (E datum : data) {
            if (datum.equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 进行扩容
     */
    public void resize() {
        /*
        实现逻辑
        创建二倍于现在的数组
        将数据进行复制
        改变引用指向
         */
        int capacity = data.length * 2;
        E[] newArray = (E[]) new Object[capacity];

        for (int i = 0; i < size; i++) {
            newArray[i] = data[i];
        }

        data = newArray;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        sb.append("[ ");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size - 1) {
                sb.append(", ");
            }
        }
        sb.append(" ]");
        return sb.toString();
    }

    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList<String>();

        MyArrayList<Integer> myArrayList = new MyArrayList();
        for (int i = 0; i < 10; i++) {
            myArrayList.addLast(i);
        }
        myArrayList.remove(1);
//        myArrayList.add(6, 11);
//        myArrayList.remove(7);
//        System.out.println("myArrayList.size = " + myArrayList.size);
//        myArrayList.add(9, 22);
//        myArrayList.add(10, 44);
//        myArrayList.update(1, 33);
        System.out.println(myArrayList.toString());
    }
}
