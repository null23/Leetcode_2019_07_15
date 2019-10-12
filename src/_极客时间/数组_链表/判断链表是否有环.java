package _极客时间.数组_链表;

import 链表.ListNode.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * leetcode 141
 */
public class 判断链表是否有环 {

    /**
     * 解法1
     * 使用一个set存每个节点的内存地址，遍历一遍链表即可，时间复杂度是 O(n)
     */
    public boolean hasCycle1(ListNode head){
        if(head == null){
            return false;
        }
        Set<ListNode> set = new HashSet<>();

        ListNode cur = head;
        while(true){
            if(set.contains(cur)){
                return true;
            }
            if(cur.next == null){
                return false;
            }
            cur = cur.next;
            set.add(cur);
        }
    }

    /**
     * 解法2
     * 快慢指针
     */
    public boolean hasCycle2(ListNode head){
        if(head == null || head.next == null){
            return false;
        }

        ListNode slowNode = head;
        ListNode fastNode = head;
        while(slowNode != null && fastNode != null){
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if(slowNode == fastNode){
                return false;
            }
        }

        return true;
    }


}
