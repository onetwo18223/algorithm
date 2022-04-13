package com.bhh.leetcode.three;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bhh
 * @description LRU 缓存
 * @date Created in 2022-02-02 15:48
 * @modified By
 */
public class Question146hot100 {
    // 需要俩个属性, 一个HashMap, 一个是双端队列
    class LRUCache {
        private int capacity;
        private Map<Integer, Node> map;
        private DoubleLinkedList linked;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>();
            linked = new DoubleLinkedList();
        }

        // map获取元素
        // linkedList 删除这个元素, 且重新添加这个元素到首部
        public int get(int key) {
            if (! map.containsKey(key)) {
                return -1;
            }
            Node node = map.get(key);
            linked.deleteNode(node);
            linked.addFirst(node);
            return node.value;
        }

        // 添加元素
        // 若是该元素已经存在, 则直接覆盖, linked类似于get
        // 否则, 判断map容量, 若是容量小于k, 则直接添加到linked和map
        // 若是容量大于k, 则删除linked的尾部元素, 同时删除map中对应元素, 再添加
        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                linked.deleteNode(node);
                node.value = value;
                linked.addFirst(node);
                map.put(key, node);
            } else {
                // 删除元素
                if (map.size() >= capacity) {
                    Node node = linked.deleteLast();
                    map.remove(node.key);
                }
                Node node = new Node(key, value);
                map.put(key, node);
                linked.addFirst(node);
            }
        }
    }

    class Node {
        int key;
        int value;
        Node next;
        Node pre;
        Node(int key, int value){
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

        // 添加头部节点
        public void addFirst(Node node) {
            node.next = head.next;
            node.pre = head;
            head.next.pre = node;
            head.next = node;
        }

        // 删除节点
        public Node deleteNode(Node node) {
            node.next.pre = node.pre;
            node.pre.next = node.next;
            return node;
        }

        // 删除尾部节点
        public Node deleteLast() {
            return deleteNode(tail.pre);
        }
    }

}
