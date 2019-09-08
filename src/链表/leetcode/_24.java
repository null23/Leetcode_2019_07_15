package 链表.leetcode;

import 链表.ListNode.ListNode;

/**
 * MidNum
 * 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例:
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class _24 {

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode p1 = head;
        ListNode p2 = head.next;

        while(true) {
            p1.next = p2.next;
            p2.next = p1;

            if(p1 == null || p1.next == null || p1.next.next == null){
               break;
            }
            p1 = p1.next;
            p2 = p1.next.next;
        }

        return pre.next;
    }
}
