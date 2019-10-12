package _极客时间.数组_链表;

import 链表.ListNode.ListNode;

/**
 * leetcode 206
 */
public class 反转链表 {

    public ListNode reverseList(ListNode head){
        if(head == null){
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;

        while(cur.next != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return cur;
    }
}
