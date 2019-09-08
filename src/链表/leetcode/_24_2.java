package 链表.leetcode;

import 链表.ListNode.ListNode;

public class _24_2 {
    /**
     * 递归写法
     */
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }
}
