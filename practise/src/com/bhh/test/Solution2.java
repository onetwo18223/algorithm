package com.bhh.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author bhh
 * @description 最长无重复的子数组长度
 * @date Created in 2022-03-12 19:28
 * @modified By
 */
public class Solution2 {
    // 使用双指针(快慢双指针, 遍历快指针) + Hash 解决
    public int maxSubArrLength(int[] arr) {
        // 判空处理
        if (arr == null || arr.length == 0) {
            return 0;
        }
        // 创建hash
        Map<Integer, Integer> map = new HashMap<>();
        // 慢指针
        int left = 0;
        // 定义结果
        int res = 0;
        // 快指针遍历
        for (int i = 0; i < arr.length; i++) {
            // 判断左边界
            left = Math.max(left, map.getOrDefault(arr[i], -1) + 1);
            // 存储元素到map中
            map.put(arr[i], i);
            res = Math.max(res, i - left + 1);
        }
        return res;
    }

    // dfs组合题目, 回溯可以解决
    // 给定了考试总次数和考试最后一次的分数
    private int examCount;
    private int lastScore;
    public ArrayList<ArrayList<Integer>> process(int[] allScoreArray,
                                                 int examCount, int lastScore) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        // 判空
        if (allScoreArray == null || allScoreArray.length == 0) {
            return res;
        }
        this.examCount = examCount;
        this.lastScore = lastScore;
        boolean[] visited = new boolean[allScoreArray.length];
        // 标记最后一个元素不再可用
        for (int i = 0; i < allScoreArray.length; i++) {
            if (allScoreArray[i] == lastScore) {
                visited[i] = true;
                break;
            }
        }
        // 进行回溯
        dfs(allScoreArray, new ArrayList<Integer>(), visited, res, lastScore, 0);
        return res;
    }

    private void dfs(int[] nums, ArrayList<Integer> lists,
                     boolean[] visited, ArrayList<ArrayList<Integer>> res, int sum, int count) {
        if (count != 0 && (sum - lastScore) % count != 0) {
            return;
        }
        if (lists.size() == examCount - 1 && sum % examCount == 0) {
            lists.add(lastScore);
            res.add(new ArrayList<>(lists));
            lists.remove(lists.size() - 1);
            return;
        }
        if (lists.size() >= examCount) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            lists.add(nums[i]);
            visited[i] = true;
            dfs(nums, lists, visited, res, sum + nums[i], count + 1);
            visited[i] = false;
            lists.remove(lists.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().
                process(new int[]{3, 4, 5, 6, 7, 8, 9, 10}, 6, 6));
    }
}
