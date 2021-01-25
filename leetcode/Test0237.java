package leetcode;

/**
 * @author Mei Siman
 * @date 2021/1/25 16:59
 *
 * 237. 删除链表中的节点
 */
public class Test0237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
