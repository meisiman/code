package offer;

/**
 * @author Mei Siman
 * @date 2020/7/16 19:21
 *
 * 剑指 Offer 52. 两个链表的第一个公共节点
 * leetcode160
 *
 * 输入两个链表，找出它们的第一个公共节点。
 */
public class Offer52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p=headA,q=headB;
        while (p!=q){
            p=(p==null)?headB:p.next;
            q=(q==null)?headA:q.next;
        }
        return p;
    }
}
