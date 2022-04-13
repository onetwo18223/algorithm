package com.bhh.lintcode.dfs;

import java.util.*;

/**
 * @author bhh
 * @description 字符串的不同排列
 * @date Created in 2021-12-11 7:48
 * @modified By
 */
public class Question10 {
    public class Solution {
        /*
        排列问题
        与组合问题不同点在于和顺序有关
        这道题需要进行一次去重
        去重方法 :
            尝试使用HashSet
            规律
        abb
        abb abb bab bab bba bba
         */
        public List<String> stringPermutation2(String str) {
            List<String> strList = new ArrayList<>();
            if (str == null || "".equals(str)) {
                return strList;
            }
            char[] chars = str.toCharArray();
            boolean[] visited = new boolean[chars.length];
            Arrays.sort(chars);
            dfs(chars, visited, "", strList);
            return strList;
        }

        private void dfs(char[] chars, boolean[] visited, String combination, List<String> strList) {
            if (combination.length() == chars.length) {
                strList.add(combination);
                return;
            }

            for (int i = 0; i < chars.length; i++) {
                if (visited[i]) {
                    continue;
                }
                // 首先i > 0, 防止越界
                // 经过排序后如果没有先使用前面的不可以使用后面的, 否则会重复
                if (i > 0 && chars[i] == chars[i - 1] && !visited[i - 1]) {
                    continue;
                }
                // 为什么 visited[i]也需要回溯, 因为对于一次for来说,
                //    里面的递归就好像是更多循环一样, 要去获取剩下位置的数据, 所以设置visited来防止访问重复数据
                //    回溯的原因是, 不能让这次的for循环来干扰向下一次的for循环
                // 回溯 combination 是一个道理
                // 为什么排列问题需要visited参与, 还要去重?
                //
                visited[i] = true;
                dfs(chars, visited, combination + chars[i], strList);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("".length());
    }
}
