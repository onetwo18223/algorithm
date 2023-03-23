package org.problem.dp.backpack;

/**
 * 背包问题
 *
 * 背包问题需要二维数组来标记状态
 * dp[n][m] n个物品能否装满m大的空间
 */
public class MDQuestion92 {
    public int backPack(int m, int[] a) {
        if (a == null || a.length == 0) return 0;
        int len = a.length;
        boolean[][] dp = new boolean[len + 1][m + 1];
        dp[0][0] = true;

        // i个物品
        for (int i = 1; i <= len; i++) {
            // 容量
            for (int j = 0; j <= m; j++) {
                // 如果 i - 1 个物品可以装满 j
                // 那么 i 个物品可以装满 j
                dp[i][j] = dp[i - 1][j];
                // 当前容量可以容纳 指定 物品
                if (j >= a[i - 1]) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - a[i - 1]];
                }
            }
        }

        for (int i = m; i >= 0; i--) {
            if (dp[len][i])
                return i;
        }
        return 0;
    }

    /**
     * 1.1 定义
     *      dp[n][m] 表示前 n个物品能否装满 m大的空间
     * 1.2 最后一步
     *      需要遍历容量判断 dp[n - 1][ m - a[i]] 能否装满
     * 2 转换公式
     *      dp[n][m] = dp[n][m] || dp[n - 1][m - a[i - 1]]
     * 3 初始值和边界值
     *      dp[0][0] = 0;
     * 4 顺序
     * @param capacity
     * @param nums
     * @return
     */
    public int backPackTwice(int capacity, int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int len = nums.length;
        boolean[][] dp = new boolean[len + 1][capacity + 1];
        // 前0个物品可以装满容量0的空间
        dp[0][0] = true;
        // 前0个物品不能装满容量 > 0 的空间
        for (int i = 1; i <= capacity; i++) dp[0][i] = false;

        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= capacity; j++) {
                dp[i][j] = dp[i - 1][j];
                // 当前容量可以容纳 指定 物品
                if (j >= nums[i - 1])
                    dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
            }
        }

        // 倒序判断 dp[len][i] len个物品能否装满容量为i的背包
        // 取最大的容量
        for (int i = capacity; i >= 0; i--) {
            if (dp[len][i]) return i;
        }
        return 0;
    }
}
