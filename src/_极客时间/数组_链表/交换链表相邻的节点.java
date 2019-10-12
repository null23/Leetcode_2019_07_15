package _极客时间.数组_链表;

import 链表.ListNode.ListNode;

/**
 * leetcode 24
 */
public class 交换链表相邻的节点 {

    /**
     * 重点在于这个pre节点
     */
    public ListNode swapPairs(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode node1 = head;
        ListNode node2 = head.next;

        while(true){
            node1.next = node2.next;
            node2.next = node1;

            if(node1 == null || node1.next == null || node1.next.next == null){
                break;
            }

            node1 = node1.next;
            node2 = node1.next.next;
        }

        return pre.next;

    }
}
