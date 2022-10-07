package org.problem.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU 缓存
 */
public class Question146 {

    class LRUCache {

        // map集合
        private Map<Integer, Node> map;
        // 双向链表
        private DoubleLinkedList list;
        // 容量
        int capacity;

        public LRUCache(int capacity) {
            map = new HashMap<>();
            list = new DoubleLinkedList();
            this.capacity = capacity;
        }

        /**
         * 获取节点, 并删除list中的该节点, 重新添加该节点到头部
         * @param key
         * @return
         */
        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            Node res = map.get(key);
            list.remove(res);
            list.addFirst(res);
            return res.value;
        }

        /**
         * 添加结点
         * @param key
         * @param value
         */
        public void put(int key, int value) {
            Node newNode = new Node(key, value);
            // 如果map中已经有这个key了, 删除list中的元素, 并添加到头结点
            if (map.containsKey(key)) {
                list.remove(map.get(key));
                map.put(key, newNode);
                list.addFirst(newNode);
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

        /**
         * Node 节点
         * 需要包含 key 和 value
         * 包含 key 是因为 map 需要移除某一个 node 时，需要借住 node.key
         * 并且需要俩个指向 pre 和 next
         */
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

        /**
         * 创建基于 Node 节点的双向链表
         * head 头结点
         * tail 尾节点
         *
         */
        class DoubleLinkedList {
            // 头结点
            private Node head;
            // 尾节点
            private Node tail;

            /**
             * 连接头结点和尾节点
             */
            public DoubleLinkedList() {
                head = new Node(0, 0);
                tail = new Node(0, 0);

                head.next = tail;
                tail.pre = head;
            }

            /**
             * 添加结点
             * @param node
             */
            public void addFirst(Node node) {
                // 双向链表添加节点
                // 添加node的俩条线
                node.next = head.next;
                node.pre = head;
                // 修改连接node的俩条线
                head.next.pre = node;
                head.next = node;
            }

            /**
             * 移除结点
             * @param node
             * @return
             */
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

    }
}
