package offer;

import java.util.Stack;

/**
 * @author Mei Siman
 * @date 2020/7/10 12:40
 *
 * 剑指 Offer 09. 用两个栈实现队列
 *
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 */
public class Offer09 {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Offer09() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if(stack1.size()==0&&stack2.size()==0)
            return -1;
        if(stack2.size()<=0){
            while (stack1.size()!=0){
                int temp = stack1.pop();
                stack2.push(temp);
            }
        }
        int delete =  stack2.pop();
        return delete;
    }
}
