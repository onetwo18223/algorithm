package com.bhh.test;

public class Solution {
    //    /**
//     * Note: 类名、方法名、参数名已经指定，请勿修改
//     *
//     *
//     * 将 sourceX, sourceY 转换成 targetX, targetY 最少需要多少次计算
//     * @param sourceX long长整型  x初始值
//     * @param sourceY long长整型  y初始值
//     * @param targetX long长整型  x目标值
//     * @param targetY long长整型  y目标值
//     * @return long长整型
//     */
//    // bfs/dfs
//    int count = Integer.MAX_VALUE;
//    public long GetMinCalculateCount(long sourceX, long sourceY,
//                                     long targetX, long targetY) {
//        if (sourceX == targetX && sourceY == targetY) {
//            return 0;
//        }
//        dfs(sourceX, sourceY, targetX, targetY, 0);
//        return count;
//    }
//
//    private void dfs(long sourceX, long sourceY,
//                     long targetX, long targetY, int i) {
//        if (sourceX == targetX && sourceY == targetY) {
//            count = Math.min(count, i);
//            return;
//        }
//        if (sourceX > targetX || sourceY > targetY) {
//            count = -1;
//            return;
//        }
//        dfs(sourceX + 1, sourceY + 1, targetX, targetY, i + 1);
//        dfs(sourceX * 2, sourceY * 2, targetX, targetY, i + 1);
//    }
//
//    public static void main(String[] args) {
//        System.out.println(new Solution().GetMinCalculateCount(10, 100, 22, 202));
//    }
    // 从字符串记录元素'Y'出现的次数
//    public int calDPDScore(String dpdInfo) {
//        // write code here
//        if (dpdInfo == null || dpdInfo.length() == 0) {
//            return 0;
//        }
//        int allCount = 0;
//        for (int i = 0; i < dpdInfo.length(); i++) {
//            if (dpdInfo.charAt(i) == 'Y') {
//                int count = 1;
//                if (i > 0 && dpdInfo.charAt(i - 1) == 'Y') {
//                    continue;
//                }
//                int j = i + 1;
//                while (j < dpdInfo.length() &&
//                        dpdInfo.charAt(j) == 'Y') {
//                    count++;
//                    j++;
//                }
//                allCount = Math.max(allCount, count);
//            }
//        }
//
//        int res = 0;
//        if (allCount == 0) {
//            res = 0;
//        } else if (allCount <= 3) {
//            res = -10;
//        } else if (allCount <= 7) {
//            res = -15;
//        } else {
//            res = -25;
//        }
//        return res;
//    }
//
//    public static void main(String[] args) {
//        System.out.println(new Solution().calDPDScore("YYNNNY"));
//    }
    public long GetSubArrayMaxProduct(long[] nums) {
        // 获取最大乘积, 使用双dp可以解决, 一个记录较大值, 一个记录较小值
        // 因为乘积可能会有负负得正的情况, 所以需要记录最小值dp
        if (nums == null || nums.length == 0) {
            return 0;
        }
        long max = nums[0];
        int len = nums.length;
        long[] maxDp = new long[len];
        long[] minDp = new long[len];
        maxDp[0] = minDp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            maxDp[i] = Math.max(nums[i],
                    Math.max(minDp[i - 1] * nums[i], maxDp[i - 1] * nums[i]));
            minDp[i] = Math.min(nums[i],
                    Math.min(minDp[i - 1] * nums[i], maxDp[i - 1] * nums[i]));
            max = Math.max(max, maxDp[i]);
        }
        return max;
    }
}