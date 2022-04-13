package com.bhh.leetcode.hot100twobrushes.heap;

/**
 * @author bhh
 * @description 寻找两个正序数组的中位数
 * @date Created in 2022-01-25 21:49
 * @modified By
 */
public class Question4 {
    class Solution {
        /*
        这道题是求中位数, 且复杂度要求O(log(m + n))
        则需要使用到二分查找/ 快速选择
        这道题是类似于topk题目的, 但是不同点在于一般topk是无序, 单个数组获取第k个元素
        本题是有序, 俩个数组获取中位数, 中位数可以进行转换为第k个元素(根据总长度判断)
        但是是俩个数组, 如何获取?
        将 k 除以 2 - 1, 分别在俩个数组上取第k个元素, 若是越界则取最后位的元素
        比较俩个元素大小, 较小的元素的左侧部分会被抛弃, 因为这个部分一定不会存在第k个元素
            当俩个数组中的某个索引为length时, 表示这个数组中数据被抛弃完了,
            这时去另一个数组中的第k位
         */
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int len1 = nums1.length;
            int len2 = nums2.length;
            int totalLength = len1 + len2;
            // 奇数时, 中位数为中间一个值
            if (totalLength % 2 == 1) {
                int mid = totalLength / 2;
                return getKthElement(nums1, nums2, mid + 1);
            }
            // 偶数时, 中位数为俩个最值
            else {
                int mid1 = totalLength / 2;
                int mid2 = totalLength / 2 - 1;
                return (getKthElement(nums1, nums2, mid1 + 1) +
                        getKthElement(nums1, nums2, mid2 + 1)) / 2.0;
            }
        }

        // 寻找俩个数组情况的第k个最小值
        private double getKthElement(int[] nums1, int[] nums2, int k) {

            int length1 = nums1.length, length2 = nums2.length;
            int index1 = 0, index2 = 0;

            while (true) {
                // 表示已经越界, 获取nums2的第k个数即可
                if (index1 == length1) {
                    return nums2[index2 + k - 1];
                }
                // nums1同理
                if (index2 == length2) {
                    return nums1[index1 + k - 1];
                }
                // 还有一种情况是俩边大小都不会越界, 但是k被消耗没了
                if (k == 1) {
                    return Math.min(nums1[index1], nums2[index2]);
                }

                // 正常情况
                // 获取k/2 - 1
                int mid = k / 2;
                // 获取新的索引, 并防止越界
                int newIndex1 = Math.min(length1, index1 + mid) -  1;
                int newIndex2 = Math.min(length2, index2 + mid) -  1;
                // 比较俩个值大小
                int tmp1 = nums1[newIndex1];
                int tmp2 = nums2[newIndex2];
                // num1的第k/2 - 1位数较小, 则将nums1左侧数抛弃
                if (tmp1 <= tmp2) {
                    k -= (newIndex1 - index1 + 1);
                    index1 = newIndex1 + 1;
                }
                // nums2同理
                else {
                    k -= (newIndex2 - index2 + 1);
                    index2 = newIndex2 + 1;
                }
            }
        }
    }
}
