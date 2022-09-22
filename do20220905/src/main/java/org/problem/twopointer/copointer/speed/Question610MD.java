package org.problem.twopointer.copointer.speed;

/**
 * 俩数之差
 * <p>
 * 实现：这道题是俩数之和的翻版,
 *          俩数之和使用相向双指针，是因为
 *          如果sum小于target则向右移动左指针即可
 *          如果sum大于target则向左移动右指针即可
 *      但是在这道题，如果使用相向双指针，
 *          若是lack大于target则可以向右移动左指针，也可以向左移动右指针，来保证lack减小
 *          若是lack小于target则没有办法通过移动相向双指针来保证lack的增大
 *          （相向双指针下，移动双指针，只会造成差值的增大）
 *      所以相向双指针不合适，可以使用同向双指针
 *      同向双指针下，
 *          若是lack大于target则右移左指针
 *          若是lack小于target则右移右指针
 */
public class Question610MD {
    public int[] twoSum7(int[] nums, int target) {
        if (nums == null || nums.length < 2) return new int[]{-1, -1};
        int left = 0;
        int right = 1;
        while (right < nums.length) {
            int lock = nums[right] - nums[left];
            if (lock < target) right++;
            else if (lock > target) left++;
            else return new int[]{nums[left], nums[right]};
        }
        return new int[]{-1, -1};
    }
}
