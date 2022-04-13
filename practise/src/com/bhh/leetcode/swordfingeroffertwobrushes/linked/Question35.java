package com.bhh.leetcode.swordfingeroffertwobrushes.linked;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bhh
 * @description 复杂链表的复制
 * @date Created in 2022-01-20 14:52
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
        一个节点来个指向, 一个是next, 一个是random
        第一遍按照next生成链表, 并将节点以(index, Node)存储在map中
        错误 :
            使用(Integer, Node)作为键值对, 因为integer并不唯一
            使用(Node, Node)作为键值对更好
         */
        public Node copyRandomList(Node head) {
            if (head == null) {
                return null;
            }
            Node p = head.next;
            Node newHead = new Node(head.val);
            Node q = newHead;
            // 创建map存储节点
            Map<Node, Node> map = new HashMap<>();
            map.put(head, newHead);
            // 第一次遍历依靠next生成链表, 并将节点对应关系存储到map中
            while (p != null) {
                q.next = new Node(p.val);
                q = q.next;
                map.put(p, q);
                p = p.next;
            }
            q = newHead;
            p = head;
            // 第二次遍历, 填充random
            while (p != null) {
                q.random = map.get(p.random);
                p = p.next;
                q = q.next;
            }
            return newHead;
        }
    }
}
