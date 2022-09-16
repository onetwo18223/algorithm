package org.problem.twopointer.reversepointer.twosum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * <p>
 * 实现：经典题目俩数之和，先排序，再使用相向双指针完成
 * 方法1：使用双指针
 * 方法2：使用HashMap
 * 因为本体需要返回index，所以HashMap更加方便
 */
public class Question1 {
    /**
     * 使用HashMap完成
     * 注意：不需要将所有的数据添加到HashMap再查找元素（俩次for），
     *      因为是俩个元素相互配合查找，所以一定有一个元素先进Map，另一个后进，
     *      再延伸可得直接一次for循环完成查找
     *      注意：需要先查找后put，防止出现当前数+当前数==target
     */
    class SolutionMethod1 {
        public int[] twoSum(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return new int[0];
            }
            Map<Integer, Integer> map = new HashMap();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(target - nums[i])) {
                    return new int[]{map.get(target - nums[i]), i};
                }
                map.put(nums[i], i);
            }
            return new int[0];
        }
    }

    /**
     * 使用相向双指针完成
     *
     * 注意：双指针并不适用于本道题，因为是需要返回索引，
     *      如果是直接返回指定值，那么可以使用双指针
     */
    class SolutionMethod2 {
        public int[] twoSum(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return new int[0];
            }
            // 排序
            Arrays.sort(nums);
            // 相向双指针
            int l = 0, r = nums.length - 1;
            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum == target) return new int[]{nums[l], nums[r]};
                else if (sum > target) r--;
                else l++;
            }
            return new int[0];
        }
    }
}
