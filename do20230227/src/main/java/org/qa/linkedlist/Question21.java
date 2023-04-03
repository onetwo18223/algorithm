package org.qa.linkedlist;

/**
 * @Desc 合并两个有序链表
 * https://leetcode.cn/problems/merge-two-sorted-lists/
 * 实现：
 * 归并排序的合并阶段，递归使用俩个链表的各一个节点，
 * 使用了其中一个节点，
 * 则另一个节点需要在下次递归中继续使用
 *
 * 需要原地实现
 * @Author Bhh
 * @Date 2023-04-03 10:10
 * @Version 1.0
 */
public class Question21 {
    class Solution {
        public ListNode mergeTwoLists(ListNode listOne, ListNode listTwo) {
            // TODO: 此处的递归结束条件可以不包含 `null == listOne && null == listTwo`
            //  因为后面的`null == listOne`和`null == listTwo`包含了上面的情况
            if (null == listOne && null == listTwo) return null;
            else if (null == listOne) return listTwo;
            else if (null == listTwo) return listOne;
            ListNode node;
            // TODO: 此处使用了新建节点的方式，但是可以使用原地更新链表的方式完成
            //  在一定程度上可以节省空间
            if (listOne.val >= listTwo.val) {
                // 原地
//                listTwo.next = mergeTwoLists(listOne, listTwo.next);
//                return listTwo;
                node = new ListNode(listTwo.val);
                node.next = mergeTwoLists(listOne, listTwo.next);
            }
            // 原地
//          listOne.next = mergeTwoLists(listOne.next, listTwo);;
//          return listOne;

            else {
                node = new ListNode(listOne.val);
                node.next = mergeTwoLists(listOne.next, listTwo);
            }
            return node;
        }
    }
}
