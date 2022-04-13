package com.bhh.leetcode.hot100.array;

/**
 * @author bhh
 * @description 寻找重复数
 * @date Created in 2021-12-24 19:58
 * @modified By
 */
public class Question287 {
    class Solution {
        /*
        将 n+1 个整数限制在 1 ~ n的范围内, 那必然是有一个数会重复
            (例如 : 把 13个数 限制在 1 ~ 12的范围内)
        二分法遍历 ' 抽屉 ’, 查看 '抽屉( 抽屉有顺序编号 )’ 中的 '苹果( 数组存储的数据 )’,
        如果从某个编号的抽屉往第一个抽屉看, 苹果的数量大于抽屉编号, 则认为苹果在 1~这个编号的抽屉中
         */
        public int findDuplicate(int[] nums) {
            if (nums == null || nums.length == 0){
                return 0;
            }
            int len = nums.length;
            int start = 1, end = len - 1;
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                int cur = 0;
                for (int num : nums) {
                    if (num <= mid){
                        cur++;
                    }
                }
                if (cur > mid){
                    end = mid;
                } else {
                    start = mid;
                }
            }
            int cur = 0;
            for (int num : nums) {
                if (num <= start){
                    cur++;
                }
            }
            if (cur > start){
                return start;
            }
            return end;
        }
    }
}
