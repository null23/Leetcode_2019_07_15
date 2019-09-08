package 链表.leetcode;

import 链表.ListNode.ListNode;

/**
 * MidNum
 * 旋转链表
 *
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 *
 * 示例 2:
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 */
public class _61 {
    /**
     * 思路：
     * 这道题，本质是使用快慢指针，找到倒数第k+1个节点，这个节点就是分割链表的节点，伪代码的流程如下：
     *  1.求出链表的长度len
     *  2.比较链表长度len和k的大小，会出现以下的情况
     *      - len == k  这种情况说明旋转的是头节点，也就是直接把头节点返回就行，不需要对链表做出任何结构上的修改
     *      - len > k   这种情况说明一次快慢指针的遍历就可以找到分割链表的倒数第 k+1 个节点
     *      - len < k   这种情况说明一次快慢指针遍历得不到结果，所以用 k%len 取余，取余之后的k重新执行 len > k这种情况
 *      3.找到分割链表的倒数第 k+1 个节点之后，它的next节点就是新的头节点，队列的尾部节点，成为老的head节点的前缀节点
     */
    public static ListNode rotateRight(ListNode head, int k) {
        if(k == 0 || head == null || head.next == null){
            return head;
        }
        int len = 0;
        ListNode pre = new ListNode(0);
        pre.next = head;

        //求出链表的长度
        ListNode curNode = head;
        while(curNode != null){
            curNode = curNode.next;
            len++;
        }

        //链表的长度和k相同，说明要旋转的是头节点，那么直接返回头节点即可
        if(len == k){
            return head;
        }

        ListNode slowNode = head;
        //一次遍历即可得出结果，使用快慢指针，找到分割链表的node
        if(k < len){
            ListNode fastNode = head;
            for(int i = 0; i < k; i++){
                fastNode = fastNode.next;
            }

            //这个while循环结束后，slowNode就是倒数第k个节点的前一个节点，也就是倒数第k+1个节点
            while(fastNode.next != null){
                fastNode = fastNode.next;
                slowNode = slowNode.next;
            }

            ListNode newHead = slowNode.next;
            ListNode splitNode = slowNode.next;
            while(splitNode.next != null){
                splitNode = splitNode.next;
            }
            slowNode.next = null;
            splitNode.next = head;
            return newHead;

        //需要用k取余，然后重新执行一遍上边的逻辑
        }else{
            k = k % len;
            return rotateRight(head, k);
        }
    }
}
