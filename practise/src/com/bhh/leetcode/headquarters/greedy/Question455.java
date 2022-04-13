package com.bhh.leetcode.headquarters.greedy;

import java.util.Arrays;

/**
 * @author bhh
 * @description 分发饼干(贪心算法例题)
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。
 * 但是，每个孩子最多只能给一块饼干。
 * 对每个孩子 i，都有一个胃口值g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；
 * 并且每块饼干 j，都有一个尺寸 s[j]。如果 s[j]>= g[i]，
 * 我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。
 * 你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 * @date Created in 2021-10-20 20:06
 * @modified By
 */
public class Question455 {
    class Solution {
        /*
        实现思路 :
        先用最大的饼干来判断能否让最贪心的孩子满足
        如果可以, 则以此类推下去
        如果不行, 则表示无法让这个孩子满足
        这样的分配原则就是贪心算法 : 将问题分为多个小问题, 给每个小问题一个最优解
        且 贪心算法一般涉及到 取最大值或者是最小值, 所以贪心一般也和排序比较有关联
         */
        public int findContentChildren(int[] g, int[] s) {
            // 排序
            Arrays.sort(g);
            Arrays.sort(s);
            int count = 0;
            for (int i = g.length - 1, j = s.length - 1; i >= 0; i--) {
                if (j >= 0 && s[j] >= g[i]) {
                    j--;
                    count++;
                }
            }
            return count;
        }
    }
}
