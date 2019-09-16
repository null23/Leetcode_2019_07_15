package 链表.leetcode;

import 链表.ListNode.ListNode;

/**
 * MidNum
 * 分隔链表
 *
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 示例:
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 */
public class _86 {

    /**
     * 思路：
     *  定义两个指针，分别维护两个队列，一个是小于x的，另一个是大于等于x的
     *  只要从头到尾遍历一次链表即可
     *
     * 时间复杂度：O(n)
     * 空间复杂度:O(1)   因为我们只是在原链表上改变的指针的指向
     */
    public ListNode partition(ListNode head, int x) {
        ListNode preSmall = new ListNode(0);
        ListNode preLarge = new ListNode(0);

        ListNode curSmall = preSmall;
        ListNode curLarge = preLarge;
        while(head != null){
            if(head.val < x){
                curSmall.next = head;
                curSmall = curSmall.next;
            }else{
                curLarge.next = head;
                curLarge = curLarge.next;
            }
            head = head.next;
        }

        curSmall.next = preLarge.next;
        curLarge.next = null;
        return preSmall.next;
    }

}
