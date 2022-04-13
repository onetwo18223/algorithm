package com.bhh.leetcode.hot100twobrushes.array.string;

/**
 * @author bhh
 * @description 字符串相加
 * @date Created in 2022-01-27 15:31
 * @modified By
 */
public class Question415 {
    class Solution {
        /*
        字符串相加, 从后往前相加
        正常的想法是先补位然后从后往前进行相加
        优点是思路清晰, 缺点是代码太长
         */
        public String addStrings(String num1, String num2) {
            int len1 = num1.length();
            int len2 = num2.length();
            // 位数降低的数据补零
            StringBuilder strBuild = new StringBuilder();
            // num1 高位补零
            if (len1 < len2) {
                // 使用num1表示高位, num2表示低位
                String tmp = num1;
                num1 = num2;
                num2 = tmp;
                len1 = num1.length();
                len2 = num2.length();
            }

            // 有效数组变成num1 和 array
            for (int i = 0; i < (len1 - len2); i++) {
                strBuild.append("0");
            }
            strBuild.append(num2);

            char[] array1 = num1.toCharArray();
            char[] array2 = strBuild.toString().toCharArray();
            strBuild = new StringBuilder();
            // 进位
            int pre = 0;
            // 每位相加
            for (int i = array1.length - 1; i >= 0; i--) {
                int sum = array1[i] - '0' + array2[i] - '0' + pre;
                if (sum / 10 > 0) {
                    pre = 1;
                    sum = sum % 10;
                } else {
                    pre = 0;
                }
                strBuild.append(sum);
            }
            if (pre == 1) {
                strBuild.append(1);
            }
            return strBuild.reverse().toString();
        }

        // 不补位, 直接相加, 若是出现越界直接认为是'0'
        public String addStringsBetter(String num1, String num2) {
            StringBuilder strBuild = new StringBuilder();
            char[] array1 = num1.toCharArray();
            char[] array2 = num2.toCharArray();
            int index1 = array1.length - 1;
            int index2 = array2.length - 1;
            // 进位
            int pre = 0;
            // 每位相加
            while (index1 >= 0 || index2 >= 0){
                int tmp1 = index1 >= 0 ? array1[index1] - '0' : 0;
                int tmp2 = index2 >= 0 ? array2[index2] - '0' : 0;
                int sum = tmp1 + tmp2 + pre;
                pre = sum / 10;
                strBuild.append(sum % 10);
                index1--;
                index2--;
            }
            if (pre == 1) {
                strBuild.append(1);
            }
            return strBuild.reverse().toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question415().new Solution().addStringsBetter("11", "123"));

    }
}
