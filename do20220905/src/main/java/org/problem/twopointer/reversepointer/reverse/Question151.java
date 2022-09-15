package org.problem.twopointer.reversepointer.reverse;

/**
 * 反转字符串中的单词
 * <p>
 * 实现：在不限制内存的条件下实现较为容易的
 * 具体方法1：不使用其他内存，先清除俩边空格，之后翻转字符串，再对字符进行翻转
 * 具体方法2：使用其他内存，先清除俩边空格，之后从后向前，
 * 获取到字符串赋值给新的StringBuilder（需要使用到同向双指针）
 */
public class Question151 {
    class Solution {
        public String reverseWords(String str) {
            // 判空处理
            if (str == null || "".equals(str)) return null;

            // 先去除俩边的空格
            int left = 0, right = str.length() - 1;
            // 循环结束时，left指向字符串第一个索引元素
            while (str.charAt(left) == ' ') left++;
            // 循环结束时，right指向字符串最后一个索引元素
            while (str.charAt(right) == ' ') right--;

            // 从后往前判断是否包含字符串，然后添加到StringBuilder
            StringBuilder strBuilder = new StringBuilder();
            // 同向双指针
            // start指向需要转移的字符串的首个索引位置，end指向最后一个索引位置
            int end = right + 1;
            for (int start = right; start >= left; start--) {
                // start寻找索引指向为' '的元素
                if (str.charAt(start) != ' ') {
                    continue;
                }
                // 当start指向' '时，需要判断start + 1是否为空，因为要避免连续空格的存在
                if (str.charAt(start + 1) == ' ') {
                    end = start;
                    continue;
                }
                // 排除重复空格之后，添加数据到strBuilder
                strBuilder.append(str.substring(start + 1, end) + " ");
                end = start;
            }
            // start结尾时为 start < left
            strBuilder.append(str.substring(left, end));
            return strBuilder.toString();
        }
    }
}
