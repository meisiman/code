package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mei Siman
 * @date 2020/9/2 15:42
 *
 * 234. 回文链表
 */
public class Test0234 {
    public boolean isPalindrome(ListNode head) {
        List<Integer> vals = new ArrayList<>();
        ListNode currentNode = head;
        while (currentNode!=null){
            vals.add(currentNode.val);
            currentNode=currentNode.next;
        }

        int front = 0;
        int back = vals.size()-1;
        while (front<back){
            if (!vals.get(front).equals(vals.get(back))) return false;
            front++;
            back--;
        }
        return true;
    }
}
