package com.bhh.datastructure.link;

/**
 * @author bhh
 * @description 使用递归实现链表增删改查
 * @date Created in 2021-07-25 11:16
 * @modified By
 */
public class LinkedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuffer bf = new StringBuffer();
            ListNode cur = this;
            while (cur != null) {
                bf.append(cur.val + "->");
                cur = cur.next;
            }
            return bf.toString();
        }
    }



    /**
     * 删除, 通过拼接实现
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElementsRecursion(ListNode head, int val) {
        // 结束条件
        if (head == null) {
            return null;
        }

        // 循环条件
        head.next = removeElementsRecursion(head.next, val);
        return head.val == val ? head.next : head;
    }
}
