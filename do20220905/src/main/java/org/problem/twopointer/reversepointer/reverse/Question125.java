package org.problem.twopointer.reversepointer.reverse;

/**
 * 判断回文串
 * <p>
 * 实现：使用相向双指针，需要注意的是空格问题
 * 方法1：可以先去除空格再判断
 * 方法2：判断时忽略空格
 */
public class Question125 {
    class Solution {
        public boolean isPalindrome(String s) {
            if (s == null) return false;
            if ("".equals(s)) return true;
            // 全部转换为小写
            s = s.toLowerCase();
            int l = 0, r = s.length() - 1;
            while(l < r) {
                if (!((48 <= s.charAt(l) && s.charAt(l) <=57)
                        || (65 <= s.charAt(l) && s.charAt(l) <= 90)
                        || (97 <= s.charAt(l) && s.charAt(l) <= 122))) {
                    l++;continue;
                }
                if (!((48 <= s.charAt(r) && s.charAt(r) <=57)
                        || (65 <= s.charAt(r) && s.charAt(r) <= 90)
                        || (97 <= s.charAt(r) && s.charAt(r) <= 122))) {
                    r--;continue;
                }
                if (s.charAt(l) == s.charAt(r)) {
                    l++;r--;
                } else {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question125().new Solution()
                .isPalindrome("A man, a plan, a canal: Panama"));
    }
}
