package com.bhh.leetcode.swordfingeroffertwobrushes.heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author bhh
 * @description 最小的k个数
 * @date Created in 2022-01-16 19:13
 * @modified By
 */
public class Question40 {
    class Solution {
        /*
        比较经典的topK问题
        使用堆完成, 使用大顶堆, 且大小维持在k个元素
         */
        public int[] getLeastNumbers(int[] arr, int k) {
            if (k == 0) {
                return new int[0];
            }
            // 使用大顶堆
            Queue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);

            for (int num : arr) {
                if (!heap.isEmpty() || heap.size() < k || heap.peek() > num) {
                    heap.add(num);
                }
                if (heap.size() > k) {
                    heap.poll();
                }
            }

            // 堆元素存储到数组中
            int[] res = new int[heap.size()];
            int j = 0;
            for (Integer integer : heap) {
                res[j++] = integer;
            }
            return res;
        }

        // 使用大顶堆
        public int[] getLeastNumbersQueue(int[] arr, int k) {
            if (arr == null || arr.length == 0 || k == 0) {
                return new int[0];
            }
            Queue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
            for (int i : arr) {
                if (heap.size() >= k) {
                    if (heap.peek() < i) {
                        continue;
                    }
                    heap.poll();
                }
                heap.offer(i);
            }

            int[] res = new int[heap.size()];
            for (int i = 0; i < res.length; i++) {
                res[i] = heap.poll();
            }
            return res;
        }

        // 使用快排
        // 获取最小的第k个元素的索引位置
        // 通过快速选择获取这个索引位置, 返回从0到这个位置之间的所有元素
        public int[] getLeastNumbersSort(int[] arr, int k) {
            if (arr == null || arr.length == 0 || k == 0) {
                return new int[0];
            }
            int targetIndex = k - 1;
            return Arrays.copyOfRange(arr, 0,
                    quickSelect(arr, targetIndex, 0, arr.length - 1) + 1);
        }

        private int quickSelect(int[] nums, int target, int left, int right) {
            int fitIndex = partition(nums, left, right);
            if (fitIndex > target) {
                return quickSelect(nums, target, left, fitIndex - 1);
            } else if (fitIndex < target) {
                return quickSelect(nums, target, fitIndex + 1, right);
            } else {
                return fitIndex;
            }
        }

        private int partition(int[] nums, int left, int right) {
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
    }
}
