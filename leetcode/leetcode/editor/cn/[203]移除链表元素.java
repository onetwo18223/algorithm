//给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,6,3,4,5,6], val = 6
//输出：[1,2,3,4,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [], val = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [7,7,7,7], val = 7
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 列表中的节点数目在范围 [0, 104] 内 
// 1 <= Node.val <= 50 
// 0 <= val <= 50 
// 
// Related Topics 递归 链表 
// 👍 660 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    //    public ListNode removeElements(ListNode head, int val) {
//        // 如果头结点需要删除
//        while (head != null && head.val == val) {
//            ListNode delNode = head;
//            head = head.next;
//            delNode.next = null;
//        }
//
//        if (head == null) {
//            return null;
//        }
//
//        // 不为头结点的节点需要删除
//        // 根据前一个节点, 判断其后节点是否需要删除
//        // 注意 : 这里重要的不变的循环点是 前一个节点的next
//        //       一定要对判断条件做出完整判断才可以判断下一个
//        //       例如 : 下面代码中if代码块中的循环点 pre.next 发生了变化需要重新再判断, 所以不可直接 pre = pre.next;
//        ListNode pre = head;
//        while (pre.next != null) {
//            if (pre.next.val == val) {
//                ListNode delNode = pre.next;
//                pre.next = delNode.next;
//                delNode.next = null;
//            }else{
//                pre = pre.next;
//            }
//        }
//
//        return head;
//    }
    public ListNode removeElements(ListNode head, int val) {
        // 结束条件
        if (head == null) {
            return null;
        }

        ListNode res = removeElements(head.next, val);
        if (head.val == val) {
            return res;
        } else {
            head.next = res;
            return head;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
