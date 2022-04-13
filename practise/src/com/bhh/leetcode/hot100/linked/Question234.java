package com.bhh.leetcode.hot100.linked;

/**
 * @author bhh
 * @description 回文链表
 * @date Created in 2021-12-24 9:57
 * @modified By
 */
public class Question234 {
    class Solution {
        /*
        回文串一般都是需要相向双指针或者背向双指针来完成
        但是因为是链表所以无法完成不同方向的遍历
        所以方法一 : 使用数组承载链表节点, 然后相向双指针判断

        进阶 : 而 时间复杂度O(n)和空间复杂度O(1) 则必须要使用双指针
        所以我们需要将链表结构进行更改
        方法二 : 寻找中间点, 对一半链表进行反转, 之后再进行双指针比对
         */
        private int sum = 1;
        public boolean isPalindrome(ListNode head) {
            if (head == null) {
                return false;
            }
            // 获取中间点
            // 2 3 3 三个数时, 中间点为 1, 奇数时, 判断start - 1 和 start + 1
            // 4 2 2 4 四个数时, 中间点为 1, 偶数时, 判断start 和 start + 1
            // 跟随快指针获取链表全部节点数, 判断是奇数还是偶数
            ListNode slow = head;
            // slow节点是中间点
            // 总结点数sum判断奇偶
            slow = getMid(slow, head);
            ListNode right = slow.next;
            slow = reverse(head, slow);
            // slow表示左边链表, right表示右边链表
            if (sum % 2 != 0) {
                slow = slow.next;
            }
            while (slow != null && right != null) {
                if (slow.val != right.val) {
                    return false;
                }
                slow = slow.next;
                right = right.next;
            }
            return true;
        }

        // 链表翻转, 从slow开始往回翻转
        private ListNode reverse(ListNode head, ListNode slow) {
            slow.next = null;
            ListNode pre = null;
            ListNode next;
            ListNode p = head;
            // 结束 : p == null, pre为链表起点
            while (p != null){
                next = p.next;
                p.next = pre;
                pre = p;
                p = next;
            }
            return pre;
        }

        private ListNode getMid(ListNode head, ListNode slow) {
            ListNode fast = head;
            while (fast.next != null) {
                if (fast.next.next == null) {
                    sum += 1;
                    break;
                }
                slow = slow.next;
                fast = fast.next.next;
                sum += 2;
            }
            return slow;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question234().new Solution().isPalindrome(
                new ListNode(1, new ListNode(2,
                        new ListNode(2, new ListNode(1))))));
    }
}
