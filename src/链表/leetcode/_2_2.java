package 链表.leetcode;

import 链表.ListNode.ListNode;
/**
 * MidNum
 *
 * 2. 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class _2_2 {
    /**
     * 思路：
     * 同时遍历两个链表，分别对两位相加，并且记录进位值。
     * 如果其中一个链表A遍历完成，但是另一个链表B遍历还没完成，那就把链表A没有值的节点记录为0。
     * 最后的时候，注意x是否还有剩余的进位，如果有要记下来为ListNode(1)。
     *
     * 注意这里pre节点的用法，在结果需要返回的是头节点的时候，一般都会这么做，额外维护一个pre节点指向头节点。
     * 这里我还不是很理解透彻，往后再做几道题试试。
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;

        //用于进位
        int x = 0;

        while(l1 != null || l2 != null){
            int p = 0;
            int q = 0;

            if(l1 != null){
                p = l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                q = l2.val;
                l2 = l2.next;
            }

            int sum = p + q + x;
            if(sum >= 10){
                x = 1;
                cur.next = new ListNode(sum%10);
            }else{
                x = 0;
                cur.next = new ListNode(sum);
            }
            cur = cur.next;
        }
        if(x > 0){
            cur.next = new ListNode(x);
        }

        return pre.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(3);
        l1.next = l12;
        l12.next = l13;

        ListNode l2 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(4);
        l2.next = l22;
        l22.next = l23;

        addTwoNumbers(l1, l2);
    }
}