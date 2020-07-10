package offer;

import java.util.Stack;

/**
 * @author Mei Siman
 * @date 2020/7/9 16:30
 */
public class Offer06 {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while(head!=null){
            stack.push(head.val);
            head=head.next;
        }
        int length=stack.size();
        int[] num = new int[length];
        for (int i = 0; i < length; i++) {
            num[i]=stack.pop();
        }
        return num;
    }
}
