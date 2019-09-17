package 链表.leetcode;

import 链表.ListNode.ListNode;

/**
 *
 * MidNum
 * 环形链表 II（返回环形链表的入口）
 *
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 说明：不允许修改给定的链表。
 */
public class _142 {

    /**
     * 思路：
     *  1.双指针判断链表是否有环，如果有，则记录第一次相遇的节点 meetNode
     *  2.从 head 和 meetNode 遍历，分别走向next指针，当 head 和 meetNode 相遇的时候就是结果
     */
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode slowNode = head;
        ListNode fastNode = head;

        while(true){
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if(slowNode == fastNode){
                break;
            }else if(fastNode == null || fastNode.next == null){
                return null;
            }
        }

        ListNode res = head;
        while(true){
            if(res == fastNode){
                return res;
            }
            res = res.next;
            fastNode = fastNode.next;
        }
    }
}
