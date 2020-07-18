package offer;

/**
 * @author Mei Siman
 * @date 2020/7/18 13:19
 *
 * 剑指 Offer 65. 不用加减乘除做加法
 *
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 */
public class Offer65 {
    public int add(int a, int b) {
        while (b!=0){//当进位为0时跳出
            int c=(a&b)<<1;//c=进位
            a^=b;//a=非进位和
            b=c;//b=进位
        }
        return a;
    }
}
