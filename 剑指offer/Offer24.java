package offer;

/**
 * @author Mei Siman
 * @date 2020/7/12 15:09
 *
 * 剑指 Offer 24. 反转链表
 * leetcode206
 *
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 */
public class Offer24 {
    public ListNode reverseList(ListNode head) {
        ListNode cur=null,pre=head,p;
        while (pre!=null){
            p=pre.next;
            pre.next=cur;
            cur=pre;
            pre=p;
        }
        return cur;
    }
}
