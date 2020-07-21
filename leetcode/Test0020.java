package leetcode;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Mei Siman
 * @date 2020/6/8 15:47
 */
public class Test0020 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();
        String s = sc.next();
        char[] chars=s.toCharArray();
        stack.push('#');
        for(int i=0;i<chars.length;i++){
            if(chars[i]=='(')
                stack.push(')');
            else if(chars[i]=='[')
                stack.push(']');
            else if(chars[i]=='{')
                stack.push('}');
            else{
                char temp=stack.pop();
                if(chars[i]!=temp){
                    System.out.println("false");
                    return;
                }
            }
        }
        if(stack.pop()=='#')
            System.out.println("true");
        else
            System.out.println("false");
    }
}
