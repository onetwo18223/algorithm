package com.bhh.leetcode.swordfingeroffertwobrushes.array;

/**
 * @author bhh
 * @description 圆圈中最后剩下的数字
 * @date Created in 2022-01-20 12:42
 * @modified By
 */
public class Question62 {
    /*
    约瑟夫环问题
    这是从结果向前反推, 结果(也就是最后一次循环剩下的数索引一定是0)
    反推公式 : (当前index + m) % 上一轮剩余数字的个数
     */
    class Solution {
        public int lastRemaining(int n, int m) {
            int ans = 0;
            // 最后一轮剩下2个人，所以从2开始反推
            for (int i = 2; i <= n; i++) {
                ans = (ans + m) % i;
            }
            return ans;
        }
    }
}
