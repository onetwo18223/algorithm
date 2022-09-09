package org.structure;

import java.util.ArrayList;

import static java.util.Collections.swap;

/**
 * 最大堆实现
 * 依靠数组实现，可以看做是完全二叉树
 * 索引之间符合规律：
 * 父节点索引获取左子节点： index * 2 + 1
 * 父节点索引获取右子节点： index * 2 + 2
 * 子节点获取父节点索引： (index - 1) / 2
 */
public class MaxHeap {

    ArrayList<Integer> array;

    MaxHeap() {
        array = new ArrayList<Integer>();
    }

    /**
     * 添加节点到树
     * 先将节点添加到数组尾部
     * 之后循环进行判断，作为子节点是否小于父节点，小于则进行交换
     *
     * @param num 添加元素的值
     */
    public void addNode(int num) {
        array.add(num);
        int index = array.size() - 1;
        int parentIndex = (index - 1) / 2;
        while (index - 1 >= 0 && array.get(index) > array.get(parentIndex)) {
            swap(array, index, parentIndex);
            parentIndex = (index - 1) / 2;
        }
    }

    /**
     * 获取最大值
     * 即获取数组第零个元素
     *
     * @return 最大值
     */
    public int getMax() throws Exception {
        if (array.size() == 0) {
            throw new Exception("数组为空");
        }
        return array.get(0);
    }

    /**
     * 堆取出节点只能取第零个元素
     * 交换最后一个元素和第一个元素，移除最后一个元素
     * 之后第零个与其左右节点进行比较，然后向下进行交换
     *
     * @return 最大值
     */
    public int removeNode() throws Exception {
        int temp = getMax();

        int index = 0;
        int removeIndex = array.size() - 1;
        swap(array, index, removeIndex);
        array.remove(removeIndex);
        int leftIndex = 0, rightIndex = 0;
        while (true) {
            // 左节点
            leftIndex = index * 2 + 1;
            rightIndex = index * 2 + 2;
            if (rightIndex < array.size() - 1 &&
                    (array.get(index) < array.get(leftIndex) || array.get(index) < array.get(rightIndex))) {
                if (array.get(leftIndex) > array.get(rightIndex)) {
                    swap(array, leftIndex, index);
                    index = leftIndex;
                } else {
                    swap(array, rightIndex, index);
                    index = rightIndex;
                }
            } else {
                break;
            }
        }
        return temp;
    }

    public static void main(String[] args) throws Exception {
        MaxHeap heap = new MaxHeap();
        heap.addNode(10);
        heap.addNode(1100);
        heap.addNode(89);
        heap.addNode(98);
        heap.addNode(67);
        heap.addNode(34);
        heap.addNode(12);
        heap.addNode(1);
        System.out.println("heap.getMax() = " + heap.getMax());
        System.out.println("heap.removeNode() = " + heap.removeNode());
        System.out.println("heap.removeNode() = " + heap.removeNode());
        System.out.println("heap.getMax() = " + heap.getMax());
    }
}
