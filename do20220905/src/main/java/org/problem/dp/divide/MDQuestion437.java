package org.problem.dp.divide;

/**
 * 书籍复印
 *
 * 本题设计到了俩个因素，一个是人数， 另一个是页数，那么需要二维数组来保存全部状态
 *
 * 1.1 最后一步
 *      最后一个人完成的最多页需要的最少时间
 * 1.2 定义
 *      指定完成pages指定页数需要的最短时间为dp[people][pages]
 *      dp[i][j] = int[people][pages];
 * 2 转换公式
 *      forl:(0 ~ j)
 *      dp[i][j] = dp[i - 1][l]
 * 3 初始值和边界值
 *      错位 dp[0][0] = 0; // 0人完成0页最少时间
 *      不错位 dp[0][0] = ？;// 1人完成1页最少时间
 * 4 顺序
 */
public class MDQuestion437 {
    /**
     * 为什么关于dp的列数量是要为pages.length + 1
     * 因为是
     * @param pages
     * @param k
     * @return
     */
    public int copyBooksError(int[] pages, int k) {
        if(pages == null || pages.length == 0) return 0;
        int pagesLen = pages.length;
        int[][] dp = new int[k + 1][pagesLen];
        for (int i = 0; i < pagesLen; i++) {
            dp[0][i] = Integer.MAX_VALUE;
        }
        int sum;

        for (int i = 1; i < k + 1; i++) {
            for (int j = 0; j < pagesLen; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                sum = 0;
                for (int l = j; l >= 0; l--) {
                    sum += pages[l];
                    dp[i][j] = Math.min(Math.max(
                            sum, dp[i - 1][l] == Integer.MAX_VALUE ? 0 : dp[i - 1][l]), dp[i][j]);
                }
            }
        }
        return dp[k][pagesLen - 1];
    }

    public int copyBooks(int[] pages, int k) {
        if (pages == null || pages.length == 0) {
            return 0;
        }
        int len = pages.length;
        int[][] dp = new int[k + 1][len + 1];
        dp[0][0] = 0;
        for (int i = 1; i < len + 1; i++) {
            dp[0][i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i < k + 1; i++) {
            // 遍历每一本书
            for (int j = 0; j < len + 1; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                int sum = 0;
                for (int l = j; l >= 0; l--) {
                    dp[i][j] = Math.min(
                            Math.max(sum, dp[i - 1][l]), dp[i][j]);
                    if (l > 0) {
                        sum += pages[l - 1];
                    }
                }
            }
        }
        return dp[k][len];
    }

    public static void main(String[] args) {
        System.out.println(new MDQuestion437().copyBooks(new int[]{3, 2, 4}, 2));
    }
}
