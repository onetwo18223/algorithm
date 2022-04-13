package com.bhh.leetcode.swordfingeroffer.string;

/**
 * @author bhh
 * @description 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * @date Created in 2021-09-15 13:27
 * @modified By
 */
public class Question05 {
    class Solution {
        /*
        实现思路 :
        方法一 : 使用replace() 方法
        方法二 : 将字符串填充到数组当中, 如果碰到" ", 则写入'%','2','0', 否则直接写入到数组
         */
        public String replaceSpace1(String s) {
            return s.replace(" ", "%20");
        }
        public String replaceSpace2(String s) {

            int length = s.length();
            char[] chars = new char[length * 3];
            int size = 0;
            for (int i = 0; i < length; i++) {
                char c = s.charAt(i);
                if (c == ' '){
                    chars[size++] = '%';
                    chars[size++] = '2';
                    chars[size++] = '0';
                }else {
                    chars[size++] = c;
                }
            }
            return new String(chars, 0, size);
        }
    }
}
