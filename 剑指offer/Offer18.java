package offer;

/**
 * @author Mei Siman
 * @date 2020/7/11 16:59
 *
 * 剑指 Offer 18. 删除链表的节点
 *
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 */
public class Offer18 {
    public ListNode deleteNode(ListNode head, int val){
        if(head==null) return null;
        if(head.val==val) return head.next;
        ListNode pre = head;
        while (pre.next!=null&&pre.next.val!=val)
            pre=pre.next;
        if(pre.next!=null)//如果val找的到
            pre.next=pre.next.next;
        return head;
    }
}
