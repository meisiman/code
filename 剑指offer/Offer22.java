package offer;

/**
 * @author Mei Siman
 * @date 2020/7/12 13:51
 *
 * 剑指 Offer 22. 链表中倒数第k个节点
 */
public class Offer22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode former = head,latter = head;
        for (int i = 0; i < k; i++) {
            former=former.next;
        }
        while (former!=null){
            former=former.next;
            latter=latter.next;
        }
        return latter;
    }
}
