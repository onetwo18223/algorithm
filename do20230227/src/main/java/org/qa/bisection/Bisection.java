package org.qa.bisection;

/**
 * @Desc 二分
 * 获取指定数值的索引值
 * @Author Bhh
 * @Date 2023-03-29 17:05
 * @Version 1.0
 */
public class Bisection {
    public int getIndex(int[] nums, int target) {
        if (null == nums || nums.length == 0) return -1;
        return bisection(nums, 0, nums.length - 1, target);
    }

    private int bisection(int[] nums, int start, int end, int target) {
        // TODO: 为什么是start + 1 < end
        // 结束条件为 start + 1 == end
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) end = mid - 1;
            else end = start + 1;
        }
        if (nums[start] == target) return start;
        return end;
    }
}
