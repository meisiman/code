package leetcode;

/**
 * @author Mei Siman
 * @date 2021/1/20 23:32
 *
 * 150. 逆波兰表达式求值
 *
 * 根据 逆波兰表示法，求表达式的值。
 *
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 */
public class Test0150 {
    public int evalRPN(String[] tokens) {
        int[] num = new int[tokens.length/2+1];
        int index=0;
        for (String s : tokens) {
            switch (s){
                case "+":
                    num[index-2]+=num[--index];
                    break;
                case "-":
                    num[index-2]-=num[--index];
                    break;
                case "*":
                    num[index-2]*=num[--index];
                    break;
                case "/":
                    num[index-2]/=num[--index];
                    break;
                default:
                    num[index++]=Integer.parseInt(s);
                    break;
            }
        }
        return num[0];
    }
}
