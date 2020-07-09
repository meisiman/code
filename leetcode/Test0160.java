package leetcode;

/**
 * @author Mei Siman
 * @date 2020/7/9 14:41
 *
 * 160. 相交链表
 *
 * 编写一个程序，找到两个单链表相交的起始节点。
 */
public class Test0160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA, q = headB;
        while(p != q){
            p = (p == null) ? headB : p.next;
            q = (q == null) ? headA : q.next;
        }
        return p;
    }
}
