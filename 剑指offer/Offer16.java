package offer;

/**
 * @author Mei Siman
 * @date 2020/7/11 13:17
 *
 * 剑指 Offer 16. 数值的整数次方
 *
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。
 * 不得使用库函数，同时不需要考虑大数问题。
 *
 */
public class Offer16 {
    public double myPow(double x, int n) {
        if(x==0) return 0;
        long b=n;
        double res=1.0;
        if(b<0){
            x=1/x;
            b=-b;
        }
        while (b>0){
            if ((b&1)==1) res*=x;
            x*=x;
            b>>=1;
        }
        return res;
    }
}
