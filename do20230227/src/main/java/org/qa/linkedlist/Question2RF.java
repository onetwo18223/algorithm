package org.qa.linkedlist;

/**
 * @Desc Question2
 * RF:right format 正确的格式
 * @Author Bhh
 * @Date 2023-04-03 9:58
 * @Version 1.0
 */
public class Question2RF {
    class Solution {
        int preNum;
        public ListNode addTwoNumbers(ListNode lOne, ListNode lTwo) {
            // 递归结束条件
            if (null == lOne && null == lTwo && preNum == 0) return null;
            int sum = (lOne == null ? 0 : lOne.val) +
                    (lTwo == null ? 0 : lTwo.val) + preNum;
            ListNode node = new ListNode(sum);
            node.next = addTwoNumbers((lOne == null ? lOne : lOne.next),
                    (lTwo == null ? lTwo : lTwo.next));
            return node;
        }
    }
}
