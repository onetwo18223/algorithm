package com.bhh.leetcode.hot100twobrushes.array.make;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bhh
 * @description LRU 缓存
 * @date Created in 2022-01-23 19:58
 * @modified By
 */
public class Question146 {
    /*
    LRU缓存
    Node节点类 + 前后指向 + <key, value> /
    双向链表类 + 虚拟头尾节点 + 添加头, 删除尾节点
    LRU类中属性 : HashMap属性(存储数据)/ 双向链表属性(最近最少使用的元素在队尾)
     */
    class LRUCache {
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

        class DoubleLinkedList {
            Node head;
            Node tail;

            DoubleLinkedList() {
                head = new Node(0, 0);
                tail = new Node(0, 0);
                head.next = tail;
                tail.pre = head;
            }

            public void addFirst(Node node) {
                // node.next的俩条线
                node.next = head.next;
                head.next.pre = node;
                // head的俩条线
                head.next = node;
                node.pre = head;
            }

            public Node remove(Node node) {
                node.next.pre = node.pre;
                node.pre.next = node.next;
                return node;
            }

            public Node removeLast() {
                return remove(tail.pre);
            }
        }

        private Map<Integer, Node> map;
        private DoubleLinkedList list;
        private int capacity;

        public LRUCache(int capacity) {
            map = new HashMap<>();
            list = new DoubleLinkedList();
            this.capacity = capacity;
        }

        /**
         * 获取数据
         * map.get()
         * list需要删除这个节点, 并在头部添加这个节点
         *
         * @param key
         * @return
         */
        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            Node node = map.get(key);
            list.remove(node);
            list.addFirst(node);
            return node.value;
        }

        /**
         * 添加数据
         * 需要考虑, 数据已存在, 修改, 类似于get
         * 数据不存在, 但是容器已满, 删除队尾元素, 相应删除map对应元素
         * 容器不满
         *
         * @param key
         * @param value
         */
        public void put(int key, int value) {
            Node newNode = new Node(key, value);
            if (map.containsKey(key)) {
                Node node = map.get(key);
                list.remove(node);
                map.put(key, newNode);
                list.addFirst(newNode);
            } else {
                if (map.size() >= capacity){
                    Node delNode = list.removeLast();
                    map.remove(delNode.key);
                }
                map.put(key, newNode);
                list.addFirst(newNode);
            }
        }
    }
}
