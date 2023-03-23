package org.problem.dp;

/**
 * 获取解码方式次数
 * 这道题可以更明确指出序列型为啥么要添加一个元素且需要进行错位
 * 因为dp[i] 要和之前的 dp[i - n] 进行互动，
 *      这时候添加一个元素对元数组不会造成影响，且会更方便bp计算
 * 但是如果dp[i]只和dp[i - 1]有互动，那么是否就不需要序列型呢？例如MDQuestion515
 *
 * 实现
 * 1.1 最后一步
 *      到最后一次，判断前一个字符+最后一个字符能否形成字母，若是可以则方式可以 + 1
 * 1.2 子问题
 * 2 公式转换
 *      dp[i] = dp[i - 1] + (chars[i - 1] * 10 + chars[i] <= 26) ? 1 : 2
 * 3 初始值
 *      dp[0] = 1
 * 4 顺序
 */
public class MDQuestion512 {
    public int getWay(String num) {
        if (num == null || num.length() == 0)
            return 0;
        char[] chars = num.toCharArray();
        int length = chars.length;
        int[] dp = new int[length];
        dp[0] = 1;
        for (int i = 1; i < length; i++) {
            if (chars[i] == '0')
                continue;
            dp[i] = dp[i - 1];
            if (i > 2) {
                int temp = Integer.parseInt(String.valueOf(chars[i - 1]) + chars[i]);
                if (10 <= temp && temp <= 26)
                    dp[i] += dp[i - 2];
            }
        }
        return dp[length - 1];
    }

    /**
     * 正确的序列型处理方式
     * @param s
     * @return
     */
    public int rightGetWay(String s) {
        char[] charArray = s.toCharArray();
        int len = charArray.length;
        if(len == 0) {
            return 0;
        }
        int[] dp = new int[len + 1];
        dp[0] = 1;

        for (int i = 1; i < len + 1; i++) {
            dp[i] = 0;
            int tmp = charArray[i - 1] - '0';
            if (tmp >= 1 && tmp <= 9) {
                dp[i] += dp[i - 1];
            }

            if (i >= 2) {
                tmp = (charArray[i - 2] - '0') * 10 + (charArray[i - 1] - '0');
                if (tmp >= 10 && tmp <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[len];
    }


    public static void main(String[] args) {
        System.out.println(new MDQuestion512().getWay("10"));
    }
}
