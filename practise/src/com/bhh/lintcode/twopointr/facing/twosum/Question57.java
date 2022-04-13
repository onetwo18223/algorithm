package com.bhh.lintcode.twopointr.facing.twosum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bhh
 * @description 三数之和
 * 给出一个有n个整数的数组S，在S中找到三个整数a, b, c，找到所有使得a + b + c = 0的三元组。
 * <p>
 * 在三元组(a, b, c)，要求a≤b≤c。结果不能包含重复的三元组。
 * @date Created in 2021-12-01 14:17
 * @modified By
 */
public class Question57 {
    public class Solution {
        /*
        三数相加, 且要求输出格式 : a <= b <= c
        不同于twoSum的点在于多了一个数, 那么我们就可以使用降维思想
        使用循环遍历 numbers, 确定a的值, 通过相遇双指针方法获取 b + c = -a 的 b和c
        注意点 :
            先排序
            题目要求"结果不能包含重复的三元组",
                所以若是遍历时出现a的值有相同的, 则只需要处理一次就可, 之后出现的相同的a值, 肯定会情况更少 38行
                所以若是获取b时, 发现b值有相同的, 跳过即可 72行
         */
        public List<List<Integer>> threeSum(int[] numbers) {
            if (numbers == null || numbers.length == 0) {
                return null;
            }
            Arrays.sort(numbers);
            List<List<Integer>> res = new ArrayList<>();
            // 确定 a 的值
            for (int i = 0; i < numbers.length; i++) {
                // 在确定a的值时, 发生相同值, 直接跳过
                // 因为前面a寻找b,c值得情况一定要比后面a的情况多
                if (i != 0 && numbers[i] == numbers[i - 1]) {
                    continue;
                }
                findTwo(numbers, i, res);
            }
            return res;
        }

        /**
         * 获取另外俩个数, 使 b + c = -a(numbers[i])
         *
         * @param numbers
         * @param i
         * @param res
         */
        private void findTwo(int[] numbers, int i, List<List<Integer>> res) {
            int start = i + 1, end = numbers.length - 1;
            int target = -numbers[i];

            while (start < end) {
                int twoSum = numbers[start] + numbers[end];
                if (twoSum > target) {
                    end--;
                } else if (twoSum < target) {
                    start++;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(numbers[i]);
                    list.add(numbers[start]);
                    list.add(numbers[end]);
                    res.add(list);
                    start++;
                    end--;
                    // 寻找 b, c 值时, 防止出现 题目所不要求的"结果不能包含重复的三元组"
                    while (start < end && numbers[start] == numbers[start - 1]) {
                        start++;
                    }
                }
            }
        }
    }
}
