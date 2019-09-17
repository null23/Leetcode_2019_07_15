package 链表.leetcode;

import 链表.ListNode.ListNode;

/**
 * Easy
 * 判断是否存在环形链表
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 */
public class _141 {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode cur1 = head;
        ListNode cur2 = head;

        boolean hasCycle = false;
        while(cur2 != null && cur2.next != null){
            cur1 = cur1.next;
            cur2 = cur2.next.next;
            if(cur1 == cur2){
                hasCycle = true;
                break;
            }
        }
        return hasCycle;
    }
}
