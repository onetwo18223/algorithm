package com.bhh.lintcode.twopointr.samedirection;

/**
 * @author bhh
 * @description 全零子串的数量
 * @date Created in 2021-12-23 9:52
 * @modified By
 */
public class Question1870 {
    public class Solution {
        /*
        这道题有点数学题的意思在里面
        例如 : 3个连续的0, 可以组合出 3 + 2 + 1 共 6 种 全零子串
        2个连续的0, 可以组合出 2 + 1 共3中 全零子串
        那我们只需要双指针, start指向0开始的地方, end指向0结束的地方, 俩者相减, 遍历即可
         */
        public int stringCount(String str) {
            if (str == null){
                return 0;
            }
            int end = 1, num = 0;
            for (int start = 0; start < str.length(); start++) {
                if (str.charAt(start) != '0'){
                    continue;
                }
                // 为了防止出现 end - start = 负数 的情况
                end = Math.max(end, start + 1);
                // 结束条件为 越界 或者 str.charAt(end) != '0'
                while (end < str.length() && str.charAt(end) == '0'){
                    end++;
                }
                // 随着start的增大, 会获取区间内所有全 0 组合的数量
                num += (end - start);
            }
            return num;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question1870().
                new Solution().stringCount("00010011"));
    }
}
