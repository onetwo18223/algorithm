package com.bhh.leetcode.swordfingeroffer.stackandqueue;

import com.bhh.leetcode.swordfingeroffer.array.Question66;

import java.util.Stack;

/**
 * @author bhh
 * @description 栈的压入、弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如，序列 {1,2,3,4,5} 是某栈的压栈序列，
 * 序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，
 * 但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 * <p>
 * 示例 1：
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * <p>
 * 示例 2：
 * 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * 输出：false
 * 解释：1 不能在 2 之前弹出。
 * @date Created in 2021-09-20 20:27
 * @modified By
 */
public class Question31 {
    class Solution {
        /*
        实现思路 : 模拟栈, 先进栈, 后出栈
        创建栈对象stack, 将pushed[] 中是数据添加到stack中,
        每添加一次数据都比较栈顶数据和popped[] 中的数组顶部数据是否一样,
        若是一样, 出栈
        当pushed[] 数据为空时, 若是stack中数据也为空, 则可返回true
        注意点 :
            在模拟出栈的过程中, 对比stack.peek()的数据和popped[j]中的数据时, 需要使用while 循环
            若使用if, 执行一次, 每次添加最多执行一次pop(), 不符合题意
         */
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            if (pushed == null || pushed.length == 0) {
                return true;
            }

            Stack<Integer> stack = new Stack();
            for (int i = 0, j = 0; i < pushed.length; i++) {
                stack.push(pushed[i]);
                while ((!stack.isEmpty()) && stack.peek().equals(popped[j])) {
                    stack.pop();
                    j++;
                }
            }
            return stack.isEmpty();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question31().new Solution().validateStackSequences(new int[]{
                1, 2, 3, 4, 5
        }, new int[]{
                4, 5, 3, 1, 2
        }));
    }
}
