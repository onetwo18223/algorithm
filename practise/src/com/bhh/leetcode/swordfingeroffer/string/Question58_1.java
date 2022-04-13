package com.bhh.leetcode.swordfingeroffer.string;

import java.util.Arrays;

/**
 * @author bhh
 * @description 翻转单词顺序
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。
 * 例如输入字符串"I am a student. "，则输出"student. a am I"。
 * <p>
 * 示例 1：
 * 输入: "the sky is blue"
 * 输出:"blue is sky the"
 * <p>
 * 示例 2：
 * 输入: " hello world! "
 * 输出:"world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * <p>
 * 示例 3：
 * 输入: "a good  example"
 * 输出:"example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * <p>
 * 说明：
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * @date Created in 2021-09-17 15:24
 * @modified By
 */
public class Question58_1 {
    class Solution {
        /*
        实现思路 :
            方法 : 双指针(一个指针指向参数, 一个指向返回结果)
                将参数s转换为char数组
                定义指针oldChars指向参数数组末尾 : 数组.length - 1;
                定义char数组, 存放输出结果, 并定义一个指针指向 0(数据插入的位置)

                循环将旧数组中的数组复制到新数组中
                若是旧数组oldChars索引位置的值不为' ', 则直接赋值到 chars[newChars]
                旧数组oldChars索引位置的值不为' ', 则判断chars[newChars - 1] 是否等于 ' ',
                    若是等于, 则不作操作
                    不等于, 则赋值chars[newChars]

        实现错误 : 字符串类问题需要看成是char[]数组来解决问题,
            但是String内部提供了很多使用的方法, 我们可直接操作String来完成
         */

        public String reverseWordsError(String s) {
            char[] charArray = s.toCharArray();
            char[] chars = new char[charArray.length];
            char[] tempChars = new char[charArray.length];
            int oldChars = charArray.length - 1, newChars = 0;

            for (; newChars < charArray.length; newChars++, oldChars--) {
                if (charArray[oldChars] != ' ') {
                    chars[newChars] = charArray[oldChars];
                } else {
                    if (newChars != 0 && chars[newChars - 1] != ' ') {
                        chars[newChars] = charArray[oldChars];
                    }
                }
            }
            return Arrays.toString(chars);
        }

        /*
        实现思路 :
            方法 :
            双指针(利用双指针获取关于参数s的相隔' '的字符串)
            双指针分别指向 l(刚开始指向参数s最末尾, 根据情况向前推进, l--;), r(参数s最末尾)
            遍历获取字符串中是' '的索引, 将索引赋值给l,切割 subString(l + 1, r + 1)赋值给StringBuilder
            遍历获取字符串中不是' '的索引, 将索引赋值给l, 再赋值给r //跳过' '
         */
        public String reverseWords(String s) {
            s = s.trim();
            int r = s.length() - 1, l = r;
            StringBuilder str = new StringBuilder();

            while (l >= 0) {
                // 寻找到空格的索引, 将l指向' '的索引位置, 那么(l + 1)到 r 是有意义的数据
                while (l >= 0 && s.charAt(l) != ' ') {
                    l--;
                }
                // 将索引之间的字符串进行切割, 并拼接到str
                str.append(s.substring(l + 1, r + 1) + " ");
                // 将l索引指向非' '的位置
                while (l >= 0 && s.charAt(l) == ' ') {
                    l--;
                }
                r = l;
            }
            return str.toString().trim();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question58_1().new Solution().reverseWords("  hello world!  "));
    }
}
