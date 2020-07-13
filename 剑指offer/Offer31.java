package offer;

import java.util.Stack;

/**
 * @author Mei Siman
 * @date 2020/7/13 10:56
 *
 * 剑指 Offer 31. 栈的压入、弹出序列
 */
public class Offer31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i=0;
        for (int num : pushed) {
            stack.push(num);
            while(!stack.isEmpty()&&stack.peek()==popped[i]){
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}
