package org.qa.sort.heapsort;

/**
 * @Desc 堆排
 * 实现：
 *  实现堆，调整堆（调整堆每次只可以调整一个元素到正确的位置（这个思想和QuickSelect相似））
 *  每次取堆顶元素，然后调整堆
 * @Author bhh
 * @Date 2023-03-28 20:20
 * @Version 1.0
 */
public class HeapSortRe {
    public void sort(int[] nums) {
        if (null == nums || nums.length == 0) return;
        // 创建堆
        // 从后往前进行调整，因为越往后调整的次数越少
        // 从最后一个叶子节点的父节点开始
        for (int i = (nums.length - 1) / 2; i >= 0; i--) {
            this.adjustHeap(nums, 0, nums.length - 1, i);
        }
        // 获取最大元素，排序，调整堆
        for (int i = nums.length - 1; i >= 1; i--) {
            this.swap(nums, 0, i);
            this.adjustHeap(nums, 0, i - 1, 0);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void adjustHeap(int[] nums, int start, int end, int parent) {
        int value = nums[parent];
        int lChild = parent * 2 + 1;
        while (lChild <= end) {
            int rChild = lChild + 1;
            if (rChild <= end && nums[rChild] > nums[lChild]) lChild = rChild;
            if (value > nums[lChild]) break;
            nums[parent] = nums[lChild];
            parent = lChild;
            lChild = parent * 2 + 1;
        }
        nums[parent] = value;
    }

    public static void main(String[] args) {
        HeapSortRe sort = new HeapSortRe();
        int[] nums = {1, 2, 54, 9, 0};
        sort.sort(nums);
        for (int num : nums) {
            System.out.print(num);
            System.out.print(" ");
        }
    }
}
