package org.qa.twopointer.reversepointer.reverse;

/**
 * @Desc 反转字符串中的单词
 * https://leetcode.cn/problems/reverse-words-in-a-string/
 * @Author bhh
 * @Date 2023-02-28 16:22
 * @Version 1.0
 */
public class Question151 {
    {
        /* 实现：
        整体翻转一次，之后遍历判断获取非连续空格下的字符串进行范围翻转
        先对多余空格进行处理
         */
    }

    class Solution {
        public String reverseWords(String s) {
            if (null == s || "".equals(s)) return null;
            char[] chars = s.toCharArray();
            int len = chars.length;
            // 整体翻转
            reverse(chars, 0, len - 1);
            // 局部翻转
            wordReverse(chars, 0, len - 1);
            // 清除多余空格
            return cleanSpace(chars);
        }

        // TODO：单词翻转是将单词开头的' '和结尾的' '作为突破点，
        //  也就是将 " abc "看做一个需要处理的整体
        //  但是不同于cleanSpace()，
        //  本方法中需要处理的特殊情况是开头无空格，结尾不空格，因为使用的是空格为结束条件
        //  开头可以给j赋值默认值解决，但是结尾需要进行特殊处理，
        //  若是chars[right] != ' '，那么说明有最后一个单词，则翻转最后一个单词
        private void wordReverse(char[] chars, int left, int right) {
            int j = left;
            for (int i = left; i <= right; i++) {
                // 寻找word结尾
                if (chars[i] != ' ') continue;
                // 判断寻找的结尾是否是结尾,
                // 若不是结尾，则是开头，将开头索引赋值给j
                if (i > 0 && chars[i - 1] == ' ') {
                    j = i;
                    continue;
                }
                reverse(chars, j, i - 1);
                // TODO：为什么j = i + 1，不能是 j = i 吗？反正j会被重新赋值为元素开头索引位置？
                //  这是为了防止出现某个元素的结尾' '= 下一个元素的开头' '
                //  例如："blue is sky the "
                j = i + 1;
            }
            // 翻转最后一个word
            if (chars[right] != ' ') {
                reverse(chars, j, right);
            }
        }

        private void reverse(char[] chars, int start, int end) {
            while(start < end) {
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;
                start++;end--;
            }
        }

        /**
         * @Author Bhh
         * @Desc 先清除首尾空格
         *       再清除字符串中的空格
         * @Date 20:12 2023/3/23
         * @Param [chars]
         * @Return void
         **/
        // TODO：难点在于在移动字符串时，怎么样保证偏移量是正确的
        //  使用双指针，同向双指针，
        //  一个索引指向正在遍历的元素，
        //  另一个指向正确字符串的下一个元素
        private String cleanSpace(char[] chars) {
            int len = chars.length;
            int i = 0, j = 0;
            // TODO：这三个循环
            //  第一个获取非' '的元素首个元素，
            //  第二个循环获取该字符串的最后一个元素，
            //  第三个元素主要用于判断第二个循环赋值后，是否不再有非' '元素，
            //  若是后续有元素则给后续重叠的 j 赋值' '，
            //  该思想就是将 "  abc abc abc  "转换为多个 " abc "，
            //      外层的while循环执行一次解决一次 " abc "
            while (i < len) {
                while(i < len && chars[i] == ' ') i++;
                while(i < len && chars[i] != ' ')
                    chars[j++] = chars[i++];
                while(i < len && chars[i] == ' ') i++;
                if (i < len) chars[j++] = ' ';
            }
            return new String(chars, 0, j);
        }
    }
    public static void main(String[] args) {
        System.out.println(new Question151().new Solution().
                reverseWords("blue is sky the"));
    }
}
