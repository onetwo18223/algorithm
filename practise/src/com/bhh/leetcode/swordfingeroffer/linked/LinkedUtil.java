package com.bhh.leetcode.swordfingeroffer.linked;

/**
 * @author bhh
 * @description 创建关于链表的测试用例
 * @date Created in 2021-09-24 8:46
 * @modified By
 */
public class LinkedUtil {
    /**
     * 获取关于ListNode的测试用例
     * @return
     */
    public static ListNode getInstance(int[] nums){
        if (nums == null || nums.length == 0){
            return new ListNode(0);
        }

        ListNode head = new ListNode(nums[0]);
        ListNode p = head;
        for (int i = 1; i < nums.length; i++, p = p.next) {
            p.next = new ListNode(nums[i]);
        }
        return head;
    }

    /**
     * 输出链表
     * @param head
     */
    public static void OutListNode(ListNode head){
        StringBuilder str = new StringBuilder();
        ListNode p = head;
        while(p != null){
            str.append(p.val);
            if (p.next != null){
                str.append(" -> ");
            }
            p = p.next;
        }
        System.out.println(str.toString());
    }
}
