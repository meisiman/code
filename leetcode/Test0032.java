package leetcode;

import java.util.Stack;

/**
 * @author Mei Siman
 * @date 2020/7/23 12:04
 *
 * 32. 最长有效括号
 *
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 */
public class Test0032 {
    public static int longestValidParentheses(String s){
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='('){
                stack.push(i);
            }else {
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else {
                    max = Math.max(max,i-stack.peek());
                }
            }
        }
        return max;
    }
}
