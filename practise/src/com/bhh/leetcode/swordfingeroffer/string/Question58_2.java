package com.bhh.leetcode.swordfingeroffer.string;

/**
 * @author bhh
 * @description 左旋转字符串
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * <p>
 * 示例 1：
 * 输入: s = "abcdefg", k = 2
 * 输出:"cdefgab"
 * <p>
 * 示例 2：
 * 输入: s = "lrloseumgh", k = 6
 * 输出:"umghlrlose"
 * @date Created in 2021-09-17 17:01
 * @modified By
 */
public class Question58_2 {
    class Solution {
        /*
        实现思路 :
        方法1 : 将指定范围索引的字符串进行切割, 再添加在字符串末端
        方法2 : 如果不使用subString()进行切割, 可以使用拼接实现
         */
        public String reverseLeftWords(String s, int n) {
            if (n > s.length()){
                return null;
            }
            return s.substring(n, s.length()) + s.substring(0, n);
        }
        public String reverseLeftWords2(String s, int n) {
            if (n > s.length()){
                return null;
            }
            StringBuilder str = new StringBuilder();
            for (int i = n; i < s.length(); i++) {
                str.append(s.charAt(i));
            }
            for (int i = 0; i < n; i++) {
                str.append(s.charAt(i));
            }
            return str.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question58_2().new Solution().reverseLeftWords2("lrloseumgh", 6));
    }
}
