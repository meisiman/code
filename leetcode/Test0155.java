package leetcode;

import java.util.Stack;

/**
 * @author Mei Siman
 * @date 2020/6/22 11:59
 *
 *  * Your MinStack object will be instantiated and called as such:
 *  * MinStack obj = new MinStack();
 *  * obj.push(x);
 *  * obj.pop();
 *  * int param_3 = obj.top();
 *  * int param_4 = obj.getMin();
 */
public class Test0155 {
    /** initialize your data structure here. */
    Stack<Integer> data;
    Stack<Integer> minStack;

    public Test0155() {
        data = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        data.push(x);
        if(minStack.isEmpty()||x<=minStack.peek())
            minStack.push(x);
    }

    public void pop() {
        //if(minStack.peek()==data.peek())
        if(minStack.peek().equals(data.peek()))//注意对象之间比较要用equals()方法
            minStack.pop();
        data.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
