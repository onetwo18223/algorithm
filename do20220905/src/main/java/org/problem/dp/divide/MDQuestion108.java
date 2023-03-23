package org.problem.dp.divide;

/**
 * 分割回文串（二）
 *
 * 划分型
 * 实现：
 * 1.1 定义 dp[i] 定义为包含回文串的最小个数
 * 1.2 最后一步 俩层循环，遍历获取最小值的dp[i]
 * 2 转换公式
 *      j:for(0 ~ i)
 *      dp[i] = min(dp[i], dp[j] + 1)
 * 3 初始值和边界值
 * 4 顺序
 */
public class MDQuestion108 {
    public int minCut(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) return 0;
        int len = s.length();
        int[] dp = new int[len];
        dp[0] = 0; dp[1] = 0;
        for (int i = 2; i < len; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (dp[j] + 1 < dp[i] && isP(s.substring(j, i)))
                    dp[i] = dp[j] + 1;
            }
        }
        return dp[len - 1];
    }

    /**
     * 判断是否是回文串
     * @param s
     */
    private boolean isP(String s) {
        if (s.length() == 1) return true;
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
