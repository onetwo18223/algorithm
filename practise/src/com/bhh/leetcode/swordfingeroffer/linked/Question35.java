package com.bhh.leetcode.swordfingeroffer.linked;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bhh
 * @description 复杂链表的复制
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，
 * 每个节点除了有一个 next 指针指向下一个节点，
 * 还有一个 random 指针指向链表中的任意节点或者 null。
 * @date Created in 2021-10-12 15:33
 * @modified By
 */
public class Question35 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    class Solution {
        /*
        实现思路 : 先按照next属性组装基本链表, 再根据map赋值random属性
        错误 : 在将节点存储在map中时, 应该是直接将节点存储在map中, 例如在本题中使用
        <Node, Node>这样的映射关系, 而不是使用<Integer, Node>的映射关系,
        毕竟Integer很有可能产生重复覆盖情况
         */
        public Node copyRandomList(Node head) {
            if (head == null){
                return null;
            }
            Node p = head.next;
            Node newHead = new Node(head.val);
            Node p1 = newHead;
            Map<Node, Node> map = new HashMap<>();
            map.put(head, newHead);

            // 先按照next来完成链表, 之后再赋予random属性
            while (p != null) {
                Node tmp = new Node(p.val);
                p1.next = tmp;
                map.put(p, tmp);
                p = p.next;
                p1 = p1.next;
            }

            p = head;
            p1 = newHead;
            while (p != null) {
                p1.random = map.get(p.random);
                p = p.next;
                p1 = p1.next;
            }
            return newHead;
        }
    }
}
