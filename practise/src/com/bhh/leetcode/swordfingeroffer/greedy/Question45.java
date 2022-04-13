package com.bhh.leetcode.swordfingeroffer.greedy;

import com.bhh.leetcode.swordfingeroffer.dynamic.Question42;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author bhh
 * @description 把数组排成最小的数
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数
 * ，打印能拼接出的所有数字中最小的一个。
 * 示例 1:
 * 输入: [10,2]
 * 输出: "102"
 * <p>
 * 示例 2:
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 * 3 30 34
 * 30334
 * 3 30 34 1
 * 130334
 * 3 30 34 31
 * 3031334
 * @date Created in 2021-10-11 9:12
 * @modified By
 */
public class Question45 {
    class Solution {
        /*
        实现思路 : 这道题重点在于排序, 例如对于nums[0]和nums[1], 即3, 30
        若是 3组合30(330) > 30组合3 (303), 则30小于3

        收获 : 重要 : 很多题目需要想着往结果靠
              但是往往很多很难想, 谁能想到这和排序有关?
              重要 : 排序并非只能靠 比较自己大小来完成, 也可以通过比较 和 来完成
         */
        public String minNumber(int[] nums) {
            int n = nums.length;
            String[] str = new String[n];
            for (int i = 0; i < n; i++) {
                str[i] = String.valueOf(nums[i]);
            }
            Arrays.sort(str, (x, y) -> (x + y).compareTo(y + x));
//            Arrays.sort(str, new Comparator<String>() {
//                @Override
//                public int compare(String o1, String o2) {
//                    return (o1 + o2).compareTo(o2 + o1);
//                }
//            });
            StringBuilder builder = new StringBuilder();
            for (String s : str) {
                builder.append(s);
            }
            return builder.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question45().new Solution().minNumber(new int[]{
                7543, 5328, 9834, 1940, 9387, 871, 5208, 7, 543
        }));
    }
}
