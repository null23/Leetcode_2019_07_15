package 链表.leetcode;

import 链表.ListNode.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * MidNum
 * 删除排序链表中的重复元素 II
 *
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例 1:
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 *
 * 示例 2:
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 */
public class _82 {

    /**
     * 思路：哑节点
     *  1.设置一个哑节点
     *  2.维护一个pre和cur，当出现cur.val == cur.next.val的情况时，就一直向后遍历，直到找到一个cur.val != cur.next.val的节点，此时更新pre = cur,cur = cur.next
     *
     *  时间复杂度：O(n)
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode pre = dummyNode;
        ListNode cur = head;

        while(cur != null && cur.next != null){
            if(cur.val == cur.next.val){
                int same = cur.val;
                //过滤掉所有值等于cur.val的节点
                while(cur != null && cur.val == same){
                    cur = cur.next;
                }
                pre.next = cur;
            }else{
                pre = cur;
                cur = cur.next;
            }

        }
        return dummyNode.next;
    }
}
