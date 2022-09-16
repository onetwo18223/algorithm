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
    class SolutionMethod1 {
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

    /**
     * 方法二实现 ： 翻转之后再翻转
     * 优雅！太优雅了！
     */
    class SolutionMethod2 {
        public String reverseWords(String str) {
            // 判空处理
            if (str == null || "".equals(str)) return null;

            char[] chars = str.toCharArray();
            int left = 0, right = chars.length - 1;
            // step1:全部翻转(原地)
            reverse(chars, left, right);

            // step2:二次翻转
            word_reverse(chars, left, right);

            // step3：收尾，先去除俩边的空格，再去除中间重复空格
            // 循环结束时，left指向字符串第一个索引元素
            return clean_space(chars);
        }

        /**
         * 翻转指定数组的指定范围的元素
         * 使用相向双指针进行交换
         * @param chars 数组
         * @param left 左边界
         * @param right 右边界
         */
        private void reverse(char[] chars, int left, int right) {
            for (int i = left, j = right; i < j; i++, j--) {
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
            }
        }

        /**
         * 单词翻转
         * 使用同向双指针寻找单词，i寻找单词结尾（以' '为结尾），还需要判断i - 1仍然是空格
         * j为单词首元素
         * @param chars 数组
         * @param left 左边界
         * @param right 右边界
         */
        private void word_reverse(char[] chars, int left, int right) {
            int j = left;
            for (int i = left; i <= right; i++) {
                // 寻找空格代表找到了一个单词结尾
                if (chars[i] != ' ') continue;
                // 如果i索引前一个是空格，则代表无法形成单词
                if (i > 0 && chars[i - 1] == ' ') {
                    j = i;
                    continue;
                }
                reverse(chars, j, i - 1);
                j = i + 1;
            }
            // 结尾最后一个单词翻转
            reverse(chars, j, right);
        }

        /**
         * 用于完成多余空格清理
         * 使用双指针判断是否存在空格，i在前，j在后，i停止在非' '位置，
         * 设置j = i，然后开始赋值
         * i继续寻找下一个空格位置，如果下一个空格位置不越界，则添加一个空格到j后
         * 循环以上
         *
         * @param chars 字符数组
         * @return
         */
        public String clean_space(char[] chars) {
            int len = chars.length;
            int i = 0, j = 0;
            while (i < len) {
                // 结束条件：越界 或者 chars[i] != ' '
                while (i < len && chars[i] == ' ') i++;
                // 结束条件：越界 或者 chars[i] == ' '
                // 对于非' '的值可以往前移
                while (i < len && chars[i] != ' ') chars[j++] = chars[i++];
                // 结束条件：越界 或者 chars[i] != ' '
                // 作用：判断上一个while移动的单词是否是最后一个单词
                while (i < len && chars[i] == ' ') i++;
                if (i < len) {
                    chars[j++] = ' ';
                }
            }
            return new String(chars, 0, j);
//            return new String(chars).substring(0, j);
        }
    }

    public static void main(String[] args) {
        SolutionMethod2 test = new Question151().new SolutionMethod2();
        String str =
                "the            sky  is blue";
        System.out.println(test.reverseWords(str));
    }
}
