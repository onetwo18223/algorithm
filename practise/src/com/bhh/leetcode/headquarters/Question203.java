package com.bhh.leetcode.headquarters;

/**
 * @author bhh
 * @description 问题 :
 * 审题 :
 * 对于空的链表, 如何处理
 * 空链表 :
 * *传入的参数* 是空链表,
 * *业务逻辑* 造(删除)成了空链表
 * 若是传入了空的节点, 但是根据 head == null 是无法判断的, 正确的判断方法是什么?
 * 编写代码必须要时长想着若是引用为null, 该怎么办? 最大程度避免 空指针异常
 * 例如 : 尤其在链表中每次使用节点属性, 要想着玩意为空怎么办
 * 对于某一种特殊情况进行了处理, 但是要思考处理之后的情况是否还是特殊情况
 * 例如 : 对头结点进行了处理, 但是对头节点进行了删除之后新的头结点是否还是需要删除
 * @date Created in 2021-07-24 13:58
 * @modified By
 */
//class Solution {
public class Question203 {

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

    public ListNode removeElements(ListNode head, int val) {
        // 如果头结点需要删除
//        while (head != null && head.val == val) {
//            ListNode delNode = head;
//            head = head.next;
//            delNode.next = null;
//        }

        ListNode dummyHead = new ListNode();
        dummyHead.next = head;

        if (head == null) {
            return null;
        }

        // 不为头结点的节点需要删除
        // 根据前一个节点, 判断其后节点是否需要删除
        // 注意 : 这里重要的不变的循环点是 前一个节点的next
        //       一定要对判断条件做出完整判断才可以判断下一个
        //       例如 : 下面代码中if代码块中的循环点 pre.next 发生了变化需要重新再判断, 所以不可直接 pre = pre.next;
        ListNode pre = dummyHead;
        while (pre.next != null) {
            if (pre.next.val == val) {
                ListNode delNode = pre.next;
                pre.next = delNode.next;
                delNode.next = null;
            } else {
                pre = pre.next;
            }
        }

        return head;
    }

    public ListNode newVirtualHead = new ListNode();
    public ListNode newPre = newVirtualHead;

    /**
     * 递归的错误用法
     * 错误之处 :
     *      每次处理一个节点,
     *      但是并没有将本个方法内处理的节点和递归调用的方法处理节点的结果进行灵活使用
     * 注意点 :
     *      注意方法的宏观作用, 可以做到灵活使用
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElementsRecursionError(ListNode head, int val) {
        // 结束条件
        if (head == null) {
            return newVirtualHead.next;
        }

        if (head.val != val) {
            newPre.next = head;
        }

        if (head.val == val && !newVirtualHead.equals(newPre)) {
            newPre.next = null;
        }

        if (newPre.next != null) {
            newPre = newPre.next;
        }

        // 循环条件
        return removeElementsRecursionError(head.next, val);
    }

    /**
     * 理想的递归
     *      该方法每次只处理一个节点, 根据方法获取下一个节点,
     *      若是该节点需要删除, 则不进行链接,
     *      若是该节点不需要删除, 则进行链接
     *      做到了宏观认识该方法的作用, 并能够灵活使用
     * 并不是传统删除, 是拼接
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElementsRecursion(ListNode head, int val) {
        // 结束条件
        if (head == null) {
            return null;
        }

//        ListNode res = removeElementsRecursion(head.next, val);
//        if (head.val == val) {
//            return res;
//        } else {
//            head.next = res;
//            return head;
//        }
        // 化简
        head.next = removeElementsRecursion(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        Question203 question203 = new Question203();
        ListNode node = question203.new ListNode(1, question203.new ListNode(2, question203.new ListNode(3, question203.new ListNode(1))));
//        ListNode node = question203.new ListNode();
//        System.out.println(question203.removeElements(node, 1));
        System.out.println("question203.removeElementsRecursion().val() = " + question203.removeElementsRecursion(node, 1));
    }
}
