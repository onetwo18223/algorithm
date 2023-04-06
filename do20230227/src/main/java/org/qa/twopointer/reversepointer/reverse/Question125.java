package org.qa.twopointer.reversepointer.reverse;

/**
 * @Desc 判断回文串
 * https://leetcode.cn/problems/valid-palindrome/
 * @Author bhh
 * @Date 2023-02-28 14:41
 * @Version 1.0
 */
public class Question125 {
    {
        /* 实现：
        小写转换 twoLowcase()
        相向双指针遍历，
        若是非 a~z || A ~ Z则跳过
        若是相同，则l++，r--
        若是不同，则返回
         */
    }

    class Solution {
        // TODO:在大小写切换的时候，因为直接使用方法会额外遍历一次数组
        //  所以可以直接在循环中完成判断，若是符合要求的字符就不做额外处理，直接判断
        //  如果是不符合要求的字符就进行二次判断（是否是大小写问题），全都不是的话就循环跳过
        //  注意每次循环判断都需要加上 left <= right
        public boolean isPalindrome(String s) {
            if (null == s || "".equals(s)) return true;
            char[] chars = s.toCharArray();
            int left = 0, right = s.length() - 1;
            int cha = 'A' - 'a';
            while (left <= right) {
                while (left <= right &&
                        !(('a' <= chars[left] && chars[left] <= 'z')
                                || ('0' <= chars[left] && chars[left] <= '9'))) {
                    if ('A' <= chars[left] && chars[left] <= 'Z') {
                        chars[left] = (char) (chars[left] - cha);
                    } else {
                        left++;
                    }
                }
                while (left <= right &&
                        !(('a' <= chars[right] && chars[right] <= 'z')
                                || ('0' <= chars[right] && chars[right] <= '9'))) {
                    if ('A' <= chars[right] && chars[right] <= 'Z') {
                        chars[right] = (char) (chars[right] - cha);
                    } else {
                        right--;
                    }
                }
                if (left <= right && chars[left] != chars[right]) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }
}
