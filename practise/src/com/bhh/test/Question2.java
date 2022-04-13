package com.bhh.test;

/**
 * @author bhh
 * @description
 * @date Created in 2022-03-05 16:04
 * @modified By
 */
public class Question2 {
    // 允许加减乘除, 使用dfs遍历实现
    public boolean compute24(int[] inputNumbers) {
        if (inputNumbers == null || inputNumbers.length == 0) {
            return false;
        }
        int len = inputNumbers.length;
        int target = 24;
        boolean[] visited = new boolean[len];
        return dfs(inputNumbers, visited, target);
    }

    private boolean dfs(int[] inputNumbers, boolean[] visited, int target) {
        if (target == 0 || target == 1) {
            return true;
        }
        boolean res = false;
        for (int i = 0; i < inputNumbers.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                res |= dfs(inputNumbers, visited, target * inputNumbers[i]);
                res |= dfs(inputNumbers, visited, target + inputNumbers[i]);
                res |= dfs(inputNumbers, visited, target - inputNumbers[i]);
                res |= dfs(inputNumbers, visited, target / inputNumbers[i]);
                visited[i] = false;
            }
        }
        return res;
    }
}
