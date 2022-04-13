package com.bhh.leetcode.hot100.make;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bhh
 * @description LRU 缓存
 * @date Created in 2021-12-27 19:25
 * @modified By
 */
public class Question146 {
    class LRUCache {
        private Map<Integer, Node> map;
        private DoubleLinkedList list;
        int capacity;

        public LRUCache(int capacity) {
            map = new HashMap<>();
            list = new DoubleLinkedList();
            this.capacity = capacity;
        }

        // 获取节点, 并删除list中的该节点, 重新添加该节点到头部
        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            Node res = map.get(key);
            list.remove(res);
            list.addFirst(res);
            return res.value;
        }

        public void put(int key, int value) {
            Node newNode = new Node(key, value);
            // 如果map中已经有这个key了, 删除list中的元素, 并添加到头结点,
            // 表示数据更新和最近使用过
            if (map.containsKey(key)) {
                list.remove(map.get(key));
                list.addFirst(newNode);
                map.put(key, newNode);
            } else {
                // 当前容器已经满了, 删除元素(同时删除map和list中的元素)
                // 这一步可以解释为什么Node中要加key属性
                if (map.size() == capacity) {
                    Node node = list.removeLast();
                    map.remove(node.key);
                }
                map.put(key, newNode);
                list.addFirst(newNode);
            }
        }


        class DoubleLinkedList {
            private Node head;
            private Node tail;

            public DoubleLinkedList() {
                head = new Node(0, 0);
                tail = new Node(0, 0);

                head.next = tail;
                tail.pre = head;
            }

            public void addFirst(Node node) {
                // 双向链表添加节点
                // 添加node的俩条线
                node.next = head.next;
                node.pre = head;
                // 修改连接node的俩条线
                head.next.pre = node;
                head.next = node;
            }

            public Node remove(Node node) {
                // 修改关于node的俩条线
                node.next.pre = node.pre;
                node.pre.next = node.next;
                return node;
            }

            public Node removeLast() {
                if (head.next == tail) {
                    return null;
                }
                return remove(tail.pre);
            }
        }

        class Node {
            int key;
            int value;
            Node pre;
            Node next;

            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
    }
}
