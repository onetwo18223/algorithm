package com.bhh.leetcode.swordfingeroffer.dynamic;

/**
 * @author bhh
 * @description 把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译为字符串：
 * 0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。
 * 请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * <p>
 * 示例 1:
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 * 1 2 2 5
 * 1 = 1
 * 1 5 = 2
 * 1 2 2 = 3 (12,2| 1,22)
 * 1 2 2 5 = 5 (12,25|12 2 5|1 2 25|1 22 5)
 * 1 2 2 5 2 = 5
 * 1 2 2 5 2 2 =
 * 1 2 2 1 2 = 8 ?(1 2 2 12 | 1 2 21 2 | 1 22 12 | 12 2 12 | 12 21 2 )
 * 12 2 1 2 | 1 22 1 2 |
 * <p>
 * 2 = 1
 * 2 6 = 1
 * 2 6 2 = 1
 * 2 6 2 1 = 2
 * @date Created in 2021-10-09 20:29
 * @modified By
 */
public class Question46 {
    class Solution {
        /*
        实现思路 :
        按照动态规划规律, 从index = 0开始, 使用memo[]数组来记录对应的翻译种类
        通过查找发现 : 若是substring(index - 1, index) 的结果 > 10 且小于 26,
            则memo[index] = memo[index - 1] + memo[index - 2]
        否则, memo[index] = memo[index - 1]

        但是, 出现问题 : 因为需要index - 2, 所以赋值低层时, 需要赋值 0, 1,但是num中索引1对应的值现在并不确定
        所以在memo[] 首位空出一个元素位置, 即memo[0] = 1;memo[1] = 1;
        这个memo[0]是空出来的位置, memo[1]对应num[0]具有一种翻译结果
        所以后面设计memo与num索引时, 索引会多-1
         */
        public int translateNum(int num) {
            String str = String.valueOf(num);
            int n = str.length();
            int[] memo = new int[n + 1];
            memo[0] = 1;
            memo[1] = 1;
            for (int i = 2; i <= n; i++) {
                String temp = str.substring(i - 2, i);
//                if(temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0){
//                    memo[i] = memo[i - 1] + memo[i - 2];
//                }else{
//                    memo[i] = memo[i - 1];
//                }

                if ((str.charAt(i - 2) < '2' && str.charAt(i - 2) > '0') ||
                        (str.charAt(i - 2) == '2' && str.charAt(i - 1) <= '5')) {
                    memo[i] = memo[i - 1] + memo[i - 2];
                } else {
                    memo[i] = memo[i - 1];
                }
            }
            return memo[n];
        }
    }
}
