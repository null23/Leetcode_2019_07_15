package 链表.leetcode;

import 链表.ListNode.ListNode;

/**
 * Easy
 * 反转链表
 *
 * 反转一个单链表。
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * 分别使用迭代/递归两种方式反转链表
 */
public class _206 {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
