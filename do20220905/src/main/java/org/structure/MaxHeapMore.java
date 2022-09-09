package org.structure;

import java.util.ArrayList;
import java.util.Random;

/**
 * 最大堆实现
 * 依靠数组实现，可以看做是完全二叉树
 * 索引之间符合规律：
 * 父节点索引获取左子节点： index * 2 + 1
 * 父节点索引获取右子节点： index * 2 + 2
 * 子节点获取父节点索引： (index - 1) / 2
 */
public class MaxHeapMore {

    ArrayList<Integer> array;

    MaxHeapMore() {
        array = new ArrayList<Integer>();
    }

    int parent(int index) {
        return (index - 1) / 2;
    }

    int leftChild(int index) {
        return index * 2 + 1;
    }

    int rightChild(int index) {
        return leftChild(index) + 1;
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
        siftUp(index);
    }

    /**
     * 将索引对应值向上移动到正确位置
     * @param index 索引
     */
    public void siftUp(int index) {
        while (index > 0 && array.get(index) > array.get(parent(index))) {
            swap(array, index, parent(index));
            index = parent(index);
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
        int lastIndex = array.size() - 1;
        swap(array, index, lastIndex);
        array.remove(lastIndex);
        siftDown(index);

        return temp;
    }

    public void siftDown(int index){
        // 先判断是否存在左子节点
        while (leftChild(index) < array.size()) {
            int j = leftChild(index);
            if (j + 1 < array.size() && array.get(j + 1) > array.get(j)) {
                j++;
            }
            if (array.get(j) > array.get(index)) {
                swap(array, j, index);
                index = j;
            } else {
                break;
            }
        }
    }

    /**
     * 替换操作
     * 实现方法1：移除最大元素之后在添加元素即可
     * 实现方法2：直接替换最大元素之后进行siftDown操作
     */
    public int replace(int num) throws Exception {
        int max = getMax();
        array.set(0, num);
        siftDown(0);
        return max;
    }

    /**
     * 将数组转换为堆形式
     * 实现：获取lastIndex的父节点，从该父节点开始往前调用下沉siftDown操作
     */
    public void heapify(int[] nums){
        if (nums.length == 0) return;
        int lastIndex = nums.length - 1;
        for (int i = parent(lastIndex); i >= 0; i--) {
            siftDown(i);
        }
    }

    private void swap(ArrayList<Integer> data, int k, int parent) {
        int e = data.get(k);
        data.set(k, data.get(parent));
        data.set(parent, e);
    }

    public static void main(String[] args) throws Exception {

        int n = 1000000;

        MaxHeapMore maxHeap = new MaxHeapMore();
        int[] arr = new int[n];
        Random random = new Random();

        /*for (int i = 0; i < n; i++)
            maxHeap.addNode(random.nextInt(Integer.MAX_VALUE));*/
        /*for (int i = 0; i < n; i++)
            arr[i] = maxHeap.removeNode();*/

        // 覆盖数值，测试 heapify()
        for (int i = 0; i < n; i++)
            arr[i] = random.nextInt(Integer.MAX_VALUE);
        maxHeap.heapify(arr);
        for (int i = 0; i < n; i++)
            arr[i] = maxHeap.removeNode();

        for (int i = 1; i < n; i++)
            if (arr[i - 1] < arr[i]) throw new Exception("Error");

        System.out.println("Test MaxHeap completed.");
    }
}
