package leetcode;

/**
 * @author Mei Siman
 * @date 2020/7/25 12:21
 *
 * 19. 删除链表的倒数第N个节点
 *
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 */
public class Test0019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode root = new ListNode(0);
        root.next=head;
        ListNode pre=root,cur=root;
        while (n>0){
            pre=pre.next;
            n--;
        }
        while (pre.next!=null){
            pre=pre.next;
            cur=cur.next;
        }
        cur.next=cur.next.next;
        return root.next;
    }
}
