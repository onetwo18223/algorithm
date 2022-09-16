package org.problem.twopointer.reversepointer.twosum;

import java.util.Arrays;

/**
 * 有效三角形的个数
 * <p>
 * 实现：类似于三数之和，排序，for选择数据之后再以双指针形式选择另外俩个数
 * 注意：正向扫描的时候，如果两边之和小于第三边，
 *      那么会有两种情况，一种是左指针往右移动，一种是右指针往左移动。反向扫描只能说左指针往右
 */
public class Question611 {
    class Solution {
        public int triangleNumber(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            // 2 3 4 4      2 2 3 4
            Arrays.sort(nums);
            int length = nums.length;
            int count = 0;
            /*for (int i = 0; i < length; i++) {
                int l = i + 1;
                int r = length - 1;
                while (l < r) {
                    if (nums[i] + nums[l] > nums[r]) {
                        // 如果nums[l] + nums[r] > nums[i]，
                        //      那么从nums[l] 到 nums[r - 1] 都可以与 nums[r] 和 nums[i] 形成三角形
                        count += r - l;
                        r--;
                    } else {
                        l++;
                    }
                }
            }*/

            for (int i = length - 1; i >= 2; i--) {
                int l = 0;
                int r = i - 1;
                while(l < r) {
                    if (nums[l] + nums[r] > nums[i]) {
                        count += r - l;
                        r--;
                    } else l++;
                }
            }
            return count;
        }
    }
}
