package com.bhh.leetcode.three;

/**
 * @author bhh
 * @description 字符串相乘
 * @date Created in 2022-02-02 22:21
 * @modified By
 */
public class Question43hot100 {
    class Solution {
        /*
        字符串相乘的关键在于计算乘法每一位, 然后相加
         */
        public String multiply(String num1, String num2) {
            if (num1.equals("0") || num2.equals("0")) {
                return "0";
            }
            String res = "0";
            // 从后往前乘
            for (int i = num2.length() - 1; i >= 0; i--) {
                StringBuilder sb = new StringBuilder();
                // 补零
                for (int j = i; j < num2.length() - 1; j++) {
                    sb.append("0");
                }
                // 乘法
                int n2 = num2.charAt(i) - '0';
                int pre = 0;
                for (int j = num1.length() - 1; j >= 0; j--) {
                    int n1 = num1.charAt(j) - '0';
                    int multiply = n1 * n2 + pre;
                    sb.append(multiply % 10);
                    pre = multiply / 10;
                }
                if (pre != 0) {
                    sb.append(pre);
                }
                res = addStrings(res, sb.reverse().toString());
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
