package com.bhh.leetcode.hot100.linked;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author bhh
 * @description 排序链表
 * @date Created in 2021-12-24 15:58
 * @modified By
 */
public class Question148 {
    class Solution {
        /*
        方法一 : 进行排序, 如果全部添加到数组之中, 再排序试试
        方法二 : 题目进阶要求, O(nlogn)时间复杂度, O(n)空间复杂度, 大概断定使用归并排序
            那么如何在链表中使用归并排序 ?
            sort需要分割left, mid, right
            merge需要比较大小, 进行互换
         */
        // 方法一
        public ListNode sortListM1(ListNode head) {
            if (head == null || head.next == null){
                return head;
            }
            List<ListNode> list = new ArrayList();
            ListNode p = head;
            while (p != null) {
                list.add(p);
                p = p.next;
            }
            Collections.sort(list, new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2) {
                    return o1.val - o2.val;
                }
            });
            head = list.get(0);
            p = head;
            for (int i = 1; i < list.size(); i++) {
                list.get(i).next = null;
                p.next = list.get(i);
                p = p.next;
            }
            return head;
        }
        // 方法二
        public ListNode sortListM2(ListNode head) {
            if (head == null || head.next == null){
                return head;
            }
            ListNode left = head;
            //  快慢指针寻找mid
            ListNode end = head;
            while (end != null){
                if (end.next == null){
                    break;
                }
                left = left.next;
                end = end.next.next;
            }
            left = head;
            end = null;
            //sort(head, mid, end);
            // TODO : 完成归并
            return null;
        }
    }
}
