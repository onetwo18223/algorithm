package org.qa.sort.heapsort;

/**
 * @Author Bhh
 * @Date 2023-03-24 9:09
 * @Version 1.0
 */
public class HeapSort {
    public void sort(int[] nums) {
        // 创建(从后向前调整)
        // TODO：为什么需要多次调整，因为每次调整都是选取了一个parent元素，
        //  然后将其调整在合适的位置
        // [1, 11, 12, 41, 110, 45]
        int len = nums.length;
        // [12, 11, 45, 41, 110, 1]
//        adjustHead(nums, len, 0);

        // 从最后一个叶子节点的父节点开始调整
        for (int i = (len - 1) / 2; i >= 0; i--) adjustHead(nums, i, len);

        // 交换最大值到最后，调整
        for (int i = len - 1; i >= 0; i--) {
            swap(nums, 0, i);
            // 从0开始重排
            adjustHead(nums, 0, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void adjustHead(int[] nums, int parent, int end) {
        int value = nums[parent];
        // 左节点
        int lChild = parent * 2 + 1;
        while(lChild < end) {
            // 在左右节点中选择较大值
            int rChild = lChild + 1;
            if (rChild < end && nums[lChild] < nums[rChild]) lChild = rChild;
            // 如果父节点较大，则break;
            // TODO：为什么这里使用的是定值value，不是动态数据nums[parent]
            //  因为本次循环目的是确定value的合适的位置
            //  因为nums[parent]在循环过程中会被覆盖，造成nums[parent] != value，进一步造成排序错误
            if (value >= nums[lChild]) break;
            // 将值赋值给父节点
            nums[parent] = nums[lChild];
            parent = lChild;
            lChild = parent * 2 + 1;
        }
        // 循环结束时lChild越界，那么parent为位置正确的叶子结点
        nums[parent] = value;
    }

    public static void main(String[] args) {
        int[] nums = {1, 11, 12, 41, 110, 45};
        new HeapSort().sort(nums);
        for (int num : nums) {
            System.out.print(num);
            System.out.print(",");
        }
    }
}
