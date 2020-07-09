package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Mei Siman
 * @date 2020/6/20 11:47
 */
public class Test0141 {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if(set.contains(head))
                return true;
            else set.add(head);
            head=head.next;
        }
        return false;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}


