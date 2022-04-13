package com.bhh.leetcode.hot100twobrushes.array.string;

/**
 * @author bhh
 * @description 字符串相乘
 * @date Created in 2022-01-27 16:39
 * @modified By
 */
public class Question43 {
    class Solution {
        /*
        num1乘以num2的每一位, 并进行相应的补零
        然后将这几个结果进行相加获得最终结果
         */
        public String multiply(String num1, String num2) {
            if (num1.equals("0") || num2.equals("0")) {
                return "0";
            }
            String res = "0";
            for (int i = num2.length() - 1; i >= 0; i--) {
                // 存储本次乘的结果
                StringBuilder tmp = new StringBuilder();
                // 补零
                for (int j = 0; j < num2.length() - 1 - i; j++) {
                    tmp.append("0");
                }
                int n2 = num2.charAt(i) - '0';
                int pre = 0;
                // 乘法运算
                for (int j = num1.length() - 1; j >= 0 ; j--) {
                    int n1 = num1.charAt(j) - '0';
                    int multiply = n1 * n2 + pre;
                    tmp.append(multiply % 10);
                    pre = multiply / 10;
                }
                // 进位不等于0时
                if (pre != 0) {
                    tmp.append(pre);
                }
                // 将结果加到res
                res = addStrings(res, tmp.reverse().toString());
            }
            return res;
        }

        // 字符串相加
        private String addStrings(String num1, String num2) {
            StringBuilder res = new StringBuilder();
            int len1 = num1.length();
            int len2 = num2.length();
            int index1 = len1 - 1;
            int index2 = len2 - 1;
            int pre = 0;
            while (index1 >= 0 || index2 >= 0) {
                int n1 = index1 >= 0 ? num1.charAt(index1) - '0' : 0;
                int n2 = index2 >= 0 ? num2.charAt(index2) - '0' : 0;
                int sum = n1 + n2 + pre;
                pre = sum / 10;
                res.append(sum % 10);
                index1--;
                index2--;
            }
            if (pre != 0) {
                res.append(pre);
            }
            return res.reverse().toString();
        }
    }
}
