package offer;

import java.util.Stack;

/**
 * @author Mei Siman
 * @date 2020/7/13 10:31
 *
 * 剑指 Offer 30. 包含min函数的栈
 * leetcode155
 *
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 */
public class Offer30 {

    Stack<Integer> data;
    Stack<Integer> min;

    public Offer30() {
        data = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        data.push(x);
        if(min.isEmpty()||min.peek()>=x) min.push(x);
    }

    public void pop() {
        if(min.peek().equals(data.peek())) min.pop();//注意.equals()方法
        data.pop();
    }

    public int top() {
        return data.peek();
    }

    public int min() {
        return min.peek();
    }

//    public void push(int x) {
//        data.push(x);
//        if(min.isEmpty()||min.peek()>=x) min.push(x);
//        else min.push(min.peek());
//    }
//
//    public void pop() {
//        min.pop();
//        data.pop();
//    }
}
