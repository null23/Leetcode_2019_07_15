package 链表.leetcode;

import 链表.ListNode.ListNode;

/**
 * Mindum
 * 删除链表的倒数第N个节点
 *
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * 给定的 n 保证是有效的。
 *
 * 你能尝试使用一趟扫描实现吗？
 */
public class _19 {

    /**
     * 这里还是得用一个dummyNode，并且双指针的移动从dummyNode开始移动。
     * 使用dummyNode可以为我们兼容以下情况：
     *  1.只有一个节点
     *  2.要删除的是头节点
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fastNode = dummy;
        for(int i = 0; i <= n; i++){
            fastNode = fastNode.next;
        }

        ListNode slowNode = dummy;
        while(fastNode != null){
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }
        slowNode.next = slowNode.next.next;
        return dummy.next;
    }
}
