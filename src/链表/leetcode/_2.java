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
public class _2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String s1 = "";
        String s2 = "";

        while(l1 != null){
            s1 = l1.val + s1 ;
            l1 = l1.next;
        }

        while(l2 != null){
            s2 = l2.val + s2 ;
            l2 = l2.next;
        }

        Long n1 = Long.valueOf(s1);
        Long n2 = Long.valueOf(s2);

        String res = String.valueOf(n1 + n2);

        ListNode listNode = null;
        ListNode curNode = null;
        for(int i = res.length() - 1; i >= 0; i--){
            int indexNum = Integer.valueOf(String.valueOf(res.charAt(i)));
            if(listNode == null){
                listNode = new ListNode(indexNum);
                curNode = listNode;
            }else{
                curNode.next = new ListNode(indexNum);
                curNode = curNode.next;
            }
        }
        return listNode;
    }

    public static void main(String[] args) {
        //[2,4,3]
        //[5,6,4]
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

//        addTwoNumbers(l1, l2);

        String s = "9999999991";
        Long a = Long.valueOf(s);
    }
}
