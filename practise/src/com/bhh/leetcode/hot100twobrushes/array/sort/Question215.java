package com.bhh.leetcode.hot100twobrushes.array.sort;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * @author bhh
 * @description 数组中的第K个最大元素
 * @date Created in 2022-01-25 13:57
 * @modified By
 */
public class Question215 {
    class Solution {
        /*
        topK问题
        方法一 : 使用优先队列, 泛用度较高
        方法二 : 使用快排改编的快速选择, 有些时候复杂度为O(n),
            但也有时候复杂度会退化到O(n^2)
         */
        // 快排
        public int findKthLargest(int[] nums, int k) {
            int len = nums.length;
            int targetIndex = len - k;
            return quickSort(nums, targetIndex, 0, nums.length - 1);
        }

        private int quickSort(int[] nums, int targetIndex, int left, int right) {
            int fitIndex = partition(nums, left, right);
            if (fitIndex == targetIndex) {
                return nums[fitIndex];
            }
            // 目标索引在大于nums[fitIndex]的位置
            else if (fitIndex < targetIndex) {
                return quickSort(nums, targetIndex, fitIndex + 1, right);
            } else {
                return quickSort(nums, targetIndex, left, fitIndex - 1);
            }
        }

        private int partition(int[] nums, int left, int right) {
            if (left >= right) {
                return left;
            }
            swap(nums, left, left + new Random().nextInt(right - left));
            // 索引j永远指向小于(或等于)nums[left]的最后一个元素位置
            int j = left;
            for (int i = left + 1; i <= right; i++) {
                if (nums[i] < nums[left]) {
                    j++;
                    swap(nums, i, j);
                }
            }
            swap(nums, j, left);
            return j;
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

        // 优先队列
        // 使用最小堆
        public int findKthLargestQueue(int[] nums, int k) {
            Queue<Integer> heap = new PriorityQueue<>();
            for (int num : nums) {
                if (heap.size() >= k) {
                    if (heap.peek() > num) {
                        continue;
                    }
                    heap.poll();
                }
                heap.offer(num);
            }
            return heap.remove();
        }
    }
}
