package org.structure.stack;

import java.util.ArrayList;

/**
 * 栈的实现
 * <p>
 * 实现：栈的实现和队列的实现是数组遵从某种规律而生成的结构
 * 所以单个数组限制数据出入数组的位置即可成为栈或者队列
 */
public class ArrayStack implements Stack {

    private ArrayList<Integer> list;

    ArrayStack() {
        list = new ArrayList();
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
    public void push(int num) {
        // 添加元素到队尾
        list.add(num);
    }

    @Override
    public int pop() {
        // 删除队尾元素
        return list.remove(list.size() - 1);
    }

    @Override
    public int peek() {
        // 获取队尾元素
        return list.get(list.size() - 1);
    }
}
